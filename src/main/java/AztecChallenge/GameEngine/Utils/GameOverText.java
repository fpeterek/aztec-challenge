package AztecChallenge.GameEngine.Utils;

import AztecChallenge.Interfaces.Renderable;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class GameOverText implements Renderable {

    private Font f;
    private String text;
    private double x;
    private double y;

    public GameOverText(double xPos, double yPos) {
        x = xPos;
        y = yPos;
        text = "Game Over\nPress esc to exit";
        f = Font.loadFont("lcd_solid.ttf", 50);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);

        gc.setFont(f);
        Font newF = new Font(gc.getFont().getFamily(),  50);
        gc.setFont(newF);
        gc.setFill(Color.BLACK);
        gc.fillText(text, x, y);
    }

}
