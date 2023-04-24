package swing.menuPanels;

import swing.PACMANGamePanel;
import swing.menuPanels.lowerPanels.LowerMenuPanel;
import swing.menuPanels.middlePanels.CustomizeYourGamePanel;
import swing.menuPanels.middlePanels.MiddleTextPanel;
import swing.menuPanels.middlePanels.RankingPanel;
import swing.menuPanels.upperPanels.UpperMenuButtonsPanel;
import swing.menuPanels.upperPanels.UpperMenuHeadingPanel;

import javax.swing.*;
import java.awt.*;

public class MenuStartPanel extends JPanel {


    Color pink = new Color(0xFD66C3);
    Color blue = new Color(0x00FDFE);

    public MainMenuCardPanel cardsPanel;

    public MenuStartPanel(PACMANGamePanel pacmanGamePanel) {

        int width = pacmanGamePanel.screenWidth;
        int height = pacmanGamePanel.screenHeight;

        this.setLayout(new BoxLayout(this, 1)); // 1 = według osi Y
//      this.setLayout(new CardLayout());

        UpperMenuHeadingPanel upperMenuHeadingPanel = new UpperMenuHeadingPanel(width, (int) (height * 0.27));
        UpperMenuButtonsPanel upperMenuButtonsPanel = new UpperMenuButtonsPanel(width, (int) (height * 0.08), this, pacmanGamePanel);

        MiddleTextPanel middleTextPanel = new MiddleTextPanel(width, (int) (height * 0.5), pacmanGamePanel);
        cardsPanel = new MainMenuCardPanel();
        cardsPanel.add(middleTextPanel, MainMenuCardPanel.TEXT);
        cardsPanel.add(new CustomizeYourGamePanel(width, height, pacmanGamePanel), MainMenuCardPanel.NEWGAME);
        cardsPanel.add(new RankingPanel(width, height, pacmanGamePanel), MainMenuCardPanel.HIGHSCORE);

        LowerMenuPanel lowerMenuPanel = new LowerMenuPanel(width, (int) (height * 0.15));


        this.add(upperMenuHeadingPanel);
        this.add(upperMenuButtonsPanel);
        this.add(cardsPanel);
        lowerMenuPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.WHITE));
        this.add(lowerMenuPanel);
    }
}
