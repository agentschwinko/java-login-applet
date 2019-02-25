/*
 * Assignment 4
 * By: Sandra Krcmar
 *
 * The Register servlet is called upon from index.html & login.jsp "sign-up" 
 * button where it serves to re-route to the register.jsp - alongside the 
 * register.jsp where it serves as a sign-up; users register their username, 
 * password (encrypted) and email which then interacts with an UserDatabase model. 
 * Upon successful registration this servlet routes to the registerResult.jsp
 */
package ejd.controller;

import ejd.model.UserDatabase;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author sandrakrcmar
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve variables
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        // if user id, password and email are null
        if (userId == null && password == null && email == null) {
        
            // forward to jsp
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
            return;        
        }

        // Create a new instance of UserDatabase
        UserDatabase db = new UserDatabase();
        
        // Error message variables
        String infoMessage = "";
        String registerMessage = "";
        
        // If user id is left blank
        if (userId.equals("")) {            
            // Assign error message
            registerMessage = "You must enter a User ID";
            // Store message as request attribute
            request.setAttribute("registerMessage", registerMessage);
            // RequestDispatcher to forward back to register.jsp
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);            
            }
        
        // If password is left blank
        else if (password.equals("")) {
            // Assign error message
            registerMessage = "You must enter a password";
            // Store message as request attribute
            request.setAttribute("registerMessage", registerMessage);
            // RequestDispatcher to forward back to register.jsp
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);            
            }
           
           // If email is left blank
           else if (email.equals("")) {
            // Assign error message
            registerMessage = "You must enter an email";
            // Store message as request attribute
            request.setAttribute("registerMessage", registerMessage);
            // RequestDispatcher to forward back to register.jsp
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);        
            }
           
           // if user id is unique, not null and not empty
           else if (db.isUnique(userId) && userId != null && !(userId.equals(""))) {
            
            // Create a hashed password    
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
           
           // a flag to measure success of adding to database 
           int flag = db.addUser(userId, hashedPassword, email);
           
           if (flag >= 0) {      
               infoMessage = "Signed up successfully. Thank you for sign up!";              
           }else {       
               infoMessage = "There was an error in processesing your sign up. "
                       + "Please try again...";        
           }
           // Store message as request attribute
           request.setAttribute("infoMessage", infoMessage);
           // RequestDispatcher forward to registerResult.jsp
           RequestDispatcher rd = request.getRequestDispatcher("registerResult.jsp");
           rd.forward(request, response);
        } else {
            // Set error message if user ID already exists        
            registerMessage = "User ID: " + userId + " already exists. Choose a "
                    + "different ID";
            // Store error as request attribute
            request.setAttribute("registerMessage", registerMessage);
            // RequestDispatcher forward to register.jsp
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);            
        }        
    }


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}
