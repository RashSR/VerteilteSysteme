package ue2.a1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        KitchenCounter kitchenCounter = new KitchenCounter(4);

        new Thread(new Waiter(kitchenCounter, "Kellner-1")).start();
        new Thread(new Waiter(kitchenCounter, "Kellner-2")).start();

        for(int i = 1; i <= 8; i++){
            new Thread(new Student(kitchenCounter, "Student-"+i)).start();
        }

        Thread.sleep(30000);

        System.out.println("Ende der Simulation!");
    }
}
