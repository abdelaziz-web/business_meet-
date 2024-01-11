package metier;

public class idee {
	
	private int id ;
	private String titre;
	private String description;
	private String business_plan1 ;
	private int FK_porteur_ide ;
	private int Fk_categorie1 ;
	private float budget ;
	
	

	public idee(int id, String titre, String description, String business_plan1, float budget) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.business_plan1 = business_plan1;
		this.budget = budget;
	}
	
	public idee(int id, String titre, String description, String business_plan1, float budget, int  FK_porteur_ide ,int Fk_categorie1 ) {
		this.id = id ;
		this.titre = titre;
		this.description = description;
		this.business_plan1 = business_plan1;
		this.budget = budget;
		this.FK_porteur_ide = FK_porteur_ide ;
		this.Fk_categorie1 = Fk_categorie1 ;
	}
	
	public idee( String titre, String description, String business_plan1, float budget, int  FK_porteur_ide ,int Fk_categorie1 ) {

		this.titre = titre;
		this.description = description;
		this.business_plan1 = business_plan1;
		this.budget = budget;
		this.FK_porteur_ide = FK_porteur_ide ;
		this.Fk_categorie1 = Fk_categorie1 ;
	}
	
	
	public idee( ) {
	
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBusiness_plan1() {
		return business_plan1;
	}

	public void setBusiness_plan1(String business_plan1) {
		this.business_plan1 = business_plan1;
	}

	public int getFK_porteur_ide() {
		return FK_porteur_ide;
	}

	public void setFK_porteur_ide(int fK_porteur_ide) {
		FK_porteur_ide = fK_porteur_ide;
	}

	public int getFk_categorie1() {
		return Fk_categorie1;
	}

	public void setFk_categorie1(int fk_categorie1) {
		Fk_categorie1 = fk_categorie1;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}
	
	
	
	
}
