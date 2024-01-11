package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import metier.Investisseur;
import DAO.DAOFactory;
import DAO.InvesstisseurImpl;
//import com.metier.Utilisateur;

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
	    	request.getRequestDispatcher("/auth_form.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		InvesstisseurImpl inv_imp = new InvesstisseurImpl(DAOFactory.getInstance()) ;
		Investisseur inv  = new Investisseur();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        inv = inv_imp.find(email, password);
        
      
        if(inv == null)  this.getServletContext().
                         getRequestDispatcher("/form_inv.jsp")
                         .forward( request, response );
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("inv", inv);
            this.getServletContext().getRequestDispatcher("/acceuil.jsp").forward( request, response );
        }
	
       
       
	}

	
		
}
