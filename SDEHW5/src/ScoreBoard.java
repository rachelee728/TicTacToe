import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

    int[] xRow = new int[5];
    int[] oRow = new int[5];
    int[] xColumn = new int[5];
    int[] oColumn = new int[5];
    int[] xDiag = new int[5];
    int[] oDiag = new int[5];
    int[] xAntiDiag = new int[5];
    int[] oAntiDiag = new int[5];

    int X = -1;
    int O = 0;

    public void initialize() {
        plays[0][0] = r0c0;
        plays[0][1] = r0c1;
        plays[0][2] = r0c2;
        plays[0][3] = r0c3;
        plays[0][4] = r0c4;
        plays[1][0] = r1c0;
        plays[1][1] = r1c1;
        plays[1][2] = r1c2;
        plays[1][3] = r1c3;
        plays[1][4] = r1c4;
        plays[2][0] = r2c0;
        plays[2][1] = r2c1;
        plays[2][2] = r2c2;
        plays[2][3] = r2c3;
        plays[2][4] = r2c4;
        plays[3][0] = r3c0;
        plays[3][1] = r3c1;
        plays[3][2] = r3c2;
        plays[3][3] = r3c3;
        plays[3][4] = r3c4;
        plays[4][0] = r4c0;
        plays[4][1] = r4c1;
        plays[4][2] = r4c2;
        plays[4][3] = r4c3;
        plays[4][4] = r4c4;
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

        moves += 1;
        Button clicked = (Button) e.getSource();

        int x = GridPane.getRowIndex(clicked);
        int y = GridPane.getColumnIndex(clicked);

        Stage backToStart = (Stage)((Node)e.getSource()).getScene().getWindow();
        startScreen stan = new startScreen();
        if (clicked == quit) {
            try {
                stan.start(backToStart);
            } catch (Exception o) {
                o.printStackTrace();
            }
        }

        else if (clicked == restart) {
            moves = 0;
            startAgain();
        }

        else {

            if (moves % 2 == 0) {
                enter(x - 1, y, "O");
                oScore.setText("O Score: " + OWon(x - 1, y));
                turns.setText("Current Turn: X");
            } else {
                enter(x - 1, y, "X");
                xScore.setText("X Score: " + XWon(x - 1, y));
                turns.setText("Current Turn: O");
            }
            clicked.setDisable(true);
        }


        if (moves == 25) {
            if (Integer.parseInt(OWon(x - 1, y)) > Integer.parseInt(XWon(x - 1, y))) {
                turns.setText("O Wins!");
            } else {
                turns.setText("X Wins!");
            }
            disable();
        }
    }

    String XWon(int r, int c) {
        int boardSize = 4;
        if (r != 4 && c != 4) {
            //checks row below and above
            if (plays[r + 1][c].equals("O") || plays[r - 1][c].equals("O")) {
                oColumn[c] = 0;
                oRow[r] = 0;
            }
            //checks column to the right and left
            if (plays[r][c + 1].equals("O") || plays[r][c - 1].equals("O")) {
                oColumn[c] = 0;
                oRow[r] = 0;
            }
            //diagonal
            if (r == c) {
                if (plays[r + 1][c + 1].equals("O") || plays[r - 1][c - 1].equals("O")) {
                    xDiag[r]++;
                    oDiag[r] = 0;
                }
            } else if (r + c == boardSize) {
                if (plays[r + 1][c + 1].equals("O") || plays[r - 1][c - 1].equals("O")) {
                    xAntiDiag[r]++;
                    oAntiDiag[r] = 0;
                }
            }
        }
        xRow[r]++;
        xColumn[c]++;

            if (xRow[r] == boardSize + 1 || xColumn[c] == boardSize + 1 || xDiag[r] == boardSize + 1|| xAntiDiag[r] == boardSize + 1)
                X += 10;
            if (xRow[r] == boardSize - 1  || xColumn[c] == boardSize - 1  || xDiag[r] == boardSize - 1 || xAntiDiag[r] == boardSize - 1)
                X += 3;
            if (xRow[r] == boardSize - 2 || xColumn[c] == boardSize - 2 || xDiag[r] == boardSize - 2 || xAntiDiag[r] == boardSize - 2)
                X += 1;
            return Integer.toString(X);
        }

    String OWon(int r, int c){
        int boardSize = 4;
        if(r != 4 && c!= 4) {
            if (plays[r + 1][c].equals("X") || plays[r - 1][c].equals("X")) {
                xRow[r] = 0;
                xColumn[c] = 0;
            }
            if (plays[r + 1][c].equals("X") || plays[r - 1][c].equals("X")) {
                xRow[r] = 0;
                xColumn[c] = 0;
            }
            if (r == c) {
                if (plays[r + 1][c+1].equals("X") || plays[r - 1][c-1].equals("X")) {
                    oDiag[r]++;
                    xDiag[r] = 0;
                }
            }
            else if (r + c == boardSize) {
                if (plays[r + 1][c+1].equals("X") || plays[r - 1][c-1].equals("X")) {
                    oAntiDiag[r]++;
                    xAntiDiag[r] = 0;
                }
            }
            oColumn[c]++;
            oRow[r]++;
            if (oRow[r] == boardSize + 1 || oColumn[c] == boardSize + 1 || oDiag[r] == boardSize + 1 || oAntiDiag[r] == boardSize + 1)
                O += 10;
            if (oRow[r] == boardSize - 1 || oColumn[c] == boardSize - 1 || oDiag[r] == boardSize - 1 || oAntiDiag[r] == boardSize - 1)
                O += 3;
            if (oRow[r] == boardSize - 2 || oColumn[c] == boardSize - 2 || oDiag[r] == boardSize - 2 || oAntiDiag[r] == boardSize - 2)
                O += 1;
        }
        return Integer.toString(O);

    }


}

