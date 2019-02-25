<%-- 
    Document   : register
    Created on : Aug 2, 2017, 12:11:30 PM
    Author     : sandrakrcmar

    This page is a sign-up form with 2 text inputs and 1 password input. 
    Sign-up button will trigger the Register servlet. If any inputs are invalid
    forwarded to this .jsp with an error message.
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
                        <li class="selected"><a href="Register.do">Sign Up</a></li>
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
                    <h2>Registration Form</h2>

                    <p> Please fill out the form below...</p>

                    <c:if test="${not empty errorMessage}">    
                        <p style="color:red;"> ${requestScope.registerMessage} </p>        
                    </c:if>

                    <form action="Register.do" method="post">
                        Choose user ID: <input type="text" name="userId">
                        <br>
                        Choose your password: <input type="password" name="password">
                        <br>
                        Enter your email address: <input type="text" name="email">
                        <br>
                        <input type="submit" value="Signup">
                    </form>

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
 