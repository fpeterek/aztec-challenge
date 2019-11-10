package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.Player;
import AztecChallenge.Interfaces.Jumping;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GauntletPlayer extends Player implements Jumping {

    private static final double spriteUpdatePeriod = 0.3;

    private boolean canPlayerJump;
    private double crouchCounter = 0;
    private boolean isCrouching = false;
    private double spriteCounter = 0;

    private Image sprite;

    private double baseHeight;

    public GauntletPlayer(double x, double y, double width, double height) {
        super(x, y, width, height);
        sprite = new Image("gauntlet_aztec.png", width * 6, height, true, false);
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

        spriteCounter += timeDelta;
        spriteCounter %= spriteUpdatePeriod * 2;

    }

    @Override
    public void render(GraphicsContext gc) {
        super.render(gc);
        if (!canJump() && !isCrouching) {
            gc.drawImage(sprite, 5*width(), 0, width(), baseHeight, x(), y(), width(), baseHeight);
        }
        else {
            int spriteIndex = (int)(spriteCounter / spriteUpdatePeriod);
            int offset = 1 + (isCrouching ? 2 : 0);
            gc.drawImage(sprite, offset * width(), 0, width(), baseHeight, x(), y()- (baseHeight-height()), width(), baseHeight);
        }
    }

}
