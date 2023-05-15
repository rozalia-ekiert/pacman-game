package controllers.game;

import model.map.MapModel;
import views.PACMANGame;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static model.map.MapModel.player;

public class PacKeyMovement implements KeyListener {

    int playerRow;
    int playerColumn;
    JTable table;
    MapModel mapModel;
    PACMANGame pacmanGame;

    public PacKeyMovement(JTable table, MapModel mapModel, PACMANGame pacmanGame) {
        this.table = table;
        this.mapModel = mapModel;
        this.pacmanGame = pacmanGame;

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                player.setPlayerXUstawKolumne(player.getCurrentRow() - 1);
            }

            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                if (player.getCurrentColumn() - 1 < 0) {
                    player.setPlayerYUstawRzad(mapModel.getColumnCount() - 1);
                    return;
                }
                player.setPlayerYUstawRzad(player.getCurrentColumn() - 1);
            }

            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                player.setPlayerXUstawKolumne(player.getCurrentRow() + 1);
            }

            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                if (player.getCurrentColumn() + 1 > mapModel.getColumnCount() - 1) {
                    player.setPlayerYUstawRzad(0);
                    return;
                }
                player.setPlayerYUstawRzad(player.getCurrentColumn() + 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}