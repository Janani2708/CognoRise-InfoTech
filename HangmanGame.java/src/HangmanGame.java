import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"program", "students", "java", "cognorise", "act","book","habit","rabbit"};

    private static final String[] HANGMAN_FIGURES = {
            "",
            " O ",
            " O \n | ",
            " O \n/| ",
            " O \n/|\\",
            " O \n/|\\ \n/",
            " O \n/|\\ \n/ \\"
    };

    public static void main(String[] args) {
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];

        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '*';
        }
        List<Character> incorrectGuesses = new ArrayList<>();
        int incorrectGuessCount = 0;

        Scanner scanner = new Scanner(System.in);

        while (incorrectGuessCount < HANGMAN_FIGURES.length - 1) {
            System.out.println(guessedWord);
            System.out.println(HANGMAN_FIGURES[incorrectGuessCount]);
            System.out.println("Incorrect guesses: " + incorrectGuesses);

            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                if (!incorrectGuesses.contains(guess)) {
                    incorrectGuesses.add(guess);
                    incorrectGuessCount++;
                }
            }

            if (String.valueOf(guessedWord).equals(word)) {
                System.out.println("Congratulations! You've guessed the word: " + word);
                break;
            }
        }

        if (incorrectGuessCount == HANGMAN_FIGURES.length - 1) {
            System.out.println(HANGMAN_FIGURES[incorrectGuessCount]);
            System.out.println("Sorry, you've been hanged! The word was: " + word);
        }

        scanner.close();
    }
}
