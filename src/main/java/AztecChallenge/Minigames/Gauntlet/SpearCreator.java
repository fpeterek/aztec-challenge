package AztecChallenge.Minigames.Gauntlet;

import AztecChallenge.GameEngine.Utils.Vector2d;
import javafx.scene.image.Image;

import java.util.Random;

public class SpearCreator {

    private Vector2d spearSize;
    private Vector2d windowSize;
    private Vector2d allowedSpearPositions;
    private Random rand;
    private Image sprite;

    public SpearCreator(Vector2d spearDim, Vector2d windowDim, Vector2d spearPos) {
        spearSize = new Vector2d(spearDim);
        windowSize = new Vector2d(windowDim);
        sprite = new Image("gauntlet_spear.png");
        allowedSpearPositions = new Vector2d(spearPos);
        rand = new Random();
    }

    private double randY() {
        return (rand.nextBoolean()) ? allowedSpearPositions.x : allowedSpearPositions.y;
    }

    private Spear leftHeaded() {
        Spear spear = new Spear(windowSize.x, randY(), spearSize.x, spearSize.y, sprite);
        spear.setForces(-4, 0);
        return spear;
    }

    private Spear rightHeaded() {
        Spear spear = new Spear(-spearSize.x, randY(), spearSize.x, spearSize.y, sprite);
        spear.setForces(4, 0);
        return spear;
    }

    public Spear createSpear() {
        return (rand.nextBoolean()) ? leftHeaded() : rightHeaded();
    }

}
