package AztecChallenge.Minigames.Stairs;

import AztecChallenge.GameEngine.Engine;
import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;
import AztecChallenge.Interfaces.Hitboxed;
import AztecChallenge.Minigames.Bridge.BridgePlayer;
import AztecChallenge.Minigames.Bridge.EmptyPlatform;
import AztecChallenge.Minigames.Bridge.PlatformSpawner;
import javafx.scene.paint.Color;

import java.util.Random;

public class Stairs extends Engine {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    private static final int edge = 100;
    private static final int boulderChance = 4;
    private static final int maxBoulders = 3;

    private BoulderCreator boulderCreator;
    private Random rand;

    public Stairs() {

        super(WIDTH, HEIGHT);

        disableGravity();
        setWindowTitle("The Stairs");

        RectanglePlatform background = new RectanglePlatform(0, 0, WIDTH, HEIGHT);
        background.color = Color.GRAY;
        renderables.add(background);

        rand = new Random();
        boulderCreator = new BoulderCreator(edge, (int)width() - edge);
        player = new StairsPlayer((width() / 2) - 25, height() - 300, 50, 100);

    }


    @Override
    protected boolean isRunning() {
        return windowIsOpen() && player.isAlive();
    }

    @Override
    protected void tick(double timedelta) {

        if (player.x() < edge) {
            player.move(edge - player.x(), 0);
        }
        else if (player.x() + player.width() > width() - edge) {
            player.move((width() - edge) - (player.x() + player.width()), 0);
        }

        if (entities.size() < maxBoulders && rand.nextInt(100) < boulderChance) {
            entities.add(boulderCreator.createBoulder());
        }

    }


}
