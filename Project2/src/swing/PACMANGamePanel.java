package swing;

import swing.menuPanels.MenuStartPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PACMANGamePanel extends JFrame {

    public int screenWidth;
    public int screenHeight;
    public Font Butterbelly;

    public PACMANGamePanel(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        this.setResizable(true);
//        this.setLocationRelativeTo(null);
        this.setTitle("PACMAN GAME");

        //==================================================================================

        String fontPath = "Butterbelly.otf";
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            customFont = customFont.deriveFont(Font.TRUETYPE_FONT, 24);
            this.Butterbelly = customFont;

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //===================================================================================

        MenuStartPanel menuStartPanel = new MenuStartPanel(this);
        this.add(menuStartPanel);

        this.setVisible(true);
    }

}
