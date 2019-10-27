package AztecChallenge.Interfaces;

import AztecChallenge.Rectangle2d;
import AztecChallenge.Vector2d;

public interface Hitboxed {

    Vector2d position();
    Rectangle2d hitbox();
    boolean hasMass();

    default boolean intersects(Hitboxed obj) {
        return obj.hitbox().intersects(hitbox());
    }


}
