package Mastery;


import java.util.Scanner;
import java.util.Arrays;

/*
 * Program: TernarySearch.java
 * Last Date of this Revision: November 24, 2026
 * Purpose: Searches an array using ternary search.
 * Author: Zubair Bechir
 * School: Crescent Heights Highschool
 * Course: Computer Programming 30
 */

/**
 * Tests the recursive ternary search algorithm.
 */
public class TernarySearch
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int[] items = VALUES.clone();

        System.out.println("Sorted array: " + Arrays.toString(items));
        System.out.print("Enter a number to search for: ");

        int goal = input.nextInt();
        int result = Searches.ternarySearch(items, 0, items.length - 1, goal);

        if (result == -1)
        {
            System.out.println("Number not found.");
        }
        else
        {
            System.out.println("Number found at index: " + result);
        }

        input.close();
    }

    private static final int[] VALUES =
        {10, 20, 30, 40, 50, 60, 70, 80, 90};
}
