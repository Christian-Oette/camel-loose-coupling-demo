package com.christianoette.producer;

import org.apache.camel.Produce;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DemoScheduler {

    @Produce(value = "direct:start")
    private MyProducerInterface myInterface;

    @Scheduled(fixedRate = 5000, initialDelay = 1000)
    public void fireMessage() {
        PojoInput input = createRandomInput();
        PojoOutput returnValue = myInterface.calculateSummary(input);
        System.out.printf("Calculated summary %s + %s = %s \n", input.valueOne, input.valueTwo, returnValue.result);
    }

    public interface MyProducerInterface {
        PojoOutput calculateSummary(PojoInput pojoInput);
    }

    private PojoInput createRandomInput() {
        PojoInput input = new PojoInput();
        int randomOne = (int) (Math.random() * 100);
        int randomTwo = (int) (Math.random() * 100);

        input.valueOne = new BigDecimal(randomOne);
        input.valueTwo = new BigDecimal(randomTwo);
        return input;
    }

}
