package model.characters;

import java.awt.image.VolatileImage;
import java.util.List;
import java.util.Map;

public abstract class Character implements Animated {

    Map<CharacterAnimationState, List<VolatileImage>> animacje;

}
