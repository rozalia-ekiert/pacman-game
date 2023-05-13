package controllers.menu;

import controllers.game.BackToMenuShortCut;
import model.game.TimeThread;
import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.Game;
import views.game.components.GameCardPanel;
import views.game.components.GameViewChange;
import views.game.components.panels.GameWindow;
import views.menu.components.middlePanels.NewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayButtonMouseListener implements MouseListener {

    private final JButton play;
    private final PACMANGame pacmanGame;
    private final NewGame newGame;
    private final Game game;
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

            if (!NewGame.isValue1Valid || !NewGame.isValue2Valid) {
                NewGame.warningField.setText(NewGame.warningFieldIsNotCorrectSize);
                if (NewGame.isNickValid) {
                    NewGame.warningNick.setText(NewGame.warningFieldIsNotCorrectSizeDefaut);
                }
            }
            if (!NewGame.isNickValid) {
                NewGame.warningNick.setText(NewGame.warningYourNickExists);
                if (NewGame.isValue1Valid && NewGame.isValue2Valid) {
                    NewGame.warningField.setText(NewGame.warningYourNickExistsDefault);
                }
            }

            if (NewGame.isValue1Valid && NewGame.isValue2Valid && NewGame.isNickValid) {

                System.out.println(newGame.play.isFocusOwner());

                Game.gameWindow = new GameWindow(PACMANGame.screenWidth, PACMANGame.screenHeight, pacmanGame, NewGame.setRows, NewGame.setColumns);
                game.gameCardPanel.add(Game.gameWindow, GameCardPanel.GAME_WINDOW);
                CardLayout cl1 = (CardLayout) (game.gameCardPanel.getLayout());
                cl1.show(game.gameCardPanel, GameCardPanel.currentCardName);

                //===============================================================================

                CardLayout cl = (CardLayout) (this.pacmanGame.viewsCardPanel.getLayout());
                cl.show(this.pacmanGame.viewsCardPanel, ViewCardPanel.GAME_VIEW);
                this.pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.GAME_VIEW;

                //===============================================================================

                synchronized (monitor) {
                    TimeThread.isGameViewReady = true;
                    monitor.notify();
                }

                //===============================================================================

                game.addKeyListener(new BackToMenuShortCut(pacmanGame));


                //===============================================================================

                GameViewChange gameViewChange = new GameViewChange(game, pacmanGame);
            }
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
