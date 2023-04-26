package controllers.menu;

import views.menu.MenuStart;
import views.menu.components.MenuCardPanel;
import views.menu.components.upperPanels.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButtonsMouseListener implements MouseListener {

    private JButton new_game;
    private JButton high_scores;
    private JButton exit_game;
    private Color pink;
    private Color blue;
    private MenuStart menuStart;
    private Buttons buttons;

    public MenuButtonsMouseListener(Buttons buttons, MenuStart menuStart) {

        this.pink = buttons.pink;
        this.blue = buttons.blue;

        this.menuStart = menuStart;
        this.buttons = buttons;

        this.new_game = buttons.new_game;
        this.high_scores = buttons.high_scores;
        this.exit_game = buttons.exit_game;

        this.new_game.addMouseListener(this);
        this.high_scores.addMouseListener(this);
        this.exit_game.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == buttons.getNew_game()) {
            CardLayout cl = (CardLayout) (this.menuStart.cardsPanel.getLayout());
            cl.show(this.menuStart.cardsPanel, MenuCardPanel.NEWGAME);
            this.menuStart.cardsPanel.currentCardName = MenuCardPanel.NEWGAME;
            high_scores.setBackground(pink);
        }
        if (e.getSource() == this.high_scores) {
            CardLayout cl = (CardLayout) (menuStart.cardsPanel.getLayout());
            cl.show(menuStart.cardsPanel, MenuCardPanel.HIGHSCORE);
            menuStart.cardsPanel.currentCardName = MenuCardPanel.HIGHSCORE;
            buttons.new_game.setBackground(pink);
        }
        if (e.getSource() == this.exit_game) {
            System.exit(-1);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.new_game) {
            buttons.new_game.setBackground(blue);
        }
        if (e.getSource() == this.high_scores) {
            buttons.high_scores.setBackground(blue);
        }
        if (e.getSource() == this.exit_game) {
            buttons.exit_game.setBackground(blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.new_game) {
            if (menuStart.cardsPanel.currentCardName.equals(MenuCardPanel.NEWGAME)) return;
            buttons.new_game.setBackground(pink);
        }
        if (e.getSource() == this.high_scores) {
            if (menuStart.cardsPanel.currentCardName.equals(MenuCardPanel.HIGHSCORE)) return;
            buttons.high_scores.setBackground(pink);
        }
        if (e.getSource() == this.exit_game) {
            buttons.exit_game.setBackground(pink);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
