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

import metier.Investisseur;
import metier.noti;
import DAO.DAOFactory;
import DAO.InvesstisseurImpl;
//import com.metier.Utilisateur;
import DAO.noti_impl;
import jakarta.servlet.http.HttpSession;





/**
 * Servlet implementation class auth
 */
public class auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public auth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		HttpSession session = request.getSession(true);
	    if(session.getAttribute("inv") == null && session.getAttribute("p_i") == null  ) { 
	    	request.getRequestDispatcher("/form_p_i_.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		InvesstisseurImpl inv_imp = new InvesstisseurImpl(DAOFactory.getInstance()) ;
		Investisseur inv  = new Investisseur();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        inv = inv_imp.find(email, password);
        
      
        if(inv == null) {  
        	
        	request.setAttribute("message", "the email or password  are wrong") ;
        	
        	this.getServletContext().
                         getRequestDispatcher("/inv_space.jsp")
                         .forward( request, response );}
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("inv", inv);
            List<noti> noti_list = new ArrayList<>();
            noti_list = send_db(inv.getid()) ;
            request.setAttribute("noti_list", noti_list);
            this.getServletContext().getRequestDispatcher("/acceuil_.jsp").forward( request, response );
        }
	
       
	}

	
	
	
	
public List<noti> send_db(int id_inv ) {
		
		
		noti noti_1 = new noti() ;
 		
 		List<noti> noti_list = new ArrayList<>();
 		
 	    noti_impl not = new noti_impl(DAOFactory.getInstance()) ;
 		
 	    noti_list	 =  not.selection(id_inv, -1) ;
 	    
 	    for (noti notiItem : noti_list) {
 	        System.out.println("ID: " + notiItem.getId());
 	        System.out.println("Date: " + notiItem.getDate());
 	        System.out.println("Status: " + notiItem.getStatus());
 	        System.out.println("ID Inv: " + notiItem.getId_inv());
 	        System.out.println("ID Ide: " + notiItem.getId_ide());
 	        System.out.println("ID Pi: " + notiItem.getId_pi());
 	        System.out.println("---------------------------------------");
 	    }
 		
 	    System.out.println("lenght " + noti_list.size()) ;
		
		return noti_list ;
 	    
		
	}
}
