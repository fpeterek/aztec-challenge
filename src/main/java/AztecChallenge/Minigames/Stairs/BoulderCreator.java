package AztecChallenge.Minigames.Stairs;

import java.util.Random;

public class BoulderCreator {

    private static int boulderSize = 150;

    private int from;
    private int spread;
    private Random rand;

    public BoulderCreator(int fromX, int toX) {
        from = fromX;
        spread = toX - fromX;
        rand = new Random();
    }

    Boulder createBoulder() {
        Boulder b = new Boulder(from + rand.nextInt(spread), -boulderSize, boulderSize, boulderSize);
        b.setForces(0, 5);
        return b;
    }

}
