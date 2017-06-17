package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DatabaseMysql;
@WebServlet("/DeleteServlet")
public class Delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int status=0;
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		status=DatabaseMysql.deleteOut(id);
		
		if(status>0){
			out.println("<p>Succesfully Deleted </p>");
			req.getRequestDispatcher("delete.jsp").include(req, resp);
		}
	}
}
