package Mastery;


/*
 * Program: Searches.java
 * Last Date of this Revision: November 24, 2026
 * Purpose: Searches sorted integer arrays.
 * Author: Zubair Bechir
 * School: Crescent Heights Highschool
 * Course: Computer Programming 30
 */

/**
 * Provides recursive search methods for sorted arrays.
 */
public class Searches
{
    /**
     * Searches an array by dividing the range into two parts.
     * @param items sorted array
     * @param start first index
     * @param end last index
     * @param goal number to find
     * @return index of the goal or -1 if not found
     */
    public static int binarySearch(int[] items, int start, int end, int goal)
    {
        if (start > end)
        {
            return -1;
        }
        int middle = start + (end - start) / 2;
        if (goal == items[middle])
        {
            return middle;
        }
        else if (goal < items[middle])
        {
            return binarySearch(items, start, middle - 1, goal);
        }
        else
        {
            return binarySearch(items, middle + 1, end, goal);
        }
    }

    /**
     * Searches an array by dividing the range into three parts.
     * @param items sorted array
     * @param start first index
     * @param end last index
     * @param goal number to find
     * @return index of the goal or -1 if not found
     */
    public static int ternarySearch(int[] items, int start, int end, int goal)
    {
        if (start > end)
        {
            return -1;
        }
        int third = (end - start) / NUM_PARTS;
        int mid1 = start + third;
        int mid2 = end - third;
        if (goal == items[mid1])
        {
            return mid1;
        }
        else if (goal == items[mid2])
        {
            return mid2;
        }
        else if (goal < items[mid1])
        {
            return ternarySearch(items, start, mid1 - 1, goal);
        }
        else if (goal > items[mid2])
        {
            return ternarySearch(items, mid2 + 1, end, goal);
        }
        else
        {
            return ternarySearch(items, mid1 + 1, mid2 - 1, goal);
        }
    }

    private static final int NUM_PARTS = 3;
}
