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

    public MenuCardPanel cardsPanel;

    public MenuStart(PACMANGame pacmanGame, Game game) {

        int width = pacmanGame.screenWidth;
        int height = pacmanGame.screenHeight;

        this.setLayout(new BoxLayout(this, 1)); // 1 = według osi Y

        Heading heading = new Heading(width, (int) (height * 0.27));
        Buttons buttons = new Buttons(width, (int) (height * 0.08), this, pacmanGame);

//        buttons.setFocusable(true);

        MiddleText middleText = new MiddleText(width, (int) (height * 0.5), pacmanGame);
        NewGame newGame = new NewGame(width, height, pacmanGame, this, game);
        HighScores highScores = new HighScores(width, height, pacmanGame);

//        newGame.setFocusable(true);

        cardsPanel = new MenuCardPanel();
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
