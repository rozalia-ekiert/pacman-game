package model.characters;

import java.awt.*;
import java.util.List;
import java.util.Map;

public abstract class Character implements Animated {

    protected int spawnLocationRow;
    protected int spawnLocationClumn;
    protected int currentRow;
    protected int currentColumn;
    Map<CharacterAnimationState, List<Image>> animacje;
    Image image;
    double speed;

    public Character() {

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

    public int getSpawnLocationRow() {
        return spawnLocationRow;
    }

    public int getSpawnLocationClumn() {
        return spawnLocationClumn;
    }

    public abstract int getMapCode();
}
