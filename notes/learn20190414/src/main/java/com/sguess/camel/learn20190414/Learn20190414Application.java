package com.sguess.camel.learn20190414;

import com.sguess.camel.learn20190414.router.MyRouter;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Learn20190414Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Learn20190414Application.class, args);
        ModelCamelContext camelContext = new DefaultCamelContext();
        camelContext.start();
        camelContext.addRoutes(new MyRouter());



    }

}
