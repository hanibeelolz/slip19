loginpage.html
<html>
<body>
<form method=GET action="http://localhost:8080/login">
User Name :<input type=text name=user><br><br>
Password :<input type=text name=pass><br><br>
<input type=submit value="Login">
</form>
</body>
</html>


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class UserPass extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws IOException, ServletException
	{
	    	PrintWriter out = response.getWriter();
	    	try{
	                	String us=request.getParameter("user");
	                	String pa=request.getParameter("pass");
    	                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    	Connection cn=DriverManager.getConnection("jdbc:odbc:dsn2","","");
                    	Statement st=cn.createStatement();
                    	ResultSet rs=st.executeQuery("select * from UserPass");
    	                while(rs.next())
   	               {
   	             	if(us.equals(rs.getString("user"))&&pa.equals(rs.getString("pass")))
   	             	out.println("Valid user");
   	             	else
  	              	out.println("Invalid user");
	    	          }
        		}catch(Exception e)
              	{  	
                  	out.println(e);        	
              	}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
	{
    	doGet(request, response);
	}
}

