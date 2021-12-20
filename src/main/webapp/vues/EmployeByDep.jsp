<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
h1>Liste des Employés</h1>
<h2>Département : ${departement.nom}  </h2>
<table border="1">
<thead><tr><th>ID</th><th>Nom</th><th>Fonction</th></thead>
<tbody>
	

<c:forEach items="${employesDept}" var="employe">
	<tr>
		<td> ${employe.id}</td>
		<td> ${employe.nom}</td>
		<td> ${employe.fonct}</td>

	</tr>
</c:forEach>
</table>
<a href="ajoutEmploye">Ajouter un Employee</a>

</body>
</html>