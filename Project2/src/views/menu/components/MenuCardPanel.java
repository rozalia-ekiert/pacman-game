package views.menu.components;

import javax.swing.*;
import java.awt.*;

public class MenuCardPanel extends JPanel {

    public static final String TEXT = "0";
    public static final String HIGHSCORE = "1";
    public static final String NEWGAME = "2";
    public String currentCardName = TEXT;


    public MenuCardPanel() {
        super(new CardLayout());
    }
}
