package AztecChallenge.Minigames.MountainRange;

import AztecChallenge.GameEngine.Player;
import AztecChallenge.Interfaces.Jumping;

public class MRPlayer extends Player implements Jumping {

    private boolean canPlayerJump;
    private boolean collideWithPlatforms = true;


    public MRPlayer(double x, double y, double width, double height) {
        super(x, y, width, height);
        affectedByGravity(true);
        canPlayerJump = true;
    }

    public void fall() {
        collideWithPlatforms = false;
    }

    @Override
    public boolean hasMass() {
        return collideWithPlatforms;
    }

    @Override
    public void onUp() {
        jump(0.45);
    }

    @Override
    public void onDown() {
        // Ignore
    }

    @Override
    public void onLeft() {
        jump(0.3);
    }

    @Override
    public void onRight() {
        jump(0.6);
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
        jump(0.5);
    }

    @Override
    public void jump(double force) {
        if (!canJump()) {
            return;
        }
        canJump(false);
        forces.y -= force;
    }

    @Override
    public void tick(double timeDelta) {

    }

}
