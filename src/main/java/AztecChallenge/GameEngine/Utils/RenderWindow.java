package AztecChallenge.GameEngine.Utils;


import AztecChallenge.Interfaces.Renderable;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class RenderWindow {

    private Stage stage;
    private Group root;
    private Canvas canvas;
    private GraphicsContext gc;

    public RenderWindow(int width, int height) {

        stage = new Stage();

        stage.setTitle("RenderWindow");

        root = new Group();
        canvas = new Canvas(width, height);

        stage.setScene(new Scene(root));
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

    }

    public double width() {
        return root.getScene().getWindow().getWidth();
    }

    public double height() {
        return root.getScene().getWindow().getHeight();
    }

    public boolean isOpen() {
        return stage != null;
    }

    public boolean isShown() {
        return stage.isShowing();
    }

    public void close() {
        stage.close();
        stage = null;
    }

    public void onKeyPress(EventHandler<KeyEvent> handler) {
        stage.getScene().setOnKeyPressed(handler);
    }

    public void onKeyRelease(EventHandler<KeyEvent> handler) {
        stage.getScene().setOnKeyReleased(handler);
    }

    public void setTitle(String title) {
        stage.setTitle(title);
    }

    public void clear() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void render(Renderable r) {
        r.render(gc);
    }

    public void show() {
        stage.show();
    }

    public void hide() {
        stage.hide();
    }

    public void drawShapes() {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }

}
