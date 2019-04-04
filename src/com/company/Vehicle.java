package com.company;

import com.company.utils.VehicleUtils;

import java.lang.Comparable;

abstract public class Vehicle implements Comparable{
    // performance get sec devices, massa e cilindrata obbligatorie,
    protected double mass, displacement;
    protected Manifacturer manifacturer;
    protected String licencePlate;
    protected Color color;

    public Vehicle(String color){
        this.licencePlate= VehicleUtils.getNextPlate();
        setColor(color);

    }

    public Vehicle(String color, String man){
        this.licencePlate= VehicleUtils.getNextPlate();
        setColor(color);
        setManifacturer(man);
    }

    public double performance()  throws ArithmeticException{
        return displacement/mass;// da togliere int
    }

    public abstract String getSecurityDeices();

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getDisplacement() {
        return displacement;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(String color) {
        for (Color c2: Color.values()){
            if(color.equals(c2.toString())){
                this.color = c2;
            }
        }
        //this.color = Color.valueOf(color);
    }

    public Manifacturer getManifacturer() {
        return manifacturer;
    }

    public void setManifacturer(String manifacturer) {

        for (Manifacturer c2: Manifacturer.values()){
            if(manifacturer.equals(c2.toString())){
                this.manifacturer = c2;
            }
        }
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    @Override
    public boolean equals(Object c) {//
        if( ! (c instanceof Vehicle)) return false;

        Vehicle v=(Vehicle) c;

        if (v.getLicencePlate().equals(licencePlate)) return true;

        else return false;

    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    @Override
    public int compareTo(Object o) {
        Vehicle v1=(Vehicle) o;
        if(v1.performance()>performance()){
            return 1;
        }
        else if(v1.performance()<performance()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
