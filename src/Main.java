import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static int lives = 10;

    public static void main(String[] args) throws FileNotFoundException {
        String movie = Asset.txtToString();
        movie = Asset.randomLineFromString(movie);
        char[] usedLetters = new char[0];
        char input;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to the game of hangman!");
        System.out.println("You have 10 lives! After you reach 0 you will lose...");
        System.out.println("Your name of the movie to guess is: " + Asset.stringToBlanks(movie));
        System.out.print("Enter a letter (or 'x' to quit): ");
        while (userInput.hasNextLine()) {
            input = userInput.next().charAt(0);
            if (input == 'x') {
                System.out.println("EXITING THE GAME");
                break;
            } else {
                usedLetters = Asset.usedLettersArray(usedLetters,input);
                String blanks1 = Asset.guessBlanks(movie,usedLetters);
                System.out.println(blanks1);
                System.out.println("Remaining lives" + lives);
                if (blanks1.equals(movie)) {
                    System.out.println("You win!");
                    break;
                } else if (!movie.contains(String.valueOf(input))) {
                    lives--;
                    System.out.println("Wrong guess! Lives remaining: " + lives);
                    if (lives == 0) {
                        System.out.println("YOU RAN OUT OF LIVES");
                        break;
                    }
                }
                System.out.println("Enter a letter (or 'x' to quit): ");
                }
            }
        }
    }
