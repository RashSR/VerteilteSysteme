package ue1.a1;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        ParkingGarage parkingGarage = new ParkingGarage(10);

        for(int i = 1; i <= 20; i++){
            Thread t = new Thread(new Car("R-FH" + i, parkingGarage ));
            t.setDaemon(true);
            t.start();
        }

        Thread.sleep(30000);

        System.out.println("Ende der Simulation!");
    }
}
