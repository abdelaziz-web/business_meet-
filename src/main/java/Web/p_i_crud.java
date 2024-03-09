package Web;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.Investisseur;
import metier.P_i;
import DAO.p_i_impl;
import DAO.DAOFactory;
import DAO.InvesstisseurImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet implementation class p_i_crud
 */
public class p_i_crud extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p_i_crud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		    auth au = new auth( ) ;
		    
		    au.doGet(request, response) ;
		
		    String parametre = request.getParameter("type");
		 
		    p_i_impl p_i_im = null;
 		
 		    p_i_im = new p_i_impl(DAOFactory.getInstance()) ;

	        // Vérifier si le paramètre est présent
	        if (parametre != null && !parametre.isEmpty() &&  parametre.equalsIgnoreCase("Supprimer")) {
	            // Le paramètre est présent, faites quelque chose avec sa valeur
	             				
	    	   	 p_i_im.delete(Integer.parseInt(request.getParameter("id"))) ;
	    		
	    	   	 ArrayList<P_i> p_i =   (ArrayList<P_i>) p_i_im.getall() ;
	    		 
	             request.setAttribute("p_i", p_i) ;
	    	     			 
	    		 this.getServletContext().getRequestDispatcher("/tab_p_i.jsp").forward( request, response );	
	        		        	
	        }else if( parametre != null && !parametre.isEmpty() &&  parametre.equalsIgnoreCase("Modifier")) {
	        	
	          P_i p_i =	p_i_im.findbyid(Integer.parseInt(request.getParameter("id"))) ;
	        	
	          request.setAttribute("inv", p_i);
	          
	          this.getServletContext().getRequestDispatcher("/update_pi.jsp").forward( request, response );
	        		        	
	        }else if( parametre == null || parametre.isEmpty()) {
	             	    		
	        	 ArrayList<P_i> p_i =   (ArrayList<P_i>) p_i_im.getall() ;
	    		 
	             request.setAttribute("p_i", p_i) ;
	    	     			 
	    		 this.getServletContext().getRequestDispatcher("/tab_p_i.jsp").forward( request, response );	
	        }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    p_i_impl p_i =new p_i_impl(DAOFactory.getInstance());
    
    String nom          =  request.getParameter("nom");
	String prenom       =  request.getParameter("prenom");
	String m_p          =  request.getParameter("motDePasse");
	String email        =  request.getParameter("email");
	String photo = null ;
    

	if(	request.getParameter("type").equals("Modification")) {
		
		int    id           = Integer.parseInt(request.getParameter("id"))  ;		
				
		p_i.update(new P_i( id ,nom,  prenom,  email,  m_p,  photo))  ;
		
		request.setAttribute("message", "Your profil has been changed");
		
		this.getServletContext().getRequestDispatcher("/profil_.jsp").forward( request, response );
		
			
	}else if(request.getParameter("type").equals("Ajouter")) {
	
	if(p_i.findbyemail(email)) {
		
	request.setAttribute("message", "this email already exists");
	
	this.getServletContext().getRequestDispatcher("/form_p_i_.jsp").forward( request, response );
	
	}else {
		
	p_i.create(new P_i( nom,  prenom,  email,  m_p,  photo))	;
	}	
	}
	
	
	
    request.setAttribute("message", "Your account have been created");
	
	this.getServletContext().getRequestDispatcher("/form_p_i_.jsp").forward( request, response );	

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	

}
