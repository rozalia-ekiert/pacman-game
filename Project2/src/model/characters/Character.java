package model.characters;

import model.characters.components.Animated;
import model.characters.components.CharacterAnimationState;
import model.map.MapModel;

import java.awt.*;
import java.util.List;
import java.util.Map;

public abstract class Character implements Animated {

    protected MapModel mapModel;
    protected int spawnLocationRow;
    protected int spawnLocationColumn;
    protected int currentRow;
    protected int currentColumn;
    Map<CharacterAnimationState, List<Image>> animacje;
    Image image;
    double speed;

    public Character(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    public int getCurrentRow() {
        return this.currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return this.currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    protected boolean isWall(int playerX, int playerY) {
        return mapModel.map[playerX][playerY] <= 15;
    }

    protected boolean isGate(int playerX, int playerY) {
        return mapModel.map[playerX][playerY] == 16;
    }

    public int getSpawnLocationRow() {
        return spawnLocationRow;
    }

    public int getSpawnLocationColumn() {
        return spawnLocationColumn;
    }

    public abstract int getMapCode();

    public abstract void moveHorizontally(int X);

    public abstract void moveVertically(int Y);

}
