package com.danielpei.learn.camel20190409.apps;

public class FileApps {
    public static void main(String[] args) {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:out/inbox?noop=true").to("file:out/outbox");
            }
        });
        context.start();
        synchronized (Tmp01.class) {
            Tmp01.class.wait();
        }
        return;
    }
}
