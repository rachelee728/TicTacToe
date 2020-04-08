import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class onePlayerStandard {
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
    protected void handleButton(ActionEvent e) throws Exception {

        moves += 1;
        Button clicked = (Button) e.getSource();

        String[][] plays = new String[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                plays[i][j] = "S";
            }
        }

        if (!(e.getSource() == quit) || !(e.getSource() == restart)) {

            int x = GridPane.getRowIndex(clicked);
            int y = GridPane.getColumnIndex(clicked);

            if (moves != 13) {
                plays[x-1][y] = "X";
                clicked.setText("X");
                if (winner(plays, "X")) {
                    turns.setText("X Wins!");
                    System.exit(0);
                }
                turns.setText("Current Turn: O");
                TimeUnit.SECONDS.sleep(4);

                Random rand = new Random();
                int xRand = rand.nextInt(5);
                int yRand = rand.nextInt(5);
                if(plays[xRand][yRand].isEmpty()) {
                    plays[x-1][y] = "O";
                    clicked.setText("O");
                    if (winner(plays, "O")) {
                        turns.setText("O Wins!");
                    }
                    turns.setText("Current Turn: X");
                }


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

    public boolean winner(String[][] plays, String player) {
        for (int i = 0; i < 5; i++) {
            if ((plays[i][0].equals(player) || plays[i][4].equals(player)) && plays[i][1].equals(player) && plays[i][2].equals(player) && plays[i][3].equals(player)) {
                return true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (plays[0][i].equals(player) && plays[1][i].equals(player) && plays[2][i].equals(player) && plays[3][i].equals(player) && plays[4][i].equals(player)) {
                return true;
            }
        }

        if (plays[0][0].equals(player) && plays[1][1].equals(player) && plays[2][2].equals(player)) {
            return true;
        }

        if (plays[0][2].equals(player) && plays[1][1].equals(player) && plays[2][0].equals(player)) {
            return true;
        }
        return false;
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
