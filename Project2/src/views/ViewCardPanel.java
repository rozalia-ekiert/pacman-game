package views;

import javax.swing.*;
import java.awt.*;

public class ViewCardPanel extends JPanel {

    public static final String MENU_VIEW = "0";
    public static final String GAME_VIEW = "1";
    public String currentCardName = MENU_VIEW;


    public ViewCardPanel() {
        super(new CardLayout());
    }
}
