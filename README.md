# ChatEngine
A Java web application built using Apache Tomcat and Eclipse Luna. Oracle Database Plugin for Eclipse Data Tools Platform and Derby
are utilized for creating + connecting to our database.

The simple chat engine allows users access to the chat box by simply typing an username. The user will join the chat then prompt to type 
a message to other user(s) that are in the chat. Manual refreshing of the chat box is required by clicking the Refresh the Chat button. 
All messages are backed up using a database table that takes in username and message. Once chat is done, developer has to manually 
delete the contents of the database. The web application takes you to a 'welcome - enter username' page and a 'chat box' page. 

Oracle Data Tools Platform is an useful Eclipse plugin that provides tools to perform database tasks a lot easier. It provides a visual
of the table-creation process and an editor for editing SQL statements.
Derby is an open-sourced relational database that provides JDBCs for MYSQL. JDBCs (Java database connectivity tools) connects clients to 
the database. For this project, Derby JDBC Embedded Driver was established and this permits one connection to the database at a time. For several 
connections to database, Derby JDBC Client Driver can be used.

The project contains JSPs and servlets which provides the 'view' of the application. JSPs (Java Servlet Pages) contains HTML code for Java
program. Servlets extends the capability of servers and hosts applications based on request/response methology. In other words, they are 
.java files!

The whole project is deployed onto Tomcat server and accessible with the URL: http://localhost:8080/ChatBotApp/ when run.

Disclaimer: This is not a Chat Bot Engine. It was intended to be but it was changed to a regular Chat Engine. :-)


Resources: 
http://www.vogella.com/tutorials/EclipseDataToolsPlatform/article.html
https://docs.oracle.com/cd/E15315_09/help/oracle.eclipse.tools.database.doc/html/gettingStarted/files/gettingStarted.html
http://www.bhaveshthaker.com/33/database-development-using-the-eclipse-ide-mysql-with-eclipse-data-tools-platform-in-java/
StackOverflow

Apache Tomcat 8.0.37
http://tomcat.apache.org/download-80.cgi

Apache Derby 10.12.1.1
http://db.apache.org/derby/releases/release-10.12.1.1.cgi

Eclipse Luna 4.4.2
http://www.eclipse.org/luna/



Experience gained:
Installation of DTP,
Download Apache Derby,
Developing Java Web Application, 
Servlets, JSPs, Get, Post,
Connecting database information into Java program,
Configuration,
Working with Databases,
Create a new Databases Connection,
Using SQL Statements,
Maintaining data in a table,
