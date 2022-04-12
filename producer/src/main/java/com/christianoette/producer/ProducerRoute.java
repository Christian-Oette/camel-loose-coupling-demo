package com.christianoette.producer;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .marshal().json()
                .to("direct:calculateSummary")
                .unmarshal().json(JsonLibrary.Jackson, PojoOutput.class);
    }
}
