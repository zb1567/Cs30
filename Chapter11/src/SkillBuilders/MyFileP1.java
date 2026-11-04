package SkillBuilders;

import java.io.File;
import java.util.Scanner;

public class MyFileP1 {

    public static void main(String[] args)
    {
        File Textfile;
        String fileName;

        try (Scanner input = new Scanner(System.in)) {
            //Obtain file name from user
            System.out.println("Enter file name: ");

            //Store file name in fileName
            fileName = input.next();
        }

        //Determine if file exist or not
        Textfile = new File(fileName);

        if (Textfile.exists())
        {
            System.out.println("File exist.");
        }
        else
        {
            System.out.println("File does NOT exist");
        }
    }
}