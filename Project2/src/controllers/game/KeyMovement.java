package controllers.game;

import model.map.MapModel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMovement implements KeyListener {

    int playerRow;
    int playerColumn;
    JTable table;
    MapModel mapModel;

    public KeyMovement(JTable table, MapModel mapModel) {
        this.table = table;
        this.mapModel = mapModel;
        this.playerColumn = mapModel.getPlayerY();
        this.playerRow = mapModel.getPlayerX();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_W, KeyEvent.VK_UP -> mapModel.setPlayerXUstawKolumne(mapModel.getPlayerX() - 1);

            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                if (mapModel.getPlayerY() - 1 < 0) {
                    mapModel.setPlayerYUstawRzad(mapModel.getColumnCount() - 1);
                    return;
                }
                mapModel.setPlayerYUstawRzad(mapModel.getPlayerY() - 1);
            }

            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> mapModel.setPlayerXUstawKolumne(mapModel.getPlayerX() + 1);

            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> {
                if (mapModel.getPlayerY() + 1 > mapModel.getColumnCount() - 1) {
                    mapModel.setPlayerYUstawRzad(0);
                    return;
                }
                mapModel.setPlayerYUstawRzad(mapModel.getPlayerY() + 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}