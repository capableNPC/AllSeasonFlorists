package priv.github.ljjdgh.AllSeasonFlorists.web.servlet.client;

import java.io.IOException;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import priv.github.ljjdgh.AllSeasonFlorists.domain.User;
import priv.github.ljjdgh.AllSeasonFlorists.service.UserService;

public class LogStateCheckServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if (flag == null || flag.trim().isEmpty()) {
			// 重定向到登录
			response.sendRedirect(request.getContextPath() + "/client/login.jsp");
		}
		else {
			// 重定向到结算
			response.sendRedirect(request.getContextPath() + "/client/order.jsp");
		}
	}
}