package AztecChallenge.Minigames.Stairs;

import java.util.Random;

public class BoulderCreator {

    private int from;
    private int spread;
    private Random rand;

    public BoulderCreator(int fromX, int toX) {
        from = fromX;
        spread = toX - fromX;
        rand = new Random();
    }

    Boulder createBoulder() {
        return new Boulder(from + rand.nextInt(spread) - 50, 0, 50, 50);
    }

}
