package metier;



public class Investisseur {
    // Attributs
	private int    id ;
    private String email;
    private String nom;
    private String prenom;
    private String motdepasse;

    // Constructeur
    public Investisseur(int id,String nom, String prenom, String email, String motdepasse) {
    	this.id = id ;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
    }
    
    public Investisseur(String nom, String prenom, String email, String motdepasse) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.motdepasse = motdepasse;
    }
    
    public Investisseur() {
   
    }

    
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
    
       
    // Getters et Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getMotdepasse() {
        return motdepasse;
    }
    
    public void setmotdepass(String mdp ) {
        motdepasse = mdp;
    }
}
   
