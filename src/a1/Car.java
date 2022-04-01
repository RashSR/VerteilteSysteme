package a1;

import java.util.Random;

public class Car implements Runnable{

    private ParkingGarage parkingGarage;
    private String carName;

    public Car(String carName, ParkingGarage parkingGarage){
        this.parkingGarage = parkingGarage;
        this.carName = carName;
    }

    @Override
    public void run() {
        while(true){
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(10000));
                parkingGarage.driveIn(this);
                Thread.sleep(random.nextInt(10000));
                parkingGarage.driveOut(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public String getCarName(){
        return this.carName;
    }
}
