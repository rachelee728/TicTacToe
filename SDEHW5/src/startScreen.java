import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class startScreen extends Application {

    Label placeHolder;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("TicTacToe!!!");

        Label label1 = new Label("Select player mode/game mode");
        Label playerMode = new Label("Player Modes");
        Label scoreMode = new Label("Score Modes");

        ToggleGroup playerModes = new ToggleGroup();
        ToggleGroup scoreModes = new ToggleGroup();

        RadioButton player1 = new RadioButton("1-player mode");
        RadioButton player2 = new RadioButton("2-player mode");
        RadioButton standardMode = new RadioButton("Standard mode"); //win when get 4 in a row
        RadioButton scoreModeButton = new RadioButton("Score mode"); //win when the board is all full--compare b/t players

        Button startButton = new Button("Start");


        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        root.add(label1,0,0);
        root.add(playerMode,0,2);
        root.add(scoreMode,3,2);

        player1.setToggleGroup(playerModes);
        player2.setToggleGroup(playerModes);
        standardMode.setToggleGroup(scoreModes);
        standardMode.setOnAction(new ButtonHandler());
        scoreModeButton.setToggleGroup(scoreModes);
        scoreModeButton.setOnAction(new ButtonHandler());

        root.add(player1,0,3);
        root.add(player2,0,5);
        root.add(standardMode,3,3);
        root.add(scoreModeButton,3,5);
        root.add(startButton,5,6);

        startButton.setOnAction(new ButtonHandler());

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            
        }
    }
}
