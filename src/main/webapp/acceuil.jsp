<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="boots.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div id="content">

<table class="table">
  <thead>
    <tr>
      <th scope="col">nom</th>
      <th scope="col">prenom</th>
      <th scope="col">project_title</th>
     
    </tr>
  </thead>
  <tbody>
    
   <c:forEach items="${noti_list}" var="noti">
        <tr>
            <td>achendid</td>
            <td>abdelaziz</td>
            <td>Restauration</td>
            <td><button id="1" type="button" class="btn btn-primary btn-lg" value="${noti.id_pi}+ ${noti.id_inv}+ ${noti.id_ide}">Accept</button></td>
            <td><button id="2" type="button" class="btn btn-primary btn-lg" value="${noti.id_pi}+ ${noti.id_inv}+ ${noti.id_ide}">Refuse</button></td>
            <td><button id="3" type="button" class="btn btn-primary btn-lg" value="${noti.id_pi}+ ${noti.id_inv}+ ${noti.id_ide}">Ignore</button></td>  
        </tr>
    </c:forEach>
 
    
 
  </tbody>
</table>

</div>

<script src="profil.js" >  </script>
<script src="p_i.js" >  </script>




<script> 



var buttons = document.querySelectorAll('button');

buttons.forEach(function(button) {
    button.addEventListener('click', function() {
    /*   
    	var buttonValue = button.value.split('+').map(function(item) {
            return parseInt(item.trim());
        });
    	
    	
    	for (var i = 0; i < buttonValue.length; i++) {
    	    console.log("Valeur " + i + " : " + buttonValue[i]);
    	    console.log("id"+button.id) ;
    	}

    	
    }
    	
}*/
/*
    
        var bodyData = 'id1=' + encodeURIComponent(id1) + '&id2=' + encodeURIComponent(id2) + '&id3=' + encodeURIComponent(id3);

        fetch('/votre-url-du-backend', {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' 
            },
            body: bodyData 
        })
        .then(response => {
            if (response.ok) {
                return response.text(); 
            }
            throw new Error('Erreur lors de la requête');
        })
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Erreur:', error);
        });
    });
    	
    */	

    	
    	// Récupérer l'ID du bouton et le convertir en entier
        var buttonId = parseInt(button.id);
        
        // Récupérer la valeur du bouton et la convertir en entier
        var buttonValue = button.value.split('+').map(function(item) {
            return parseInt(item.trim());
        });
        
        // Afficher l'ID et la valeur dans la console (vous pouvez faire d'autres traitements avec ces valeurs)
        console.log("ID du bouton : " + buttonId);
        console.log("Valeur du bouton : " + buttonValue[2]);
        
        
        var bodyData = 'id_pi=' + encodeURIComponent(buttonValue[0]) + '&id_inv=' + encodeURIComponent(buttonValue[1]) + '&id_ide=' + encodeURIComponent(buttonValue[2]) + '&id=' + encodeURIComponent(buttonId);

        fetch('http://localhost:8080/projet_federateur/notification', {
            method: 'POST', 
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded' 
            },
            body: bodyData 
        })
        .then(response => {
            if (response.ok) {
                return response.text(); 
            }
            throw new Error('Erreur lors de la requête');
        })
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error('Erreur:', error);
        });
        
     
        
        
        
    });
});





</script>























</body>
</html>