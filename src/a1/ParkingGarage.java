package a1;

public class ParkingGarage {

    private int carAmount;
    private int maxAmount;
    private final Object monitor = new Object();

    public ParkingGarage(int maxAmount){
        this.maxAmount = maxAmount;
    }

    public void driveIn(Car car){
       synchronized (monitor){
           while(carAmount >= maxAmount){
               try{
                   System.out.println("\t Wartet auf Einfahrt: " + car.getCarName() );
                   monitor.wait();
               }catch (InterruptedException ex){

               }
           }
           carAmount++;
           System.out.println("Einfahrt: " + car.getCarName());
           monitor.notifyAll();
       }
    }

    public void driveOut(Car car){
        synchronized (monitor){
            while(carAmount < 3){
                try{
                    System.out.println("\t Wartet auf Ausfahrt: " + car.getCarName());
                    monitor.wait();
                }catch (InterruptedException ex){

                }
            }
            carAmount--;
            System.out.println("Ausfahrt: " + car.getCarName());
            monitor.notifyAll();
        }
    }
}
