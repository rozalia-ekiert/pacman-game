package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public Gameplay(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));

        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        int sqHeight = (int) (height * 0.8);
        int sqWidth = sqHeight;

        // --------------------------------------------------------------------------------
        JPanel map = new GameplayMap(sqWidth, sqHeight);
        int top = 30;
        this.setBorder(BorderFactory.createMatteBorder(top, top, top, top, Color.RED));

        // --------------------------------------------------------------------------------

        GridBagConstraints gbc = new GridBagConstraints();
        this.add(map);
    }
}
