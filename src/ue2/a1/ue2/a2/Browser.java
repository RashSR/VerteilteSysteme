package ue2.a1.ue2.a2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Browser extends JFrame implements ActionListener{

    private int downloads;
    private JProgressBar[] balken;
    private JButton startButton;

    // Deklaration Ihrer Synchronisations-Hilfsklassen hier:
    private CountDownLatch countDownLatch;
    private CyclicBarrier cyclicBarrier;
    private Thread[] threadPool;

    private Thread t;

    public Browser(int downloads) {
        super("Mein Download-Browser");
        this.downloads = downloads;

        // Initialisierung Ihrer Synchronisations-Hilfsklassen hier:
        countDownLatch = new CountDownLatch(downloads);
        cyclicBarrier = new CyclicBarrier(downloads + 1);

        // Aufbau der GUI-Elemente:
        balken = new JProgressBar[downloads];
        JPanel zeilen = new JPanel(new GridLayout(downloads, 1));

        for(int i=0; i<downloads; i++) {
            JPanel reihe = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 10));
            balken[i] = new JProgressBar(0, 100);
            balken[i].setPreferredSize(new Dimension(500, 20));
            reihe.add(balken[i]);
            zeilen.add(reihe);


            // neue Download-Threads erzeugen und starten
            // ggf. müssen Synchronisations-Objekte im Konstruktor übergeben werden!!
            // balken ist ebenfalls zu übergeben!
             new Thread(new Download(balken[i], countDownLatch, cyclicBarrier)).start();
        }

        startButton = new JButton("Downloads starten");
        startButton.addActionListener(this);

        this.add(zeilen, BorderLayout.CENTER);
        this.add(startButton, BorderLayout.SOUTH);


        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws InterruptedException {
        new Browser(5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Blockierte Threads jetzt laufen lassen
        if(startButton.getText().equals("Downloads abgeschlossen!")){
            this.dispose();
            new Browser(5);
        }else {
            startButton.setEnabled(false);
            startButton.setSelected(false);
            startButton.setText("Downloads laufen...");

            try {
                cyclicBarrier.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (BrokenBarrierException ex) {
                ex.printStackTrace();
            }

            // Auf Ende aller Download-Threads warten ... erst dann die Beschriftung ändern
            // Achtung, damit die Oberflaeche "reaktiv" bleibt dies in einem eigenen Runnable ausfuehren!

            new Thread(new ReactiveGUI(countDownLatch, startButton)).start();
        }


    }

}

