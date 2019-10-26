package AztecChallenge.Interfaces;

import AztecChallenge.Vector2d;
import javafx.geometry.Rectangle2D;

public interface Moveable {

    Rectangle2D hitbox();
    boolean hasMass();
    Vector2d forces();

}
