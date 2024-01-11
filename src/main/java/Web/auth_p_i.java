package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import metier.Investisseur;
import metier.P_i;

import java.io.IOException;

import DAO.DAOFactory;
import DAO.InvesstisseurImpl;
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
        
      
        if(p_i == null)  this.getServletContext().
                         getRequestDispatcher("/form_p_i.jsp")
                         .forward( request, response );
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("p_i", p_i);
            this.getServletContext().getRequestDispatcher("/acceuil.jsp").forward( request, response );
        }
		
		
		
	}

}
