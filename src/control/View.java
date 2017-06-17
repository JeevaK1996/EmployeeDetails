package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.DatabaseMysql;
@WebServlet("/View")
	public class View extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			try {
				List<Employee> list = DatabaseMysql.view();
				req.setAttribute("list", list);
				req.getRequestDispatcher("view.jsp").include(req, resp);;
				} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
