package tn.enig.Dao;

import java.util.List;

import tn.enig.Model.*;

public interface IGestion {
	public List<Departement> AfficherListDep();
	public List<Employe> AfficherListEmp(int id);
	public List<Projet> AfficherListProj(int id);
	public List<Employe> AfficherListEmpProj(int id);
	public void AjoutPjt(Projet p);
	public void AjoutEmplye(Employe e);
	public Projet GetProjById(int id);
	public Departement GetDepById (int id);
	
}
