package org.example;

public class Board {

    public int[][] layout;
    final private String[] colors   = {
            "  \u001B[47m   \u001B[0m",  // white  = empty
            "  \u001B[44m   \u001B[0m",  // blue   = player 1
            "  \u001B[43m   \u001B[0m",  // yellow = player 2
            "  \u001B[41m   \u001B[0m"   // red    = winning coins
    };

    private int currentPlayerId;

    public int getCurrentPlayerId(){
        return currentPlayerId;
    }

    public void setCurrentPlayerId(int id){
        this.currentPlayerId = id;
    }

    public void switchCurrentPlayerId(){
        setCurrentPlayerId((this.currentPlayerId == 1) ? 0 : 1);
    }

    public Board(){
        this.layout = new int[6][7];
        this.currentPlayerId = 1;
    }

    public void displayBoard(){
        System.out.println("\n\t\t   1    2    3    4    5    6    7");
        for (int[] row : this.layout) {
            System.out.print("\t\t");
            for (int j = 0; j < this.layout[0].length; j++) {
                System.out.print(this.colors[row[j]]);
            }
            System.out.println();
            System.out.println();
        }
    }

    public boolean isFull(){
        boolean containsEmptyFields = false;
        // vertikal |
        for (int i = 0; i < this.layout.length; i++) {
            for (int j = 0; j < this.layout[0].length; j++) {
                if(this.layout[i][j] < 1){
                    containsEmptyFields = true;
                };
            }
        }
        return !containsEmptyFields;
    }

    public boolean insertCoin(int currentPlayer, int idxColumn) {
        for (int i = 5; i >= 0; i--) {
            if (layout[i][idxColumn] == 0) {
                layout[i][idxColumn] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public boolean checkIfWinner(int currentValue) {

        // vertikal |
        for (int i = 0; i < layout.length-3; i++) {
            for (int j = 0; j < layout[0].length; j++) {
                if (layout[i][j] == currentValue &&
                        layout[i+1][j] == currentValue &&
                        layout[i+2][j] == currentValue &&
                        layout[i+3][j] == currentValue){
                    layout[i  ][j] = 3;
                    layout[i+1][j] = 3;
                    layout[i+2][j] = 3;
                    layout[i+3][j] = 3;
                    displayBoard();
                    return true;
                }
            }
        }
        // horizontal -
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[0].length-3; j++) {
                if (layout[i][j] == currentValue &&
                        layout[i][j+1] == currentValue &&
                        layout[i][j+2] == currentValue &&
                        layout[i][j+3] == currentValue){
                    layout[i][j  ] = 3;
                    layout[i][j+1] = 3;
                    layout[i][j+2] = 3;
                    layout[i][j+3] = 3;
                    displayBoard();
                    return true;
                };
            }
        }
        // diagonal \
        for (int i = 0; i < layout.length-3; i++) {
            for (int j = 0; j < layout[0].length - 3; j++) {
                if (layout[i][j] == currentValue &&
                        layout[i+1][j+1] == currentValue &&
                        layout[i+2][j+2] == currentValue &&
                        layout[i+3][j+3] == currentValue){
                    layout[i  ][j  ] = 3;
                    layout[i+1][j+1] = 3;
                    layout[i+2][j+2] = 3;
                    layout[i+3][j+3] = 3;
                    displayBoard();
                    return true;
                };
            }
        }
        // diagonal /
        for (int i = 0; i < layout.length-3; i++) {
            for (int j = 3; j < layout[0].length; j++) {
                if (layout[i][j] == currentValue &&
                        layout[i+1][j-1] == currentValue &&
                        layout[i+2][j-2] == currentValue &&
                        layout[i+3][j-3] == currentValue){
                    layout[i  ][j  ] = 3;
                    layout[i+1][j-1] = 3;
                    layout[i+2][j-2] = 3;
                    layout[i+3][j-3] = 3;
                    displayBoard();
                    return true;
                };
            }
        }
        return false;
    }

}