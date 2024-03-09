package metier;

public class noti {

	
	int id ;
	String	date ;
	int status ;	
	int id_inv	;
	int id_ide	;
	int id_pi ;
	

	public noti( String date, int status, int id_inv, int id_ide, int id_pi) {
		
		this.date = date;
		this.status = status;
		this.id_inv = id_inv;
		this.id_ide = id_ide;
		this.id_pi = id_pi;
	}
	
	
public noti( ) {
		
	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public int getId_pi() {
		return id_pi;
	}
	public void setId_pi(int id_pi) {
		this.id_pi = id_pi;
	}	
	 
	
}
