package ue2.a1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KitchenCounter {

    private int maxAmount;
    private int amount;
    Lock monitor = new ReentrantLock();
    Condition taker = monitor.newCondition();
    Condition puter = monitor.newCondition();

    public KitchenCounter(int maxAmount){
        this.maxAmount = maxAmount;
    }

    public void put(Waiter waiter){
        monitor.lock();
        try{
            while(amount >= maxAmount){
                try{
                    System.out.println("Puter has to wait.");
                    puter.await();
                }catch (InterruptedException ex){

                }
            }
            System.out.println(waiter.getName() + " added one Semmel. Amount: " + amount);
            amount++;
            taker.signal();
        }finally {
            monitor.unlock();
        }
    }

    public void take(Student student){
        monitor.lock();
        try{
            while(amount <= 0){
                try{
                    System.out.println("Taker has to wait.");
                    taker.await();
                }catch (InterruptedException ex){

                }
            }
            System.out.println(student.getName() + " removed one Semmel. Amount: " + amount);
            amount--;
            puter.signal();
        }finally {
            monitor.unlock();
        }
    }
}
