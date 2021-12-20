<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ajouter un Employe</h1>
<form:form  action="${cxt}/saveEmploye" modelAttribute="employe" >
    <table>
        <tr>
            <td><label>nom et prenom<input type="text" name="nom" /></label></td>
          </tr>
          <tr>
            <td>Fonction:</td>
            <td><form:select path="fonction" >
            <form:option value="Responsable" label="Responsable" />
            <form:option value="Manager" label="Manager" />
            
            </form:select>
          </tr>
          <tr>
         
            <td>Departement:</td>
            <td>
            <form:select path="departement.id" items="${departements}"
            itemValue="id" itemLabel="nom" />
            
       
            </td>
          </tr>
               <tr>
         
            <td>Projet:</td>
            <td>
            <form:select path="projet.id" items="${projets}"
            itemValue="id" itemLabel="titre" />
            
       
            </td>
          </tr>

            <td colspan="2">
                  <input class="btn btn-warning" type="submit" value="enregistrer" />
            </td>
          </tr>
    </table>
</form:form>
  </div>
</body>
</html>