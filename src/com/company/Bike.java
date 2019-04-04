package com.company;

public class Bike extends Vehicle{
    private boolean helmet;
    private boolean abs;

    @Override
    public String getSecurityDeices() {
        return "Security devices-> helmet:"+helmet+" abs:"+abs;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "security devices='" + getSecurityDeices() + '\'' +
                ", color='" + color + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                ", mass=" + mass +
                ", displacement=" + displacement +
                ", performance='"+ performance()+
                '}';
    }
    public Bike(String color, double mass, double displacement, String man){
        super(color,man);
        this.mass=mass;
        this.displacement=displacement;
    }

    public Bike(boolean helmet, boolean abs, String color, double mass, double displacement) {
        super(color);
        this.helmet = helmet;
        this.abs = abs;
        this.mass=mass;
        this.displacement=displacement;
    }

    public boolean getHelmet() {
        return helmet;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }

    public boolean getAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }



    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
}
