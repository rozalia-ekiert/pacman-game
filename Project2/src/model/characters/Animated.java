package model.characters;

import java.awt.image.VolatileImage;

public interface Animated {

    //eating
    //movement
    //eyes movement

    VolatileImage getAnimatonFrame(long deltaT);

}
