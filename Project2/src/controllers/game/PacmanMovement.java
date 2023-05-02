package controllers.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacmanMovement implements KeyListener {

    int currX, currY;

    public PacmanMovement(int x, int y) {
        this.currX = x;
        this.currY = y;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                this.currY = currY + 5;
                System.out.println("Naciśnięto klawisz W");
            }
            case KeyEvent.VK_A -> this.currX = currX - 5;
            case KeyEvent.VK_S -> this.currY = currY - 5;
            case KeyEvent.VK_D -> this.currX = currX + 5;
            default -> {
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}