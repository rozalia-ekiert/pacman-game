package controllers.menu;

import views.menu.MenuStart;
import views.menu.components.middlePanels.NewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartButtonMouseListener implements MouseListener {

    private JButton play;
    private MenuStart menuStart;
    private NewGame newGame;
    private Color pink;
    private Color blue;

    public StartButtonMouseListener(NewGame newGame, MenuStart menuStart) {

        this.menuStart = menuStart;
        this.newGame = newGame;

        this.play = newGame.play;
        this.pink = newGame.pink;
        this.blue = newGame.blue;

        this.play.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.play) {
            newGame.play.setBackground(blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.play) {

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
