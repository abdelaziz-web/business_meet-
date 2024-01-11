package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.Investisseur;


public class InvesstisseurImpl  implements  Inv_interface {

	private DAOFactory        daoFactory;
	

    public InvesstisseurImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
        
    }
    
	public InvesstisseurImpl() {
		// TODO Auto-generated constructor stub
	}

	 
	  	    
       private static Investisseur map( ResultSet resultSet ) throws SQLException {
    	   
    	Investisseur inv = new Investisseur()  ;
    	   
    	inv.setid((int)resultSet.getInt( "id" ) );
    	inv.setNom( resultSet.getString( "nom" ) );
    	inv.setEmail( resultSet.getString( "email" ) );
    	inv.setPrenom( resultSet.getString( "prenom" ) );
    	inv.setmotdepass( resultSet.getString( "m_p" ) );
    	
   		return inv;
   		}
       
       
   	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
   	    for ( int i = 0; i < objets.length; i++ ) {
   	        preparedStatement.setObject( i + 1, objets[i] );
   	    }
   	    return preparedStatement;
   	}


	
	

	@Override
	public void create(Investisseur inv) throws DAOException {
		// TODO Auto-generated method stub
			
			
		       final String SQL_INSERT = "INSERT INTO  inv (nom,prenom,email,m_p) VALUES (?,?,?,? ) ;"  ;
		       			
				
				Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			   // ResultSet resultSet = null;
			    
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_INSERT,inv.getNom()  , inv.getPrenom(),inv.getEmail() ,
			        inv.getMotdepasse() );
			       preparedStatement.execute();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			    	 //ClosingAll( resultSet, preparedStatement, connexion );	
			    }
	}

	
public List<Investisseur> getall() throws DAOException{
		
		final String SQL_SELECT = "SELECT * FROM inv " ;
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Investisseur inv = null;
	    ArrayList<Investisseur> listeInvestisseur = new ArrayList<>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	            
	        	    int id = resultSet.getInt("id");
	                String nom = resultSet.getString("nom");
	                String prenom = resultSet.getString("prenom");
	                String email = resultSet.getString("email") ;
	                String mot_pass = resultSet.getString("m_p") ;
	                
	                Investisseur free_1 = new Investisseur(id, nom, prenom, email,mot_pass);
	                listeInvestisseur.add(free_1) ;  
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	 //   int nombreElements = listeInvestisseur.size();
	 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
	    
	    return listeInvestisseur ;
	    
 
	}
	
	
	
	@Override
	public Investisseur find(String email, String mot_pass) throws DAOException {
		  
		    Investisseur  inv =  new Investisseur()  ;
		
		    final String SQL_SELECT_PAR_NOM = "SELECT id, nom, prenom,email,m_p FROM inv WHERE email = ? and m_p = ? ";
		    Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		 //   PersonBean personBean = null;

		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, email, mot_pass );
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		            inv = map( resultSet );     
		        }else {
		        	inv = null ;
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		    return inv;       
	}
		
	public Investisseur findbyid(int id) throws DAOException {
		
        final String SQL_SELECT = "SELECT * FROM inv WHERE id = ?" ;
		
		Connection  connexion = null ;
		PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Investisseur inv = new Investisseur() ;
				
		try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT,id );
	        resultSet =  preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	            inv = map( resultSet );
	            }
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }
	    
	    return inv;       
}
		
	@Override
	public void update( Investisseur inv ) throws DAOException {
		// TODO Auto-generated method stub
		
	
		
		final String SQL_SELECT_Update = "UPDATE inv SET nom = ?, prenom = ?, email = ?, m_p = ?  WHERE id = ?";
		
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	   // ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_Update , inv.getNom() , inv.getPrenom(),
	        inv.getEmail(),	inv.getMotdepasse(),    inv.getid() );
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
		// TODO Auto-generated method stub


	    	final String SQL_SELECT_DELETE = "DELETE FROM inv WHERE id = ?" ;
	    			
	    			
	    			Connection connexion = null;
	    		    PreparedStatement preparedStatement = null;
	    		   // ResultSet resultSet = null;
	    		    
	    		    try {
	    		        /* Récupération d'une connexion depuis la Factory */
	    		        connexion = daoFactory.getConnection();
	    		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_DELETE, String.valueOf(id) );
	    		        preparedStatement.execute();
	    		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	    		        
	    		    } catch ( SQLException e ) {
	    		        throw new DAOException( e );
	    		    } finally {
	    		        //ClosingAll( resultSet, preparedStatement, connexion );
	    		    }
			
		}
	
	
	
	public Boolean findbyemail(String email) throws DAOException {
		// TODO Auto-generated method stub
		
		

		final String SQL_SELECT = "SELECT COUNT(*) AS TOTAL FROM inv WHERE email = ?" ;	    			
	    			
	    			Connection connexion = null;
	    		    PreparedStatement preparedStatement = null;
	    		    ResultSet resultSet = null;
	    		   // ResultSet resultSet = null;
	    		   
	    		    try {
	    		        /* Récupération d'une connexion depuis la Factory */
	    		        connexion = daoFactory.getConnection();
	    		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT, email );
	    		        resultSet = preparedStatement.executeQuery();
	    		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	    		        boolean inv_exist = resultSet.next() ;
	    		        int nbr  = resultSet.getInt("TOTAL") ;
	    		         
	    		        if(nbr > 0)  return true ;
	    		        
	    		        else return false ;
	    		         
	    		         
	    		        
	    		    } catch ( SQLException e ) {
	    		        throw new DAOException( e );
	    		    } finally {
	    		        //ClosingAll( resultSet, preparedStatement, connexion );
	    		    }
	    		    
					
		}
	
		
		
	}










	
	
	


