package AztecChallenge.Interfaces;

import javafx.geometry.Rectangle2D;

public interface Hittable {

    Rectangle2D hitbox();
    void onHit();

}
