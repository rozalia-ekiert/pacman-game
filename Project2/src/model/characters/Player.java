package model.characters;

import model.DrawableObjects;
import model.NumberFormatter;
import model.characters.components.Destination;
import model.characters.components.GhostChasingState;
import model.characters.components.MapTile;
import model.game.Bonuses;
import model.game.GameThread;
import model.highScore.RankingEntry;
import model.map.MapGenerator;
import model.map.MapModel;
import views.game.Game;
import views.game.components.EndGameViewChange;
import views.game.components.GameCardPanel;
import views.game.components.panels.gameWindow.Comments;
import views.game.components.panels.gameWindow.CurrentStats;
import views.menu.components.middlePanels.HighScores;
import views.menu.components.middlePanels.NewGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static model.map.MapGenerator.*;
import static model.map.MapModel.*;

public class Player extends Character implements MapTile {

    public Destination destination;
    int[] pacOpenessState = new int[]{22, 23, 24, 23};
    public Bonuses bonusState;

    public Player(MapModel mapModel) {
        super(mapModel);
        try {
            this.image = ImageIO.read(new File("assets/pacman_icons/pac_caly.png"));

            DrawableObjects.addDrawable(getMapCode(), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        destination = Destination.RIGHT;
        bonusState = null;
    }

    @Override
    public int getMapCode() {
        return 22;
    }

    private static void eatBigCookie() {
        CurrentStats.yourScore += 50;
        for (Enemy enemy : enemies) {
            enemy.ghostChasingState = GhostChasingState.GhostsSCARED;
            enemy.currentColorCode = 38;
        }
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

    private void addLife() {
        int counter = 0;
        CurrentStats.livesNumber += 1;

        for (int i = 0; i < CurrentStats.livesRows; i++) {
            for (int j = 0; j < 5; j++) {
                counter++;
                if (CurrentStats.livesTable.getValueAt(i, j).equals(19)) {
                    CurrentStats.livesTable.setValueAt(33, i, j);
                    CurrentStats.model.fireTableDataChanged();
                    return;
                }
            }
        }
    }

    public void updatePacmanAnimation(int counter) {

        int currentOpen = pacOpenessState[counter];

        switch (destination) {
            case UP -> {
                String tmp = String.valueOf(currentOpen) + String.valueOf(0);
                int currentState = Integer.parseInt(tmp);
                mapModel.setValueAt(currentState, player.getCurrentRow(), player.getCurrentColumn());
            }
            case DOWN -> {
                String tmp = String.valueOf(currentOpen) + String.valueOf(1);
                int currentState = Integer.parseInt(tmp);
                mapModel.setValueAt(currentState, player.getCurrentRow(), player.getCurrentColumn());
            }
            case RIGHT -> {
                String tmp = String.valueOf(currentOpen) + String.valueOf(2);
                int currentState = Integer.parseInt(tmp);
                mapModel.setValueAt(currentState, player.getCurrentRow(), player.getCurrentColumn());
            }
            case LEFT -> {
                String tmp = String.valueOf(currentOpen) + String.valueOf(3);
                int currentState = Integer.parseInt(tmp);
                mapModel.setValueAt(currentState, player.getCurrentRow(), player.getCurrentColumn());

            }
        }
    }

    private static void resetStats() {
        EndGameViewChange endGameViewChange = new EndGameViewChange();
        GameCardPanel.currentCardName = GameCardPanel.START_SCREEN_1;
        GameThread.isGameViewReady.set(false);

        String nickname = NewGame.setYourNick;
        int yourFinalScore = CurrentStats.yourScore;
        String finalTime = CurrentStats.setTime.getText();

        RankingEntry entry = new RankingEntry(0, nickname, yourFinalScore, finalTime);
        HighScores.rankingModel.addEntryWithSorting(entry);
        HighScores.rankingModel.saveToFile();

        GameThread.isReady.set(false);
        CurrentStats.livesNumber = 5;
        CurrentStats.yourScore = 0;
        enemies = null;
        cookiesCounter = 0;
    }

    public void moveVertically(int Y) {
        for (Enemy e : enemies) {
            if (mapModel.getValueAt(getCurrentRow(), Y).equals(mapModel.getValueAt(e.currentRow, e.currentColumn))) {
                if (e.ghostChasingState == GhostChasingState.GhostsCHASE) {
                    mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
                    eatenByGhosts();
                    return;
                }
                if (e.ghostChasingState == GhostChasingState.GhostsSCARED) {
                    if (e.valueUnderWhereIsStanding == cookieSmall || e.valueUnderWhereIsStanding == cookieBig)
                        cookiesCounter--;
                    e.eatenByPacman(e);
                    break;
                }
            }
        }
        if (isWall(getCurrentRow(), Y)) return;
        if (isFood(getCurrentRow(), Y)) {
            mapModel.setValueAt(pustePole, player.getCurrentRow(), player.getCurrentColumn());
            mapModel.setValueAt(player.getMapCode(), player.getCurrentRow(), Y);
            return;
        }
        if (mapModel.getValueAt(getCurrentRow(), Y).equals(cookieSmall) || mapModel.getValueAt(getCurrentRow(), Y).equals(cookieBig)) {
            if (mapModel.getValueAt(getCurrentRow(), Y).equals(cookieSmall)) {
                CurrentStats.yourScore += 10;
            }
            if (mapModel.getValueAt(getCurrentRow(), Y).equals(cookieBig)) {
                eatBigCookie();
            }
            eatCookie();
            CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
            Game.gameWindow.currentStats.compareYourAndHighScore();
            if (isThisNewMap) {
                isThisNewMap = false;
                return;
            }
        }
        mapModel.setValueAt(pustePole, player.getCurrentRow(), player.getCurrentColumn());
        mapModel.setValueAt(player.getMapCode(), player.getCurrentRow(), Y);
    }

    public void moveHorizontally(int X) {
        for (Enemy e : enemies) {
            if (mapModel.getValueAt(X, getCurrentColumn()).equals(mapModel.getValueAt(e.currentRow, e.currentColumn))) {
                if (e.ghostChasingState == GhostChasingState.GhostsCHASE) {
                    mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
                    eatenByGhosts();
                    return;
                }
                if (e.ghostChasingState == GhostChasingState.GhostsSCARED) {
                    if (e.valueUnderWhereIsStanding == cookieSmall || e.valueUnderWhereIsStanding == cookieBig)
                        cookiesCounter--;
                    e.eatenByPacman(e);
                    break;
                }
            }
        }
        if (isWall(X, getCurrentColumn()) || isGate(X, getCurrentColumn())) return;
        if (isFood(X, getCurrentColumn())) {
            mapModel.setValueAt(pustePole, player.getCurrentRow(), player.getCurrentColumn());
            mapModel.setValueAt(player.getMapCode(), X, player.getCurrentColumn());
            return;
        }
        if (mapModel.getValueAt(X, getCurrentColumn()).equals(cookieSmall) || mapModel.getValueAt(X, getCurrentColumn()).equals(cookieBig)) {
            if (mapModel.getValueAt(X, getCurrentColumn()).equals(cookieSmall)) CurrentStats.yourScore += 10;

            if (mapModel.getValueAt(X, getCurrentColumn()).equals(cookieBig)) {
                eatBigCookie();
            }
            eatCookie();
            CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
            Game.gameWindow.currentStats.compareYourAndHighScore();
            if (isThisNewMap) {
                isThisNewMap = false;
                return;
            }
        }
        mapModel.setValueAt(pustePole, player.getCurrentRow(), player.getCurrentColumn());
        mapModel.setValueAt(player.getMapCode(), X, player.getCurrentColumn());
    }

    private boolean isFood(int x, int y) {

        if (mapModel.getValueAt(x, y).equals(60)) {
            this.bonusState = Bonuses.LEAF;
            return true;
        }
        if (mapModel.getValueAt(x, y).equals(61)) {
            return true;
        }
        if (mapModel.getValueAt(x, y).equals(62)) { //done
            if (CurrentStats.livesNumber < 5) addLife();
            return true;
        }
        if (mapModel.getValueAt(x, y).equals(63)) {
            return true;
        }
        if (mapModel.getValueAt(x, y).equals(64)) {
            return true;
        }

        if (mapModel.getValueAt(x, y).equals(65) || mapModel.getValueAt(x, y).equals(66) || mapModel.getValueAt(x, y).equals(67)) {
            CurrentStats.yourScore += 200;
            CurrentStats.setYourScore.setText(NumberFormatter.changeScoreToString(CurrentStats.yourScore));
            Game.gameWindow.currentStats.compareYourAndHighScore();
            return true;
        }
        return false;
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    protected void eatenByGhosts() {
        CurrentStats.livesNumber--;
        mapModel.setValueAt(pustePole, getCurrentRow(), getCurrentColumn());
        mapModel.setValueAt(getMapCode(), rows - rows / 4, columns / 2);

        Comments.message.setText(Comments.messageEatenByGhosts);
        messageTimer.start();

        removeLife();

        if (CurrentStats.livesNumber == 0) {

            resetStats();
        }
    }

    private void eatCookie() {
        cookiesCounter--;
        if (cookiesCounter == 0) {
            map = MapGenerator.generateMap();
            mapModel.setValueAt(getMapCode(), rows - rows / 4, columns / 2);
            spawnEnemies(mapModel);
            isThisNewMap = true;
            mapModel.pacmanGame.repaint();
            Comments.message.setText(Comments.messageCookiesEaten);
            messageTimer.start();
        }
    }

    public void resetBonusesState() {
        this.bonusState = null;
    }

    @Override
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }
}