package views.menu;

import javax.swing.*;
import java.awt.*;

public class MainMenuCardPanel extends JPanel {
    public static final String TEXT = "0";
    public static final String HIGHSCORE = "1";
    public static final String NEWGAME = "3";

    public String currentCardName = TEXT;


    public MainMenuCardPanel() {
        super(new CardLayout());

    }
}
