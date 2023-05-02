package views;

import views.game.Game;
import views.menu.MenuStart;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PACMANGame extends JFrame {

    public static final String MENU_VIEW = "0";
    public static final String GAME_VIEW = "1";
    public String currentCardName = MENU_VIEW;
    public ViewCardPanel viewsCardPanel;

    public int screenWidth;
    public int screenHeight;
    public Font Butterbelly;

    public PACMANGame() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
//        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PACMAN GAME");

        this.setFont(Butterbelly);

        Container contentPane = getContentPane();

        //==================================================================================

        String fontPath = "Butterbelly.otf";
        try {
            Font customFont = Font.createFont(Font.PLAIN, new File(fontPath));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            customFont = customFont.deriveFont(Font.PLAIN, 24);
            this.Butterbelly = customFont;

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //===================================================================================

        this.viewsCardPanel = new ViewCardPanel();

        Game game = new Game(this);
        MenuStart menuStart = new MenuStart(this, game);

        viewsCardPanel.add(menuStart, MENU_VIEW);
        viewsCardPanel.add(game, GAME_VIEW);

        contentPane.add(viewsCardPanel);

        //===================================================================================

//        this.setFocusable(true);
//        this.addKeyListener(new PacmanMovement(MapModel.pacCurrentX, MapModel.pacCurrentY));

        this.setVisible(true);
    }

}