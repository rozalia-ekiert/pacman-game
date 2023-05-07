package controllers.menu;

import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.Game;
import views.game.components.GameViewChange;
import views.game.components.TimeThread;
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
    public static final Object monitor = new Object();


    public PlayButtonMouseListener(NewGame newGame, PACMANGame pacmanGame, Game game) {
        this.pacmanGame = pacmanGame;
        this.newGame = newGame;
        this.game = game;

        this.play = newGame.play;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.play) {
            //todo jeśli pola nie są wypełnione nie rób

//            game.gameWindow.gameplay.map.mapTable.setFocusable(true);
//            game.gameWindow.gameplay.map.mapTable.requestFocus();
//            game.gameWindow.gameplay.map.mapTable.grabFocus();

//            game.addKeyListener(new KeyMovement(game.gameWindow.gameplay.map.mapTable, game.gameWindow.gameplay.map.mapModel));
//            game.setFocusable(true);
//            game.requestFocusInWindow();

            System.out.println(newGame.play.isFocusOwner()); //true

//            newGame.play.setFocusable(false);
//            newGame.play.setEnabled(false);
//            newGame.play.setFocusTraversalKeysEnabled(false);

            CardLayout cl = (CardLayout) (this.pacmanGame.viewsCardPanel.getLayout());
            cl.show(this.pacmanGame.viewsCardPanel, ViewCardPanel.GAME_VIEW);
            this.pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.GAME_VIEW;

            synchronized (monitor) {
                TimeThread.isGameViewReady = true;
                monitor.notify();
            }

            GameViewChange gameViewChange = new GameViewChange(game, pacmanGame);

        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == this.play) {
            newGame.play.setBackground(GameColors.blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == this.play) {
            newGame.play.setBackground(GameColors.pink);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
