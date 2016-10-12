package chatbotapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ChatBotApp
 * @author Winnie Oct 11, 2016
 * LoginServlet.java
 */
@WebServlet(urlPatterns = "/userLogin")
public class LoginServlet extends HttpServlet{
	
	
	public String username;
	HttpSession session;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		try{
			session = request.getSession();
			session.setAttribute("username", request.getParameter("username"));
			
			out.println("<html>  <head> <body bgcolor=\"#0099B8\"> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <title>Chat Room</title>  </head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> <center>");
			out.println("<h2>Hi ");
			out.println(username);
			out.println("<br> Welcome to Chat Engine ");
			out.println("</h2><br><hr>");
			out.println("  <body>");
			out.println("      <form name=\"chatWindow\" action=\"chatWindow\">");
			out.println("Message: <input type=\"text\" name=\"txtMsg\" value=\"\" /><input type=\"submit\" value=\"Send\" name=\"cmdSend\"/>");
			out.println("<br><br> <a href=\"chatWindow\">Refresh Chat Room</a>");
			out.println("<br>  <br>");
			out.println("Messages in Chat Box:");
			out.println("<br><br>");
			out.println("<textarea  readonly=\"readonly\"   name=\"textMessage\" rows=\"20\" cols=\"60\">");
			
		
			
			//Retrieve messages from database
			try{
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver"); //driver
				java.sql.Connection con = DriverManager.getConnection("jdbc:derby:/Users/Winnie/MyDatabase;create=true", "", "");
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery("select *from WEBCHATDATABASE.MYTABLE");
				
				while(resultSet.next()){
	                String messages = resultSet.getString(1)+ " >> " + resultSet.getString(2);
	                
	                out.println(messages);
	            }
	               
				//statement.executeUpdate("TRUNCATE TABLE WEBCHATDATABASE.MYTABLE");
	            con.close();
	         	
			} 	
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		
			out.println("</textarea>");
			out.println("<hr>");
			out.println("</form>");
			out.println("</body");
			out.println("</html>");
		}
		catch(Exception e){
            System.out.println(e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/lib/index.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		processRequest(request, response);
	
	}
	
	
}
