package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;

/**
 * Servlet implementation class login
 */
@WebServlet({"/login","/logout"})
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		switch (request.getServletPath())
		{
		case "/logout":
		HttpSession	session=request.getSession();
			session.invalidate();
			response.sendRedirect("login");
			break;
		case "/login":
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp");
			
			dispatcher.forward(request, response); 
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String motdepass = request.getParameter("motdepasse");

		// ou "admin".equals(login
		if(login.equals("admin") && motdepass.equals("passer")) {
			Utilisateur utilisateur = new Utilisateur(login,motdepass);
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", session);
			session.setAttribute("isConnected", true);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/listerUtilisateur.jsp");
			
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("connexionFailed", true);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp");
			
			dispatcher.forward(request, response);

		}
		
	}


}
