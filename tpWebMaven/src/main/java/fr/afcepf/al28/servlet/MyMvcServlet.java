package fr.afcepf.al28.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afcepf.al28.model.CalculEmprunt;

/**
 * Servlet implementation class MyMvcServlet
 */
@WebServlet("/MyMvcServlet")
public class MyMvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMvcServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String task=request.getParameter("task");
		
		switch(task){
		case "calculMensualite":
			doCalculmensualite(request, response);
			break;
			default :
				//....
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doCalculmensualite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sUrl="/paramEmpruntMvc.jsp"; //vers paramEmpruntMvc.jsp
		
		String sMontant=request.getParameter("montant");
		String sDuree=request.getParameter("duree");
		String sTauxAnnuel=request.getParameter("taux");
		
		CalculEmprunt objCalcul= new CalculEmprunt(sMontant, sDuree, sTauxAnnuel);
		if(objCalcul.getMsg()!=null && objCalcul.getMsg().size()==0){
			request.setAttribute("mensualite",objCalcul.calculMensualite());
			
		}
		
		//request.setAttribute("objCalcul",objCalcul);
		HttpSession session=request.getSession();
		session.setAttribute("objCalcul",objCalcul);
		ServletContext application = getServletContext();//peu être dangereux car utilisé par tous les users de l'application
		RequestDispatcher rd = application.getRequestDispatcher(sUrl);
		rd.forward(request,response);
	}

}
