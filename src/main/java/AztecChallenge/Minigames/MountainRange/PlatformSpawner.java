package AztecChallenge.Minigames.MountainRange;

import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;
import javafx.scene.paint.Color;

import java.util.Random;

public class PlatformSpawner {

    private static int platformWidth = 100;
    private static int platformHeight = 30;

    private int platformY;
    private int emptyCounter = 0;
    private Random rand;

    public PlatformSpawner(int y) {

        platformY = y;
        rand = new Random();

    }

    public EmptyPlatform emptyPlatform(double x) {
        ++emptyCounter;
        EmptyPlatform p = new EmptyPlatform(x, platformY, platformWidth, platformHeight);
        p.color = new Color(0.7, 0.7, 0.3, 1.0);
        return p;
    }

    public RectanglePlatform normalPlatform(double x) {
        emptyCounter = 0;
        RectanglePlatform p = new RectanglePlatform(x, platformY, platformWidth, platformHeight);
        p.color = new Color(0.7, 0.5, 0.5, 1.0);
        return p;
    }

    public Platform getPlatform(double x) {
        System.out.println("Get platform");
        if (emptyCounter == 3) {
            return normalPlatform(x);
        }
        return rand.nextBoolean() ? normalPlatform(x) : emptyPlatform(x);
    }

}
