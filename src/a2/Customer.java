package a2;

import java.util.Random;

public class Customer implements Runnable{

    private ParkingGarage parkingGarage;

    public Customer(ParkingGarage parkingGarage){
        this.parkingGarage = parkingGarage;
    }

    @Override
    public void run() {
        while(true){
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parkingGarage.buyCar();
        }
    }
}
