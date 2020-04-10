import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class onePlayerScoreApp extends Application {
    Parent root;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/onePlayerScore.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
