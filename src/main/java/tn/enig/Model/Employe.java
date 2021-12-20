package tn.enig.Model;

public class Employe {
	private int id;
	private String nom;
	private Projet p;
	private Departement dp;
	String fct;
	
	
	
	public Employe(int id, String nom,String fct, Projet p, Departement dp) {
		super();
		this.id = id;
		this.nom = nom;
		this.p = p;
		this.dp = dp;
		this.fct=fct;
	}
	public Employe() {
		super();
		
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Projet getP() {
		return p;
	}



	public void setP(Projet p) {
		this.p = p;
	}



	public Departement getDp() {
		return dp;
	}



	public void setDp(Departement dp) {
		this.dp = dp;
	}



	public String getFct() {
		return fct;
	}



	public void setFct(String fct) {
		this.fct = fct;
	}
	
}
