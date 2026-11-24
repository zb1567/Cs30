
package Mastery;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Program: Friends.java
 * Last Date of this Revision: November 24, 2026
 * Purpose: Creates and manages a database of friends.
 * Author: Your Name
 * School: Your School
 * Course: Computer Programming 30
 */

/**
 * Manages and saves friend records.
 */
public class Friends
{
    /**
     * Creates the database and scanner.
     */
    public Friends()
    {
        friends = new ArrayList<Friend>();
        input = new Scanner(System.in);
    }

    /**
     * Runs the friends database.
     */
    public void run()
    {
        try
        {
            loadFriends();
            String choice = "";

            while (!choice.equals(QUIT))
            {
                displayMenu();
                choice = input.nextLine().trim();
                processChoice(choice);
            }

            System.out.println("Goodbye!");
        }
        catch (IOException e)
        {
            System.out.println("File error: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Unable to read friend records.");
        }
        finally
        {
            input.close();
        }
    }

    public static void main(String[] args)
    {
        Friends database = new Friends();
        database.run();
    }

    /**
     * Displays the menu options.
     */
    private void displayMenu()
    {
        System.out.println("\nFRIENDS DATABASE");
        System.out.println(ADD + ". Add a friend");
        System.out.println(BY_LAST + ". Display by last name");
        System.out.println(BY_FIRST + ". Display by first name");
        System.out.println(FIND + ". Find a friend");
        System.out.println(DELETE + ". Delete a friend");
        System.out.println(QUIT + ". Quit");
        System.out.print("Enter choice: ");
    }

    /**
     * Processes the selected menu option.
     * @param choice selected option
     * @throws IOException if saving fails
     */
    private void processChoice(String choice) throws IOException
    {
        if (choice.equals(ADD))
        {
            addFriend();
        }
        else if (choice.equals(BY_LAST))
        {
            displayFriends(false);
        }
        else if (choice.equals(BY_FIRST))
        {
            displayFriends(true);
        }
        else if (choice.equals(FIND))
        {
            findFriend();
        }
        else if (choice.equals(DELETE))
        {
            deleteFriend();
        }
        else if (!choice.equals(QUIT))
        {
            System.out.println("Invalid choice.");
        }
    }

    /**
     * Reads text from the keyboard.
     * @param prompt message displayed
     * @return entered text
     */
    private String readText(String prompt)
    {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    /**
     * Adds a friend to the database.
     * @throws IOException if saving fails
     */
    private void addFriend() throws IOException
    {
        String first = readText("First name: ");
        String last = readText("Last name: ");

        if (findIndex(first, last) != -1)
        {
            System.out.println("Friend already exists.");
            return;
        }

        String phone = readText("Phone number: ");
        String email = readText("Email address: ");

        friends.add(new Friend(first, last, phone, email));
        saveFriends();
        System.out.println("Friend added.");
    }

    /**
     * Displays friends in alphabetical order.
     * @param byFirstName determines sorting order
     */
    private void displayFriends(boolean byFirstName)
    {
        if (friends.isEmpty())
        {
            System.out.println("No friends in the database.");
        }
        else
        {
            sortFriends(byFirstName);

            for (Friend friend : friends)
            {
                System.out.println(friend);
            }
        }
    }

    /**
     * Sorts friends using selection sort.
     * @param byFirstName determines sorting order
     */
    private void sortFriends(boolean byFirstName)
    {
        for (int i = 0; i < friends.size() - 1; i++)
        {
            int smallest = i;

            for (int j = i + 1; j < friends.size(); j++)
            {
                if (compareNames(friends.get(j),
                    friends.get(smallest), byFirstName) < 0)
                {
                    smallest = j;
                }
            }

            Collections.swap(friends, i, smallest);
        }
    }

    /**
     * Compares two friend names.
     * @param first first friend
     * @param second second friend
     * @param byFirstName determines sorting order
     * @return comparison result
     */
    private int compareNames(Friend first, Friend second,
                             boolean byFirstName)
    {
        int result;

        if (byFirstName)
        {
            result = first.getFirstName().compareToIgnoreCase(
                second.getFirstName());

            if (result == 0)
            {
                result = first.getLastName().compareToIgnoreCase(
                    second.getLastName());
            }
        }
        else
        {
            result = first.getLastName().compareToIgnoreCase(
                second.getLastName());

            if (result == 0)
            {
                result = first.getFirstName().compareToIgnoreCase(
                    second.getFirstName());
            }
        }

        return result;
    }

    /**
     * Finds the index of a friend.
     * @param first first name
     * @param last last name
     * @return friend index or -1 if not found
     */
    private int findIndex(String first, String last)
    {
        for (int i = 0; i < friends.size(); i++)
        {
            Friend friend = friends.get(i);

            if (friend.getFirstName().equalsIgnoreCase(first)
                && friend.getLastName().equalsIgnoreCase(last))
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * Searches for a friend.
     */
    private void findFriend()
    {
        String first = readText("First name: ");
        String last = readText("Last name: ");
        int index = findIndex(first, last);

        if (index == -1)
        {
            System.out.println("Friend not found.");
        }
        else
        {
            System.out.println(friends.get(index));
        }
    }

    /**
     * Deletes a friend from the database.
     * @throws IOException if saving fails
     */
    private void deleteFriend() throws IOException
    {
        String first = readText("First name: ");
        String last = readText("Last name: ");
        int index = findIndex(first, last);

        if (index == -1)
        {
            System.out.println("Friend not found.");
        }
        else
        {
            friends.remove(index);
            saveFriends();
            System.out.println("Friend deleted.");
        }
    }

    /**
     * Loads saved friend records.
     * @throws IOException if reading fails
     * @throws ClassNotFoundException if records are invalid
     */
    private void loadFriends()
        throws IOException, ClassNotFoundException
    {
        File file = new File(FILE_NAME);

        if (file.exists())
        {
            try (ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream(file)))
            {
                int count = stream.readInt();

                for (int i = 0; i < count; i++)
                {
                    friends.add((Friend) stream.readObject());
                }
            }
        }

        System.out.println("Loaded " + friends.size() + " friend(s).");
    }

    /**
     * Saves friend records to a file.
     * @throws IOException if saving fails
     */
    private void saveFriends() throws IOException
    {
        try (ObjectOutputStream stream = new ObjectOutputStream(
            new FileOutputStream(FILE_NAME)))
        {
            stream.writeInt(friends.size());

            for (Friend friend : friends)
            {
                stream.writeObject(friend);
            }
        }
    }

    private ArrayList<Friend> friends;
    private Scanner input;

    private static final String FILE_NAME = "friends.dat";
    private static final String ADD = "1";
    private static final String BY_LAST = "2";
    private static final String BY_FIRST = "3";
    private static final String FIND = "4";
    private static final String DELETE = "5";
    private static final String QUIT = "6";
}
