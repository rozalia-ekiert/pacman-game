package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Comments extends JPanel {

    public static JLabel message;
    public static String messageDefault = "<html><center><font size=6 color=black>No more cookies!<br>Good job!</br></center></html></font>";
    public static String messageCookiesEaten = "<html><center><font size=6 color=#E9FDAE>No more cookies!<br>Good job!</center></html></font>";
    public static String messageEatenByGhosts = "<html><center><font size=6 color=#E9FDAE>You were eaten by the ghosts!<br>Be careful!</br></center></html></font>";
    String comment;


    public Comments(int width, int height, PACMANGame pacmanGame) {

        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.BLACK);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        message = new JLabel();
        message.setText(messageDefault);
//        message.setSize(new Dimension(getSize().width, (int) (height * 0.15)));
        message.setFont(pacmanGame.Butterbelly);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 20, 0, 20);
        gbc.anchor = GridBagConstraints.NORTH;

        this.add(message, gbc);

    }
}
