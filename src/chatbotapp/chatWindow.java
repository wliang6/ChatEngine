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
 * chatWindow.java
 */
@WebServlet(urlPatterns = {"/chatWindow"})
public class chatWindow extends HttpServlet{

	String username, tempName;
	HttpSession session;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){ 
			
			String message = request.getParameter("txtMsg");
			String username = session.getAttribute("username").toString();
			
			//request.getRequestDispatcher("/WEB-INF/lib/chatbox.jsp").forward(request, response);
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
			
			
			if(request.getParameter("txtMsg") != null){
				
				try{
					Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:derby:/Users/Winnie/MyDatabase;create=true", "", "");
					Statement st = con.createStatement();
					String sql = "insert into WEBCHATDATABASE.MYTABLE values ('"+username+"','"+message+"')";
	                st.executeUpdate(sql);

	                st.execute("commit");

				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
			
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
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		session = request.getSession();
		if(username != null){
			tempName = username;
		}
		
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		processRequest(request, response);
	}
}
