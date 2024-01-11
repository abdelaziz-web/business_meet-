<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<%@ include file="boots.jsp" %>

</head>
<body>

<div id="ajax"  > 

<h1> Tableau des investisseurs  </h1>
        
        Nombre d'éléments dans la liste : ${invs.size()}
        
       <table border="3" class="table">
    <tr>
        <th>id</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>email</th>
        <th>mot_passe</th>
        <th>Action_1</th>
        <th>Action_2</th>
    </tr>
    <c:forEach items="${invs}" var="inv">
        <tr>
            <td>${inv.id}</td>
            <td>${inv.nom}</td>
            <td>${inv.prenom}</td>
            <td>${inv.email}</td>
            <td>${inv.motdepasse}</td>
            <td>
                <form action="servlet" method="get">
                    <input type="hidden" name="id" value="${inv.id}">
                    <input type="submit" name="type" value="Modifier">
                </form>
            </td>
            <td>
                <form action="servlet" method="get">
                    <input type="hidden" name="id" value="${inv.id}">
                    <input type="submit" name="type"  value="Supprimer">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
 
 
  

</body>
</html>