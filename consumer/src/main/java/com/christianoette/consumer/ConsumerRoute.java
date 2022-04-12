package com.christianoette.consumer;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class ConsumerRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:calculateSummary")
                .unmarshal().json(JsonLibrary.Jackson, PojoInput.class)
                .bean(ConsumerRoute.class, "calculate")
                .marshal().json();
    }

    public PojoOutput calculate(PojoInput input) {
        PojoOutput output = new PojoOutput();
        output.result = input.valueOne.add(input.valueTwo);
        return output;
    }

}
