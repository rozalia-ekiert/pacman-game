package swing.menuPanels.upperPanels;

import swing.MouseMode;
import swing.menuPanels.MenuStartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UpperMenuButtonsPanel extends JPanel {

    public JButton new_game;
    public JButton high_scores;
    public JButton exit_game;
    Color pink = new Color(0xFD66C3);
    Color blue = new Color(0x00FDFE);

    public Font Butterbelly;

    public UpperMenuButtonsPanel(int width, int height, MenuStartPanel menuStartPanel) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.new_game = new JButton("new game");
        this.high_scores = new JButton("HIgH scores");
        this.exit_game = new JButton("exIT");

        ArrayList<JButton> menuButtons = new ArrayList<>();
        menuButtons.add(new_game);
        menuButtons.add(high_scores);
        menuButtons.add(exit_game);


        GridLayout layout = new GridLayout(1, 3, 40, 0);
        this.setLayout(layout);

        String fontPath = "Butterbelly.otf";
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            customFont = customFont.deriveFont(Font.TRUETYPE_FONT, 24);
            this.Butterbelly = customFont;

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (JButton b : menuButtons) {
            b.setBackground(pink);
            b.setFont(Butterbelly);
            b.setForeground(Color.BLACK);
            this.add(b);

        }

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
