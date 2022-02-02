import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int MAX_VALUE = 21;

    public static void main(String[] args) {
        boolean wantToContinue = false;
        int playerValue = 0;
        int computerValue = 0;
        do {
            playerValue = askForACard(playerValue);
            computerValue = askForACard(computerValue);
            showValuePlayer(playerValue);
            wantToContinue = wantContinue(wantToContinue);
        }
        while (wantToContinue);
        compareValue(playerValue, computerValue);

    }

    private static void showValuePlayer(int playerValue) {
        System.out.println("The value of letter for the player is " + playerValue);
    }

    private static void compareValue(int playerValue, int computerValue) {

        if (playerValue > MAX_VALUE && computerValue > MAX_VALUE) {
            messageOfATie(playerValue, computerValue);
        } else if (playerValue > MAX_VALUE) {
            messageOfGameOver(playerValue);
        } else if (computerValue > MAX_VALUE) {
            messageOfWin(playerValue, computerValue);
        } else if (playerValue == MAX_VALUE && computerValue == MAX_VALUE) {
            messageOfATie(playerValue, computerValue);
        } else if (computerValue == MAX_VALUE) {
            messageOfBlackJackLose(computerValue);
        } else if (playerValue < computerValue) {
            messageOfGameOver(playerValue, computerValue);
        } else if (playerValue > computerValue) {
            messageOfWin(playerValue, computerValue);
        } else if (playerValue == computerValue) {
            messageOfATie(playerValue, computerValue);
        }

    }

    private static void messageOfATie(int playerValue, int computerValue) {
        System.out.println("The value of player is " + playerValue + " and the value of the computer is " + computerValue + " so is a tie");
    }

    private static void messageOfBlackJackLose(int computerValue) {
        System.out.println("The computer has a blackjack " + computerValue + " and the player lose");
    }


    private static void messageOfWin(int playerValue, int computerValue) {
        System.out.println("You Win player with " + playerValue + " and computer " + computerValue);
    }

    private static void messageOfBlackJack(int valuePlayer) {
        System.out.println("Your number is " + valuePlayer + " so you have a blackjack ¡Congratulations!");
    }

    private static void messageOfGameOver(int valuePlayer) {
        System.out.println("Your value in blackjack is more than 21 and yours is " + valuePlayer + " so you lose");
    }

    private static void messageOfGameOver(int valuePlayer, int computerValue) {
        System.out.println("Your value in blackjack is  " + valuePlayer + "and the computer is " + computerValue + " so you lose");
    }


    private static int askForACard(int valuePlayer) {
        int valueAdding = AddValue();
        valuePlayer += valueAdding;
        return valuePlayer;
    }

    private static int AddValue() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    private static boolean wantContinue(boolean wantToContinue) {
        return confirmation(wantToContinue);
    }

    private static boolean confirmation(boolean wantToContinue) {
        System.out.println("Do you want to continue?");
        Scanner scan = new Scanner(System.in);
        String confirm = scan.nextLine();

        return confirm.equalsIgnoreCase("S");
    }
}
