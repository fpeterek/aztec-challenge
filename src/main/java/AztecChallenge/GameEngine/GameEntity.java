package AztecChallenge.GameEngine;

import AztecChallenge.Interfaces.Hitboxed;
import AztecChallenge.GameEngine.Utils.Rectangle2d;
import AztecChallenge.GameEngine.Utils.Vector2d;

public class GameEntity extends Rectangle2d implements Hitboxed {

    protected Vector2d forces;
    private boolean gravity;

    public GameEntity(double x, double y, double width, double height) {
        super(x, y, width, height);
        forces = new Vector2d(0, 0);
    }

    public boolean affectedByGravity() {
        return gravity;
    }

    public void affectedByGravity(boolean g) {
        gravity = g;
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

    public Vector2d getForces() {
        return new Vector2d(forces);
    }

    public void setForces(Vector2d forces) {
        this.forces = forces;
    }

    public void setForces(double fx, double fy) {
        this.forces.x = fx;
        this.forces.y = fy;
    }

    public void onDelete() {

    }

    public void tick(double timedelta) {

    }

}
