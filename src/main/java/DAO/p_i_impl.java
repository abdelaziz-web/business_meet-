package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.P_i;




public  class p_i_impl  implements  p_i_interface  {
	
		private DAOFactory        daoFactory;
		

	    public p_i_impl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	        
	    }
	    
		public p_i_impl() {
			// TODO Auto-generated constructor stub
		}

		 
		  	    private static P_i map( ResultSet resultSet ) throws SQLException {
	    	   
               P_i p_i = new P_i()  ;
	    	   
	    	   p_i.setId((int)resultSet.getInt( "id" ) );
	    	   p_i.setNom( resultSet.getString( "nom" ) );
	    	   p_i.setPrenom( resultSet.getString( "prenom" ) );
	    	   p_i.setEmail( resultSet.getString( "email" ) );
	    	   p_i.setM_p( resultSet.getString( "m_p" ) );
	    	   p_i.setPhoto( resultSet.getString( "photo" ) );
	    	
	   		return p_i;
	   		}
	       
	       
	   	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	   	    for ( int i = 0; i < objets.length; i++ ) {
	   	        preparedStatement.setObject( i + 1, objets[i] );
	   	    }
	   	    return preparedStatement;
	   	}


		
		

		@Override
		public void create(P_i p_i) throws DAOException {
			// TODO Auto-generated method stub
				
				
			       final String SQL_INSERT = "INSERT INTO  p_i (nom,prenom,email,m_p,photo) VALUES (?,?,?,?,?) ;"  ;
			       			
					
					Connection connexion = null;
				    PreparedStatement preparedStatement = null;
				   // ResultSet resultSet = null;
				    
				    try {
				        /* Récupération d'une connexion depuis la Factory */
				        connexion = daoFactory.getConnection();
				        preparedStatement = initRequestPrepare( connexion, SQL_INSERT
				        		,p_i.getNom()
				        		,p_i.getPrenom()
				        		,p_i.getEmail()
				                ,p_i.getM_p()
				                ,p_i.getPhoto());
				       preparedStatement.execute();
				        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
				        
				    } catch ( SQLException e ) {
				        throw new DAOException( e );
				    } finally {
				    	 //ClosingAll( resultSet, preparedStatement, connexion );	
				    }
		 }

		
	public List<P_i> getall() throws DAOException{
			
			final String SQL_SELECT = "SELECT * FROM p_i " ;
			
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    P_i p_i = null;
		    ArrayList<P_i> listep_i = new ArrayList<>();
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
		                String photo = resultSet.getString("photo") ;
		                
		                p_i = new P_i( id,nom,  prenom,  email,  mot_pass,  photo );
		                
		                listep_i.add(p_i) ;  
		        	
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		 //   int nombreElements = listeInvestisseur.size();
		 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
		    
		    return listep_i ;
		    
	 
		}
		
		
		
		@Override
		public P_i find(String email, String mot_pass) throws DAOException {
			  
			    P_i  p_i =  new P_i()  ;
			
			    final String SQL_SELECT_PAR_NOM = "SELECT id, nom, prenom,email,m_p,photo  FROM p_i WHERE email = ? and m_p = ? ";
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
			        	p_i = map( resultSet );     
			        }else {
			        	p_i = null ;
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        //ClosingAll( resultSet, preparedStatement, connexion );
			    }

			    return p_i;       
		}
		
		
			
		public P_i findbyid(int id) throws DAOException {
			
	        final String SQL_SELECT = "SELECT * FROM p_i WHERE id = ?" ;
			
			Connection  connexion = null ;
			PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		    
		    P_i p_i = new P_i() ;
					
			try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion , SQL_SELECT, id );
		        resultSet =  preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        if ( resultSet.next() ) {
		            p_i = map( resultSet );
		            }
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
		    
		    return p_i;       
	}
			
		@Override
		public void update( P_i p_i ) throws DAOException {
			// TODO Auto-generated method stub
			
					
			final String SQL_SELECT_Update = "UPDATE p_i SET nom = ?, prenom = ?, email = ?, m_p = ?, photo =? WHERE id = ?";
			
			
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		   // ResultSet resultSet = null;
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_Update ,
		        		p_i.getNom(),
		        		p_i.getPrenom(),
		                p_i.getEmail(),
		                p_i.getM_p(),
		                p_i.getPhoto(),
		                p_i.getId()
		                );
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


		            	final String SQL_SELECT_DELETE = "DELETE FROM p_i WHERE id = ?" ;
		    			
		    			
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
			
			

			final String SQL_SELECT = "SELECT COUNT(*) AS TOTAL FROM p_i WHERE email = ?" ;	    			
		    			
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
