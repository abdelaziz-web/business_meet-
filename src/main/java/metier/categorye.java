package metier;

public class categorye {
	
	private int  id ;
	private String  Designation ;
	

	public categorye(int id, String designation) {
		this.id = id;
		Designation = designation;
	}

	public categorye() {
		
	}
	
	public categorye(String designation) {
		Designation = designation;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}

}
