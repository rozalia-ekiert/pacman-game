package views.menu;

import views.PACMANGame;
import views.game.Game;
import views.menu.components.MenuCardPanel;
import views.menu.components.lowerPanels.LowerMenu;
import views.menu.components.middlePanels.HighScores;
import views.menu.components.middlePanels.MiddleText;
import views.menu.components.middlePanels.NewGame;
import views.menu.components.upperPanels.Buttons;
import views.menu.components.upperPanels.Heading;

import javax.swing.*;
import java.awt.*;

public class MenuStart extends JPanel {

    public static MenuCardPanel cardsPanel;

    public MenuStart(PACMANGame pacmanGame, Game game) {

        this.cardsPanel = new MenuCardPanel();

        int width = pacmanGame.screenWidth;
        int height = pacmanGame.screenHeight;

        this.setLayout(new BoxLayout(this, 1)); // 1 = według osi Y

        int headingHeight = (int) (height * 0.27);
        int buttonsHeight = (int) (height * 0.08);
        int middleHeight = height - headingHeight - buttonsHeight;

        Heading heading = new Heading(width, headingHeight);
        Buttons buttons = new Buttons(width, buttonsHeight, this, pacmanGame);

        NewGame newGame = new NewGame(width, middleHeight, pacmanGame, this, game);
        HighScores highScores = new HighScores(width, middleHeight, pacmanGame);
        MiddleText middleText = new MiddleText(width, middleHeight, pacmanGame);

        cardsPanel.add(middleText, MenuCardPanel.TEXT);
        cardsPanel.add(newGame, MenuCardPanel.NEWGAME);
        cardsPanel.add(highScores, MenuCardPanel.HIGHSCORE);

        LowerMenu lowerMenu = new LowerMenu(width, (int) (height * 0.15));

        this.add(heading);
        this.add(buttons);
        this.add(cardsPanel);
        lowerMenu.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, Color.WHITE));
        this.add(lowerMenu);
    }
}
