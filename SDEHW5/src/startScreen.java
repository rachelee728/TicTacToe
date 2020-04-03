import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class startScreen extends Application {
    //hi
    Label placeHolder;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TicTacToe!!!1");

        placeHolder = new Label("");
        placeHolder.setVisible(false);

        Button button1 = new Button();
        button1.setText("1-player mode");

        Button button2 = new Button();
        button2.setText("2-player mode");

        Button button3 = new Button();
        button3.setText("Standard mode");

        Button button4 = new Button();
        button4.setText("Start");
        button4.setOnAction(new ButtonHandler());

        FlowPane root = new FlowPane();
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(button3);
        root.getChildren().add(button4);
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            placeHolder.setVisible(true);
            placeHolder.setText("You have pressed the button");
        }
    }
}
