package Web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

/**
 * Servlet implementation class upload
 */
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String nomFichier_1 = "Business";
        
        String nomFichier_2 = request.getParameter("upload");
         
        
        response.setContentType("image/jpeg");

        
        	 if (verifierExtension(nomFichier_2, "pdf")) {
        		 
        	//	 response.setContentType("application/pdf");
        		 
        		 nomFichier_1 = nomFichier_1 + ".pdf" ;
                
             } else if (verifierExtension(nomFichier_2, "jpg", "jpeg")) {
                
            	 nomFichier_1 = nomFichier_1 + ".jpg" ;
            	 
            	// response.setContentType("image/jpeg");
             } else if (verifierExtension(nomFichier_2, "png")) {
            	// response.setContentType("image/png");
            	 
            	 nomFichier_1 = nomFichier_1 + ".png" ;
                 
             } else {
            	 response.setContentType("application/octet-stream");
                 
             }
         
        	 response.setHeader("Content-Disposition", "attachment; filename=" + nomFichier_1);
        	
        	 File test =  new File(/*cheminVersPdf+*/nomFichier_2) ;
        	 
        	 try (FileInputStream fichierPdf = new FileInputStream(test)) {
        	
            byte[] buffer = new byte[4096];
            int length;

            // Écrit le contenu du fichier dans le flux de sortie
            while ((length = fichierPdf.read(buffer)) > 0) {
                response.getOutputStream().write(buffer, 0, length);
            }

            // Vide le tampon et force l'envoi du contenu au client
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private static boolean verifierExtension(String cheminFichier, String... extensionsAttendues) {
        File fichier = new File(cheminFichier);
        String nomFichier = fichier.getName();
        String extension = nomFichier.substring(nomFichier.lastIndexOf(".") + 1).toLowerCase();

        for (String extensionAttendue : extensionsAttendues) {
            if (extension.equals(extensionAttendue.toLowerCase())) {
                return true;
            }
        }

        return false;
    }
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
