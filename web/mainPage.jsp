<%-- 
    Document   : mainPage
    Created on : Aug 2, 2017, 12:11:59 PM
    Author     : sandrakrcmar

    The user's main page that prints a welcome message with the user's id
    and the user's profile (ID and email). User must be authenticated or else
    routes to index.html. Also links to logout.jsp.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />

    </head>
    <body>
        <div id="main">
            <div id="header">
                <div id="logo">
                    <div id="logo_text">
                        <h1><a href="index.html">ejd_<span class="logo_colour">home</span></a></h1>

                    </div>
                </div>
                <div id="menubar">
                    <ul id="menu">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="Register.do">Sign Up</a></li>
                        <li><a href="#">A Page</a></li>
                        <li><a href="#">Another Page</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>

            </div>
            <div id="content_header"></div>
            <div id="site_content">

                <IMG src="Images/cloud.png" alt="TechLogo" 
                     width="870" height="180" border="0" align="center"></a>

                <div id="content">
                    <!-- page content here -->
                    <%
                        // Disable browser caching
                        response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
                        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
                        response.setDateHeader("Expires", 0); //prevents caching at the proxy server

                        if (session.getAttribute("user") == null) {
                            response.sendRedirect("index.html");
                        }

                    %>

                    <h3>Hello ${sessionScope.user.id}, 
                        <br>
                        You logged in successfully.
                    </h3>
                    <br>
                    <h3>Your Profile:</h3>
                    <p>User ID: ${sessionScope.user.id}</p>
                    <p>Email: ${sessionScope.user.email}</p>

                    <br>
                    <a href="logout.jsp">Log out</a>
                </div>
            </div>
            <div id="content_footer"></div>
            <div id="footer">
                <p><a href="index.html">Home</a> | <a href="Register.do">Sign Up</a> | <a href="#">A Page</a> | <a href="#">Another Page</a> | <a href="#">Contact Us</a></p>
                <p>Copyright &copy; edj_home 
            </div>
        </div>
    </body>

</html>