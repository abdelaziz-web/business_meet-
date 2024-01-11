package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import metier.categorye;
import metier.idee;

public class category_impl implements category_interface {

	
	private DAOFactory    daoFactory;
	
	
	 public category_impl( DAOFactory daoFactory ) {
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
	public void create(categorye category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int categoryId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<categorye> getAll() {
		
        final String SQL_SELECT = "SELECT * FROM categorie " ;
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	   
	    ArrayList<categorye> listecategorye = new ArrayList<>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	            
	        	    int id = resultSet.getInt("id");
	                String Designation = resultSet.getString("Designation");
	                categorye cat = new categorye(id,Designation );
	                listecategorye.add(cat) ;  
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	 //   int nombreElements = listeInvestisseur.size();
	 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
	    
	    return listecategorye ;
	
		
		
		
		
	}

}
