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
        
        Nombre d'éléments dans la liste : ${p_i.size()}
        
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
    <c:forEach items="${p_i}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.nom}</td>
            <td>${p.prenom}</td>
            <td>${p.email}</td>
            <td>${p.m_p}</td>
            <td>
                <form action="p_i_crud" method="get">
                    <input type="hidden" name="id" value="${p.id}">
                    <input type="submit" name="type" value="Modifier">
                </form>
            </td>
            <td>
                <form  id="deleteForm" action="p_i_crud" method="get"  >
                    <input type="hidden" name="id"  id="userId" value="${p.id}">
                    <input type="submit" name="type"   value="Supprimer">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
 
 
 
 
 <!--  
 
 <script>
function deleteUser(event) {
	
    event.preventDefault(); // Empêche le formulaire d'être soumis normalement

    // Obtenez les données du formulaire
    var formData =  document.getElementById("deleteForm");

   // var userId = document.getElementById("userId").value;
   
   var userId = 6 ;
    
    // Créez une requête DELETE avec XMLHttpRequest
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", "p_i_crud?id=" + encodeURIComponent(userId), true);

    xhr.onload = function() {
        if (xhr.status == 200) {
            console.log("DELETE request succeeded with response:", xhr.responseText);
        } else {
            console.error("DELETE request failed with status:", xhr.status);
        }
    };

    xhr.send();    
      
}
</script>
-->
  
  
</body>
</html>