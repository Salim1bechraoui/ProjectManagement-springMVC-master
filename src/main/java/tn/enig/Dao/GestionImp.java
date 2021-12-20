package tn.enig.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import tn.enig.Model.*;

@Repository
public class GestionImp implements IGestion {
	DataSource data;

	public List<Departement> AfficherListDep() {
		List<Departement> D = null;
		try {
			Connection con = data.getConnection();
			PreparedStatement pr = con.prepareStatement("select * from Departement");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Departement d = new Departement(rs.getInt("id"), rs.getString("nom"));
				D.add(d);
			}
		} catch (Exception e) {
			System.out.println("erreur");
		}
		return D;
	}

	public List<Employe> AfficherListEmp(int id) {
		List<Employe> E = null;
		try {
			Connection con = data.getConnection();
			PreparedStatement pr = con.prepareStatement("select * from Employe where Departement.getId = id");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Projet p = GetProjById(rs.getInt("idPjt"));
				Departement dp = GetDepById(rs.getInt("idDep"));
				Employe d = new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("fct"), p, dp);
				E.add(d);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return E;
	}

	public List<Projet> AfficherListProj(int id) {
		List<Projet> E = null;
		try {
			Connection con = data.getConnection();
			PreparedStatement pr = con.prepareStatement("select * from Projet where Departement.getId = id");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Departement dp = GetDepById(rs.getInt("idDep"));
				Projet d = new Projet(rs.getInt("id"), rs.getString("nom"), rs.getString("etat"), dp);
				E.add(d);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return E;

	}

	public List<Employe> AfficherListEmpProj(int id) {

		return null;
	}

	public void AjoutPjt(Projet p) {
		try {
			Connection con = data.getConnection();
			PreparedStatement pr = con.prepareStatement("INSERT INTO Projet (NULL,?,?,?)");
			pr.setString(1, p.getTitre());
			pr.setString(2, p.getEtat());
			pr.setInt(3, p.getDp().getId());
			pr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void AjoutEmplye(Employe e) {
		try {
			Connection cnx = data.getConnection();
			String req = "INSERT INTO Employe values (NULL,?,?,?,?)";
			PreparedStatement pr = cnx.prepareStatement(req);
			pr.setString(1, e.getNom());
			pr.setString(2, e.getFct());
			pr.setObject(3, e.getDp().getId());
			pr.setObject(4, e.getP().getId());
			pr.executeUpdate();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

	}

	public Projet GetProjById(int id) {

		Projet p = null;
		try {
			Connection con = data.getConnection();
			PreparedStatement pr = con.prepareStatement("select * from Projet where Projet.getId = id");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Departement d = GetDepById(rs.getInt("idDep"));
				Projet c = new Projet(rs.getInt("id"), rs.getString("titre"), rs.getString("etat"), d);
				p = c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

	public Departement GetDepById(int id) {
		Departement d = null;
		try {
			Connection con = data.getConnection();
			PreparedStatement pr = con.prepareStatement("select * from Projet where Projet.getId = id");
			ResultSet rs = pr.executeQuery();
			while (rs.next()) {
				Departement c = new Departement(rs.getInt("id"), rs.getString("non"));
				d = c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return d;
	}

}
