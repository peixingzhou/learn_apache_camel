package com.sguess.camel.camel20190413.apps;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class RestLetpp {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("restlet:/");
            }
        });
        context.start();



        synchronized (RestLetpp.class) {
            RestLetpp.class.wait();
        }
        return;

    }
}
