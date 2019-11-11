package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.Utils.Vector2d;
import javafx.scene.image.Image;

import java.util.Random;

public class EnemyCreator {

    private static double fx = 1.6;
    private static double fy = 1;

    private static double width = 16;
    private static double height = 20;

    private static int spriteWidth = 24;
    private static int spriteHeight = 30;
    private static int spriteMod = 10;

    private Image sprite;
    private Vector2d windowSize;
    private Vector2d offset;
    public EnemyCreator(Vector2d windowDim, Vector2d spawnOffset) {

        windowSize = new Vector2d(windowDim);
        offset = new Vector2d(spawnOffset);
        sprite = new Image("gauntlet_enemy.png", spriteWidth*spriteMod, spriteHeight*spriteMod, true, false);

    }

    public Enemy leftHeaded() {
        Enemy enemy = new Enemy(windowSize.x / 2 - offset.x - width, offset.y, width, height, sprite);
        enemy.setForces(-fx, fy);
        enemy.affectedByGravity(false);
        return enemy;
    }

    public Enemy rightHeaded() {
        Enemy enemy = new Enemy(windowSize.x / 2 + offset.x, offset.y, width, height, sprite);
        enemy.setForces(fx, fy);
        enemy.affectedByGravity(false);
        return enemy;
    }

}
