package com.sguess.camel.camel20190413.demo.jetty.service;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.common.HttpMessage;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class JettyDemoApp {
    public static void main(String[] args) throws Exception {

        ModelCamelContext camelContext = new DefaultCamelContext();
        camelContext.start();
        camelContext.addRoutes(new JettyDemoBuilder());

        synchronized (JettyDemoApp.class) {
            JettyDemoApp.class.wait();
        }
    }
}

class JettyDemoBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        from("jetty:http://0.0.0.0:8282/doHelloWorld").process(new JettyDemoProcessor()).to("log:helloworld?showExchangeId=true");
        from("jetty:http://localhost:8282/doHelloWorld").process(new JettyDemoProcessor()).to("log:helloworld?showExchangeId=true");
    }
}

class JettyDemoProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        HttpMessage message = (HttpMessage) exchange.getIn();
        InputStream bodyStream = (InputStream) message.getBody();
        String inputContext = this.analysisMessage(bodyStream);
        bodyStream.close();

        if (exchange.getPattern() == ExchangePattern.InOut) {
            Message outMessage = exchange.getOut();
            outMessage.setBody(inputContext + " || out");

        }
    }

    private String analysisMessage(InputStream bodyStream) throws IOException {

        String responseStr = IOUtils.toString(bodyStream, "UTF-8");
        return responseStr;
    }
}