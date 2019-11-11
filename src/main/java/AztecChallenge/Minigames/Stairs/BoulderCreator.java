package AztecChallenge.Minigames.Stairs;

import javafx.scene.image.Image;

import java.util.Random;

public class BoulderCreator {

    private static int boulderSize = 150;

    private int from;
    private int spread;
    private Random rand;
    private Image sprite;

    public BoulderCreator(int fromX, int toX) {
        sprite = new Image("stairs_boulder.png", boulderSize * 4, boulderSize, true, false);
        from = fromX;
        spread = toX - fromX;
        rand = new Random();
    }

    Boulder createBoulder() {
        Boulder b = new Boulder(from + rand.nextInt(spread), -boulderSize, boulderSize, boulderSize, sprite);
        b.setForces(0, 5);
        return b;
    }

}
