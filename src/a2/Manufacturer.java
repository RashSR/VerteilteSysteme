package a2;

import java.util.Random;

public class Manufacturer implements Runnable{

    private ParkingGarage parkingGarage;
    private int carNumber = 0;

    public Manufacturer(ParkingGarage parkingGarage){
        this.parkingGarage = parkingGarage;
    }

    @Override
    public void run() {
        while(true){
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            carNumber++;
            parkingGarage.storeCar(new Car("R-FH" + carNumber));
        }
    }
}
