package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Users;

/**
 * Servlet implementation class ListUser
 */
@WebServlet({"/list",""})
public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VUE_LIST_UTILISATEUR="/WEB-INF/listerUtilisateur.jsp";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Users user=new Users();
		request.setAttribute("utilisateurs",  user.recupererUtilisateurs());
		
	getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
	}

}
