package org.antislashn.communes.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antislashn.communes.entities.Commune;
import org.antislashn.communes.services.CommuneServices;


@WebServlet("/CommuneByNomServlet")
public class CommuneByNomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommuneServices service = (CommuneServices) getServletContext().getAttribute(Constantes.COMMUNE_SERVICE);
		String nomVille = request.getParameter("nomVille");
		String page = "";
		if(nomVille==null || nomVille.isEmpty()) {
			page="/index.jsp";
		}else {
			List<Commune> communes = service.getCommunesByNom(nomVille);
			request.setAttribute("communes", communes);
			request.setAttribute("titre", "Communes débutant par "+nomVille);
			page = "/show-communes.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
