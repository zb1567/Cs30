package SkillBuilders;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class StatsP1 {
    public static void main(String[] args) {
    	File dataFile = new File("../Chapter11/text1.txt");
        FileReader in;
        BufferedReader readFile;
        String stuName, score;
        double scoreValue;
        double lowScore = 0;
        double highScore = 0;
        double avgScore;
        double totalScore = 0;
        int numScores = 0;
        try {
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
                System.out.println("No scores found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + dataFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Problem reading file.");
        }
    }
}