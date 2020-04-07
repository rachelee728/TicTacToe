import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;

import java.awt.*;

public class ScoreBoard {

    int moves = 0;
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
    Button quit, restart;
    @FXML
    Label turns;

    @FXML
    protected void handleButton(ActionEvent e) {

        moves += 1;
        Button clicked = (Button) e.getSource();

        if(e.getSource() == quit){

        }
        else if(e.getSource() == restart){

        }
        else{
            if (moves % 2 == 0) {
                clicked.setText("O");
                turns.setText("Current Turn : X");
            } else {
                clicked.setText("X");
                turns.setText("Current Turn: O");
            }
            clicked.setDisable(true);
        }

    }
}
