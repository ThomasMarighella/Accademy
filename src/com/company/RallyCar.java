package com.company;

public class RallyCar extends Car {

    final String MANIFACTURER;
    final double PERFORMANCEENHANCER=1.3;//prestazioni migliori

    public RallyCar( String MANIFACTURER, String color) {// da scrivere il costruttore aggiornato con security
        super(color);
        this.MANIFACTURER = MANIFACTURER;
    }
    public RallyCar( String MANIFACTURER, String color,String man,double displacement, double mass) {// da scrivere il costruttore aggiornato con security
        super(color,man,displacement,mass);
        this.MANIFACTURER = MANIFACTURER;
    }

    @Override
    public double performance() {
        return super.performance()*PERFORMANCEENHANCER;
    }
}
