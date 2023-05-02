package model.characters;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class Enemy extends Character {

    Map<CharacterAnimationState, List<Image>> animacje;
    Image currentState;
    double speed = 80;

    @Override
    public Image getAnimatonFrame(long deltaT) {
        return null;
    }
}
