package AztecChallenge;

public class Rectangle2d {

    private Vector2d pos;
    private Vector2d dim;

    public double x() {
        return pos.x;
    }

    public double y() {
        return pos.y;
    }

    public double width() {
        return dim.x;
    }

    public double height() {
        return dim.y;
    }

    public Vector2d position() {
        return new Vector2d(pos);
    }

    public Vector2d size() {
        return new Vector2d(dim);
    }

    public boolean intersects(Rectangle2d rect) {

        boolean xMiss = rect.x() + rect.width() < x() || x() + width() < rect.x();
        boolean yMiss = rect.y() + rect.height() < y() || y() + height() < rect.y();

        boolean miss = xMiss || yMiss;

        return !miss;

    }

    public void move(double dx, double dy) {
        pos.move(dx, dy);
    }

    public void move(Vector2d delta) {
        pos.move(delta);
    }

    public Rectangle2d(double x, double y, double width, double height) {
        pos = new Vector2d(x, y);
        dim = new Vector2d(width, height);
    }

    public Rectangle2d(Vector2d position, Vector2d size) {
        pos = new Vector2d(position);
        dim = new Vector2d(size);
    }

    public Rectangle2d(Rectangle2d orig) {
        pos = new Vector2d(orig.pos);
        dim = new Vector2d(orig.dim);
    }

}
