package AztecChallenge;

import AztecChallenge.Interfaces.Hitboxed;

public class Platform extends Rectangle2d implements Hitboxed {

    public Platform(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public Vector2d position() {
        return new Vector2d(x(), y());
    }

    @Override
    public Rectangle2d hitbox() {
        return new Rectangle2d(this);
    }

    @Override
    public boolean hasMass() {
        return true;
    }

}
