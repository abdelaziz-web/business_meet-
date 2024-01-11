package DAO;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.P_i;
import metier.idee;
import metier.categorye;

public class idee_impl implements idee_interface {

	private DAOFactory        daoFactory;
	
	
	 public idee_impl( DAOFactory daoFactory ) {
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
	public void create(idee idee_1) throws DAOException {
		
		final String SQL_INSERT = "INSERT INTO  ide (titre,description,business_plan,FK_p_i  ,Fk_categorie ,budget)"
				+ " VALUES (?,?,?,?,?,? ) ;"  ;
			
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	   // ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_INSERT, idee_1.getTitre() ,idee_1.getDescription() ,
	        		idee_1.getBusiness_plan1(), idee_1.getFK_porteur_ide(), idee_1.getFk_categorie1(), idee_1.getBudget() );
	       preparedStatement.execute();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	 //ClosingAll( resultSet, preparedStatement, connexion );	
	    }
		
		

	}

	@Override
	public idee find() throws DAOException {
		
		return null;
	}

	@Override
	public List<idee> getall() throws DAOException {
		
        final String SQL_SELECT = "SELECT * FROM ide " ;
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	   
	    ArrayList<idee> listeidee = new ArrayList<>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	            
	        	    int id = resultSet.getInt("id");
	                String titre = resultSet.getString("titre");
	                String description = resultSet.getString("description");
	                String business_plan = resultSet.getString("business_plan") ;
	                float budget = resultSet.getFloat("budget") ;
	                int FK_cat = resultSet.getInt("Fk_categorie");
	                int FK_p_i = resultSet.getInt("FK_p_i");

	               idee ide = new idee( id ,titre, description, business_plan,budget,FK_p_i, FK_cat); 
	               listeidee.add(ide) ;  
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	 //   int nombreElements = listeInvestisseur.size();
	 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
	    
	    return listeidee ;
	}

	@Override
	public void update(idee idee_1) throws DAOException {
		
	String updateQuery = "UPDATE ide SET titre = ?, description = ?, business_plan = ?,  Fk_categorie = ?, budget = ? WHERE id = ?";

	Connection connexion = null;
    PreparedStatement preparedStatement = null;
   // ResultSet resultSet = null;
    
    try {
        /* Récupération d'une connexion depuis la Factory */
        connexion = daoFactory.getConnection();
        preparedStatement = initRequestPrepare( connexion, updateQuery, idee_1.getTitre() ,idee_1.getDescription() ,
        		idee_1.getBusiness_plan1(), idee_1.getFk_categorie1(), idee_1.getBudget() );
       preparedStatement.execute();
        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
        
    } catch ( SQLException e ) {
        throw new DAOException( e );
    } finally {
    	 //ClosingAll( resultSet, preparedStatement, connexion );	
    }
		
	}

	@Override
	public void delete(int id) throws DAOException {
		
		
		final String SQL_SELECT_DELETE = "DELETE FROM ide WHERE id = ?" ;
		
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	   // ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_DELETE, id );
	        preparedStatement.execute();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
		
		
		

	}

	@Override
	public List<idee> getwithcatego(String category) throws DAOException {
		
		
	   ArrayList<idee> listeidee = new ArrayList<>(); 
		
		
	   String find_fk ="SELECT id FROM categories WHERE  = ?; " ;
	   int Fk_categorie ;
	   Connection connexion = null;
	   PreparedStatement preparedStatement = null;
	   ResultSet resultSet = null;	
	   
	   try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, find_fk, category );
	        resultSet  = preparedStatement.executeQuery();
	        Fk_categorie = resultSet.getInt("id");
	        
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	    	 //ClosingAll( resultSet, preparedStatement, connexion );	
	    }

	   
	   String find_id = "SELECT * FROM ide WHERE Fk_categorie = ?;" ;

	   try {
	
	        preparedStatement = initRequestPrepare( connexion, find_id, Fk_categorie );
	        resultSet  = preparedStatement.executeQuery();

	    
	   while ( resultSet.next() ) {
           
   	       int id = resultSet.getInt("id");
           String titre = resultSet.getString("titre");
           String description = resultSet.getString("description");
           String business_plan = resultSet.getString("business_plan") ;
           float budget = resultSet.getFloat("budget") ;

          idee ide = new idee(id, titre, description, business_plan,budget);
          listeidee.add(ide) ;  
   	
   }
	 }catch ( SQLException e ) {
	        throw new DAOException( e );
	   
	}
	return listeidee;
}
	
	
	
	
	 public P_i p_i(idee idee) {
	       
	
			    final String porteur = "SELECT * FROM p_i WHERE id = ? ;";
			    	
			    Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;
			    
			 
			   
			   
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        
			        preparedStatement = initRequestPrepare( connexion, porteur,idee.getFK_porteur_ide());
			        resultSet = preparedStatement.executeQuery();
			   
			       
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        if ( resultSet.next() ) {
			        
			                String nom = resultSet.getString("nom");
			                String prenom = resultSet.getString("prenom");
			                String m_p = resultSet.getString("m_p");
			                String email = resultSet.getString("email") ;
			                String photo = resultSet.getString("photo") ;

			             return    new P_i( nom, prenom, email,m_p,photo);
			        } 
			        	
			        
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        //ClosingAll( resultSet, preparedStatement, connexion );
			    }

			 //   int nombreElements = listeInvestisseur.size();
			 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
			    
			
		//	return new P_i( nom, prenom, email,m_p,photo) ;
		 
		 
		 return null ;
	    }
	
	
	 public categorye cat(int fkPorteurIdee) {
	       
			
		    final String categorie = "SELECT * FROM categorie WHERE id = ? ;";
		    	
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    
		    categorye cat = null ;
		   
		   
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, categorie,fkPorteurIdee);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		           
		                String Designation = resultSet.getString("Designation");
		            
		                cat = new categorye( Designation);
		               
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		 //   int nombreElements = listeInvestisseur.size();
		 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
		    
		 return cat ;
	 
	 
	 
 }
	
	}
