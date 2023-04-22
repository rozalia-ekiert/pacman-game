package swing;

import swing.gamePanels.GameoverPanel;
import swing.gamePanels.GameplayPanel;
import swing.menuPanels.MenuStartPanel;
import swing.menuPanels.middlePanels.RankingPanel;

import javax.swing.*;
import java.awt.*;

public class PACMANGamePanel extends JFrame {

    public int screenWidth;
    public int screenHeight;

    public PACMANGamePanel(){

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        this.screenWidth = screenSize.width;
        this.screenHeight = screenSize.height;

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);
        this.setResizable(true);
        this.setTitle("PACMAN GAME");

        MenuStartPanel menuStartPanel = new MenuStartPanel(screenWidth, screenHeight);
        this.add(menuStartPanel);

        this.setVisible(true);
    }


}
