package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.Investisseur;
import metier.P_i;
import metier.noti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOFactory;
import DAO.InvesstisseurImpl;
import DAO.noti_impl;
import DAO.p_i_impl;

/**
 * Servlet implementation class auth_p_i
 */
public class auth_p_i extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public auth_p_i() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       //	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   //	doGet(request, response);
		
		p_i_impl p_i_imp = new p_i_impl(DAOFactory.getInstance()) ;
		P_i p_i  = new P_i();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        p_i = p_i_imp.find(email, password);
        
      
        if(p_i == null) { 
        	
            request.setAttribute("message", "The email or password is wrong or both");

        	
        	this.getServletContext().
                         getRequestDispatcher("/form_p_i_.jsp")
                         .forward( request, response );
        

        }
        else {
        	List<noti> noti_list =  send_db(p_i.getId());
            HttpSession session = request.getSession(true);
            session.setAttribute("p_i", p_i);
        //    session.setAttribute("noti_list", noti_list);
            request.setAttribute("noti_list", noti_list);

            this.getServletContext().getRequestDispatcher("/acceuil.jsp").forward( request, response );
            
        
        }
		
		
		
	}

	public List<noti> send_db(int id_pi ) {
		
		
		noti noti_1 = new noti() ;
 		
 		List<noti> noti_list = new ArrayList<>();
 		
 	    noti_impl not = new noti_impl(DAOFactory.getInstance()) ;
 		
 	    noti_list	 =  not.selection(id_pi, 0) ;
 	    
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
