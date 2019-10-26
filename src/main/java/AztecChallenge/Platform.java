package AztecChallenge;

import AztecChallenge.Interfaces.Hitboxed;
import AztecChallenge.Interfaces.Renderable;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class Platform implements Hitboxed, Renderable {

    private Vector2d pos;

    @Override
    public Vector2d position() {
        return new Vector2d(pos.x, pos.y);
    }

    @Override
    public Rectangle2D hitbox() {
        return null;
    }

    @Override
    public boolean hasMass() {
        return false;
    }

    @Override
    public void render(GraphicsContext gc) {

    }
}
