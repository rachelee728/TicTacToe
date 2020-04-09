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
    Button r0c0, r1c0, r2c0, r3c0, r4c0;
    @FXML
    Button r0c1, r1c1, r2c1, r3c1, r4c1;
    @FXML
    Button r0c2, r1c2, r2c2, r3c2, r4c2;
    @FXML
    Button r0c3, r1c3, r2c3, r3c3, r4c3;
    @FXML
    Button r0c4, r1c4, r2c4, r3c4, r4c4;

    @FXML
    Button quit, restart;
    @FXML
    Label turns, xScore, oScore;

    Button[][] plays = new Button[5][5];

    int[] row;
    int[] column;
    int[] diag;
    int[] antiDiag;

    public void initialize() {
        plays[0][0] = r0c0; plays[0][1] = r0c1; plays[0][2] = r0c2; plays[0][3] = r0c3; plays[0][4] = r0c4;
        plays[1][0] = r1c0; plays[1][1] = r1c1; plays[1][2] = r1c2; plays[1][3] = r1c3; plays[1][4] = r1c4;
        plays[2][0] = r2c0; plays[2][1] = r2c1; plays[2][2] = r2c2; plays[2][3] = r2c3; plays[2][4] = r2c4;
        plays[3][0] = r3c0; plays[3][1] = r3c1; plays[3][2] = r3c2; plays[3][3] = r3c3; plays[3][4] = r3c4;
        plays[4][0] = r4c0; plays[4][1] = r4c1; plays[4][2] = r4c2; plays[4][3] = r4c3; plays[4][4] = r4c4;
    }

    public void enter(int x, int y, String move) {
        plays[x][y].setText(move);
    }

    public void startAgain() {
        for (int i = 0; i < plays.length; i++) {
            for (int j = 0; j < plays.length; j++) {
                plays[i][j].setDisable(false);
                plays[i][j].setText("");
                turns.setText("Current Turn: X");
            }
        }
    }

    public void disable() {
        for (int i = 0; i < plays.length; i++) {
            for (int j = 0; j < plays.length; j++) {
                plays[i][j].setDisable(true);
            }
        }
    }

    @FXML
    protected void handleButton(ActionEvent e) throws Exception {

        Button clicked = (Button)e.getSource();
        ScoreBoard scored = new ScoreBoard();

        moves += 1;
        if (!(e.getSource() == quit) || !(e.getSource() == restart)) {

            int x = GridPane.getRowIndex(clicked);
            int y = GridPane.getColumnIndex(clicked);

            if (moves % 2 == 0) {
                enter(x-1, y, "O");
                clicked.setText("O");
                OWon(x-1,y);
                turns.setText("Current Turn: X");
                if (scored.OWon(x-1,y) > scored.XWon(x-1,y)) {
                    turns.setText("O Wins!");
                }
            } else {
                enter(x-1, y, "X");
                clicked.setText("X");
                XWon(x-1, y);
                turns.setText("Current Turn: O");
                if (scored.XWon(x-1,y) > scored.OWon(x-1,y)) {
                    turns.setText("X Wins!");
                }
            }
            clicked.setDisable(true);
        }
        else if (e.getSource() == quit) {
            startScreen backToStart = new startScreen();
            backToStart.start(backToStart.stage);
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

