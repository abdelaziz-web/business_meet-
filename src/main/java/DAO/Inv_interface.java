package DAO;

import java.util.List;
import metier.Investisseur;

public interface Inv_interface {
	 void create( Investisseur inv ) throws DAOException;
	 public Investisseur find (String email, String mot_pass) throws DAOException ;
	 List<Investisseur> getall() throws DAOException;
	 void update( Investisseur inv) throws DAOException;
	 void delete( int id) throws DAOException;
	  
}





	