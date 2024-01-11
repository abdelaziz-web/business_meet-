package DAO;

import java.util.List;
import metier.comment;

public interface com_inter {
	
    void create(comment com);
    
    List<comment> getAll( int id_ide );
    	
}
