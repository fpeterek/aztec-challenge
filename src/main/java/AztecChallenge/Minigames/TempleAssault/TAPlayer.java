package AztecChallenge.Minigames.TempleAssault;

import AztecChallenge.GameEngine.Player;
import AztecChallenge.Interfaces.Jumping;

public class TAPlayer extends Player implements Jumping {

    private boolean canPlayerJump;

    public TAPlayer(double x, double y, double width, double height) {
        super(x, y, width, height);
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

    }

    @Override
    public void onRight() {

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
