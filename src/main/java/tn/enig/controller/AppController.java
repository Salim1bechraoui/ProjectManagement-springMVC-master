package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enig.Dao.GestionImp;
import tn.enig.Model.*;

@Controller
public class AppController {
	@Autowired 
	GestionImp g;

	@RequestMapping(value="/Home", method = RequestMethod.GET)
	public String Departement(Model m ) {
		List<Departement> LD = g.AfficherListDep();
		
		m.addAttribute("deps",LD);
		return "Home";
	}
	@RequestMapping(value = "/employes/dept/{num}", method = RequestMethod.GET)
	public String getAllEmployesByDept(Model model, @PathVariable("num") int num) {
		List<Employe> employeeList = g.AfficherListEmp(num);
		Departement departement = (Departement) g.AfficherListEmpProj(num);
		model.addAttribute("departement",departement);
		model.addAttribute("employesDept",employeeList);
		return "employes";
}
	@RequestMapping(value = "/projets/{num}", method = RequestMethod.GET)
	public String getAllProjets(Model model, @PathVariable("num") int numDep) {
		List <Projet> LP = g.AfficherListProj(numDep);
		model.addAttribute("projets",LP);
		return "projets";
}
	@RequestMapping(value = "/employes/proj/{num}", method = RequestMethod.GET)
	public String getAllEmployesByProj(Model model, @PathVariable("num") int num) {

		List<Employe> employeeList = g.AfficherListEmpProj(num);


		model.addAttribute("employesProj",employeeList);
		return "employeByProj";
}
	@RequestMapping(value = "/ajoutProjet", method = RequestMethod.GET)
	public String ajoutProjet(Model model) {
		Projet projet = new Projet() ; 
		List<Departement> listD = g.AfficherListDep();
		model.addAttribute("projet", projet);
		model.addAttribute("departements", listD);
		return ("addProjet");
		

}
	@RequestMapping(value="saveProjet", method = RequestMethod.POST)
	public String saveProjet(Model model, @ModelAttribute("projet") Projet p) {
		g.AjoutPjt(p);
		return ("redirect:/Home");
}


	@RequestMapping(value="/ajoutEmploye", method = RequestMethod.GET)
	public String addEmploye(Model model) {
		Employe employee = new Employe();
		List<Departement> listD = g.AfficherListDep(); 
		model.addAttribute("departements", listD);
		model.addAttribute("employe", employee);
		return ("addEmploye");
}


	@RequestMapping(value="saveEmploye", method = RequestMethod.POST)
	public String saveEmploye(Model model, @ModelAttribute("employe") Employe e) {
		g.AjoutEmplye(e);
		return ("redirect:/home");
}
}
