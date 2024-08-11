package com.tic_tac_toe;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class GameBoardView {
    // class variables
    String[][] counter;
    int j;
    int i;
    String turnPlayer;
    Label turnLabel;


    // constructor
    public GameBoardView() {
        this.counter = new String[3][3];
        this.turnPlayer = "X";
        this.turnLabel = new Label("Turn: " + turnPlayer);
        this.i = 0;
        this.j = 0;

    }

    // creating the new gameBoard
    public Parent getGameBoardView() {
        // instantiate new main Layout
        BorderPane layout = new BorderPane();

        // styling the turnLabel
        this.turnLabel.setFont(Font.font("MonoSpaced", 35));

        // instantiate new game board
        GridPane board = new GridPane();

        // styling the game board
        board.setPrefSize(250, 250);
        board.setPadding(new Insets(10, 10, 10, 10));
        board.setVgap(10);
        board.setHgap(10);

        // create and add the buttons to the board
        int idxI = 0;
        int idxJ = 0;

        while (idxI < 3) {
            board.add(createGameButtons(), idxI, idxJ);
            idxJ++;
            if (idxJ == 3) {
                idxJ = 0;
                idxI++;
            }
        }

        // adding all the components to the main layout
        layout.setTop(this.turnLabel);
        layout.setCenter(board);

        // returns the layout
        return layout;
    }


    // method create a button
    private Button createGameButtons() {
        // instantiate the counter array with values
        instantiateCounter();

        // instantiate the new button
        Button button = new Button();

        // styling button
        button.setFont(Font.font("Monospaced", 40));
        button.setMinSize(100, 100);

        // button functionality
        button.setOnAction(event -> {

            // first we set the text to the button of the turn player also disabling the button
            button.setText(this.turnPlayer);
            button.setDisable(true);

            // then we add the turn player to this.counter[][] to keep track of the score then we change turn
            // we make use of the method variables i and j to keep track of the button being pressed

            this.counter[this.i][this.j] = turnPlayer;
            this.j++;
            if (this.j == 3) {
                this.j = 0;
                this.i ++;
            }

            changeTurn();

            // we then check for a winner or draw
            if (winnerOrDraw()) {

                // if the game is over we make it, so we can't press buttons and set game over text on label

                this.turnLabel.setText("The end!");
            }
        });

        return button;
    }

    private  void changeTurn() {
        if (this.turnPlayer.equals("X")) {
            this.turnPlayer = "O";
        } else if (this.turnPlayer.equals("O")) {
            this.turnPlayer = "X";
        }
        this.turnLabel.setText("Turn: " + turnPlayer);
    }

    private boolean winnerOrDraw() {
        // Check for a win

        // we first check for rows
        if ((this.counter[0][0].equals(this.counter[0][1]) && this.counter[0][1].equals(this.counter[0][2]) && !this.counter[0][0].equals(" ")) ||
                (this.counter[1][0].equals(this.counter[1][1]) && this.counter[1][1].equals(this.counter[1][2]) && !this.counter[1][0].equals(" ")) ||
                (this.counter[2][0].equals(this.counter[2][1]) && this.counter[2][1].equals(this.counter[2][2]) && !this.counter[2][0].equals(" ")) ||
                // then we check columns
                (this.counter[0][0].equals(this.counter[1][0]) && this.counter[1][0].equals(this.counter[2][0]) && !this.counter[0][0].equals(" ")) ||
                (this.counter[0][1].equals(this.counter[1][1]) && this.counter[1][1].equals(this.counter[2][1]) && !this.counter[0][1].equals(" ")) ||
                (this.counter[0][2].equals(this.counter[1][2]) && this.counter[1][2].equals(this.counter[2][2]) && !this.counter[0][2].equals(" ")) ||
                // then we check diagonals
                (this.counter[0][0].equals(this.counter[1][1]) && this.counter[1][1].equals(this.counter[2][2]) && !this.counter[0][0].equals(" ")) ||
                (this.counter[0][2].equals(this.counter[1][1]) && this.counter[1][1].equals(this.counter[2][0]) && !this.counter[0][2].equals(" "))) {
            return true;
        }
        // Check for a tie
        else if (!String.join(" ", this.counter[0]).contains(" ")) {
            return true;
        }
        // Game is not over
        else {
            return false;
        }
    }

    public void instantiateCounter() {
        int ii = 0;
        int jj = 0;

        while (ii < 3) {
            this.counter[ii][jj] = " ";
            jj++;
            if (jj == 3) {
                jj = 0;
                ii++;
            }
        }
    }
}
