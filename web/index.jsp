<!DOCTYPE html>
<!--
    Document   : index
    Created on : Aug 2, 2017, 12:11:30 PM
    Author     : sandrakrcmar

    This page is a the home page and has a login form (user id & password)
    The login button requests the login servlet. It also has a link to register.
-->
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8"/>
        <link rel="stylesheet" type="text/css" href="Style/style.css" />
    </head>
    <div id="main">
            <div id="header">
                <div id="logo">
                    <div id="logo_text">
                        <h1><a href="index.html">ejd_<span class="logo_colour">home</span></a></h1>

                    </div>
                </div>
                <div id="menubar">
                    <ul id="menu">
                        <li class="selected"><a href="index.html">Home</a></li>
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
                     width="870" height="180" border="0" align="center">
                <div id="sidebar_container">
                    <div class="sidebar">
                        <div class="sidebar_top"></div>
                        <div class="sidebar_item">
                            <!-- Log in -->
                            <h3>Log In</h3>
                            
                            
                            <form action="Login.do" method="post">
                                User ID: <input type="text" name="id"> 
                                <br>
                                Password:<input type="password" name="pass">
                                <br>
                                <input type="submit" value="Login">
                            </form>
                        </div>
                        <div class="sidebar_base"></div>
                    </div>
                    <div class="sidebar">
                        <div class="sidebar_top"></div>
                        <div class="sidebar_item">
                            <h3>Newsletter</h3>
                            <form method="post" action="#" id="search_form">
                                <p>
                                    <input class="search" type="text" name="search_field" value="enter email address" />
                                    <input name="search" type="submit"  />
                                </p>
                            </form>
                        </div>
                        <div class="sidebar_base"></div>
                    </div>
                </div>
                <div id="content">
                    <!-- page content here -->
                    <h1>Welcome to EJD - Please Log In!</h1>
                    
                    
                    
                    <p>
                        If you have not already registered please do so here 
                        <a href="Register.do">
                            Sign Up 
                    </p>
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

