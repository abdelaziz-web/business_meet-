package DAO;

import java.util.List;
import metier.P_i;

public interface p_i_interface {
	 void create( P_i p_i  ) throws DAOException;
	 public P_i find (String email, String mot_pass) throws DAOException ;
	 List<P_i> getall() throws DAOException;
	 void update( P_i inv) throws DAOException;
	 void delete( int id) throws DAOException;
	  
}



