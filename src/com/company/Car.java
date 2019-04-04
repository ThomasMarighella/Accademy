package com.company;

import com.company.utils.VehicleUtils;

public class Car extends Vehicle{
    private int numberOfDoors;
    private boolean abs;
    private boolean airbag;

    private String security;

    public Car(String color){
        super(color);
    }

    public Car(String color,String man,double displacement, double mass){
        super(color,man);
        this.displacement=displacement;
        this.mass=mass;
    }

    public Car(String color, int numberOfDoors, double displacement, double mass, boolean abs, boolean airbag) {
        super(color);
        this.numberOfDoors = numberOfDoors;
        this.displacement = displacement;
        this.mass = mass;
        this.airbag=airbag;
        this.abs=abs;
    }


    void startEngine(){

    }

    void sopEngine(){
        int tempCounter=0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", displacement=" + displacement +
                ", mass=" + mass +
                ", licencePlate='" + licencePlate + '\'' +
                ", security devices='"+ getSecurityDeices()+
                ", performance='"+ performance()+
                '}';
    }

    // metodo calcolo prestazioni-> rappoto cilindrata e peso;

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }


    @Override
    public String getSecurityDeices() {
        return "Security devices-> airbag:"+airbag+" abs:"+abs;
    }

    // il setter della trga non serve perchè non dovrebbee essere cambiata
}
