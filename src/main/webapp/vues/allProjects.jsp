<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>Liste des Projets</h1>
<h2>Département : ${departement.nom}  </h2>
<body>
<table border="1">
<thead><tr><th>ID</th><th>Titre</th><th>etat</th></thead>
<tbody>

<c:forEach items="${projets}" var="projet">
<tr>
<td> ${projet.id}</td>
<td> ${projet.titre}</td>
<td> ${projet.etat}</td>

<td><a href='${cxt}/employes/proj/${projet.id}'>Liste des employees</a></td>


</tr>
</c:forEach>
</table>
<a href='${cxt}/ajoutProjet'>Ajouter un projet</a>

</body>
</html>