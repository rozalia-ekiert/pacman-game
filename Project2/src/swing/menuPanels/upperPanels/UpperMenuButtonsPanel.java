package swing.menuPanels.upperPanels;


import swing.PACMANGamePanel;
import swing.menuPanels.MainMenuCardPanel;
import swing.menuPanels.MenuStartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UpperMenuButtonsPanel extends JPanel {

    public JButton new_game;
    public JButton high_scores;
    public JButton exit_game;
    Color pink = new Color(0xFD66C3);
    Color blue = new Color(0x00FDFE);


    public UpperMenuButtonsPanel(int width, int height, MenuStartPanel menuStartPanel, PACMANGamePanel pacmanGamePanel) {

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
            b.setFont(pacmanGamePanel.Butterbelly);
            b.setForeground(Color.BLACK);
            this.add(b);
        }

        new_game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CardLayout cl = (CardLayout) (menuStartPanel.cardsPanel.getLayout());
                cl.show(menuStartPanel.cardsPanel, MainMenuCardPanel.NEWGAME);
                menuStartPanel.cardsPanel.currentCardName = MainMenuCardPanel.NEWGAME;
                high_scores.setBackground(pink);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                new_game.setBackground(blue);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (menuStartPanel.cardsPanel.currentCardName.equals(MainMenuCardPanel.NEWGAME)) return;
                new_game.setBackground(pink);
            }

        });

        high_scores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                CardLayout cl = (CardLayout) (menuStartPanel.cardsPanel.getLayout());
                cl.show(menuStartPanel.cardsPanel, MainMenuCardPanel.HIGHSCORE);
                menuStartPanel.cardsPanel.currentCardName = MainMenuCardPanel.HIGHSCORE;
                new_game.setBackground(pink);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                high_scores.setBackground(blue);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                if (menuStartPanel.cardsPanel.currentCardName.equals(MainMenuCardPanel.HIGHSCORE)) return;
                high_scores.setBackground(pink);
            }
        });

        exit_game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
