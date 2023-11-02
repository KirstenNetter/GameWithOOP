package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    final private String colorName;
    final private int value;
    private String playerName;

    public Player(String colorName, int value){
        this.colorName = colorName;
        this.value = value;
    }


    public String getColorName(){
        return colorName;
    }

    public int getValue(){
        return value;
    }

    public String getPlayerName(){
        return this.playerName;
    }


    public void setPlayerName(String name){
        this.playerName = name;
    }


    public void namePlayer(Scanner sc){
        System.out.printf(" %nSpieler %s, deine Farbe ist %s.", this.value, this.colorName);
        System.out.println(" Gib deinen Namen ein: ");
        this.setPlayerName(sc.nextLine());
    }

    public int chooseColumn(Scanner sc){

        int chosenColumn;
        while (true) {
            System.out.print(this.playerName + " ist dran. Wähle eine Spalte 1-7: ");
            try {
                chosenColumn = sc.nextInt();
                if (chosenColumn >= 1 && chosenColumn <= 7) {
                    break;
                } else {
                    System.out.println("Ungültige Eingabe. Wähle eine Spalte 1-7: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Wähle eine Spalte 1-7: ");
                sc.next(); // Leere die Eingabewarteschlange
            }
        }
        return chosenColumn;
    }
}