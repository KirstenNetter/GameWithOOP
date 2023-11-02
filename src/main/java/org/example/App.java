package org.example;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        Player[] players = new Player[2];

        players[0] = new Player( "BLAU", 1);
        players[1] = new Player( "GELB", 2);

        players[0].namePlayer(sc);
        players[1].namePlayer(sc);

        boolean isWinner = false;
        int selectedColumn = 0;

        // display empty board
        board.displayBoard();

        // play
        while(!isWinner){

            if(board.isFull()){
                System.out.println("Unentschieden.");
                break;
            } else {
                board.switchCurrentPlayerId();
                selectedColumn = players[board.getCurrentPlayerId()].chooseColumn(sc);
                board.insertCoin(players[board.getCurrentPlayerId()].getValue(), selectedColumn-1);
                board.displayBoard();
                isWinner = board.checkIfWinner(players[board.getCurrentPlayerId()].getValue());
            }
        }
        if (isWinner) {
            System.out.println(players[board.getCurrentPlayerId()].getPlayerName() + " hat gewonnen.");
        }
        sc.close();
    }
}
