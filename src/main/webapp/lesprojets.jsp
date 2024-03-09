<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="boots.jsp" %>
    <title>Formulaire d'Informations</title>
    <!-- Vous pouvez inclure ici des liens vers des styles CSS, Bootstrap, etc. -->
</head>
<body> 

 <%@ include file="navbar.jsp" %>
       
       <%@ page import="metier.Investisseur" %>
       
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
 
         <h1> Tableau des projets  </h1>
        
        Nombre d'éléments dans la liste : ${les_idees.size()}
 <%@ page import="Web.projet" %>
  
      
  
        
  
        
       <table border="1" class="table">
    <tr>
        <th>id_ide</th>
        <th>Titre</th>
        <th>description</th>
        <th>porteur</th>
        <th>categorie</th>
        <th>B_p</th>
        <th>commentaire</th>
        <th>Notifier</th>
    </tr>
    <c:forEach items="${listeProjets}" var="inv">
        <tr>
            <td>${inv.id_ide}</td>
            <td>${inv.titre}</td>
            <td>${inv.description}</td>
            <td>${inv.porteur}</td>
            <td>${inv.categorie}</td>
           <td>
            <%-- ${inv.b_p} --%>
            <form action="upload" method="post">
            <button type="submit" value="${inv.b_p}" name="upload">Télécharger_le_fichier_BP</button>
            </form>
            </td>
           <td>         
            <button class="btn btn-primary" type="button"  value="${inv.id_ide}"   >Button</button>          
           </td>
           <td> <button  id="monBouton"  data-group="navigation" class="btn btn-primary" type="button"  value="${inv.id_ide} + ${inv.fk_p_i}"   >Button</button> </td>
        </tr>
    </c:forEach>
</table>

    </div>    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 <script src="profil.js" >  </script>
 <script src="p_i.js" >  </script>

<script>

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