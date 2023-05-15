package model.characters;

import java.awt.*;
import java.util.List;
import java.util.Map;

public abstract class Character implements Animated {

    protected int spawnLocationRow;
    protected int spawnLocationClumn;
    Map<CharacterAnimationState, List<Image>> animacje;
    Image image;
    double speed;

    public Character() {

    }

    public int getSpawnLocationRow() {
        return spawnLocationRow;
    }

    public int getSpawnLocationClumn() {
        return spawnLocationClumn;
    }

    public abstract int getMapCode();
}
