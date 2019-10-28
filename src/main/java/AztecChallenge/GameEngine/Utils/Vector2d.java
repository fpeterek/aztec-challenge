package AztecChallenge.GameEngine.Utils;

public class Vector2d {

    public double x;
    public double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(Vector2d cp) {
        this.x = cp.x;
        this.y = cp.y;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public void move(Vector2d delta) {
        x += delta.x;
        y += delta.y;
    }

}
