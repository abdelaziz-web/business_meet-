package metier;

public class P_i {

	private int id ;
	private String nom ;
	private String prenom ;
	private String email ;
	private String m_p ;
	private String photo ;
	
		
	public P_i(String nom, String prenom, String email, String m_p, String photo) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.m_p = m_p;
		this.photo = photo;
	}
	
	public P_i( int id ,String nom, String prenom, String email, String m_p, String photo) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.m_p = m_p;
		this.photo = photo;
	}
	
	public P_i() {
		
	}
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getM_p() {
		return m_p;
	}
	public void setM_p(String m_p) {
		this.m_p = m_p;
	}
	
	
}
