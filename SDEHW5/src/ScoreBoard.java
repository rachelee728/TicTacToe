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

    int methodCounter = 0;

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

//        moves += 1;
//        Button clicked = (Button) e.getSource();
//
//        int x = GridPane.getRowIndex(clicked);
//        int y = GridPane.getColumnIndex(clicked);
//
//        if (clicked == quit) {
//            startScreen backToStart = new startScreen();
//            backToStart.start(backToStart.stage);
//        } else if (clicked == restart) {
//            startAgain();
//        } else {
//
//            if (moves % 2 == 0) {
//                enter(x - 1, y, "O");
//                oScore.setText("O Score: " + OWon(x - 1, y));
//                turns.setText("Current Turn: X");
//            } else {
//                enter(x - 1, y, "X");
//                xScore.setText("X Score: " + XWon(x - 1, y));
//                turns.setText("Current Turn: O");
//            }
//            clicked.setDisable(true);
//        }


//        if (moves == 25) {
//            if (Integer.parseInt(OWon(x - 1, y)) > Integer.parseInt(XWon(x - 1, y))) {
//                turns.setText("O Wins!");
//                disable();
//            } else {
//                turns.setText("X Wins!");
//                disable();
//            }
//        }
    }

    public void checkColumn(int r, int c, String player) {
        if (player == "X") {
            if ((plays[r + 1][c].equals("X")) || (plays[r - 1][c].equals("X"))) {
                if ((plays[r + 2][c].equals("X")) || (plays[r - 2][c].equals("X"))) {
                    X += 10;
                } else {
                    X += 1;
                }
                if (!(plays[r + 2][c].equals("X")) || (plays[r - 2][c].equals("X"))) {
                    if (!(plays[r + 2][c].equals("X")) || (plays[r - 3][c].equals("X"))) {

                    }
                }
            } else {
                X += 1;
            }
            if ((plays[r + 1][c].equals("X")) || !(plays[r - 1][c].equals("X"))) {
                if ((plays[r + 2][c].equals("X"))) {
                    if ((plays[r + 3][c].equals("X"))) {
                        if ((plays[r + 4][c].equals("X"))) {
                            X += 10;
                        }
                        X += 3;
                    } else {
                        X += 1;
                    }
                }
            }
            if (!(plays[r + 1][c].equals("X")) || (plays[r - 1][c].equals("X"))) {
                if ((plays[r + 2][c].equals("X"))) {
                    if ((plays[r + 3][c].equals("X"))) {
                        if ((plays[r + 4][c].equals("X"))) {
                            X += 10;
                        }
                        X += 3;
                    } else {
                        X += 1;
                    }
                }
            }
        }

        if (player == "O") {
            if ((plays[r + 1][c].equals("O")) || (plays[r - 1][c].equals("O"))) {
                if ((plays[r + 2][c].equals("O")) || (plays[r - 2][c].equals("O"))) {
                    X += 10;
                } else {
                    X += 3;
                }
            } else {
                X += 1;
            }
            if ((plays[r + 1][c].equals("X")) || !(plays[r - 1][c].equals("X"))) {
                if ((plays[r + 2][c].equals("X"))) {
                    if ((plays[r + 3][c].equals("X"))) {
                        if ((plays[r + 4][c].equals("X"))) {
                            X += 10;
                        }
                        X += 3;
                    } else {
                        X += 1;
                    }
                }
            }
            if (!(plays[r + 1][c].equals("X")) || (plays[r - 1][c].equals("X"))) {
                if ((plays[r + 2][c].equals("X"))) {
                    if ((plays[r + 3][c].equals("X"))) {
                        if ((plays[r + 4][c].equals("X"))) {
                            X += 10;
                        }
                        X += 3;
                    } else {
                        X += 1;
                    }
                }
            }
        }
    }

    public void checkRow(int r, int c, String player) {
        if (player == "X") {
            if ((plays[r][c + 1].equals("X")) || (plays[r][c - 1].equals("X"))) {
                if ((plays[r][c + 2].equals("X")) || (plays[r][c - 2].equals("X"))) {
                    if ((plays[r][c + 3].equals("X")) || (plays[r][c - 3].equals("X"))) {
                        X += 10;
                    }
                } else {
                    X += 3;
                }
            }
            else {
                X += 1;
            }
            if ((plays[r][c + 1].equals("X")) || !(plays[r][c - 1].equals("X"))) {
                if ((plays[r][c + 2].equals("X"))) {
                    if ((plays[r][c + 3].equals("X"))) {
                        X += 10;
                    }
                } else {
                    X += 3;
                }
            }
            else {
                X += 1;
            }
            if (!(plays[r][c + 1].equals("X")) || (plays[r][c - 1].equals("X"))) {
                if ((plays[r][c - 2].equals("X"))) {
                    if ((plays[r][c - 3].equals("X"))) {
                        X += 10;
                    }
                } else {
                    X += 3;
                }
            }
            else {
                X += 1;
            }
        }

        if (player == "O") {
            if ((plays[r][c + 1].equals("O")) || (plays[r][c - 1].equals("O"))) {
                if ((plays[r][c + 2].equals("O")) || (plays[r][c - 2].equals("O"))) {
                    if ((plays[r][c + 3].equals("O")) || (plays[r][c - 3].equals("O"))) {
                        O += 10;
                    }
                } else {
                    O += 3;
                }
            }
            else {
                O += 1;
            }
            if ((plays[r][c + 1].equals("O")) || !(plays[r][c - 1].equals("O"))) {
                if ((plays[r][c + 2].equals("O"))) {
                    if ((plays[r][c + 3].equals("O"))) {
                        O += 10;
                    }
                } else {
                    O += 3;
                }
            }
            else {
                O += 1;
            }
            if (!(plays[r][c + 1].equals("O")) || (plays[r][c - 1].equals("O"))) {
                if ((plays[r][c - 2].equals("O"))) {
                    if ((plays[r][c - 3].equals("O"))) {
                        O += 10;
                    }
                } else {
                    O += 3;
                }
            }
            else {
                O += 1;
            }
        }
    }

    public void checkDiagonal(int r, int c, String player) {
        if (player == "X") {
            if ((plays[r - 1][c - 1].equals("X")) || (plays[r + 1][c + 1].equals("X"))) {
                if ((plays[r - 2][c - 2].equals("X")) || (plays[r + 2][c + 2].equals("X"))) {
                    if ((plays[r - 3][c - 3].equals("X")) || (plays[r + 3][c + 3].equals("X"))) {
                        X += 10;
                    }
                } else {
                    X += 3;
                }
            }
            else {
                X += 1;
            }
            if ((plays[r - 1][c - 1].equals("X")) || !(plays[r][c - 1].equals("X"))) {
                if ((plays[r][c + 2].equals("X"))) {
                    if ((plays[r][c + 3].equals("X"))) {
                        X += 10;
                    }
                } else {
                    X += 3;
                }
            }
            else {
                X += 1;
            }
            if (!(plays[r][c + 1].equals("X")) || (plays[r][c - 1].equals("X"))) {
                if ((plays[r][c - 2].equals("X"))) {
                    if ((plays[r][c - 3].equals("X"))) {
                        X += 10;
                    }
                } else {
                    X += 3;
                }
            }
            else {
                X += 1;
            }
        }

        if (player == "O") {
            if ((plays[r][c + 1].equals("O")) || (plays[r][c - 1].equals("O"))) {
                if ((plays[r][c + 2].equals("O")) || (plays[r][c - 2].equals("O"))) {
                    if ((plays[r][c + 3].equals("O")) || (plays[r][c - 3].equals("O"))) {
                        O += 10;
                    }
                } else {
                    O += 3;
                }
            }
            else {
                O += 1;
            }
            if ((plays[r][c + 1].equals("O")) || !(plays[r][c - 1].equals("O"))) {
                if ((plays[r][c + 2].equals("O"))) {
                    if ((plays[r][c + 3].equals("O"))) {
                        O += 10;
                    }
                } else {
                    O += 3;
                }
            }
            else {
                O += 1;
            }
            if (!(plays[r][c + 1].equals("O")) || (plays[r][c - 1].equals("O"))) {
                if ((plays[r][c - 2].equals("O"))) {
                    if ((plays[r][c - 3].equals("O"))) {
                        O += 10;
                    }
                } else {
                    O += 3;
                }
            }
            else {
                O += 1;
            }
        }
    }

    public int checkAntiDiagonal(int r, int c) {
        return 1;
    }

}
