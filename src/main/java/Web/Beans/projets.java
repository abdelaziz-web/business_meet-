package Web.Beans;

public class projets {

private int  fk_p_i ;
private int    id_ide  ;
private String titre ;
private String description;
private String porteur ;	
private String categorie ;
private String b_p ;


public projets(int id_ide, String titre, String description, String porteur, String categorie, String b_p) {
	this.id_ide = id_ide ;
	this.titre = titre;
	this.description = description;
	this.porteur = porteur;
	this.categorie = categorie;
	this.b_p = b_p;
}


public projets(int fk_p_i, int id_ide, String titre, String description, String porteur, String categorie, String b_p) {
	this.setFk_p_i(fk_p_i) ;
	this.id_ide = id_ide ;
	this.titre = titre;
	this.description = description;
	this.porteur = porteur;
	this.categorie = categorie;
	this.b_p = b_p;
}








public projets() {

}


public int getId_ide() {
	return id_ide;
}

public void setId_ide(int id_ide) {
	this.id_ide = id_ide;
}

public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getB_p() {
	return b_p;
}
public void setB_p(String b_p) {
	b_p = b_p;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPorteur() {
	return porteur;
}
public void setPorteur(String porteur) {
	this.porteur = porteur;
}
public String getCategorie() {
	return categorie;
}

public void setCategorie(String categorie) {
	this.categorie = categorie;
}


public int getFk_p_i() {
	return fk_p_i;
}


public void setFk_p_i(int fk_p_i) {
	this.fk_p_i = fk_p_i;
}




}
