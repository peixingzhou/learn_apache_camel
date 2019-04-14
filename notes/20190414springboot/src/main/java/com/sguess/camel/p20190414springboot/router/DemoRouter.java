package com.sguess.camel.p20190414springboot.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().component("restlet").host("localhost").port("8080");
//        rest("/api/people").get().route().setBody(constant("Tom and Jerry"));
        rest("/api/people").post().route().setBody(constant("Hello"));
    }
}
