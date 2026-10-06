package Mastery;

import java.io.*;
import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the text file name: ");
        String fileName = input.nextLine();

        int vowels = 0;

        try (BufferedReader reader =
                new BufferedReader(new FileReader(fileName))) {

            int character;

            while ((character = reader.read()) != -1) {
                char letter = Character.toLowerCase((char) character);

                if (letter == 'a' || letter == 'e' || letter == 'i'
                        || letter == 'o' || letter == 'u') {
                    vowels++;
                }
            }

            System.out.println("Number of vowels: " + vowels);

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