import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/serv5")
public class servlet5 extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String id = req.getParameter("cid");
	String username = req.getParameter("username");
	int cid = Integer.parseInt(id);
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unheard_voices","root","060603");
		PreparedStatement ps = con.prepareStatement("delete from complaints where cid=? and USERNAME=?"); 
		ps.setInt(1,cid);
		ps.setString(2,username);
		ps.executeUpdate();
		res.sendRedirect("complaint.html");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

