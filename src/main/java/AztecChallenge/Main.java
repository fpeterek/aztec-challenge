package AztecChallenge;

import AztecChallenge.GameEngine.Engine;
import AztecChallenge.Minigames.TempleAssault.TempleAssault;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage mainMenu;
    private VBox vbox;
    private List<Button> buttons;
    private BorderPane root;

    public static void main(String[] args) {
        launch(args);
    }

    private void runGame(Engine engine) {
        engine.run();
    }

    private void notYetImplemented() {
        System.out.println("Not yet implemented");
    }

    private void templeAssault() {
        runGame(new TempleAssault());
    }

    private void hideMenu() {
        mainMenu.hide();
    }

    private void showMenu() {
        mainMenu.show();
    }

    private void createButton(String label, Runnable fun) {

        Button button = new Button();
        button.setOnAction(event -> fun.run());
        button.setText(label);
        button.setMinWidth(250);
        button.setMaxWidth(250);
        buttons.add(button);

    }

    private void exit() {
        mainMenu.close();
        mainMenu = null;
        System.exit(0);
    }

    private void createButtons() {

        buttons = new ArrayList<>();

        createButton("Temple Assault", this::templeAssault);
        createButton("Mountain Range", this::notYetImplemented);
        createButton("Dungeon ", this::notYetImplemented);
        createButton("Exit", this::exit);

        vbox.getChildren().addAll(buttons);

    }

    private void initVBox() {
        vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
    }

    private void initRoot() {
        root = new BorderPane();
        root.setCenter(vbox);
    }

    @Override
    public void start(Stage primaryStage) {

        initVBox();
        initRoot();
        createButtons();

        mainMenu = primaryStage;
        mainMenu.setScene(new Scene(root, 800, 600));
        mainMenu.show();


    }


}
