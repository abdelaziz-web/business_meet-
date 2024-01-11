package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.idee;
import jakarta.servlet.http.Part;
import java.io.*;
import DAO.idee_impl;
import metier.idee;
import DAO.DAOFactory;
import metier.categorye;
import DAO.category_impl;
import java.util.*;


/**
 * Servlet implementation class servlet_ide
 */

public class servlet_ide extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final int TAILLE_TAMPON = 10240 ;
    public static final String CHEMIN_FICHIER = "C:\\Users\\hp\\Desktop\\java\\final\\" ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_ide() {
        super();      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	   	category_impl cat = new category_impl(DAOFactory.getInstance()); 
		
		 ArrayList<categorye> listcat =   (ArrayList<categorye>) cat.getAll() ;
		 
         request.setAttribute("cate", listcat) ;
	     	
		 this.getServletContext().getRequestDispatcher("/form_ide.jsp").forward( request, response );		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		Part filePart = request.getPart("plan");
        String fileName = getFileName(filePart);
        String titre = request.getParameter("titre") ;
        String description = request.getParameter("description") ;
        float Budget = Float.parseFloat( request.getParameter("Budget")) ;
        int FK_categorie = Integer.parseInt(request.getParameter("cat")) ;
        int FK_p_i = Integer.parseInt(request.getParameter("id")) ;

      //  java.io.PrintWriter out = response.getWriter();
      //  out.println(fileName);
        
        System.out.println(fileName);
        
        idee ide =  new idee(titre,description,CHEMIN_FICHIER + fileName,Budget,FK_p_i,FK_categorie) ;
        
        idee_impl ide_impl = new idee_impl(DAOFactory.getInstance()) ;
        
        ide_impl.create(ide) ;
        
        ecrire_fichier(filePart,fileName,CHEMIN_FICHIER) ;
        
        request.setAttribute("message", "l'élement a bien éte enregisterer") ;
        
        this.getServletContext().getRequestDispatcher("/form_ide.jsp").forward( request, response ); 
        
   

	}
	
	
	private String getFileName(final Part part) {
	       final String partHeader = part.getHeader("content-disposition");
	       for (String content : partHeader.split(";")) {
	           if (content.trim().startsWith("filename")) {
	               return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
	           }
	       }
	       return null;
	   }
		
			
			
		
		private void ecrire_fichier(Part part ,String fileName,String chemin_final)throws IOException {
			
			BufferedInputStream entre = null ;
			BufferedOutputStream sortie  =null;
			
			try {
				entre = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON ) ;
				sortie = new BufferedOutputStream(new FileOutputStream(CHEMIN_FICHIER + fileName ),TAILLE_TAMPON) ;
				
				
				byte[] tampan = new byte[TAILLE_TAMPON];
				int longueur ;
				while( (longueur = entre.read(tampan)) > 0 ) {
					sortie.write(tampan, 0, longueur);
					
				}
				
			}finally {
				try {
					sortie.close() ;
				}catch(IOException ignore) {
					
				}
				try	{
					entre.close() ;
				}catch(IOException ignore) {					
					
				}
				
				
			}
			
	       
	   }

	
}