
package Mastery;

import java.io.Serializable;

/*
 * Program: Friend.java
 * Last Date of this Revision: November 24, 2026
 * Purpose: Stores friend information.
 * Author: Your Name
 * School: Your School
 * Course: Computer Programming 30
 */

/**
 * Represents a friend in the database.
 */
public class Friend implements Serializable
{
    /**
     * Creates a friend with contact information.
     * @param first first name
     * @param last last name
     * @param phone phone number
     * @param email email address
     */
    public Friend(String first, String last, String phone, String email)
    {
        firstName = first;
        lastName = last;
        phoneNumber = phone;
        emailAddress = email;
    }

    /**
     * Returns the first name.
     * @return first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the last name.
     * @return last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Returns the friend's contact information.
     * @return contact information
     */
    @Override
    public String toString()
    {
        return firstName + " " + lastName + " | "
                + phoneNumber + " | " + emailAddress;
    }

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private static final long serialVersionUID = 1L;
}
