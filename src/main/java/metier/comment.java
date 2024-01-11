package metier;
import java.util.Date;


public class comment {
	
	private int  id ;
	private Integer id_inv ;
	private int id_ide ;
	private Integer id_p_i ;
	private String date ;
	private String description ;
	
	
	
	public comment(Integer id_inv, int id_ide, Integer id_p_i, String date2, String description) {
		this.id_inv = id_inv;
		this.id_ide = id_ide;
		this.id_p_i = id_p_i;
		this.date = date2;
		this.description = description;
	}
	
		
	public comment() {
		super();
	}

	public comment( int id ,Integer id_inv, int id_ide, Integer id_p_i, String date2, String description) {
		this.id = id ;
		this.id_inv = id_inv;
		this.id_ide = id_ide;
		this.id_p_i = id_p_i;
		this.date = date2;
		this.description = description;
	}
   



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_inv() {
		return id_inv;
	}
	public void setId_inv(int id_inv) {
		this.id_inv = id_inv;
	}
	public int getId_ide() {
		return id_ide;
	}
	public void setId_ide(int id_ide) {
		this.id_ide = id_ide;
	}
	public int getId_p_i() {
		return id_p_i;
	}
	public void setId_p_i(int id_p_i) {
		this.id_p_i = id_p_i;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
