package model.game;

import model.NumberFormatter;
import model.characters.Enemy;
import model.map.MapModel;
import views.PACMANGame;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static model.map.MapModel.enemies;
import static model.map.MapModel.player;

public class GameThread extends Thread {

    public static final AtomicBoolean isGameViewReady = new AtomicBoolean(false);
    PACMANGame pacmanGame;
    private final JLabel timeLabel;
    final int updatesPerSecond = 2;
    final int animationUpdatePerSecond = 6;
    int pacCounter = 0;
    public static final AtomicBoolean isReady = new AtomicBoolean(true);

    public GameThread(JLabel timeLabel, PACMANGame pacmanGame) {
        this.timeLabel = timeLabel;
        this.pacmanGame = pacmanGame;
    }

    public void run() {
        {
            long now1 = System.currentTimeMillis();
            long now2 = System.currentTimeMillis();
            long tick = 0;
            isReady.set(true);
            while (isReady.get()) {
                if (System.currentTimeMillis() - now2 < 1000 / animationUpdatePerSecond || !isGameViewReady.get()) {
                    continue;
                }
                animationUpdate();
                now2 = System.currentTimeMillis();

                if (System.currentTimeMillis() - now1 < 1000 / updatesPerSecond || !isGameViewReady.get()) {
                    continue;
                }
                tick++;
                update(System.currentTimeMillis() - now1, tick);
                now1 = System.currentTimeMillis();
            }
        }
    }

    private void update(long deltaT, long tick) {
        timeLabel.setText(NumberFormatter.changeTimeToString(tick * 1000 / updatesPerSecond));

        for (Enemy enemy : enemies) {
            enemy.updateAI();
            if (tick % 5 == 0) {
                enemy.spawnBonuses();
            }
        }
        System.out.println();
        MapModel.showModel();
    }

    private void animationUpdate() {
        for (Enemy enemy : enemies) {
            enemy.updateEnemyAnimation(enemy);
        }
        if (pacCounter == 4) pacCounter = 0;
        player.updatePacmanAnimation(pacCounter);
        pacCounter++;
    }

}