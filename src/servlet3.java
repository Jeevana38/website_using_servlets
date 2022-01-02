import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/serv3")
public class servlet3 extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String cid = req.getParameter("cid");
	String username = req.getParameter("username");
	String complaint = req.getParameter("complaint");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unheard_voices","root","060603");
		PreparedStatement ps = con.prepareStatement("insert into complaints values(?,?,?)");
	    ps.setString(1,cid);
		ps.setString(2, username);
	    ps.setString(3, complaint);
	    ps.executeUpdate();
		res.sendRedirect("complaint.html");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

