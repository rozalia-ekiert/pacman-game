package views.menu.components.upperPanels;


import views.PACMANGame;
import views.menu.MenuStart;
import views.menu.components.MainMenuCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Buttons extends JPanel {

    public JButton new_game;
    public JButton high_scores;
    public JButton exit_game;
    Color pink = new Color(0xFD66C3);
    Color blue = new Color(0x00FDFE);


    public Buttons(int width, int height, MenuStart menuStart, PACMANGame pacmanGameFrame) {

        //==============================================================================

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        GridLayout layout = new GridLayout(1, 3, 40, 20);
        this.setLayout(layout);

        //================================================================================

        this.new_game = new JButton("new game");
        this.high_scores = new JButton("HIgH scores");
        this.exit_game = new JButton("exIT");

        ArrayList<JButton> menuButtons = new ArrayList<>();
        menuButtons.add(new_game);
        menuButtons.add(high_scores);
        menuButtons.add(exit_game);

        for (JButton b : menuButtons) {
            b.setBackground(pink);
            b.setFont(pacmanGameFrame.Butterbelly);
            b.setForeground(Color.BLACK);
            this.add(b);
        }

        new_game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CardLayout cl = (CardLayout) (menuStart.cardsPanel.getLayout());
                cl.show(menuStart.cardsPanel, MainMenuCardPanel.NEWGAME);
                menuStart.cardsPanel.currentCardName = MainMenuCardPanel.NEWGAME;
                high_scores.setBackground(pink);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                new_game.setBackground(blue);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (menuStart.cardsPanel.currentCardName.equals(MainMenuCardPanel.NEWGAME)) return;
                new_game.setBackground(pink);
            }

        });

        high_scores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CardLayout cl = (CardLayout) (menuStart.cardsPanel.getLayout());
                cl.show(menuStart.cardsPanel, MainMenuCardPanel.HIGHSCORE);
                menuStart.cardsPanel.currentCardName = MainMenuCardPanel.HIGHSCORE;
                new_game.setBackground(pink);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                high_scores.setBackground(blue);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (menuStart.cardsPanel.currentCardName.equals(MainMenuCardPanel.HIGHSCORE)) return;
                high_scores.setBackground(pink);
            }
        });

        exit_game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(-1);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                exit_game.setBackground(blue);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                exit_game.setBackground(pink);
            }
        });

        //==========================================================================

    }

}
