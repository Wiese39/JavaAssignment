//Author : Jeremy Wiese (1007024)

import java.util.Random;
import java.util.Scanner;

public class Gokje {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            clearScreen();
            System.out.println("Welcome to Number Guesser!");
            System.out.println("Choose an option:");
            System.out.println("1. Play Number Guesser");
            System.out.println("2. Play Number Guesser (Bot)");
            System.out.println("3. Exit");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    playNumberGuesser(input);
                    break;
                case 2:
                    playNumberGuesserBot(input);
                    break;
                case 3:
                    System.out.println("Thanks for playing Number Guesser!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    public static void playNumberGuesser(Scanner input) {
        clearScreen();
        System.out.println("Number Guesser");
        System.out.print("Enter the maximum range of numbers to guess: ");
        int maxRange = input.nextInt();

        int numberToGuess = new Random().nextInt(maxRange) + 1;
        int maxAttempts = calculateMaxAttempts(maxRange);

        System.out.println("Guess a number between 1 and " + maxRange + ".");
        System.out.println("You have " + maxAttempts + " attempts.\n");

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Enter your guess(Attempt #" + attempts + "): ");
            int guess = input.nextInt();

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else {
                printHint(numberToGuess, guess);
                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you ran out of attempts. The number was " + numberToGuess + ".");
                }
            }
        }

        System.out.print("Do you want to play again? (y/n): ");
        String playAgain = input.next();

        if (playAgain.equalsIgnoreCase("y")) {
            playNumberGuesser(input);
        } else {
            System.out.print("Do you want to return to the main menu? (y/n): ");
            String returnToMenu = input.next();

            if (returnToMenu.equalsIgnoreCase("y")) {
                return;
            } else {
                System.out.println("Thanks for playing Number Guesser!");
                System.exit(0);
            }
        }
    }

    public static void playNumberGuesserBot(Scanner input) {
        clearScreen();
        System.out.println("Number Guesser (Bot)");
        System.out.print("Enter the maximum range of numbers to guess: ");
        int maxRange = input.nextInt();

        int numberToGuess = new Random().nextInt(maxRange) + 1;
        int maxAttempts = calculateMaxAttempts(maxRange);

        System.out.println("The bot will guess a number between 1 and " + maxRange + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.\n");

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Enter your guess(#"+ attempts +"): ");
            int guess = input.nextInt();

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.\n");
                break;
            } else {
                printHint(numberToGuess, guess);
                if (attempts == maxAttempts) {
                    System.out.println                ("Sorry, you ran out of attempts. The number was " + numberToGuess + ".\n");
                }
            }
    
            int botGuess = new Random().nextInt(maxRange) + 1;
            System.out.println("The bot guesses: " + botGuess);
            if (botGuess == numberToGuess) {
                System.out.println("The bot guessed the number in " + attempts + " attempts.");
                break;
            }
        }
    
        System.out.print("Do you want to play again? (y/n): ");
        String playAgain = input.next();
    
        if (playAgain.equalsIgnoreCase("y")) {
            playNumberGuesserBot(input);
        } else {
            System.out.print("Do you want to return to the main menu? (y/n): ");
            String returnToMenu = input.next();
    
            if (returnToMenu.equalsIgnoreCase("y")) {
                return;
            } else {
                System.out.println("Thanks for playing Number Guesser!");
                System.exit(0);
            }
        }
    }
    
    public static void printHint(int numberToGuess, int guess) {
        if (guess < numberToGuess) {
            System.out.println("The number is higher than your guess.");
        } else {
            System.out.println("The number is lower than your guess.");
        }
    }
    
    public static int calculateMaxAttempts(int maxRange) {
        if (maxRange <= 10) {
            return 3;
        } else if (maxRange <= 50) {
            return 5;
        } else if (maxRange <= 100) {
            return 7;
        } else {
            return 10;
        }
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}    
