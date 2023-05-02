package model.characters;

import java.awt.*;
import java.util.List;
import java.util.Map;

public abstract class Character implements Animated {

    Map<CharacterAnimationState, List<Image>> animacje;
    Image currentState;
    double speed;

    public Character() {

    }


}
