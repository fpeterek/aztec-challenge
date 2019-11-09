package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.Player;
import AztecChallenge.Interfaces.Jumping;

public class GauntletPlayer extends Player implements Jumping {

    private boolean canPlayerJump;
    private double crouchCounter = 0;
    private boolean isCrouching = false;

    private double baseHeight;

    public GauntletPlayer(double x, double y, double width, double height) {
        super(x, y, width, height);
        affectedByGravity(true);
        baseHeight = height;
        canPlayerJump = true;
    }

    @Override
    public void onUp() {
        jump();
    }

    @Override
    public void onDown() {
        crouch();
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
        return canPlayerJump && !isCrouching;
    }

    @Override
    public void jump() {
        if (!canJump()) {
            return;
        }
        canJump(false);
        forces.y -= 0.5;
    }

    private void crouch() {
        if (!canJump()) {
            return;
        }
        canJump(false);

        isCrouching = true;
        setSize(width(), baseHeight / 2);
        move(0, baseHeight / 2);
        crouchCounter = 1.5;

    }

    private void uncrouch() {
        canJump(true);
        setSize(width(), baseHeight);
        move(0, - (baseHeight / 2));
        isCrouching = false;
    }

    @Override
    public void tick(double timeDelta) {

        if (isCrouching && crouchCounter > 0) {
            crouchCounter -= timeDelta;
        }
        if (isCrouching && crouchCounter <= 0) {
            uncrouch();
        }

    }

}
