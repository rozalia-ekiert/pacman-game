package controllers.menu;

import controllers.game.GameViewChange;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.Game;
import views.menu.components.middlePanels.NewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayButtonMouseListener implements MouseListener {

    private JButton play;
    private PACMANGame pacmanGame;
    private NewGame newGame;
    private Game game;
    private Color pink;
    private Color blue;

    public PlayButtonMouseListener(NewGame newGame, PACMANGame pacmanGame, Game game) {

        this.pacmanGame = pacmanGame;
        this.newGame = newGame;
        this.game = game;

        this.play = newGame.play;
        this.pink = newGame.pink;
        this.blue = newGame.blue;

        this.play.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.play) {
            //todo jeśli pola nie są wypełnione nie rób

            CardLayout cl = (CardLayout) (this.pacmanGame.viewsCardPanel.getLayout());
            cl.show(this.pacmanGame.viewsCardPanel, ViewCardPanel.GAME_VIEW);
            this.pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.GAME_VIEW;

            GameViewChange gameViewChange = new GameViewChange(game, pacmanGame);
        }
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
            newGame.play.setBackground(pink);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
