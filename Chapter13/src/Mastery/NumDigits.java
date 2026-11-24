package Mastery;


import java.util.Scanner;

/*
 * Program: NumDigits.java
 * Last Date of this Revision: November 24, 2026
 * Purpose: Counts the digits in an integer using recursion.
 * Author: Zubair Bechir
 * School: Crescent Heights Highschool
 * Course: Computer Programming 30
 */

/**
 * Counts the number of digits in an integer.
 */
public class NumDigits
{
    /**
     * Counts digits using recursion.
     * @param number integer to examine
     * @return number of digits
     */
    public static int numDigits(int number)
    {
        if (number > -BASE && number < BASE)
        {
            return 1;
        }
        return 1 + numDigits(number / BASE);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        System.out.println("Number of digits: " + numDigits(number));
        input.close();
    }

    private static final int BASE = 10;
}
