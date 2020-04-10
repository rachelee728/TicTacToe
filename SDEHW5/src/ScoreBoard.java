import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


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
    int xDiag = 0;
    int oDiag = 0;
    int xAntiDiag = 0;
    int oAntiDiag = 0;

    int X = -1;
    int O = 0;

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

        moves += 1;
        Button clicked = (Button) e.getSource();

        int x = GridPane.getRowIndex(clicked);
        int y = GridPane.getColumnIndex(clicked);

        if (clicked == quit) {
            startScreen backToStart = new startScreen();
            backToStart.start(backToStart.stage);
        } else if (clicked == restart) {
            startAgain();
        } else {

            if (moves % 2 == 0) {
                enter(x - 1, y, "O");
                checkRow(x-1, y, "O");
                checkColumn(x-1, y, "O");
                checkDiag(x-1, y, "O");
                checkAntiDiag(x-1, y, "O");
                oScore.setText("O Score: " + O);
                turns.setText("Current Turn: X");
            } else {
                enter(x - 1, y, "X");
                checkRow(x-1, y, "X");
                checkColumn(x-1, y, "X");
                checkDiag(x-1, y, "X");
                checkAntiDiag(x-1, y, "X");
                xScore.setText("X Score: " + X);
                turns.setText("Current Turn: O");
            }
            clicked.setDisable(true);
        }


        if (moves == 25) {
            if (O > X) {
                turns.setText("O Wins!");
                disable();
            } else {
                turns.setText("X Wins!");
                disable();
            }
        }
    }

    public void checkRow(int x, int y, String player) {
            if (plays[x][0].getText().equals(player) && plays[x][1].getText().equals(player) && plays[x][2].getText().equals(player)
                    && plays[x][3].getText().equals(player) && plays[x][4].getText().equals(player)) {
                if (player.equals("X")) X += 10;
                else O += 10;
            }

            else if ((plays[x][0].getText().equals(player) || plays[x][4].getText().equals(player)) && plays[x][1].getText().equals(player)
                    && plays[x][2].getText().equals(player) && plays[x][3].getText().equals(player)) {
                if (player.equals("X")) X += 3;
                else O += 3;
            }

            else if ((plays[x][0].getText().equals(player) && plays[x][1].getText().equals(player) && plays[x][2].getText().equals(player))
                    || (plays[x][1].getText().equals(player) && plays[x][2].getText().equals(player) && plays[x][3].getText().equals(player))
                    || (plays[x][2].getText().equals(player) && plays[x][3].getText().equals(player) && plays[x][4].getText().equals(player))) {
                if (player.equals("X")) X += 1;
                else O += 1;
            }
    }

    public void checkColumn(int x, int y, String player) {
        if (plays[0][y].getText().equals(player) && plays[1][y].getText().equals(player) && plays[2][y].getText().equals(player)
                && plays[3][y].getText().equals(player) && plays[4][y].getText().equals(player)) {
            if (player.equals("X")) X += 10;
            else O += 10;
        }

        else if ((plays[0][y].getText().equals(player) || plays[4][y].getText().equals(player)) && plays[1][y].getText().equals(player)
                && plays[2][y].getText().equals(player) && plays[3][y].getText().equals(player)) {
            if (player.equals("X")) X += 3;
            else O += 3;
        }

        else if ((plays[0][y].getText().equals(player) && plays[1][y].getText().equals(player) && plays[2][y].getText().equals(player))
                || (plays[1][y].getText().equals(player) && plays[2][y].getText().equals(player) && plays[3][y].getText().equals(player))
                || (plays[2][y].getText().equals(player) && plays[3][y].getText().equals(player) && plays[4][y].getText().equals(player))) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }
    }

    public void checkDiag(int x, int y, String player) {
        if (x == y) {
            if (plays[0][0].getText().equals(player) && plays[1][1].getText().equals(player) && plays[2][2].getText().equals(player)
                    && plays[3][3].getText().equals(player) && plays[4][4].getText().equals(player)) {
                if (player.equals("X")) X += 10;
                else O += 10;
            }

            else if ((plays[0][0].getText().equals(player) || plays[4][4].getText().equals(player)) && plays[1][1].getText().equals(player)
                    && plays[2][2].getText().equals(player) && plays[3][3].getText().equals(player)) {
                if (player.equals("X")) X += 3;
                else O += 3;
            }

            else if ((plays[0][0].getText().equals(player) && plays[1][0].getText().equals(player) && plays[2][2].getText().equals(player))
                    || (plays[1][1].getText().equals(player) && plays[2][2].getText().equals(player) && plays[3][3].getText().equals(player))
                    || (plays[2][2].getText().equals(player) && plays[3][3].getText().equals(player) && plays[4][4].getText().equals(player))) {
                if (player.equals("X")) X += 1;
                else O += 1;
            }
        }

        else if (plays[0][1].getText().equals(player) && plays[1][2].getText().equals(player) && plays[2][3].getText().equals(player)
                && plays[3][4].getText().equals(player)) {
            if (player.equals("X")) X += 3;
            else O += 3;
        }

        else if (plays[1][0].getText().equals(player)  && plays[2][1].getText().equals(player) && plays[3][2].getText().equals(player)
                && plays[4][3].getText().equals(player)) {
            if (player.equals("X")) X += 3;
            else O += 3;
        }

        else if ((plays[0][1].getText().equals(player) || plays[3][4].getText().equals(player)) && plays[1][2].getText().equals(player)
                && plays[2][3].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }

        else if ((plays[1][0].getText().equals(player) || plays[4][3].getText().equals(player)) && plays[2][1].getText().equals(player)
                && plays[3][2].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }

        else if (plays[2][0].getText().equals(player)  && plays[3][1].getText().equals(player) && plays[4][2].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }

        else if (plays[0][2].getText().equals(player)  && plays[1][3].getText().equals(player) && plays[2][4].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }
    }

    public void checkAntiDiag(int x, int y, String player) {
        if ((x + y) == 4) {
            if (plays[0][4].getText().equals(player) && plays[1][3].getText().equals(player) && plays[2][2].getText().equals(player)
                    && plays[3][1].getText().equals(player) && plays[4][0].getText().equals(player)) {
                if (player.equals("X")) X += 10;
                else O += 10;
            }

            else if ((plays[0][4].getText().equals(player) || plays[4][0].getText().equals(player)) && plays[1][3].getText().equals(player)
                    && plays[2][2].getText().equals(player) && plays[3][1].getText().equals(player)) {
                if (player.equals("X")) X += 3;
                else O += 3;
            }

            else if ((plays[0][0].getText().equals(player) && plays[1][3].getText().equals(player) && plays[2][2].getText().equals(player))
                    || (plays[1][3].getText().equals(player) && plays[2][2].getText().equals(player) && plays[3][1].getText().equals(player))
                    || (plays[2][2].getText().equals(player) && plays[3][1].getText().equals(player) && plays[4][0].getText().equals(player))) {
                if (player.equals("X")) X += 1;
                else O += 1;
            }
        }

        else if (plays[0][3].getText().equals(player) && plays[1][2].getText().equals(player) && plays[2][1].getText().equals(player)
                && plays[3][0].getText().equals(player)) {
            if (player.equals("X")) X += 3;
            else O += 3;
        }

        else if (plays[1][4].getText().equals(player)  && plays[2][3].getText().equals(player) && plays[3][2].getText().equals(player)
                && plays[4][1].getText().equals(player)) {
            if (player.equals("X")) X += 3;
            else O += 3;
        }

        else if ((plays[0][3].getText().equals(player) || plays[3][0].getText().equals(player)) && plays[1][2].getText().equals(player)
                && plays[2][1].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }

        else if ((plays[1][4].getText().equals(player) || plays[4][1].getText().equals(player)) && plays[2][3].getText().equals(player)
                && plays[3][2].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }

        else if (plays[0][2].getText().equals(player)  && plays[1][1].getText().equals(player) && plays[2][0].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }

        else if (plays[2][4].getText().equals(player)  && plays[3][3].getText().equals(player) && plays[4][2].getText().equals(player)) {
            if (player.equals("X")) X += 1;
            else O += 1;
        }
    }
}