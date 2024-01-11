package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.comment;
import metier.idee;

public class com_impl implements com_inter {

	
	private DAOFactory        daoFactory;
	
	
	 public com_impl(DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	        
	    }
	
	
	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
  	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
  	    for ( int i = 0; i < objets.length; i++ ) {
  	        preparedStatement.setObject( i + 1, objets[i] );
  	    }
  	    return preparedStatement;
  	}
	

	
	
	@Override
	public void create(comment com) {
		
		final String SQL_INSERT = "INSERT INTO  commentaire (id_inv,id_ide,date,descripiton	,id_p_i)"
				+ " VALUES (?,?,?,?,?) ;"  ;
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	   // ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_INSERT, com.getId_inv() ,com.getId_ide() ,
	        		com.getDate(), com.getDescription(),com.getId_p_i());
	       preparedStatement.execute();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	 //ClosingAll( resultSet, preparedStatement, connexion );	
	    }
	
	}

	@Override
	public List<comment> getAll(int id_ide) {
		
		
       final String SQL_SELECT = "SELECT * FROM commentaire where id_ide= ? ;" ;
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	   
	    ArrayList<comment> listecom = new ArrayList<>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT,id_ide);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	    int id = resultSet.getInt("id");
	                String date = resultSet.getString("date");
	                String description = resultSet.getString("descripiton"); 
	                int id_inv = resultSet.getInt("id_inv");
	                int id_ide_11 = resultSet.getInt("id_ide");
	                int id_p_i = resultSet.getInt("id_p_i");

	               comment com = new comment( id ,id_inv, id_ide_11, id_p_i ,date,description);
	               listecom.add(com) ;  
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	 //   int nombreElements = listeInvestisseur.size();
	 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
	    
	    return listecom ;
		

	}

}
