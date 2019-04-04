package com.company;

import com.company.utils.VehicleUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        double d = 200;
        double m = 3.5;
        Scanner in = new Scanner(System.in);
        Car car1 = new Car("ORANGE");
        car1.setDisplacement(d);
        car1.setMass(m);

        RallyCar rallyCar = new RallyCar("OPEL", "RED");
        rallyCar.setDisplacement(d);
        rallyCar.setMass(m);

        //Truck truck1 = new Truck(5, 545, "PURPLE","");

        Bike bike1 = new Bike(true, false, "RED", 2, 200);
        Bike bike2 = new Bike(true, false, "red", 1, 200);

        CarDealer dealerIn= localFileToDealer("inport.txt","in id", 9,9,9);


        // faccio un'arrai di cardealer per trovare quello con la media più alta


        CarDealer dealer = new CarDealer("id1", 2, 2, 2);
        try {
            dealer.addVehicle(car1);
            dealer.addVehicle(car1);
            dealer.addVehicle(rallyCar);
            dealer.addVehicle(bike1);
            //dealer.addVehicle(truck1);
        } catch (SpaceExeededException e) {
            System.out.println(e);
        }


        CarDealer dealer2 = new CarDealer("id2", 3, 3, 3);
        try {
            dealer2.addVehicle(car1);
            dealer2.addVehicle(bike2);
        } catch (SpaceExeededException e) {
            System.out.println(e);
        }
        VehicleUtils.colorChange(bike2, "GREEN");

        List<CarDealer> dealers = new ArrayList<>();
        dealers.add(dealer);
        dealers.add(dealer2);
        dealers.add(dealerIn);



// trovare in media tra due dealer chi ha in media le auto più performanti (e chi ha la macchina più performante )
        //System.out.println("Insert the list of cars(type e to exit):");
        /*while(true){// WIP: da mettere l'opzione di inseriment di bike/car/rallyCar/Truck; da mettere l'opzione per selezionare il car dealer in cui mettere i vehicle; da mettere l'opzione per aggiungere car dealers
         *//*
         * loop infinito che richiede di inserire i parametri di car. pwe uscire scrvo e nel Licence Plate
         *
         *
         * @throws InputMismatchExeption: se l'input non è consentito e di tipo diverso
         * *//*
            try{
                System.out.print("Licence plate:");
                String lp=in.nextLine();// per lo string
                if(lp.equals("e")){
                    break;
                }// non dovrebbe servire l'else perchè faccio il break

                System.out.print("number of doors:");
                int nd= in.nextInt();// per gli int

                System.out.print("Displacement:");
                double di= in.nextDouble();

                System.out.print("Mass:");
                double ma=in.nextDouble();

                System.out.print("Color:");
                String co=in.next();
                //in.next();// color non sembra inserirlo

                System.out.println("Airbag:");
                boolean air= in.nextBoolean();
                in.nextLine();

                System.out.println("Abs:");
                boolean abs= in.nextBoolean();
                in.nextLine();

                // se non lo metto non mi fa mettere co
                Car c=new Car(co,nd,di,ma,lp, abs, air);
                dealer.addVehicle(c);
            }
            catch(InputMismatchException e){
                System.out.println("Tipo di input non consentito \n errore: "+e.getMessage());
                in.nextLine();// va messo perchè se no licence plate non viene inserito
            }
        }
*/

        for (CarDealer c : dealers) {
            List<Vehicle> dealerList = c.geCars();
            try {
                Collections.sort(dealerList);
            } catch (ArithmeticException e) {
                System.out.println("Errore nel calcolo: " + e.getMessage());
            }
        }
        Collections.sort(dealers);// con questo sort quello con la media più alta sarà semre in posizione 0
        System.out.println("The car dealer with the highest average performance is :" + dealers.get(0).id() + " with an average performance of: " + dealers.get(0).getAvgPerformance());// stampo il to string del migliore
        // 83.93 media
        // cn string.format("%03", Stringa )
        System.out.println("And " + dealers.get(0).id() +"'s best vehicle is: "+dealers.get(0).getBestVehicle());
        //fiat biaggio e iveco

    }


    private static CarDealer localFileToDealer(String file, String id, int b, int c, int t) {// da mettere direttamente un cardealer in return
        BufferedReader read = null;
        //List<Vehicle> vehicles= new ArrayList<>();
        CarDealer dealer=new CarDealer(id,b,c,t);
        try {
            read = new BufferedReader(new FileReader(file));
            String line;
            while ((line = read.readLine()) != null) {
                String[] linea= line.split(",");
                String i=linea[0];
                for (Manifacturer c2: Manifacturer.values()){
                    if(i.equals(c2.toString())){
                        switch(c2.getCat()){
                            case "car":
                                dealer.addVehicle(new Car(linea[1],i,Double.parseDouble(linea[3]),Double.parseDouble(linea[2])));
                                break;
                            case "rally car":
                                dealer.addVehicle(new RallyCar(linea[2],linea[1],i,Double.parseDouble(linea[3]),Double.parseDouble(linea[2])));
                                break;
                            case "bike":
                                dealer.addVehicle(new Bike(linea[1],Double.parseDouble(linea[2]),Double.parseDouble(linea[3]),i));
                                break;
                            case "truck":
                                dealer.addVehicle(new Truck(Double.parseDouble(linea[2]),Double.parseDouble(linea[3]),linea[1],i));
                                break;
                        }
                    }
                }

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (SpaceExeededException e) {
            e.printStackTrace();
        } finally {
            try {
                if (read != null) {
                    read.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return dealer;
    }
}