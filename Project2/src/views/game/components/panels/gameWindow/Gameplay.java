package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public GameplayMap map;
    public static JLabel message;

    public static String messageDefault = "<html><center><font size=6 color=black>No more cookies!<br>Good job!</br></center></html></font>";
    public static String messageCookiesEaten = "<html><center><font size=6 color=#E9FDAE>No more cookies!<br>Good job!</br></center></html></font>";

    public Gameplay(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
//        this.setFocusable(false);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        int sqHeight = (int) (height * 0.85);
        int sqWidth = sqHeight;

        //-------------------------------------------------------------------------

        GridBagConstraints gbc = new GridBagConstraints();

        message = new JLabel();
        message.setText(messageDefault);
        message.setSize(new Dimension(sqWidth, (int) (height * 0.15)));
        message.setFont(pacmanGame.Butterbelly);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        this.add(message, gbc);

        map = new GameplayMap(sqWidth, sqHeight, pacmanGame);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        this.add(map, gbc);

    }
}