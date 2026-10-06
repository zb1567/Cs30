package Mastery;
import java.io.*;
import java.util.*;

public class WordGuess {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter the word file name: ");
			String fileName = input.nextLine();

			try {
			    int count = 0;

			    try (BufferedReader reader =
			            new BufferedReader(new FileReader(fileName))) {
			        String line;

			        while ((line = reader.readLine()) != null) {
			            if (!line.trim().isEmpty()) {
			                count++;
			            }
			        }
			    }

			    if (count == 0) {
			        System.out.println("The word file is empty.");
			        return;
			    }

			    int chosen = new Random().nextInt(count);
			    String secretWord = "";

			    try (BufferedReader reader =
			            new BufferedReader(new FileReader(fileName))) {
			        String line;
			        int index = 0;

			        while ((line = reader.readLine()) != null) {
			            if (!line.trim().isEmpty()) {
			                if (index == chosen) {
			                    secretWord = line.trim().toUpperCase(Locale.ROOT);
			                    break;
			                }
			                index++;
			            }
			        }
			    }

			    if (!secretWord.matches("[A-Z]+")) {
			        System.out.println(
			            "Each entry must be one word containing only letters."
			        );
			        return;
			    }

			    String wordSoFar = "";

			    for (int i = 0; i < secretWord.length(); i++) {
			        wordSoFar += "-";
			    }

			    int numGuesses = 0;
			    boolean won = false;

			    System.out.println("WordGuess game");

			    while (!won) {
			        System.out.println(wordSoFar);
			        System.out.print(
			            "Enter a letter (! to guess the entire word): "
			        );

			        if (!input.hasNextLine()) {
			            return;
			        }

			        String guess =
			            input.nextLine().trim().toUpperCase(Locale.ROOT);

			        if (guess.equals("!")) {
			            System.out.print("What is your word guess? ");

			            if (!input.hasNextLine()) {
			                return;
			            }

			            numGuesses++;
			            won = input.nextLine().trim()
			                       .equalsIgnoreCase(secretWord);
			            break;
			        }

			        if (!guess.matches("[A-Z]")) {
			            System.out.println("Please enter one letter or !.");
			            continue;
			        }

			        numGuesses++;
			        String updatedWord = "";

			        for (int i = 0; i < secretWord.length(); i++) {
			            if (secretWord.charAt(i) == guess.charAt(0)) {
			                updatedWord += guess;
			            } else {
			                updatedWord += wordSoFar.charAt(i);
			            }
			        }

			        wordSoFar = updatedWord;
			        won = wordSoFar.equals(secretWord);
			    }

			    if (won) {
			        System.out.println("You won!");
			    } else {
			        System.out.println("Sorry. You lose.");
			    }

			    System.out.println("The secret word is " + secretWord);
			    System.out.println("You made " + numGuesses + " guesses.");

			} catch (FileNotFoundException e) {
			    System.out.println(
			        "File not found. Check the file name and path."
			    );
			} catch (IOException e) {
			    System.out.println("Unable to read the file: " + e.getMessage());
			} catch (SecurityException e) {
			    System.out.println(
			        "You do not have permission to read this file."
			    );
			}
		}
    }
}