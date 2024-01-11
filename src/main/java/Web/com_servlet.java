package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import metier.comment;

import DAO.DAOFactory;
import DAO.com_impl;

/**
 * Servlet implementation class com_servlet
 */
public class com_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public com_servlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id_ide =  Integer.parseInt(request.getParameter("id_ide")) ;
		
		// int id_ide = 5 ;
		
		 com_impl com = new com_impl(DAOFactory.getInstance()) ;
		 
	     List<comment> maListe = com.getAll(id_ide);
		 
         request.setAttribute("maListe", maListe) ;
         
         request.setAttribute("id_ide", id_ide) ;

		 request.getRequestDispatcher("/comment.jsp").forward(request, response);
		 
		// PrintWriter out = response.getWriter();

		// for (comment commentaire : maListe) {
		//    out.println("<p>" + commentaire.getId_ide() + "</p>");
		//	}

		//	out.println("</body>");
		//	out.println("</html>");

			// N'oubliez pas de fermer le PrintWriter
	    //		out.close();
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		if (request.getParameter("id_p_i") == null || request.getParameter("id_p_i").isEmpty()) {

			int id_inv_1 =  Integer.parseInt(request.getParameter("id_inv")) ;
			
			// int id_p_i_1 = (Integer) null ; 
			
			String commentaire =  request.getParameter("com") ;
			
	        int id_ide =  Integer.parseInt(request.getParameter("id_ide")) ;

	        LocalDate dateActuelle = LocalDate.now();

	        
	        String dateEnString = dateActuelle.toString();
	        
	        comment com  = new comment( id_inv_1, id_ide ,15, dateEnString , commentaire );
			
	        com_impl com_1 = new com_impl(DAOFactory.getInstance()) ;
	   		 
  	        com_1.create(com);
		
		
		}else {
        	
    		int id_p_i_1 =  Integer.parseInt(request.getParameter("id_p_i")) ;	
	
    		// int id_inv_1 = (Integer) null ; 
    		
    		
    		String commentaire =  request.getParameter("com") ;
    		
            int id_ide =  Integer.parseInt(request.getParameter("id_ide")) ;

            LocalDate dateActuelle = LocalDate.now();

            
            String dateEnString = dateActuelle.toString();
            
            comment com  = new comment( 44, id_ide ,id_p_i_1, dateEnString , commentaire );
       
            com_impl com_1 = new com_impl(DAOFactory.getInstance()) ;
   		 
   	         com_1.create(com);
   	         
            
        }
		
	 
	
		 request.getRequestDispatcher("/acceuil.jsp").forward(request, response);
		
	
	
	}

}
