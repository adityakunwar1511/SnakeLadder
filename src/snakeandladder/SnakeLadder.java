package snakeandladder;

import java.util.Random;
import java.util.Scanner;

public class SnakeLadder {
    private static final int BOARD_SIZE = 100;
    private static final int NUM_PLAYERS = 2;

    public static void main(String[] args) {
        int[] playerPositions = new int[NUM_PLAYERS];
        boolean gameOver = false;
        int currentPlayer = 0;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Player " + (currentPlayer + 1) + "'s turn.");
            System.out.println("Press Enter to roll the dice.");
            scanner.nextLine();
            int roll = random.nextInt(6) + 1;
            System.out.println("You rolled a " + roll + ".");

            playerPositions[currentPlayer] += roll;
            if (playerPositions[currentPlayer] > BOARD_SIZE) {
                playerPositions[currentPlayer] -= roll;
                System.out.println("You cannot move that far. Try again.");
            } else {
                int event = random.nextInt(10);
                if (event < 3) {
                	playerPositions[currentPlayer]-= roll;
                	if(playerPositions[currentPlayer]<0)playerPositions[currentPlayer]=0;
                	
                    System.out.println("Oh no! You landed on a snake. Moving down to " + playerPositions[currentPlayer] + ".");
                    
                } else if (event < 6) {
                	playerPositions[currentPlayer]+=roll;
                	if(playerPositions[currentPlayer] >BOARD_SIZE)playerPositions[currentPlayer] = BOARD_SIZE;
                    System.out.println("Yay! You landed on a ladder. Moving up to " + playerPositions[currentPlayer] + ".");
                   
                } else {
                    System.out.println("You landed on a neutral space. No change.");
                }
                printBoard(playerPositions);
                if (playerPositions[currentPlayer] >= BOARD_SIZE) {
                    System.out.println("Player " + (currentPlayer + 1) + " wins!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer + 1) % NUM_PLAYERS;
                }
            }
        }
    }

    private static void printBoard(int[] playerPositions) {
        for (int i = 1; i <= BOARD_SIZE; i++) {
            if (i == playerPositions[0]) {
                System.out.print("P1 ");
            } else if (i == playerPositions[1]) {
                System.out.print("P2 ");
            } else {
                System.out.print(i + " ");
            }
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}