package AztecChallenge.Minigames.MountainRange;

import AztecChallenge.GameEngine.Player;
import AztecChallenge.Interfaces.Jumping;

public class MRPlayer extends Player implements Jumping {

    private boolean canPlayerJump;


    public MRPlayer(double x, double y, double width, double height) {
        super(x, y, width, height);
        affectedByGravity(true);
        canPlayerJump = true;
    }

    @Override
    public void onUp() {
        jump();
    }

    @Override
    public void onDown() {
        // Ignore
    }

    @Override
    public void onLeft() {
        //forces.x = -1;
    }

    @Override
    public void onRight() {
        //forces.x = 1;
    }

    @Override
    public void onUpRelease() {

    }

    @Override
    public void onDownRelease() {

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
    public void canJump(boolean canObjectJump) {
        canPlayerJump = canObjectJump;
    }

    @Override
    public boolean canJump() {
        return canPlayerJump;
    }

    @Override
    public void jump() {
        if (!canJump()) {
            return;
        }
        canJump(false);
        forces.y -= 0.5;
    }

    @Override
    public void tick(double timeDelta) {

    }

}
