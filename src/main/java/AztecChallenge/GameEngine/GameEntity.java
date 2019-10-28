package AztecChallenge.GameEngine;

import AztecChallenge.Interfaces.Hitboxed;
import AztecChallenge.GameEngine.Utils.Rectangle2d;
import AztecChallenge.GameEngine.Utils.Vector2d;

public class GameEntity extends Rectangle2d implements Hitboxed {

    public GameEntity(double x, double y, double width, double height) {
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
