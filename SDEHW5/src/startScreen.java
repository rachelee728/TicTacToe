/**
*@author: Rachel Lee, Dwij Gandhi, Kevin Luk
*/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class startScreen extends Application {

    Label placeHolder;
    RadioButton player1;
    RadioButton player2;
    RadioButton standardMode;
    RadioButton scoreModeButton;
    Button startButton;
    Stage stage;
    GridPane root;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setTitle("TicTacToe!!!");

        Label label1 = new Label("Select player mode/game mode");
        Label playerMode = new Label("Player Modes");
        Label scoreMode = new Label("Score Modes");

        placeHolder = new Label("");
        placeHolder.setVisible(false);

        ToggleGroup playerModes = new ToggleGroup();
        ToggleGroup scoreModes = new ToggleGroup();

        // create widgets to be displayed on screen
        player1 = new RadioButton("1-player mode");
        player2 = new RadioButton("2-player mode");
        standardMode = new RadioButton("Standard mode"); //win when get 4 in a row
        scoreModeButton = new RadioButton("Score mode"); //win when the board is all full--compare b/t players

        startButton = new Button("Start");

        // create scene to display widgets
        root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);

        root.add(label1,0,0);
        root.add(playerMode,0,2);
        root.add(scoreMode,3,2);

        // add radio button to group
        player1.setToggleGroup(playerModes);
        player2.setToggleGroup(playerModes);
        standardMode.setToggleGroup(scoreModes);
        scoreModeButton.setToggleGroup(scoreModes);

        // display widgets
        root.add(player1,0,3);
        root.add(player2,0,5);
        root.add(placeHolder, 0, 6);
        root.add(standardMode,3,3);
        root.add(scoreModeButton,3,5);
        root.add(startButton,1,7);

        startButton.setOnAction(new ButtonHandler());

        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            StandardApp standard = new StandardApp();
            ScoreApp scored = new ScoreApp();

            if(player1.isSelected() && standardMode.isSelected()) {

            }

            else if(player1.isSelected() && scoreModeButton.isSelected()) {

            }
            else if(player2.isSelected() && standardMode.isSelected()) {
                try {
                    standard.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else if(player2.isSelected() && scoreModeButton.isSelected()) {
                try {
                    scored.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                placeHolder.setText("You didn't pick two options!");
                placeHolder.setTextFill(Color.RED);
                placeHolder.setVisible(true);
            }
        }
    }
}
