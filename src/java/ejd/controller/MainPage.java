/*
 * Assignment 4
 * By: Sandra Krcmar
 *
 * The MainPage servlet is called upon from the login servlet. It serves to
 * generate the user's main page and must check if the user is authenticated. 
 * If a user tries to access the mainPage.jsp without authentication they will
 * be re-routed back to index.html as browsing caching has been disabled.
 */
package ejd.controller;

import ejd.model.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sandrakrcmar
 */
public class MainPage extends HttpServlet {

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

        // Retrieve Session
        HttpSession session = request.getSession(true);

        // Retrieve session attribute (user) and assign to variable
        User activeUser = (User) session.getAttribute("user");

        // if active user exists 
        if (activeUser != null) {

            // Disable browser caching
            response.setHeader("Cache-Control", "private no-cache, no-store, "
                    + "must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setHeader("Expires", "0"); // Proxies.
            RequestDispatcher rd = request.getRequestDispatcher("mainPage.jsp");
            rd.forward(request, response);

        } else {

            // redirect to index.html
            response.sendRedirect("index.html");

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
