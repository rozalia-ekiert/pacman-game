package model.game;

import controllers.menu.PlayButtonMouseListener;
import model.NumberFormatter;
import views.PACMANGame;

import javax.swing.*;

public class TimeThread extends Thread {
    private static final Object monitor = PlayButtonMouseListener.monitor;
    public static boolean isGameViewReady = false;
    PACMANGame pacmanGame;
    private JLabel timeLabel;
    private long startTime;

    public TimeThread(JLabel timeLabel, PACMANGame pacmanGame) {
        this.timeLabel = timeLabel;
        this.pacmanGame = pacmanGame;
    }

    public void run() {
        synchronized (monitor) {
            while (!isGameViewReady) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startTime = System.currentTimeMillis();  //todo zmiana razem z czasem wyświetlania screen1 i 2
                while (isGameViewReady) {
                    long currentTime = System.currentTimeMillis() - 1000;
                    long gameTime = (currentTime - startTime);
                    timeLabel.setText(NumberFormatter.changeTimeToString(gameTime));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}