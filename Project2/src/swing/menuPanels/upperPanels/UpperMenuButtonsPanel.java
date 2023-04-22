package swing.menuPanels.upperPanels;

import swing.MouseMode;
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
    public UpperMenuButtonsPanel(int width, int height, MenuStartPanel menuStartPanel) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.new_game = new JButton("new game");
        this.high_scores = new JButton("high scores");
        this.exit_game = new JButton("exit");

        ArrayList<JButton> menuButtons = new ArrayList<>();
        menuButtons.add(new_game);
        menuButtons.add(high_scores);
        menuButtons.add(exit_game);

        for (JButton b : menuButtons){
            b.setBackground(pink);
            b.setFont(new Font("Arial", Font.BOLD, 25));
            this.add(b);
        }

        GridLayout layout = new GridLayout(1, 3, 40, 0);
        this.setLayout(layout);

        new_game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                menuStartPanel.setMouseMode(MouseMode.CLICK_NEW_GAME, UpperMenuButtonsPanel.this);
            }
        });

        high_scores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
//                high_scores.setBackground(blue);
                menuStartPanel.setMouseMode(MouseMode.CLICK_HIGH_SCORES, UpperMenuButtonsPanel.this);
            }
        });

        exit_game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                menuStartPanel.setMouseMode(MouseMode.CLICK_EXIT, UpperMenuButtonsPanel.this);
            }
        });
    }

}
