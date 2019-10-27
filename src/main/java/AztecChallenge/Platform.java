package AztecChallenge;

import AztecChallenge.Interfaces.Hitboxed;
import javafx.scene.canvas.GraphicsContext;

public class Platform extends Rectangle2d implements Hitboxed {

    private Vector2d pos;

    public Platform(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public Vector2d position() {
        return new Vector2d(pos.x, pos.y);
    }

    @Override
    public Rectangle2d hitbox() {
        return new Rectangle2d(1,1,1,1);
    }

    @Override
    public boolean hasMass() {
        return true;
    }

}
