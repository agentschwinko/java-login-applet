/*
 * Assignment 4
 * By: Sandra Krcmar
 *
 * The Login servlet is called upon from the index.html & login.jsp and checks
 * if the user id and password are valid - if invalid the servlet re-routes back 
 * to login.jsp with an error. This servlet also interacts with the UserDatabase 
 * model and routes to the MainPage servlet upon user validity.
 */
package ejd.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ejd.model.User;
import ejd.model.UserDatabase;

/**
 *
 * @author sandrakrcmar
 */
public class Login extends HttpServlet {

    /**
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve variables
        String userId = request.getParameter("id");
        String password = request.getParameter("pass");
        
        // Create a new instance of UserDatabase
        UserDatabase db = new UserDatabase();
        // if user id and password are valid
        if (db.isValid(userId, password)) {

            // Create session
            HttpSession session = request.getSession(true);
            // Session timeout after 10 mins.
            session.setMaxInactiveInterval(10 * 60); // 10 minutes
            // User object to store user from database
            User user = db.getUser(userId);
            // Store user as session attribute
            session.setAttribute("user", user);

            // redirect to MainPage
            response.sendRedirect("MainPage.do");

        } else {

            // Set error message
            String loginMessage = "Invalid User ID or password";
            // Store loginMessage as request attribute
            request.setAttribute("loginMessage", loginMessage);
            // RequestDispatcher forward to login.jsp
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}

