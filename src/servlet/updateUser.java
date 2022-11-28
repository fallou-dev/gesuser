package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;

import forms.UpdateUserForm;
import modele.Users;

/**
 * Servlet implementation class updateUser
 */
@WebServlet("/update")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Utilisateur user=new Utilisateur(request.getParameter("nom"),request.getParameter("prenom"),request.getParameter("login"),request.getParameter("password"));
		Users users=new Users();
		String id =request.getParameter("id");
		if(id!= null && id.matches("[0-9]+")) {
			Utilisateur utilisateur =users.get(Integer.parseInt(request.getParameter("id")));
			if(utilisateur!=null) {
				request.setAttribute("utilisateur", utilisateur);
				 getServletContext().getRequestDispatcher("/WEB-INF/UpdateUtilisateur.jsp").forward(request,response);
				return;
			}
			}
		response.sendRedirect("list");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateUserForm form =new UpdateUserForm(request);
		
		if(form.update(Integer.parseInt(request.getParameter("id"))))
		{
			response.sendRedirect("list");
		}
		
		else {
		
		request.setAttribute("status", form.isStatus());
		request.setAttribute("statusMessage", form.getStatusMessage());
		request.setAttribute("utilisateur", form.getUtilisateur());
		request.setAttribute("erreurs", form.getErreurs());
	
		 getServletContext().getRequestDispatcher("/WEB-INF/UpdateUtilisateur.jsp").forward(request,response);
	
		}
	}

}
