package views.game.components;

import javax.swing.*;
import java.awt.*;

public class GameCardPanel extends JPanel {

    public static final String START_SCREEN_1 = "0";
    public static final String START_SCREEN_2 = "1";
    public static final String GAME_WINDOW = "2";
    public static final String GAME_OVER = "3";

    public String currentCardName = START_SCREEN_1;


    public GameCardPanel() {
        super(new CardLayout());
    }

}
