package views.game.components.panels.gameWindow;

import views.PACMANGame;

import javax.swing.*;
import java.awt.*;

public class Gameplay extends JPanel {

    public static GameplayMap map;
    public static JLabel message;

    public static int sqHeight;
    public static int sqWidth;

    public static String messageDefault = "<html><center><font size=6 color=black>No more cookies!<br>Good job!</br></center></html></font>";
    public static String messageCookiesEaten = "<html><center><font size=6 color=#E9FDAE>No more cookies!<br>Good job!</center></html></font>";
    public static String messageEatenByGhosts = "<html><center><font size=6 color=#E9FDAE>You were eaten by the ghosts!<br>Be careful!</br></center></html></font>";

    public Gameplay(int width, int height, PACMANGame pacmanGame, int setRows, int setColumns) {

//        this.setFocusable(false);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridBagLayout());

        sqHeight = (int) (height * 0.85);
        sqWidth = sqHeight;

        //-------------------------------------------------------------------------

        GridBagConstraints gbc = new GridBagConstraints();

        message = new JLabel();
        message.setText(messageDefault);
        message.setSize(new Dimension(getSize().width, (int) (height * 0.15)));
        message.setFont(pacmanGame.Butterbelly);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.NORTH;

//        this.add(message, gbc);

        map = new GameplayMap(sqWidth, sqHeight, pacmanGame, setRows, setColumns);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(Gameplay.map, gbc);


    }
}