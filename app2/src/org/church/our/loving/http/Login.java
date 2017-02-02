package org.church.our.loving.http;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.church.our.loving.test.DBConnection;
import org.church.our.loving.util.SecurityUtil;
import org.church.our.loving.util.StringUtil;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			StringUtil.debug(logger, request, "testing db connection : " + DBConnection.getConnectionByJNDI());
		} catch (Exception e) {
			StringUtil.error(logger, request, "Error", e);
		}
		
		if (SecurityUtil.checkFormRequest("", request, response,"error.jsp")) {
			request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (!StringUtil.isEmpty(username) && !StringUtil.isEmpty(password) && username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("307")) {
				request.getSession().setAttribute("username", username);
				response.sendRedirect("index.jsp");
			}else {
				request.setAttribute("msg", "密码错误");
				SecurityUtil.sendRequestDispatcher("login.jsp", request, response);
			}
		}
	}

	/** 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
