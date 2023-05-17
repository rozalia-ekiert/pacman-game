package model.characters;

import model.characters.components.GhostChasingState;
import model.characters.components.GhostsColors;
import model.characters.components.MapTile;
import model.game.Bonuses;
import views.game.components.panels.gameWindow.CurrentStats;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static model.DrawableObjects.addDrawable;
import static model.map.MapGenerator.*;
import static model.map.MapModel.enemies;
import static model.map.MapModel.player;

public class Enemy extends Character implements MapTile {

    public final GhostsColors color;
    private Image image;
    public int valueUnderWhereIsStanding;
    int originalColorCode;
    int currentColorCode;
    boolean passedTheGate;
    GhostChasingState ghostChasingState;

    int pointsForEatingGhosts = 200;

    public Enemy(int row, int column, GhostsColors color, int colorCode) {
        super(null);
        this.spawnLocationRow = row;
        this.spawnLocationColumn = column;
        this.originalColorCode = colorCode;
        this.currentColorCode = colorCode;

        this.currentRow = row;
        this.currentColumn = column;

        valueUnderWhereIsStanding = 1000;

        this.color = color;

        passedTheGate = false;
        ghostChasingState = GhostChasingState.GhostsCHASE;

        try {
            switch (color) {
                case PINK -> this.image = ImageIO.read(new File("assets/enemies_icons/pink/pink_2_straight.png"));
                case GREEN -> this.image = ImageIO.read(new File("assets/enemies_icons/green/green_2_straight.png"));
                case BLUE -> this.image = ImageIO.read(new File("assets/enemies_icons/blue/blue_2_straight.png"));
                default -> this.image = ImageIO.read(new File("assets/enemies_icons/purple/purple_2_straight.png"));
            }
        } catch (IOException e) {
            System.out.println("Nieprawidłowe zdjęcie.");
        }
        addDrawable(this.getMapCode(), this);
    }

    @Override
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }

    @Override
    public int getMapCode() {
        return Integer.parseInt("4" + this.color.ordinal());
    }

    @Override
    public void moveHorizontally(int X) {
    }

    @Override
    public void moveVertically(int Y) {
    }

    @Override
    public Image getImage() {
        return this.image;
    }

    public static <T extends Enum<?>> T getRandomEnumElement(Class<T> enumClass) {
        Random random = new Random();
        T[] values = enumClass.getEnumConstants();
        int index = random.nextInt(values.length);
        return values[index];
    }

    public void updateAI(Enemy e) {

        setNewDestination(e);
        isGhostChased(e);
    }

    public void updateEnemyAnimation(Enemy e) {
        switch (e.currentColorCode) {
            case 38 -> {
                e.currentColorCode = 39;
                mapModel.setValueAt(e.currentColorCode, e.currentRow, e.currentColumn);
            }
            case 39 -> {
                e.currentColorCode = 38;
                mapModel.setValueAt(e.currentColorCode, e.currentRow, e.currentColumn);
            }
        }
    }

    public boolean isGhostChased(Enemy enemy) {
        if (enemy.ghostChasingState == GhostChasingState.GhostsSCARED) return true;
        return false;
    }

    public void spawnBonuses() { //todo
        double rand = Math.random();
        if (rand > 0.25) return;

        Random random = new Random();
        Bonuses currentBonus = getRandomEnumElement(Bonuses.class);

        switch (currentBonus) {
            case LEAF -> {
            }
            case CARROT -> {
            }
            case AVOCADO -> {
            }
            case MUSCHROOM -> {
            }
            case PINEAPPLE -> {
            }
        }
    }

    private void setNewDestination(Enemy e) {

        ArrayList<Integer> possibleDestinations = new ArrayList<>();
        possibleDestinations = checkDestinations(e);

        //jeśli nie ma żadnej drogi, zostań w miejscu
        if (possibleDestinations.size() == 0) {
            return;
        }

        //wybierz losowy kierunek spośród możliwych
        Random random = new Random();
        int randomIndex = random.nextInt(possibleDestinations.size());
        int chosenDestination = possibleDestinations.get(randomIndex);

        if (e.valueUnderWhereIsStanding == gate) chosenDestination = 0;

        if (e.valueUnderWhereIsStanding == 40 || e.valueUnderWhereIsStanding == 41
                || e.valueUnderWhereIsStanding == 42 || e.valueUnderWhereIsStanding == 43) {
            e.valueUnderWhereIsStanding = pustePole;
        }

        switch (chosenDestination) {

            case 0 -> { //do góry

                if (((int) mapModel.getValueAt(e.currentRow - 1, e.currentColumn) == pacman)) {
                    if (e.ghostChasingState == GhostChasingState.GhostsCHASE) {
                        player.eatenByGhosts();
                        setDefaultGhostsLocalization();
                    }
                    if (e.ghostChasingState == GhostChasingState.GhostsSCARED) {
                        return;
                    }
                    possibleDestinations = null;
                    return;
                }
                if (((int) mapModel.getValueAt(e.currentRow - 1, e.currentColumn) == gate)) {
                    if (!e.passedTheGate) {
                        e.passedTheGate = true;
                    } else {
                        return;
                    }
                }
                if (e.valueUnderWhereIsStanding != 1000) {
                    mapModel.setValueAt(e.valueUnderWhereIsStanding, e.currentRow, e.currentColumn);
                } else {
                    mapModel.setValueAt(pustePole, e.currentRow, e.currentColumn);
                }
                e.valueUnderWhereIsStanding = (int) mapModel.getValueAt(e.currentRow - 1, e.currentColumn);
                e.setCurrentRow(e.currentRow - 1);
                mapModel.setValueAt(e.currentColorCode, e.currentRow, e.currentColumn);
                possibleDestinations = null;
            }

            case 1 -> { //w dół
                if (((int) mapModel.getValueAt(e.currentRow + 1, e.currentColumn) == pacman)) {
                    if (e.ghostChasingState == GhostChasingState.GhostsCHASE) {
                        player.eatenByGhosts();
                        setDefaultGhostsLocalization();
                    }
                    if (e.ghostChasingState == GhostChasingState.GhostsSCARED) {
                        return;
                    }
                    possibleDestinations = null;
                    return;
                }
                if (((int) mapModel.getValueAt(e.currentRow + 1, e.currentColumn) == gate)) {
                    return;
                }
                if (e.valueUnderWhereIsStanding != 1000) {
                    mapModel.setValueAt(e.valueUnderWhereIsStanding, e.currentRow, e.currentColumn);
                } else {
                    mapModel.setValueAt(pustePole, e.currentRow, e.currentColumn);
                }
                e.valueUnderWhereIsStanding = (int) mapModel.getValueAt(e.currentRow + 1, e.currentColumn);
                e.setCurrentRow(e.currentRow + 1);
                mapModel.setValueAt(e.currentColorCode, e.currentRow, e.currentColumn);
                possibleDestinations = null;
            }

            case 2 -> { //w prawo
                if (((int) mapModel.getValueAt(e.currentRow, e.currentColumn + 1) == pacman)) {
                    if (e.ghostChasingState == GhostChasingState.GhostsCHASE) {
                        player.eatenByGhosts();
                        setDefaultGhostsLocalization();
                    }
                    if (e.ghostChasingState == GhostChasingState.GhostsSCARED) {
                        return;
                    }
                    possibleDestinations = null;
                    return;
                }
                if (e.valueUnderWhereIsStanding != 1000) {
                    mapModel.setValueAt(e.valueUnderWhereIsStanding, e.currentRow, e.currentColumn);
                } else {
                    mapModel.setValueAt(pustePole, e.currentRow, e.currentColumn);
                }
                e.valueUnderWhereIsStanding = (int) mapModel.getValueAt(e.currentRow, e.currentColumn + 1);
                e.setCurrentColumn(e.currentColumn + 1);
                mapModel.setValueAt(e.currentColorCode, e.currentRow, e.currentColumn);
                possibleDestinations = null;
            }

            case 3 -> { //w lewo
                if (((int) mapModel.getValueAt(e.currentRow, e.currentColumn - 1) == pacman)) {
                    if (e.ghostChasingState == GhostChasingState.GhostsCHASE) {
                        player.eatenByGhosts();
                        setDefaultGhostsLocalization();
                    }
                    if (e.ghostChasingState == GhostChasingState.GhostsSCARED) {
                        return;
                    }
                    possibleDestinations = null;
                    return;
                }
                if (e.valueUnderWhereIsStanding != 1000) {
                    mapModel.setValueAt(e.valueUnderWhereIsStanding, e.currentRow, e.currentColumn);
                } else {
                    mapModel.setValueAt(pustePole, e.currentRow, e.currentColumn);
                }
                e.valueUnderWhereIsStanding = (int) mapModel.getValueAt(e.currentRow, e.currentColumn - 1);
                e.setCurrentColumn(e.currentColumn - 1);
                mapModel.setValueAt(e.currentColorCode, e.currentRow, e.currentColumn);
                possibleDestinations = null;
            }
        }
    }


    private ArrayList<Integer> checkDestinations(Enemy e) {
        ArrayList<Integer> destinations = new ArrayList<>();
        int[] currentOptions = new int[4];

        int currentValueUp = (int) mapModel.getValueAt(e.currentRow - 1, e.currentColumn); //0
        int currentValueDown = (int) mapModel.getValueAt(e.currentRow + 1, e.currentColumn); //1
        int currentValueRight = (int) mapModel.getValueAt(e.currentRow, e.currentColumn + 1); //2
        int currentValueLeft = (int) mapModel.getValueAt(e.currentRow, e.currentColumn - 1); //3

        currentOptions[0] = currentValueUp;
        currentOptions[1] = currentValueDown;
        currentOptions[2] = currentValueRight;
        currentOptions[3] = currentValueLeft;

        //sprawdzam czy jest możliwość ruchu
        if ((currentValueUp <= 15 || currentValueUp >= 40)
                && (currentValueDown <= 16 || currentValueDown >= 40)
                && (currentValueRight <= 15 || currentValueRight >= 40)
                && (currentValueLeft <= 15 || currentValueLeft >= 40)) { // 16 - bramka
            return destinations;
        }

        //jesli na trasie jest pacman to zignoruj inne opcje

//        isPacmanOnWay(destinations, e);
//        if (destinations.size() != 0) return destinations;

        //jesli nie ma pacmana, podaj wszystkie możliwe kierunki
        for (int i = 0; i < currentOptions.length; i++) {
            if (isDestinationFreeToGo(currentOptions, i)) {
                destinations.add(i);
            }
        }
        return destinations;
    }

//    private ArrayList<Integer> isPacmanOnWay(ArrayList<Integer> destinations, Enemy e) { // sprawdzić czy da się tam bezposrednio dotrzec
//        if (player.getCurrentRow() == e.currentRow) {
//            if (player.getCurrentColumn() < e.currentColumn) {
//                boolean thereIsSomethingOnWay = false;
//                for (int i = e.currentColumn - 1; i >= player.currentColumn; i--) {
//                    if (!mapModel.getValueAt(e.currentRow, i).equals(pustePole) || !mapModel.getValueAt(e.currentRow, i).equals(cookieBig)
//                            || !mapModel.getValueAt(e.currentRow, i).equals(cookieSmall) || !mapModel.getValueAt(e.currentRow, i).equals(pacman)) {
//                        thereIsSomethingOnWay = true;
//                        break;
//                    }
//                }
//                if (!thereIsSomethingOnWay) {
//                    destinations.add(3);
//                    return destinations;
//                }
//            }
//            if (player.getCurrentColumn() > e.currentColumn) {
//
//                boolean thereIsSomethingOnWay = false;
//                for (int i = e.currentColumn + 1; i <= player.currentColumn; i++) {
//                    if (!mapModel.getValueAt(e.currentRow, i).equals(pustePole) || !mapModel.getValueAt(e.currentRow, i).equals(cookieBig)
//                            || !mapModel.getValueAt(e.currentRow, i).equals(cookieSmall) || !mapModel.getValueAt(e.currentRow, i).equals(pacman)) {
//                        thereIsSomethingOnWay = true;
//                        break;
//                    }
//                }
//                if (!thereIsSomethingOnWay) {
//                    destinations.add(2);
//                    return destinations;
//                }
//            }
//        }
//        if (player.getCurrentColumn() == currentColumn) {
//            if (player.getCurrentRow() < e.currentRow) {
//                boolean thereIsSomethingOnWay = false;
//                for (int i = e.currentRow - 1; i >= player.currentColumn; i--) {
//                    if (!mapModel.getValueAt(i, e.currentColumn).equals(pustePole) || !mapModel.getValueAt(i, e.currentColumn).equals(cookieBig)
//                            || !mapModel.getValueAt(i, e.currentColumn).equals(cookieSmall) || !mapModel.getValueAt(i, e.currentColumn).equals(pacman)) {
//                        thereIsSomethingOnWay = true;
//                        break;
//                    }
//                }
//                if (!thereIsSomethingOnWay) {
//                    destinations.add(1);
//                    return destinations;
//                }
//            }
//            if (player.getCurrentRow() > e.currentRow) {
//                boolean thereIsSomethingOnWay = false;
//                for (int i = e.currentRow + 1; i <= player.currentColumn; i++) {
//                    if (!mapModel.getValueAt(i, e.currentColumn).equals(pustePole) || !mapModel.getValueAt(i, e.currentColumn).equals(cookieBig)
//                            || !mapModel.getValueAt(i, e.currentColumn).equals(cookieSmall) || !mapModel.getValueAt(i, e.currentColumn).equals(pacman)) {
//                        thereIsSomethingOnWay = true;
//                        break;
//                    }
//                }
//                if (!thereIsSomethingOnWay) {
//                    destinations.add(0);
//                    return destinations;
//                }
//            }
//        }
//        return destinations;
//    }

    private boolean isDestinationFreeToGo(int[] currentOptions, int i) {

        return currentOptions[i] == pustePole || currentOptions[i] == cookieSmall || currentOptions[i] == cookieBig || currentOptions[i] == gate || currentOptions[i] == pacman;
    }

    public void setDefaultGhostsLocalization() {
        for (Enemy e : enemies) {
            mapModel.setValueAt(e.originalColorCode, e.spawnLocationRow, e.spawnLocationColumn);
            mapModel.setValueAt(e.valueUnderWhereIsStanding, e.currentRow, e.currentColumn);
            e.currentRow = e.spawnLocationRow;
            e.currentColumn = e.spawnLocationColumn;
            e.passedTheGate = false;
            e.valueUnderWhereIsStanding = 1000;
        }
    }

    public void eatenByPacman(Enemy e) {
        mapModel.setValueAt(e.originalColorCode, e.spawnLocationRow, e.spawnLocationColumn);

        e.currentColorCode = e.originalColorCode;
        e.currentColumn = e.spawnLocationColumn;
        e.currentRow = e.spawnLocationRow;
        e.ghostChasingState = GhostChasingState.GhostsCHASE;
        e.valueUnderWhereIsStanding = 1000;
        e.passedTheGate = false;

        CurrentStats.yourScore += pointsForEatingGhosts;
        pointsForEatingGhosts += 200; //todo jak się skończy ten stan wracamy do 200 a color do original
    }
}