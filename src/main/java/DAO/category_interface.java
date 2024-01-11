package DAO;
import java.util.List;
import metier.categorye;

public interface category_interface {
	
    void create(categorye category);

    void delete(int categoryId);
   
    List<categorye> getAll();
	
}
