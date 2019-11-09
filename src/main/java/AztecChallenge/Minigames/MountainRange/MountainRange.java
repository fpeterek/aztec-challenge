package AztecChallenge.Minigames.MountainRange;

import AztecChallenge.GameEngine.Engine;
import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;
import AztecChallenge.GameEngine.Utils.Vector2d;
import javafx.scene.paint.Color;

public class MountainRange extends Engine {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    private PlatformSpawner platformSpawner;

    public MountainRange() {

        super(WIDTH, HEIGHT);

        enableGravity();
        setWindowTitle("Mountain Range");

        setG(0.5);

        RectanglePlatform sky = new RectanglePlatform(0, 0, WIDTH, HEIGHT);
        sky.color = Color.LIGHTBLUE;
        renderables.add(sky);

        platformSpawner = new PlatformSpawner(400);

        for (int i = 0; i < (WIDTH / 100) + 1; ++i) {
            Platform p = platformSpawner.normalPlatform(i * 100);
            platforms.add(p);
        }
        System.out.println(platforms.size());

        player = new MRPlayer((width() / 2) - (50 / 2), 200, 50, 100);

        // spearCreator = new SpearCreator(new Vector2d(150, 8), new Vector2d(width(), height()), new Vector2d(610, 680));

    }

    private void spawnPlatform() {
        Platform last = platforms.get(platforms.size() - 1);
        Platform p = platformSpawner.getPlatform(last.x() + last.width());
        platforms.add(p);
    }

    @Override
    protected boolean isRunning() {
        return windowIsOpen() && player.isAlive();
    }

    @Override
    protected void tick(double timedelta) {

        if (player.position().x > height()) {
            player.onHit();
        }

        for (Platform p : platforms) {
            p.move(-100 * timedelta, 0);
            if (p.position().x + p.width() < 0) {
                platforms.remove(p);
                spawnPlatform();
            }
        }

    }


}
