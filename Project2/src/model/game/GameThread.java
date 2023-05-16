package model.game;

import model.NumberFormatter;
import model.characters.Enemy;
import views.PACMANGame;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static model.map.MapModel.enemies;

public class GameThread extends Thread {

    public static final AtomicBoolean isGameViewReady = new AtomicBoolean(false);
    PACMANGame pacmanGame;
    private final JLabel timeLabel;
    final int updatesPerSecond = 2;

    public GameThread(JLabel timeLabel, PACMANGame pacmanGame) {
        this.timeLabel = timeLabel;
        this.pacmanGame = pacmanGame;
    }

    public void run() {
        {
            long now = System.currentTimeMillis();
            long tick = 0;
            while (true) {
                if (System.currentTimeMillis() - now < 1000 / updatesPerSecond || !isGameViewReady.get()) {
                    continue;
                }
                tick++;
                update(System.currentTimeMillis() - now, tick);
                now = System.currentTimeMillis();
            }
        }
    }

    private void update(long l, long tick) {
        timeLabel.setText(NumberFormatter.changeTimeToString(tick * 1000 / updatesPerSecond));
        int counter = 0;
        for (Enemy enemy : enemies) {
            counter++;
            enemy.updateAI(enemy);
            if (counter == 4) return;
        }
//        spawnBonuses();
    }

    private void spawnBonuses() {

    }

}