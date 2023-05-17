package views.menu.components.middlePanels;

import views.GameColors;
import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class HighScores extends JPanel {

    public static JList ranking;

    public HighScores(int width, int height, PACMANGame pacmanGameFrame) {
        this.setBackground(Color.BLACK);
        Font currentButterbelly = new Font("Butterbelly", Font.PLAIN, 40);
        this.setLayout(new GridBagLayout());

        ranking = new JList<>();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(0, 0, GameColors.gradient1, getWidth(), getHeight(), GameColors.gradient2);
        g2d.setPaint(gradient);
        g2d.fillRect((int) (getWidth() * 0.1), (int) (getHeight() * 0.1), (int) (getWidth() * 0.8), (int) (getHeight() * 0.8));

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(Color.BLACK);
    }

}
