package AztecChallenge.Minigames.Stairs;

import AztecChallenge.GameEngine.Player;
import AztecChallenge.Interfaces.Jumping;

public class StairsPlayer extends Player {

    public StairsPlayer(double x, double y, double width, double height) {
        super(x, y, width, height);
        affectedByGravity(false);
    }

    @Override
    public void onUp() {
        // Ignore
    }

    @Override
    public void onDown() {
        // Ignore
    }

    @Override
    public void onLeft() {
        forces.x = -5;
    }

    @Override
    public void onRight() {
        forces.x = 5;
    }

    @Override
    public void onUpRelease() {
        // Ignore
    }

    @Override
    public void onDownRelease() {
        // Ignore
    }

    @Override
    public void onLeftRelease() {
        forces.x = 0;
    }

    @Override
    public void onRightRelease() {
        forces.x = 0;
    }

    @Override
    public void tick(double timeDelta) {

    }

}
