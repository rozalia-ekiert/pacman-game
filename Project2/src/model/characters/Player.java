package model.characters;

import model.DrawableObjects;
import model.NumberFormatter;
import model.characters.components.CharacterAnimationState;
import model.characters.components.MapTile;
import model.game.GameThread;
import model.map.MapGenerator;
import model.map.MapModel;
import views.PACMANGame;
import views.game.Game;
import views.game.components.GameCardPanel;
import views.game.components.panels.gameWindow.Comments;
import views.game.components.panels.gameWindow.CurrentStats;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static model.map.MapGenerator.*;
import static model.map.MapModel.*;

public class Player extends Character implements MapTile {

    public static CharacterAnimationState currentState = CharacterAnimationState.PLayerDEFAULT;

    public Player(MapModel mapModel) {
        super(mapModel);
        try {
            this.image = ImageIO.read(new File("assets/pacman_icons/pac_sredni.png"));

            DrawableObjects.addDrawable(getMapCode(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getMapCode() {
        return 22;
    }


    public void moveHorizontally(int X) {
        for (Enemy e : enemies) {
            if (mapModel.getValueAt(X, getCurrentColumn()).equals(e.getMapCode())) {
                mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
                eatenByGhosts();
                return;
            }
        }
        if (isWall(X, getCurrentColumn()) || isGate(X, getCurrentColumn())) return;
        if (mapModel.getValueAt(X, getCurrentColumn()).equals(cookieSmall) || mapModel.getValueAt(X, getCurrentColumn()).equals(cookieBig)) {
            if (mapModel.getValueAt(X, getCurrentColumn()).equals(cookieSmall)) CurrentStats.yourScore += 10;
            if (mapModel.getValueAt(X, getCurrentColumn()).equals(cookieBig)) CurrentStats.yourScore += 50;
            eatCookie();
            CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
            Game.gameWindow.currentStats.compareYourAndHighScore();
            if (isThisNewMap) {
                isThisNewMap = false;
                return;
            }
        }
        mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
        mapModel.setValueAt(getMapCode(), X, getCurrentColumn());

    }

    protected void eatenByGhosts() {
        CurrentStats.livesNumber--;
        mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
        mapModel.setValueAt(getMapCode(), rows - rows / 4, columns / 2);

        Comments.message.setText(Comments.messageEatenByGhosts);
        messageTimer.start();

        removeLife();

        if (CurrentStats.livesNumber == 0) {
            CardLayout cl = (CardLayout) (PACMANGame.game.gameCardPanel.getLayout());
            cl.show(PACMANGame.game.gameCardPanel, GameCardPanel.GAME_OVER);
            GameCardPanel.currentCardName = GameCardPanel.GAME_OVER;

            GameThread.isGameViewReady.set(false);

            CurrentStats.livesNumber = 5;
            CurrentStats.yourScore = 0;
        }
    }

    @Override //TODO do zrobienia albo wyjebania
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }

    private void removeLife() {
        int counter = CurrentStats.livesNumber;

        for (int i = 0; i < CurrentStats.livesRows; i++) {
            for (int j = 0; j < 5; j++) {
                counter--;
                CurrentStats.livesTable.getColumnModel().getColumn(j).setPreferredWidth(CurrentStats.lifeCellSize);
                CurrentStats.livesTable.getColumnModel().getColumn(j).setCellRenderer(CurrentStats.mapComponentsRenderer);
                if (counter >= 0) {
                    CurrentStats.livesTable.setValueAt(33, i, j);
                } else {
                    CurrentStats.livesTable.setValueAt(19, i, j);
                }
            }
        }
        CurrentStats.model.fireTableDataChanged();
    }

    public void moveVertically(int Y) {
        for (Enemy e : enemies) {
            if (mapModel.getValueAt(getCurrentRow(), Y).equals(e.getMapCode())) {
                mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
                eatenByGhosts();
                return;
            }
        }

        if (isWall(getCurrentRow(), Y)) return;
        if (mapModel.getValueAt(getCurrentRow(), Y).equals(cookieSmall) || mapModel.getValueAt(getCurrentRow(), Y).equals(cookieBig)) {
            if (mapModel.getValueAt(getCurrentRow(), Y).equals(cookieSmall)) CurrentStats.yourScore += 10;
            if (mapModel.getValueAt(getCurrentRow(), Y).equals(cookieBig)) CurrentStats.yourScore += 50;
            eatCookie();
            CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
            Game.gameWindow.currentStats.compareYourAndHighScore();
            if (isThisNewMap) {
                isThisNewMap = false;
                return;
            }
        }
        mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
        mapModel.setValueAt(getMapCode(), getCurrentRow(), Y);
    }

    private void eatCookie() {
        cookiesCounter--;
        if (cookiesCounter == 0) {
            mapModel.map = MapGenerator.generateMap();
            mapModel.setValueAt(getMapCode(), rows - rows / 4, columns / 2);
            spawnEnemies(mapModel);
            isThisNewMap = true;
            mapModel.pacmanGame.repaint();
            Comments.message.setText(Comments.messageCookiesEaten);
            messageTimer.start();
        }
    }

    @Override
    public Image getImage() {
        return this.image;
    }
}