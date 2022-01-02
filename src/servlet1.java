import java.util.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/serv1")
public class servlet1 extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String name= req.getParameter("name");
	String phone = req.getParameter("phone");
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/unheard_voices","root","060603");
		PreparedStatement st = con.prepareStatement("SELECT COUNT(DISTINCT USERNAME) FROM details WHERE USERNAME=?");
		st.setString(1,username);
		ResultSet rs = st.executeQuery();
		int c=0;
		while(rs.next())
		{ c = rs.getInt(1);}
	
		if(c==1)
		{  
			RequestDispatcher rd = req.getRequestDispatcher("/home.html");
			rd.include(req,res);
		}
		else {
			PreparedStatement ps = con.prepareStatement("insert into details values(?,?,?,?)");
	         
		    ps.setString(1, username);
		    ps.setString(2, name);
		    ps.setString(3, phone);
		    ps.setString(4, password);
		    ps.executeUpdate();
		    RequestDispatcher rd = req.getRequestDispatcher("/complaint.html");
			rd.include(req,res);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
