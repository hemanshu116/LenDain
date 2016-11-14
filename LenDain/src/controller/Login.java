package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import pojo.LoginPojo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		response.getWriter().append(emailId);
		response.getWriter().append(password);
		LoginPojo lp = new LoginPojo();
		lp.setEmailId(emailId);
		lp.setPassword(password);

		boolean check = false;
		try {
			check = new LoginDao().validate(lp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check == true) {
			HttpSession hs = request.getSession(true);
			hs.setAttribute("login", lp);
			lp.getName();
			RequestDispatcher rd = request.getRequestDispatcher("Registered.jsp");
			rd.forward(request, response);
			response.getWriter().append("true ").append(lp.getName()).append(request.getContextPath());

		} else {
			response.getWriter().append("false ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
