package ue2.a1.ue2.a2;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

public class ReactiveGUI implements Runnable{

    private CountDownLatch countDownLatch;
    private JButton startButton;

    public ReactiveGUI(CountDownLatch countDownLatch, JButton startButton){
        this.countDownLatch = countDownLatch;
        this.startButton = startButton;
    }


    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        startButton.setText("Downloads abgeschlossen!");
        startButton.setEnabled(true);
    }
}
