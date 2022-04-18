package ue2.a2;

import javax.swing.JProgressBar;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

// aktive Klasse
public class Download implements Runnable
{

    private final JProgressBar balken;
    // weitere Attribute zur Synchronisation hier definieren
    private CountDownLatch countDownLatch;
    private CyclicBarrier cyclicBarrier;

    public Download(JProgressBar balken, CountDownLatch countDownLatch, CyclicBarrier cyclicBarrier /* ggf. weitere Objekte */) {
        this.balken = balken;
        // ...
        this.countDownLatch = countDownLatch;
        this.cyclicBarrier = cyclicBarrier;
    }

    /*  hier die Methode definieren, die jeweils den Balken weiterschiebt
     *  Mit balken.getMaximum() bekommt man den Wert fuer 100 % gefuellt
     *  Mit balken.setValue(...) kann man den Balken einstellen (wieviel gefuellt) dargestellt wird
     *  Setzen Sie den value jeweils und legen Sie die Methode dann für eine zufaellige Zeit schlafen
     */

    @Override
    public void run() {
        int fuellstand = 0;
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        while(balken.getValue() != balken.getMaximum()){
            balken.setValue(fuellstand++);
            try {
                Thread.sleep(new Random().nextInt(120));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countDownLatch.countDown();
    }


}

