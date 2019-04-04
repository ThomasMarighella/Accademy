package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDealer implements CarDealerRules, Comparable{
    // ha una lista di macchine che può vendere
    // lista di car e metodi di get e metodo di aggiunta car a lista
    private List<Vehicle> cars= new ArrayList<>();
    private String id;
    private final int MAXBIKE;// numero massimo di bike che possono essere contenuti
    private final int MAXCAR;// massimo di maccihine ( comprese rallycar)
    private final int MAXTRUCK;// massimo di truck
    // queste variabili sembrano ridondanti, forse cè un metodo più semplice per tener conto del numero
    // metto le variabilli per evitare di fare un for e un counter per ogni tipo di veicolo, però se aggiuno una nuova classe
    private int currentBike=0;
    private int currentCar=0;
    private int currentTruck=0;

    public CarDealer(String id, int b, int c, int t){// dichiaro nel costruttore quanti posti ha ogni dealer
        this.id=id;
        this.MAXBIKE=b;
        this.MAXCAR=c;
        this.MAXTRUCK=t;
    }

    public List geCars(){
        return cars;
    }

    public void addVehicle(Vehicle c) throws SpaceExeededException{// controllo quante mto/ macchine ci sono e di conseguenza tooManyBikes exeption.
        // get msg nel costruttore

        boolean i=true;// è di default true perchè se la lista è vuota non entra nel for e la variabile non viene mai inizializzata
        if(cars.contains((c))){
            i=false;
        }

        if(i){
            //int count=0;
            //for (Vehicle v2:cars) {
                    if(c instanceof Bike){

                        if (currentBike < MAXBIKE ){
                            currentBike++;
                        }
                        else{
                            throw new SpaceExeededException("bike");
                        }
                    }
                    else if(c instanceof Car){
                        if (currentCar < MAXCAR ){
                            currentCar++;
                        }
                        else{
                            throw new SpaceExeededException("car");
                        }
                    }
                    else if(c instanceof Truck){
                        if (currentTruck < MAXTRUCK ){// dovrebbe funzionare anche per le raòòy car
                            currentTruck++;
                        }
                        else{
                            throw new SpaceExeededException("truck");
                        }
                    }
                    else{
                        // tipo sconosciuto
                    }

            //}
            cars.add(c);
            System.out.println("Vehicle inserted correctly");
        }
        else System.out.println("Licence plate '"+c.getLicencePlate()+"' already present");

    }

    public Vehicle getBestVehicle(){// per il miglior veicolo, restituisco oggetto veicolo
        List<Vehicle> v= cars;
        Collections.sort(v);
        return v.get(0);

    }

    public List<Vehicle> getAllVehicles(){
        return cars;
    }
    public double getAvgPerformance(){// clcola la media escludendo i truck
        double avg=0;
        int count=0;// mi serve perchè non posso fare il size di cars perchè non conto i Truck
        for (Vehicle v:cars) {
            if(!(v instanceof Truck)){
                avg+=v.performance();
                count++;
            }
        }
        avg/=count;
        return avg;
    }
    @Override
    public String id() {
        return id;
    }

    @Override
    public int compareTo(Object o) {
        CarDealer c=(CarDealer) o;
        if(c.getAvgPerformance()>getAvgPerformance()){
            return 1;
        }
        else if(c.getAvgPerformance()<getAvgPerformance()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
