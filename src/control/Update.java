package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.DatabaseMysql;
@WebServlet("/Update")
public class Update extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Employee employee=new Employee();
		employee.setId(Integer.parseInt(req.getParameter("id")));
		employee.setName(req.getParameter("name"));
		employee.setCountry(req.getParameter("country"));
		employee.setState(req.getParameter("state"));
		int status=DatabaseMysql.update(employee);
		System.out.println("transfer");
		if(status>0){
			out.println("<p>Update Sucessfully</p>");
			req.getRequestDispatcher("update.jsp").include(req, resp);
		}else{
			out.println("<p>Not Updated</p>");
		}
		
	}
}
