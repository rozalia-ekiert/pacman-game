package controllers.game;

import model.map.MapTable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacmanMovement implements KeyListener {

    int x;
    int y;

    public PacmanMovement(int x, int y, MapTable mapTable) {
//        this.x = mapTable.mapModel.getPacCurrentX();
//        this.y = mapTable.mapModel.getPacCurrentY();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                this.y = y + 5;
                System.out.println("Naciśnięto klawisz W");
            }
            case KeyEvent.VK_A -> this.x = x - 5;
            case KeyEvent.VK_S -> this.y = y - 5;
            case KeyEvent.VK_D -> this.x = x + 5;
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}