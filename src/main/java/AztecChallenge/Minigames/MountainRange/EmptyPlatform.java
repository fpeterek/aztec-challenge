package AztecChallenge.Minigames.MountainRange;

import AztecChallenge.GameEngine.Platform.RectanglePlatform;

public class EmptyPlatform extends RectanglePlatform {

    public EmptyPlatform(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public boolean hasMass() {
        return false;
    }

}
