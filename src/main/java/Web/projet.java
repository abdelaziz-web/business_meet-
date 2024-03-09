package Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import DAO.DAOFactory;
import DAO.category_impl;
import DAO.idee_impl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.categorye;
import metier.idee;
import Web.Beans.projets;


/**
 * Servlet implementation class projet
 */
public class projet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public projet(String titre, String description, String nom, String designation, String business_plan1) {
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
		
	 	category_impl cat = new category_impl(DAOFactory.getInstance()); 
	 	List<categorye> les_cat =   cat.getAll();
	 	
	 	idee_impl ide = new idee_impl(DAOFactory.getInstance());
		List<idee> les_ides =   ide.getall();
		
		List<projets> listeProjets = new ArrayList<>();
		
	
		
		 
		
	//	PrintWriter out = response.getWriter();
     //   out.println(ide.p_i(les_ides.get(i)));
	//	 out.println(les_ides.get(i).getFk_categorie1());
		
		String path = null ;
		for (int i = 0; i < les_ides.size(); i++) {
			path = les_ides.get(i).getBusiness_plan1() ;
			listeProjets.add(new projets  (
					les_ides.get(i).getFK_porteur_ide(),
					les_ides.get(i).getId(),
					les_ides.get(i).getTitre(),
					les_ides.get(i).getDescription(),
					ide.p_i(les_ides.get(i)).getNom(),
					ide.cat(les_ides.get(i).getFk_categorie1()).getDesignation(),
					path 
					));
        }
		
	//	int i  = 0 ;
		PrintWriter out = response.getWriter();
	     //   out.println(ide.p_i(les_ides.get(i)));
	    out.println(path);
			

	 	request.setAttribute("listeProjets", listeProjets);
	 	request.setAttribute("les_cat", les_cat) ;
		request.setAttribute("les_idees", les_ides) ;
		this.getServletContext().getRequestDispatcher("/lesprojets_.jsp").forward( request, response );
		 			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		
		
		
		
		
		
	}

}
