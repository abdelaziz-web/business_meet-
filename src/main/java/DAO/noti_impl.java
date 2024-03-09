package DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.Investisseur;
import metier.noti;


public class noti_impl {



	private DAOFactory        daoFactory;
	

    public noti_impl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
        
    }
    
	public noti_impl() {
		// TODO Auto-generated constructor stub
	}

	 
	  	    
	private static noti map(ResultSet resultSet) throws SQLException {
	    noti noti_ = new noti();

	    noti_.setId(resultSet.getInt("id"));
	    noti_.setDate(resultSet.getString("date"));
	    noti_.setStatus(resultSet.getInt("status"));
	    noti_.setId_inv(resultSet.getInt("id_inv"));
	    noti_.setId_ide(resultSet.getInt("id_ide"));
	    noti_.setId_pi(resultSet.getInt("id_pi"));

	    return noti_;
	}
		
       
       
   	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
   	    for ( int i = 0; i < objets.length; i++ ) {
   	        preparedStatement.setObject( i + 1, objets[i] );
   	    }
   	    return preparedStatement;
   	}


	public void create(noti noti_1) throws DAOException {
		// TODO Auto-generated method stub
			
		       final String SQL_INSERT = "INSERT INTO  notfication (date,status,id_inv,id_ide,id_pi) VALUES (?,?,?,?,?);"  ;
		       			
				Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			   // ResultSet resultSet = null;
			    
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_INSERT,
			        		noti_1.getDate(),
			        		noti_1.getStatus(),
			        		noti_1.getId_inv(),
			        		noti_1.getId_ide(),
			        		noti_1.getId_pi()
			        		);
			       preparedStatement.execute();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			    	 //ClosingAll( resultSet, preparedStatement, connexion );	
			    }
	}
	
	
	public List<noti> selection(int id_pi, int status) throws DAOException {
		// TODO Auto-generated method stub
			
		       final String SQL_ = "SELECT * FROM notfication WHERE status = ? AND id_pi = ?;"  ;
		       			
		       final String SQL_1 = "SELECT * FROM notfication WHERE  id_inv = ?;"  ;

		       Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;
			
			    noti noti_ = new noti() ;
			    
			    List<noti> noti_list = new ArrayList<>();
			    
			    if(status != -1) {
			    
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_, status, id_pi );
			        resultSet = preparedStatement.executeQuery();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        while ( resultSet.next() ) {
			            noti_ = map( resultSet );
			            noti_list.add(noti_);
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        //ClosingAll( resultSet, preparedStatement, connexion );
			    }

                
			    }else {
	            
			    	 try {
					        /* Récupération d'une connexion depuis la Factory */
					        connexion = daoFactory.getConnection();
					        preparedStatement = initRequestPrepare( connexion, SQL_1, id_pi );
					        resultSet = preparedStatement.executeQuery();
					        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
					        while ( resultSet.next() ) {
					            noti_ = map( resultSet );
					            noti_list.add(noti_);
					        }
					    } catch ( SQLException e ) {
					        throw new DAOException( e );
					    } finally {
					        //ClosingAll( resultSet, preparedStatement, connexion );
					    }

			    }
	
			    return noti_list;
	            	
	            }

	
	/*UPDATE notfication SET status = 0 WHERE id_inv = 19 AND id_pi = 1 AND id_ide = 5;*/
	
	
	
	public void update(int status ,int id_inv, int id_pi, int id_ide) throws DAOException {

			
		       final String SQL_ = "UPDATE notfication SET status = ? WHERE id_inv = ? AND id_pi = ? AND id_ide = ?;"  ;
		       			
		       Connection connexion = null;
		       PreparedStatement preparedStatement = null;
		      // ResultSet resultSet = null;
		       
		       try {
		           /* Récupération d'une connexion depuis la Factory */
		           connexion = daoFactory.getConnection();
		           preparedStatement = initRequestPrepare( connexion, SQL_, status ,id_inv,
		           		id_pi, id_ide );
		          preparedStatement.execute();
		           /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		           
		       } catch ( SQLException e ) {
		           throw new DAOException( e );
		       } finally {
		       	 //ClosingAll( resultSet, preparedStatement, connexion );	
		       } 
	}
	
}