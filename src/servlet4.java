import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/serv4")
public class servlet4 extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String username = req.getParameter("username");
	String feedback = req.getParameter("feedback");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unheard_voices","root","060603");
		PreparedStatement ps = con.prepareStatement("insert into opinion values(?,?)");
	    ps.setString(1, username);
	    ps.setString(2,feedback);
	    ps.executeUpdate();
		res.sendRedirect("complaint.html");
		}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

