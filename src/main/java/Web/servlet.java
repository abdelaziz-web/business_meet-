package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.*;
import metier.Investisseur;


/**
 * Servlet implementation class servlet
 */
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		

		
		InvesstisseurImpl inv = new InvesstisseurImpl(DAOFactory.getInstance());
		
		String parametre = request.getParameter("type") ;
		 
		if ( parametre != null && !parametre.isEmpty() && "Supprimer".equals(request.getParameter("type"))) {
		    
			inv.delete( Integer.parseInt(request.getParameter("id")));	
			
			request.setAttribute("invs", inv.getall());
			
			this.getServletContext().getRequestDispatcher("/tab_inv.jsp").forward( request, response );
			
		} else if( parametre != null && !parametre.isEmpty() && "Modifier".equals(request.getParameter("type")))
			{
		    System.out.println("Le type n'est pas égal à 'Supprimer'");
		    
		    Investisseur inv_2 = inv.findbyid( Integer.parseInt(request.getParameter("id"))) ;
		    
		    request.setAttribute("inv", inv_2);
		    
		   
		    this.getServletContext().getRequestDispatcher("/update.jsp").forward( request, response );

		 }else {
			 
			    int id              =  Integer.parseInt(request.getParameter("id"));
			    String nom          =  request.getParameter("nom");
				String prenom       =  request.getParameter("prenom");
				String motDePasse   =  request.getParameter("motDePasse");
				String email        =  request.getParameter("email");
			 
			 inv.update(new Investisseur(id,nom,prenom,email,motDePasse)) ;
			 
			 request.setAttribute("invs", inv.getall());
				
			 this.getServletContext().getRequestDispatcher("/tab_inv.jsp").forward( request, response ); 
			 	 
		 }
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
		String nom          =  request.getParameter("nom");
		String prenom       =  request.getParameter("prenom");
		String motDePasse   =  request.getParameter("motDePasse");
		String email        =  request.getParameter("email");
		
		InvesstisseurImpl inv =new InvesstisseurImpl(DAOFactory.getInstance());
		
		//Investisseur a=  new Investisseur(nom,prenom,email,motDePasse) ;
		
		PrintWriter out = response.getWriter();
		
		// out.println(inv.findbyemail(email));
		
		 if(! inv.findbyemail(email)) {
		
		inv.create(new Investisseur(nom,prenom,email,motDePasse)) ;
		
		request.setAttribute("invs", inv.getall());
		
		this.getServletContext().getRequestDispatcher("/tab_inv.jsp").forward( request, response );
		
		}else {
			
		request.setAttribute("message", "e_mail déja utilusé");	
			
	    this.getServletContext().getRequestDispatcher("/form_inv.jsp").forward( request, response );	
			
		}
		
		
	}
	
	
	 protected void doPut(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 
		 
	       
	 }       
}
