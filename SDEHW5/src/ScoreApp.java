import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScoreApp extends Application {

    Parent root;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/ScoreBoard.fxml"));
        scene = new Scene(root);
<<<<<<< HEAD
    }

}
=======
        stage.setScene(scene);
        stage.show();
    }
}
>>>>>>> 101bb9d0a7eeb6b68d39aa142734d4b260b01c51
