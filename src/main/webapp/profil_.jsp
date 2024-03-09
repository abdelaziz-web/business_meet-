<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profil</title>
    <link rel="stylesheet" href="css.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css">
    
    <!-- Inclusion des fichiers JavaScript de Bootstrap (optionnel, uniquement si vous avez besoin des fonctionnalités JavaScript de Bootstrap) -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>


</head>
<body>
<%@ page import="metier.Investisseur" %>
<%@ page import="metier.P_i" %>

<%@ include file="navbar.jsp" %>

    <form method="get" action="servlet">

<input type="hidden" id="id" name="id"  value="${inv.id}"  ><br><br>
<input type="hidden" name="type" value="Modifier">

<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span class="font-weight-bold">${inv.nom}</span><span class="text-black-50">${inv.email}</span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6"><label class="labels">Last Name :</label><input type="text" name="nom"  value="${inv.nom}" class="form-control" placeholder="Last name" ></div>
                    
                    <div class="col-md-6"><label class="labels">First name :</label><input type="text" class="form-control"  placeholder="First name" name="prenom" value="${inv.prenom}"   ></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-12"><label class="labels">Email</label><input type="email" class="form-control"  name="email"  value="${inv.email}"  placeholder="enter email" ></div>
                    <div class="col-md-12"><label class="labels">password</label><input type="password" class="form-control" placeholder="enter a password"  name="motDePasse"  value="${inv.motdepasse}"></div>
                    <div class="col-md-12"><label class="labels">Confirm password</label><input type="password" class="form-control" placeholder="confirm a password"></div>
                </div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div>
            </div>
        </div>
        
    </div>
</div>
</div>
</div>

</form>

























</body>
</html>
