<%-- 
    Document   : logout
    Created on : Aug 2, 2017, 12:12:26 PM
    Author     : sandrakrcmar

    The page displays a goodbye message and has a link to the index.html.
    Also the session is invalidated.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
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
                        // Request session only if it exists - don't create a new one.
                        HttpSession existingSession = request.getSession(false);
                        // Validate existing session
                        if (existingSession != null && existingSession.getAttribute("user") != null) {
                            // Invalidate session
                            session.invalidate();
                        }

                    %>

                    <p>Goodbye, you successfully logged out.</p>

                    <a href="index.html">Go to Home page.</a>

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
