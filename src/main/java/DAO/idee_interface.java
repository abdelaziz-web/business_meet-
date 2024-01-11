package DAO;


import java.util.List;
import metier.idee;

public interface idee_interface {

	 void create( idee idee_1 ) throws DAOException;
	 public idee find() throws DAOException ;
	 public List<idee> getall() throws DAOException;
	 void update( idee idee_1) throws DAOException;
	 void delete( int id) throws DAOException;
	 public List<idee> getwithcatego(String category ) throws DAOException;
		
}
