package com.christianoette.producer;

import java.io.Serializable;
import java.math.BigDecimal;

public class PojoInput implements Serializable {
    private static final long serialVersionUID = 8582433437601788991L;

    public BigDecimal valueOne;
    public BigDecimal valueTwo;
}
