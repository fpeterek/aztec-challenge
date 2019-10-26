package AztecChallenge.Interfaces;

import AztecChallenge.Vector2d;
import javafx.geometry.Rectangle2D;

public interface Hitboxed {

    Vector2d position();
    Rectangle2D hitbox();
    boolean hasMass();


}
