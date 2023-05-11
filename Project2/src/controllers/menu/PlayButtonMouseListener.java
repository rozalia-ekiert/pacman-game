package controllers.menu;

import model.game.TimeThread;
import views.GameColors;
import views.PACMANGame;
import views.ViewCardPanel;
import views.game.Game;
import views.game.components.GameViewChange;
import views.game.components.panels.gameWindow.Gameplay;
import views.game.components.panels.gameWindow.GameplayMap;
import views.menu.components.MenuCardPanel;
import views.menu.components.middlePanels.NewGame;
import views.menu.components.upperPanels.Buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
            //todo jeśli pola nie są wypełnione nie rób

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

                System.out.println(newGame.play.isFocusOwner()); //true

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;
                gbc.anchor = GridBagConstraints.CENTER;

                Gameplay.map = new GameplayMap(Gameplay.sqWidth, Gameplay.sqHeight, pacmanGame);
                game.gameWindow.gameplay.add(Gameplay.map, gbc);

                //===============================================================================
                CardLayout c1 = (CardLayout) (PACMANGame.menuStart.cardsPanel.getLayout());
                c1.show(PACMANGame.menuStart.cardsPanel, MenuCardPanel.TEXT);
                PACMANGame.menuStart.cardsPanel.currentCardName = MenuCardPanel.TEXT;
                Buttons.new_game.setBackground(GameColors.pink);
                Buttons.high_scores.setBackground(GameColors.pink);
                //===============================================================================
                CardLayout c2 = (CardLayout) (this.pacmanGame.viewsCardPanel.getLayout());
                c2.show(this.pacmanGame.viewsCardPanel, ViewCardPanel.GAME_VIEW);
                this.pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.GAME_VIEW;
                //===============================================================================
                game.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
                            System.out.println("Pressed Ctrl + Shift + Q");

                            CardLayout cl = (CardLayout) (pacmanGame.viewsCardPanel.getLayout());
                            cl.show(pacmanGame.viewsCardPanel, ViewCardPanel.MENU_VIEW);
                            pacmanGame.viewsCardPanel.currentCardName = ViewCardPanel.MENU_VIEW;
                        }
                    }
                });
                //===============================================================================
                synchronized (monitor) {
                    TimeThread.isGameViewReady = true;
                    monitor.notify();
                }
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
