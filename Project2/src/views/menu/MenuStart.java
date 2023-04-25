package views.menu;

import views.PACMANGame;
import views.menu.lowerPanels.LowerMenu;
import views.menu.middlePanels.CustomizeYourGame;
import views.menu.middlePanels.HighScores;
import views.menu.middlePanels.MiddleText;
import views.menu.upperPanels.Buttons;
import views.menu.upperPanels.Heading;

import javax.swing.*;
import java.awt.*;

public class MenuStart extends JPanel {


    public MainMenuCardPanel cardsPanel;
    Color pink = new Color(0xFD66C3);
    Color blue = new Color(0x00FDFE);

    public MenuStart(PACMANGame pacmanGameFrame) {

        int width = pacmanGameFrame.screenWidth;
        int height = pacmanGameFrame.screenHeight;

        this.setLayout(new BoxLayout(this, 1)); // 1 = według osi Y
//      this.setLayout(new CardLayout());

        Heading heading = new Heading(width, (int) (height * 0.27));
        Buttons upperMenuButtons = new Buttons(width, (int) (height * 0.08), this, pacmanGameFrame);

        MiddleText middleText = new MiddleText(width, (int) (height * 0.5), pacmanGameFrame);
        cardsPanel = new MainMenuCardPanel();
        cardsPanel.add(middleText, MainMenuCardPanel.TEXT);
        cardsPanel.add(new CustomizeYourGame(width, height, pacmanGameFrame), MainMenuCardPanel.NEWGAME);
        cardsPanel.add(new HighScores(width, height, pacmanGameFrame), MainMenuCardPanel.HIGHSCORE);

        LowerMenu lowerMenu = new LowerMenu(width, (int) (height * 0.15));


        this.add(heading);
        this.add(upperMenuButtons);
        this.add(cardsPanel);
        lowerMenu.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.WHITE));
        this.add(lowerMenu);
    }
}
