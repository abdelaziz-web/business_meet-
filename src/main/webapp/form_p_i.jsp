<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
    <title>Formulaire - Porteur d'idée</title>
  
<%@ include file="boots.jsp" %>

</head>
<body>

 <%@ include file="navbar.jsp" %>
    <div class="container my-5">
        <div class="row">
        
            <div class="col-md-6 mx-auto text-center">
      <h4>Formulaire d'Informations</h4>
    <h1>Formulaire - Porteur d'idée</h1>
    <form method="post" action="p_i_crud">
        
        <input type="hidden"  name="type"  value="Ajouter"  ><br><br>   
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom"  required><br><br>
        
        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="prenom" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"   required><br><br>
        <c:out value="${requestScope.message}" /> <br><br>
        
        <label for="motDePasse">Mot de passe:</label>
        <input type="password" id="motDePasse" name="motDePasse"  required><br><br>
        
        <input type="submit" value="Enregistrer" class="btn btn-primary mb-3">
    </form>
   </div>
     </div>
       </div>
       
            
</body>
</html>
