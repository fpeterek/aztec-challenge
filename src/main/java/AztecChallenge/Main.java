package AztecChallenge;

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

    private void runGame() {

    }

    private void createButton(String label, Runnable fun) {

        Button button = new Button();
        button.setOnAction(event -> fun.run());
        button.setText(label);
        button.setMinWidth(250);
        button.setMaxWidth(250);
        buttons.add(button);

    }

    private void createButtons() {

        buttons = new ArrayList<>();

        createButton("Temple Assault", this::runGame);
        createButton("Mountain Range", this::runGame);
        createButton("Dungeon ", this::runGame);
        createButton("Temple Assault", this::runGame);

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
