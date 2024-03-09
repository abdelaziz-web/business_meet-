package Web;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.noti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DAO.DAOFactory;
import DAO.noti_impl;

/**
 * Servlet implementation class notification
 */
public class notification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public notification() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int id_ide =  Integer.parseInt(request.getParameter("id_ide")) ;
        int fk_p_i =  Integer.parseInt(request.getParameter("fk_p_i"));
        int fk_inv =  Integer.parseInt( request.getParameter("fk_inv"));

        // Faites ce que vous voulez avec les paramètres récupérés
        System.out.println("id_ide : " + id_ide);
        System.out.println("fk_p_i : " + fk_p_i);
        System.out.println("fk_inv : " + fk_inv);
	
        
       
        Date date = new Date();

        // Créer un objet SimpleDateFormat pour formater la date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Formater la date en chaîne de caractères
        String date_= dateFormat.format(date);
        
	    noti noti_1 = new noti(date_,0,fk_inv,id_ide,fk_p_i) ;
	
        noti_impl not = new noti_impl(DAOFactory.getInstance()) ;
	
	    not.create(noti_1) ;
	
	    String message = "Ceci est un message de notification de la servlet." ;
        
        PrintWriter out = response.getWriter();
        out.write(message);
	
		
	/*	
		try {
            // Chemin vers l'interpréteur PHP sur votre système
            String phpInterpreter = "C:\\xampp\\php\\php.exe";

            // Chemin vers votre script PHP
            String phpScript = "C:\\Users\\hp\\Desktop\\script.php";

            // Création du processus d'exécution
            Process process = Runtime.getRuntime().exec(phpInterpreter + " " + phpScript);

            // Lire la sortie du processus (si nécessaire)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Attendre la fin de l'exécution du processus
            int exitCode = process.waitFor();
            System.out.println("Le script PHP a terminé avec le code de sortie : " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
		
	*/	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  
     //   noti_impl not = new noti_impl(DAOFactory.getInstance()) ;
		
	//	not.update(0, 19, 1,5) ;

		int status = -1 ;
		
		int id_pi = Integer.parseInt(request.getParameter("id_pi")) ;
	    int id_inv = Integer.parseInt(request.getParameter("id_inv")) ;
	    int id_ide = Integer.parseInt(request.getParameter("id_ide")) ;
	    int id = Integer.parseInt(request.getParameter("id")) ;
	    
	    // Afficher les variables dans la console
	    System.out.println("id_pi : " + id_pi);
	    System.out.println("id_inv : " + id_inv);
	    System.out.println("id_ide : " + id_ide);
	    System.out.println("id : " + id);
		
		if(id == 1) {
			
			status =1 ;
			
		}
	    
	    if(id == 2) {
	    	
	    	status =  2 ;
	    }
	     
	    if(id==3) {
	    	
	    	status = 3 ;	
	    }
	    
	    noti_impl not = new noti_impl(DAOFactory.getInstance()) ;
	    
	    not.update(status, id_inv, id_pi,id_ide) ;
		
        String message = "Ceci est un message de notification de la servlet." ;
        
        PrintWriter out = response.getWriter();
        out.write(message);
   	
	}

}
