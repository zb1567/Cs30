package SkillBuilders;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class StatsP2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File dataFile = new File("../Chapter11/text1.txt");
        String stuName, score;
        int numStudents;
        int numScores = 0;
        double scoreValue;
        double lowScore = 0;
        double highScore = 0;
        double totalScore = 0;
        double avgScore;
        FileWriter out;
        BufferedWriter writeFile;
        FileReader in;
        BufferedReader readFile;
        System.out.print("Enter the number of students: ");
        numStudents = input.nextInt();
        input.nextLine();
        try {
            out = new FileWriter(dataFile);
            writeFile = new BufferedWriter(out);
            for (int i = 0; i < numStudents; i++) {
                System.out.print("Enter student name: ");
                stuName = input.nextLine();
                System.out.print("Enter student score: ");
                scoreValue = input.nextDouble();
                input.nextLine();
                writeFile.write(stuName);
                writeFile.newLine();
                writeFile.write(Double.toString(scoreValue));
                writeFile.newLine();
            }
            writeFile.close();
            out.close();
            in = new FileReader(dataFile);
            readFile = new BufferedReader(in);
            while ((stuName = readFile.readLine()) != null) {
                score = readFile.readLine();
                System.out.println(stuName + " " + score);
                scoreValue = Double.parseDouble(score);
                numScores += 1;
                totalScore += scoreValue;
                if (numScores == 1) {
                    lowScore = scoreValue;
                    highScore = scoreValue;
                }
                if (scoreValue < lowScore) {
                    lowScore = scoreValue;
                }
                if (scoreValue > highScore) {
                    highScore = scoreValue;
                }
            }
            readFile.close();
            in.close();
            if (numScores > 0) {
                avgScore = totalScore / numScores;
                System.out.println("Lowest score: " + lowScore);
                System.out.println("Highest score: " + highScore);
                System.out.println("Average score: " + avgScore);
            } else {
                System.out.println("No scores entered.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found or opened.");
        } catch (IOException e) {
            System.out.println("Problem reading or writing file.");
            System.out.println(e.getMessage());
        }
        input.close();
    }
}