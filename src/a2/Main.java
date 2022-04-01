package a2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ParkingGarage parkingGarage = new ParkingGarage(10);

        Manufacturer manufacturer = new Manufacturer(parkingGarage);
        Thread t = new Thread(manufacturer);
        t.setDaemon(true);
        t.start();

        for(int i = 0; i < 5; i++){
            Customer customer = new Customer(parkingGarage);
            t = new Thread(customer);
            t.setDaemon(true);
            t.start();
        }

        Thread.sleep(30000);
        System.out.println("Simulation Ende!");
    }
}
