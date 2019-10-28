package AztecChallenge.Interfaces;

import AztecChallenge.GameEngine.Utils.Vector2d;

public interface Moveable extends Hitboxed {

    Vector2d forces();
    void move(double x, double y);

}
