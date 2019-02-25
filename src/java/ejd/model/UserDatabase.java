/*
    UserDatabase.java
    Author: Sandra Krcmar
    Date: Aug 2 2017

    Description
    The UserDatabase class is used to access the ejd database.
    It has 4 core methods; adduser, getUser, isUnqiue & isValid.

    See @ Register.java
    See @ Login.java
 
 
 */
package ejd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author sandrakrcmar
 */
public class UserDatabase {

    // Constants
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ejd";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "PROG32758";

    public int addUser(String userId, String password, String email) {

        // User uniqueness 
        if (isUnique(userId)) {

            // SQL Query with placeholders
            String sql = "INSERT INTO ejdUser (id, password, email) VALUES (?, ?, ?)";

            // SQL Exception Handling
            try {

                Class.forName("com.mysql.jdbc.Driver");

                // Create Connection
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                // Create PreparedStatement
                PreparedStatement ps = connection.prepareStatement(sql);

                // Set
                ps.setString(1, userId);
                ps.setString(2, password);
                ps.setString(3, email);

                // Execute
                ps.executeUpdate();

                // Close resources
                ps.close();
                connection.close();

                // Handle SQL Related Exceptions    
            } catch (SQLException e) {

                e.printStackTrace();

            } catch (Exception e) {

                e.printStackTrace();

            }
            // Successful adding of User
            return 1;
        } else {
            // Failed Adding of User
            return -1;
        }
    }

    public User getUser(String userId) {

        // Validate user        
        if (userId == null || userId.isEmpty()) {
            return null;
        }

        // SQL Query
        String sql = "SELECT * FROM ejdUser WHERE id = ? ";

        // rVariable User object set to null
        User user = null;

        // SQL Exception Handling
        try {

            Class.forName("com.mysql.jdbc.Driver");

            // Create Connection
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            //Create PreparedStatement
            PreparedStatement ps = connection.prepareStatement(sql);

            // Set
            ps.setString(1, userId);

            // Result set
            ResultSet rs = ps.executeQuery();

            // Populate records to User
            if (rs.first()) {

                // Get 3 cols from a row
                String id = rs.getString(1);
                String password = rs.getString(2);
                String email = rs.getString(3);

                // create User JavaBean object with 3 cols
                user = new User(id, password, email);
            }

            // Close resources
            rs.close();
            ps.close();
            connection.close();

            // Handle SQL Related Exceptions 
        } catch (SQLException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
        // Return User object
        return user;

    }

    public boolean isUnique(String userId) {

        // get user
        User user = getUser(userId);

        if (user == null) {

            return true;
        } else {

            return false;

        }
    }

    public boolean isValid(String userId, String password) {

        User user = getUser(userId);

        if (user == null) {

            return false;

        } else {
            // Check encrpted hashed password
            boolean valid = BCrypt.checkpw(password, user.getPassword());

            return valid;

        }

    }

}
