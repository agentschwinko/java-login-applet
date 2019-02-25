/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sandrakrcmar
 * Created: Aug 2, 2017
 */

-- make sure we are using ejd database
USE ejd;

-- delete tables if already exist
DROP TABLE IF EXISTS ejdUser;

-- create tables
CREATE TABLE ejdUser
(
    id VARCHAR(25) NOT NULL PRIMARY KEY,
    password VARCHAR(128) NOT NULL,
    email VARCHAR(50) NOT NULL
);

-- show tables in ejd
SHOW TABLES;

SELECT * FROM ejdUser;

