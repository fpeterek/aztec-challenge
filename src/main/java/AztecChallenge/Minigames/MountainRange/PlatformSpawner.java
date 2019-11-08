package AztecChallenge.Minigames.MountainRange;

import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;

import java.util.Random;

public class PlatformSpawner {

    private static int platformWidth = 100;
    private static int platformHeight = 30;

    private int width;
    private int height;
    private int emptyCounter = 0;
    private Random rand;

    public PlatformSpawner(int winWidth, int winHeight) {

        width = winWidth;
        height = winHeight;
        rand = new Random();

    }

    private EmptyPlatform emptyPlatform() {
        ++emptyCounter;
        return new EmptyPlatform(width, 300, platformWidth, platformHeight);
    }

    private RectanglePlatform normalPlatform() {
        emptyCounter = 0;
        return new RectanglePlatform(width, 300, platformWidth, platformHeight);
    }

    public Platform getPlatform() {
        if (emptyCounter == 3) {
            return normalPlatform();
        }
        return rand.nextBoolean() ? normalPlatform() : emptyPlatform();
    }

}
