package AztecChallenge.Minigames.TempleAssault;

import AztecChallenge.GameEngine.Player;
import AztecChallenge.Interfaces.Jumping;

public class TAPlayer extends Player implements Jumping {

    private boolean canPlayerJump;

    public TAPlayer(double x, double y, double width, double height) {
        super(x, y, width, height);
        canPlayerJump = true;
    }

    @Override
    public void onUp() {
        jump();
    }

    @Override
    public void onDown() {

    }

    @Override
    public void onLeft() {
        forces.x = -1;
    }

    @Override
    public void onRight() {
        forces.x = 1;
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
        if (!canPlayerJump) {
            return;
        }
        canPlayerJump = false;
        forces.y -= 0.5;
    }
}
