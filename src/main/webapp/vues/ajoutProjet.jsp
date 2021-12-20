<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un Projet</title>
<h1>Ajouter un Projet</h1>
</head>
<body>
	<form:form action="${cxt}/saveProjet" modelAttribute="projet">
		<table>
			<tr>
				<label>Titre<input type="text" id="Utilisateur" name="titre" /></label>
			</tr>
			<tr><td>
				<label >Etat:</label>

				<select name="etat" id="etat">
					<option value="">--Non lance--</option>
					<option value="1">Non Lancé</option>
					<option value="2">Lancé</option>
					
				</select>
				

			</td></tr>
			
			<tr>

				<td>Departement:</td>
				<td><form:select path="departement.id" items="${departements}"
						itemValue="id" itemLabel="nom" /></td>
			</tr>

			<td colspan="2"><input class="btn btn-warning" type="submit"
				value="enregistrer" /></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>