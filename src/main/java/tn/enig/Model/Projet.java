package tn.enig.Model;

import java.util.List;

public class Projet {
	private int id;
	private String titre;
	private String etat;
	private Departement dp;
	
	
	public Projet(int id, String titre, String etat, Departement dp) {
		super();
		this.id = id;
		this.titre = titre;
		this.etat = etat;
		this.dp = dp;
	}
	public Projet() {
		super();
	
	}
	
	private List<Employe> l ;
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
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Departement getDp() {
		return dp;
	}
	public void setDp(Departement dp) {
		this.dp = dp;
	}
	public List<Employe> getL() {
		return l;
	}
	public void setL(List<Employe> l) {
		this.l = l;
	}

}
