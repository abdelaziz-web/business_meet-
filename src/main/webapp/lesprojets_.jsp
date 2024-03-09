<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Our Services</title>
    <link rel="stylesheet" href="style__.css" class="css">
    <!-- FONT AWESOME LINK USING BOXICON -->
    <%@ include file="boots.jsp" %>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body> 
 <%@ include file="navbar.jsp" %>
       
       <%@ page import="metier.Investisseur" %>
       
       <%@ page import="Web.projet" %>
       
       <%
        // Récupérer un attribut de session
        Investisseur inv = (Investisseur) session.getAttribute("inv");
        int id = 0;
        if ( inv != null) {
        	id = inv.getid() ;
            out.println("");
        } else {
            out.println("");
        }
     %>
       
     
   <div id="fxkl" >
 
         
         <div class="wrapper">
        <h1>Available projects</h1>
        <p>Investing today opens the doors to a brighter financial future tomorrow</p>
        <p>If you want to notify someone click in the card</p>
             <div class="content-box">
     <c:forEach items="${listeProjets}" var="inv">     
         <div class="card">
         
         <%
    // Récupérer un attribut de session
    Investisseur inv_ = (Investisseur) session.getAttribute("inv");
    int id_ = 0;
    if (inv_ != null) {
        id = inv.getid();
%>
                 
                   <button class="btn btn-primary"  type="hidden" data-group="navigation" value="${inv.id_ide} + ${inv.fk_p_i}" >notify</button>         
  
  <%
    } // fin du if
%>
         
                    <p>Estimated_budget =  <span class="estimatedBudget"></span> $ </p>
                    <img class="rounded-circle mt-5 project-image " width="150px" src="">
                   
                  <h2>${inv.titre}</h2>
                  <p>${inv.description} </p>
                  
                  <p style="font-size: 13px;">Idea_owner = ${inv.porteur} </p>
                
                  <form action="upload" method="post">
                  <button  class="btn btn-primary" type="submit" value="${inv.b_p}" name="upload">get_a_Bussiness_plan</button>
                  </form> <br> 
                  <button class="btn btn-primary" type="button"  value="${inv.id_ide}"   >Comment</button>          
                
              
                </div>
          </c:forEach>
         </div>
       </div>  
  
    
    
</div>
   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 <script src="profil.js" >  </script>
 <script src="p_i.js" >  </script>

<script>


var imagePaths = [
    "https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg",
    "7309681.jpg",
    "7309685.jpg",
    "7309700.jpg",
    "9440461.jpg"
    ];


function generateRandomBudgets() {
    var estimatedBudgetElements = document.querySelectorAll('.estimatedBudget');

    // Parcourir chaque élément de budget estimé et générer un budget aléatoire
    estimatedBudgetElements.forEach(function(element) {
        var estimatedBudget = Math.floor(Math.random() * 900) + 101; // entre 101 et 1000
        element.innerText = estimatedBudget;
    });
}

// Appeler la fonction au chargement de la page pour générer les budgets estimés



//-------------------------------



    function chooseRandomImage() {
        var projectImages = document.querySelectorAll('.project-image');

        // Parcourir chaque élément d'image de projet et choisir aléatoirement un chemin d'image
        projectImages.forEach(function(imageElement) {
            var randomIndex = Math.floor(Math.random() * imagePaths.length); // Génère un index aléatoire
            var randomImagePath = imagePaths[randomIndex]; // Récupère le chemin d'image correspondant à l'index aléatoire
            imageElement.src = randomImagePath; // Attribue le chemin d'image choisi à l'élément d'image
        });
    }

    
    function but() {
        var bouton_1 = document.querySelectorAll("[data-group='navigation']");

        for (var j = 0; j < bouton_1.length; j++) {
            bouton_1[j].style.display = 'none';
        }
    }





function setup(){
	
	generateRandomBudgets();
	chooseRandomImage() ;

}

window.onload = setup;



function effectuerRequete(a) {
    // URL du servlet sur le serveur
    const url = 'http://localhost:8080/projet_federateur/com_servlet';

    const value = a.value;
    
    console.log(value);
    // Données à inclure dans la requête GET
    const donnees = {
    		id_ide: value,
    };

    // Construire l'URL avec les paramètres de requête
    const urlAvecParametres = new URL(url);
    Object.keys(donnees).forEach(key => urlAvecParametres.searchParams.append(key, donnees[key]));

    // Configuration de la requête GET
    const requestOptions = {
        method: 'GET',
    };

    // Envoi de la requête
    fetch(urlAvecParametres.toString(), requestOptions)
        .then(response => {
            if (!response.ok) {
                throw new Error(`Erreur HTTP! Statut : ${response.status}`);
            }
            return response.text(); // Utilisation de .text() pour récupérer du texte (HTML dans ce cas)
        })
        .then(html => {
            // Afficher le HTML dans un élément de la page
          const conteneurHTML = document.getElementById('fxkl');
          // conteneurHTML.innerHTML = html;
      //    const conteneurHTML = document.querySelector('table');
          conteneurHTML.innerHTML = html;
        //   document.documentElement.innerHTML = html;
            console.log('Est bien passé');
            console.log(html);
        })
        .catch(error => {
            // Gestion des erreurs
            console.error('Erreur lors de la requête GET:', error);
        });
}

// Ajout d'un gestionnaire d'événements au bouton
//const boutons = document.getElementById('monBouton');

//boutons.addEventListener('click', effectuerRequete);

const bouton = document.querySelectorAll('.btn');

bouton.forEach(a => {
    a.addEventListener('click', () => {
        effectuerRequete(a);
    });
});


// ---------------------------------------------------------------------------


function fetchData(url) {
	fetch(url, {
	    method: 'GET',
	    headers: {
	        'Content-Type': 'text/plain'
	    }
	})
	.then(response => {
	    if (!response.ok) {
	        throw new Error('Erreur lors de la requête');
	    }
	    return response.text();
	})
	.then(data => {
	    console.log(data);
	})
	.catch(error => {
	    console.error('Erreur:', error);
	});

}


var bouton_1 = document.querySelectorAll("[data-group='navigation']");



for (var j = 0; j < bouton_1.length; j++) {
    bouton_1[j].addEventListener("click", function() {
   
    	this.style.display = 'none';
    	
    	var valeurBouton = this.value;

    	console.log("La valeur du bouton est : " + valeurBouton);

    	var valeurs = valeurBouton.split(" + ");

    	//Convertir les valeurs en nombres
    	var id_ide = parseInt(valeurs[0]);
    	var fk_p_i = parseInt(valeurs[1]);

    	//Vérifier si la conversion a réussi
    	if (!isNaN(id_ide) && !isNaN(fk_p_i)) {
    	 console.log("id_ide: " + id_ide);
    	 console.log("fk_p_i: " + fk_p_i);
    	} else {
    	 console.error("Erreur lors de la conversion des valeurs en nombres.");
    	}

    	var id_inv = <%= id %>


    	const donnees = {
    			id_ide_1: id_ide,
    			fk_p_i_1: fk_p_i,
    			id_inv_1 : id_inv		
    	};

    	//const url_not = 'http://localhost:8080/projet_federateur/notification';

    	//const urlAvecParametres = new URL(url_not);
    	//Object.keys(donnees).forEach(key => urlAvecParametres.searchParams.append(key, donnees[key]));

    	const url_not ="http://localhost:8080/projet_federateur/notification?id_ide="+id_ide+'&fk_p_i='+fk_p_i+'&fk_inv='+id_inv ;

    	const url_2 = 'http://localhost:8080/projet_federateur/notification?id_ide='+encodeURIComponent(id_ide)+'&fk_p_i='+encodeURIComponent(fk_p_i)+'&fk_inv='+encodeURIComponent(id_inv);


    	const url_not_1 = encodeURIComponent(url_not); ;

    	console.log(url_2);
    	
    	
    	fetchData(url_2);
  
    	
    	
    	
    	
    	
    	
    	
    	
    });
}

</script>
  
 </body>
 </html>