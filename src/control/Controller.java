package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.DatabaseMysql;
@WebServlet("/Controller")
public class Controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
	
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=req.getParameter("name");
		String country=req.getParameter("country");
		String state=req.getParameter("state");
		
		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setCountry(country);
		employee.setState(state);
	int status=	DatabaseMysql.save(employee);
	if(status>0)
	{
		out.println("<p>successfully saved</p>");
		req.getRequestDispatcher("index.jsp").include(req, resp);
	}else
	out.print("not saved");
		
	}
}
