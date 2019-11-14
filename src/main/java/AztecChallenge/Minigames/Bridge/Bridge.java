package AztecChallenge.Minigames.Bridge;

import AztecChallenge.GameEngine.Config.Config;
import AztecChallenge.GameEngine.Engine;
import AztecChallenge.GameEngine.Platform.Platform;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;
import AztecChallenge.Interfaces.Hitboxed;
import javafx.scene.paint.Color;

public class Bridge extends Engine {

    private static final int platformV = -200;
    private PlatformSpawner platformSpawner;

    public Bridge(Config conf) {

        super(conf);

        enableGravity();
        setWindowTitle("The Bridge");

        setG(0.8);

        RectanglePlatform sky = new RectanglePlatform(0, 0, conf.width, conf.height);
        sky.color = Color.LIGHTBLUE;
        renderables.add(sky);

        platformSpawner = new PlatformSpawner(400);

        for (int i = 0; i < (conf.width / 100) + 1; ++i) {
            Platform p = platformSpawner.normalPlatform(i * 100);
            platforms.add(p);
        }

        player = new BridgePlayer((width() / 2) - (50 / 2), 200, 50, 100);

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

        if (player.position().y > height()) {
            player.onHit();
        }

        boolean intersectsWithEmpty = false;
        boolean intersectsWithNormal = false;

        for (Platform p : platforms) {
            p.move(platformV * timedelta, 0);
            if (p instanceof EmptyPlatform && player.intersects((Hitboxed) p)) {
                intersectsWithEmpty = true;
            }
            else if (player.intersects((Hitboxed)p)) {
                intersectsWithNormal = true;
            }
            if (p.position().x + p.width() < 0) {
                platforms.remove(p);
                spawnPlatform();
            }
        }

        if (intersectsWithEmpty && !intersectsWithNormal) {
            ((BridgePlayer)player).fall();
        }

    }


}
