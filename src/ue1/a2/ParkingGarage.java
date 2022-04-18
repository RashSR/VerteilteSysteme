package ue1.a2;

import java.util.Deque;
import java.util.LinkedList;

public class ParkingGarage {
    private int maxAmount;
    private Deque<Car> storedCars = new LinkedList<>();
    private final Object monitor = new Object();

    public ParkingGarage(int maxAmount){
        this.maxAmount = maxAmount;
    }

    public void storeCar(Car car){
        synchronized (monitor){
            while(storedCars.size() >= maxAmount){
                try {
                    System.out.println(car.getLicensePlate() + " has to wait to be stored.");
                    monitor.wait();
                }catch(InterruptedException ex){

                }
            }
            storedCars.add(car);
            System.out.println("Stored Car: " + car.getLicensePlate());
            monitor.notifyAll();
        }
    }

    public void buyCar(){
        synchronized (monitor){
            while (storedCars.size() <= 0){
                try{
                    System.out.println("Can't buy a Car. Have to wait.");
                    monitor.wait();
                }catch (InterruptedException ex){

                }
            }
            Car c = storedCars.pop();
            System.out.println("Selled Car: " + c.getLicensePlate());
            monitor.notifyAll();
        }
    }
}
