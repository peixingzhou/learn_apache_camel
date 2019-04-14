package com.sguess.camel.camel20190413.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RestletProcessor implements Processor {

    public RestletProcessor() {
        System.out.println("This is construct function.................");
    }

    @Override
    public void process(Exchange exchange) throws Exception {
//        exchange.getContext().
//        System.out.println("Hello World");
        exchange.getOut().setBody("This is a process body.............");
    }
}
