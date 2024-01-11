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
<%@ page import="metier.Investisseur" %>
<%@ page import="metier.P_i" %>

<%@ include file="navbar.jsp" %>
<h1>Formulaire - Porteur d'idée</h1>
    <form method="post" action="p_i_crud">
        
        <input type="hidden"  name="type"  value="Modification"  ><br><br>   
   
        <input type="hidden" id="id" name="id"  value="${inv.id}"  ><br><br>
        
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom"  value="${inv.nom}"  ><br><br>
        
        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="prenom" value="${inv.prenom}"  ><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"  value="${inv.email}"  ><br><br>
        
    <label for="motDePasse">Mot de passe:</label>
    <input type="password" id="motDePasse" name="motDePasse"  value="${inv.m_p}"  ><br><br>
      
    <input type="submit" value="Enregistrer" class="btn btn-primary mb-3">  
       
    </form>




</body>
</html>
