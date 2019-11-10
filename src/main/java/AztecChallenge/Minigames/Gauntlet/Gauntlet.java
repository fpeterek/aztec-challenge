package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.Engine;
import AztecChallenge.GameEngine.GameEntity;
import AztecChallenge.GameEngine.Platform.RectanglePlatform;
import AztecChallenge.GameEngine.Utils.Vector2d;
import javafx.scene.paint.Color;

public class Gauntlet extends Engine {

    private static final int WIDTH = 1600;
    private static final int HEIGHT = 900;

    private SpearCreator spearCreator;
    private EnemyCreator enemyCreator;

    private double enemySpawnTimer = 0;

    public Gauntlet() {

        super(WIDTH, HEIGHT);

        Spear.resetSpearCount();

        enableGravity();
        setG(0.7);
        setWindowTitle("The Gauntlet");

        RectanglePlatform sky = new RectanglePlatform(0, 0, WIDTH, HEIGHT);
        sky.color = Color.LIGHTBLUE;
        renderables.add(sky);

        RectanglePlatform background = new RectanglePlatform(0, 300, WIDTH, 600);
        background.color = new Color(0.92, 0.90, 0.39, 1.0);
        renderables.add(background);

        RectanglePlatform rp = new RectanglePlatform(0, 700, WIDTH, 200);
        rp.color = new Color(0.92, 0.90, 0.39, 1.0);
        platforms.add(rp);

        player = new GauntletPlayer((width() / 2) - (50 / 2), 500, 100, 200);

        spearCreator = new SpearCreator(new Vector2d(150, 8), new Vector2d(width(), height()), new Vector2d(530, 650));
        enemyCreator = new EnemyCreator(new Vector2d(width(), height()), new Vector2d(150, 300));

    }

    private void spawnEnemies(double timedelta) {

        enemySpawnTimer -= timedelta;

        if (enemySpawnTimer <= 0.0) {
            entities.add(enemyCreator.leftHeaded());
            entities.add(enemyCreator.rightHeaded());
            enemySpawnTimer += 1.1;
        }
    }

    @Override
    protected boolean isRunning() {
        return windowIsOpen() && player.isAlive();
    }

    private void tickEnemies(double timedelta) {
        for (GameEntity e : entities) {
            if (e instanceof Enemy) {
                ((Enemy)e).tick(timedelta);
            }
        }
    }

    private void spawnSpear() {

        if (Spear.spearCount() <= 0) {
            entities.add(spearCreator.createSpear());
        }

    }

    @Override
    protected void tick(double timedelta) {

        spawnSpear();
        player.tick(timedelta);
        tickEnemies(timedelta);
        spawnEnemies(timedelta);

    }


}
