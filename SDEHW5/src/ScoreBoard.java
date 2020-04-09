import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;

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

    String[][] plays = new String[5][5];
    int[] row;
    int[] column;
    int[] diag;
    int[] antiDiag;

    public void initalize() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                plays[i][j] = "S";
            }
        }
    }

    public void enter(int x, int y, String player) {
        plays[x][y] = player;
    }

    @FXML
    protected void handleButton(ActionEvent e) throws Exception {

        moves += 1;
        Button clicked = (Button) e.getSource();
        ScoreBoard scored = new ScoreBoard();

        if (!(e.getSource() == quit) || !(e.getSource() == restart)) {

            int x = GridPane.getRowIndex(clicked);
            int y = GridPane.getColumnIndex(clicked);

            if (moves % 2 == 0) {
                enter(x-1, y, "O");
                clicked.setText("O");
                OWon(x-1, y);
                if (scored.XWon(x-1,y) > scored.OWon(x-1,y)) {
                    turns.setText("O Wins!");
                }
                turns.setText("Current Turn: X");
            } else {
                enter(x-1, y, "X");
                clicked.setText("X");
                XWon(x-1, y);
                if (scored.XWon(x-1,y) > scored.OWon(x-1,y)) {
                    turns.setText("X Wins!");
                }
                turns.setText("Current Turn: O");
            }
            clicked.setDisable(true);
        }
        else if (e.getSource() == quit) {
            startScreen backTostart = new startScreen();
            backTostart.start(backTostart.stage);
        }
        else {

        }
    }

    int XWon(int r, int c){ // Call this function when player moves
        int X = 0;
        int boardSize = plays[0].length;
        row[r]++;
        column[c]++;
        if(r==c) diag[r]++;
        if(r+c==boardSize) antiDiag[r]++;
        if(row[r] == boardSize || column[c] == boardSize || diag[r] == boardSize || antiDiag[r] == boardSize) X += 10;
        if(row[r] == boardSize-1 || column[c] == boardSize-1 || diag[r] == boardSize-1 || antiDiag[r] == boardSize-1) X+=3;
        if(row[r] == boardSize-2 || column[c] == boardSize-2 || diag[r] == boardSize-2 || antiDiag[r] == boardSize-2) X += 1;
        return X;
    }

    int OWon(int r, int c){
        int O = 0;
        int boardSize = plays[0].length;
        row[r]++;
        column[c]++;
        if(r==c) diag[r]++;
        if(r+c==boardSize) antiDiag[r]++;
        if(row[r] == boardSize || column[c] == boardSize || diag[r] == boardSize || antiDiag[r] == boardSize) O += 10;
        if(row[r] == boardSize-1 || column[c] == boardSize-1 || diag[r] == boardSize-1 || antiDiag[r] == boardSize-1) O+=3;
        if(row[r] == boardSize-2 || column[c] == boardSize-2 || diag[r] == boardSize-2 || antiDiag[r] == boardSize-2) O += 1;
        return O;

    }


}

