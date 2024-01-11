<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>


    <title>Formulaire - Porteur d'idée</title>
  
<%@ include file="boots.jsp" %>
    
     <style>
        .centered {
            width: 300px; /* Largeur de votre choix */
            margin: 0 auto; /* Marge automatique sur les côtés pour centrer */
            background-color: lightgray; /* Couleur de fond pour visualiser la div */
            text-align: center; /* Alignement du contenu à l'intérieur de la div */
        }
    </style>
    
    
</head>

<body>

<div class ="centered" >
    <h1>Formulaire - INV</h1>
    
    <form method="post" action="servlet">
    <div>
    <div class="text-center">
        <label for="nom"  class="form-label" >Nom:</label>
        <input type="text" id="nom" name="nom" class="form-control" required><br><br>
    </div> 
    <div class="text-center" >
        <label for="prenom" class="form-label" >Prénom:</label>
        <input type="text" id="prenom" name="prenom" class="form-control" required><br><br>
      </div>  
      <div class="text-center" >
        <label for="email" class="form-label" >Email:</label>
        <input type="email" id="email" name="email" class="form-control"  required><br><br>
        <c:out value="${requestScope.message}" />
       </div  > 
        <div class="text-center" >
        <label for="motDePasse"class="form-label" >Mot de passe:</label>
        <input type="password" id="motDePasse" name="motDePasse" class="form-control" required><br><br>
        </div> 
    </div>    
        
        <input type="submit" value="Enregistrer" class="btn btn-primary mb-3">
    </form>
   </div>
</body>
</html>
