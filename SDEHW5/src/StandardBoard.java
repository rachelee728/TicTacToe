import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StandardBoard {

    @FXML
    Button oneZeroButton, twoZeroButton, threeZeroButton, fourZeroButton, fiveZeroButton;
    @FXML
    Button oneOneButton, twoOneButton, threeOneButton, fourOneButton, fiveOneButton;
    @FXML
    Button oneTwoButton, twoTwoButton, threeTwoButton, fourTwoButton, fiveTwoButton;
    @FXML
    Button oneThreeButton, twoThreeButton, threeThreeButton, fourThreeButton, fiveThreeButton;
    @FXML
    Button oneFourButton, twoFourButton, threeFourButton, fourFourButton, fiveFourButton;

    @FXML
    Label turns, quit, restart;

    @FXML
    protected void handleButton(ActionEvent e) {
        turns.setText("hello");
    }
}
