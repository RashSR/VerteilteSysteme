package ue2.a1;

public class Waiter implements Runnable{

    private KitchenCounter kitchenCounter;
    private String name;

    public Waiter(KitchenCounter kitchenCounter, String name){
        this.kitchenCounter = kitchenCounter;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void run() {
        while(true){
            kitchenCounter.put(this);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
