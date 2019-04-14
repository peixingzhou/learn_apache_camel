package com.sguess.camel.learn20190414.router;

import org.apache.camel.builder.RouteBuilder;

public class MyRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("restlet")
                .host("localhost").port("8080");
        rest("/api/people").get().route().setBody(constant("Rod,Jane"));
    }
}
