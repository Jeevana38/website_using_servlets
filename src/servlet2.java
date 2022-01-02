import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/serv2")
public class servlet2 extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unheard_voices","root","060603");
		PreparedStatement st = con.prepareStatement("SELECT PASSWORD FROM details WHERE USERNAME=?");
		st.setString(1,username);
		ResultSet rs = st.executeQuery();
		String p="";
		while(rs.next()) {
			 p = rs.getString(1);
		}
		if(p.equals(password))
		{
           res.sendRedirect("complaint.html");
		}
		else {
			
				res.sendRedirect("home.html");
			}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

