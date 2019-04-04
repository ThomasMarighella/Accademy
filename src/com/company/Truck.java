package com.company;

import com.company.utils.VehicleUtils;

public class Truck extends Vehicle{
    private boolean abs;
    private boolean airbag;
    private boolean collisionControl;
    private final int PERFORMANCEREDUCTION=2;

    public Truck( double m, double d,String color,String man){// da aggiungere un costruttore col color
        super(color,man);
        this.mass=m;
        this.displacement=d;
    }

    public Truck(String color, boolean abs, boolean airbag, boolean collisionControl) {
        super(color);
        this.abs = abs;
        this.airbag = airbag;
        this.collisionControl = collisionControl;
    }

    @Override
    public double performance() throws ArithmeticException {
        return super.performance()/PERFORMANCEREDUCTION;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "abs=" + abs +
                ", airbag=" + airbag +
                ", collisionControl=" + collisionControl +
                ", mass=" + mass +
                ", displacement=" + displacement +
                ", licencePlate='" + licencePlate + '\'' +
                ", color='" + color + '\'' +
                "security devices='"+getSecurityDeices()+"'"+
                "performance='"+performance()+"'"+
                '}';
    }

    @Override
    public String getSecurityDeices() {
        return "Security devices-> airbag:"+airbag+" abs:"+abs+" collision control:"+collisionControl;
    }
}
