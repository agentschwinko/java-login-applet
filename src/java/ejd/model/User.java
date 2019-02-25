/*
    User.java
    Author: Sandra Krcmar
    Date: Aug 2 2017

    Description
    The User javabean class is used to define the user information corresponding
    to the ejdUser table in the database. It contains 3 attributes & stores
    hashed password values.
 
 
 */
package ejd.model;

import java.io.Serializable;

/**
 *
 * @author sandrakrcmar
 */
public class User implements Serializable {
    // Variables
    private String id;
    private String password;
    private String email;
    
    /**
     * Constructs an empty User object
     */
    public User () {
        id="";
        password="";
        email="";
    }

    /**
     * Constructs an empty User object with id, password, and email parameters
     * @param id the id of this user
     * @param password the hashed password of this user
     * @param email the email of this User
     */
    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    /**
     * Retrieves the id of this User
     * @return The User ID
     */
    public String getId() {
        return id;
    }

    /**
     * Places valid ID for this User
     * @param id The ID for this User
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the hashed password of this User
     * @return The User's hashed password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Places a valid hashed password for this User
     * @param password The hashed password for this User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the email of this User
     * @return The User's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Places a valid email for this User
     * @param email the email for this User
     */
    public void setEmail(String email) {
        this.email = email;
    }    
}
