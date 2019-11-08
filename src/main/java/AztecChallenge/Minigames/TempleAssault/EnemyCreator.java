package AztecChallenge.Minigames.TempleAssault;

import AztecChallenge.GameEngine.Utils.Vector2d;

import java.util.Random;

public class EnemyCreator {

    private static double fx = 0.6;
    private static double fy = 1;

    private static double width = 12;
    private static double height = 24;

    private Vector2d windowSize;
    private Vector2d offset;
    private Random rand;

    public EnemyCreator(Vector2d windowDim, Vector2d spawnOffset) {

        windowSize = new Vector2d(windowDim);
        offset = new Vector2d(spawnOffset);
        rand = new Random();

    }

    public Enemy leftHeaded() {
        Enemy enemy = new Enemy(windowSize.x / 2 - offset.x - width, offset.y, width, height);
        enemy.setForces(-fx, fy);
        enemy.affectedByGravity(false);
        return enemy;
    }

    public Enemy rightHeaded() {
        Enemy enemy = new Enemy(windowSize.x / 2 + offset.x, offset.y, width, height);
        enemy.setForces(fx, fy);
        enemy.affectedByGravity(false);
        return enemy;
    }

}
