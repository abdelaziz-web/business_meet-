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
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">project_title</th>
      <th scope="col">Etat</th>

    </tr>
  </thead>
  <tbody>
  
   <c:forEach items="${noti_list}" var="noti">
        <tr>
            <td>acw</td>
            <td>acw</td>
            <td>Restauration</td>
            <td><button id="1" type="button" class="btn btn-primary btn-lg" value="${noti.status}">Large button</button></td>
        </tr>
    </c:forEach>
 
    
 
  </tbody>
</table>

</div>




<script src="profil.js" >  </script>
<script src="p_i.js" >  </script>

<script> 



var isFirstIteration = true;

var buttons = document.querySelectorAll('button');

buttons.forEach(function(button) {
  
	    if(isFirstIteration){
	    	
	    	isFirstIteration = false ;
	    }else{
	
     	console.log(button.value) ;
    	
        var button_ = parseInt(button.value);
                
        console.log("value du bouton : " + button_); 
     
        if(button_ ==  1){
        	
       	var nouveauElement = document.createElement('div');
            nouveauElement.textContent = 'accepter';
            
            button.parentNode.replaceChild(nouveauElement, button);
            
	
        }else if( button_ ==2 ){
        	
        	 var nouveauElement = document.createElement('div');
            nouveauElement.textContent = 'refuser';
            
            // Remplacer le bouton par le nouvel élément
            button.parentNode.replaceChild(nouveauElement, button);
        
        	
        }else{
  
        	var nouveauElement = document.createElement('div');
            nouveauElement.textContent = 'pas encore';
            
            // Remplacer le bouton par le nouvel élément
            button.parentNode.replaceChild(nouveauElement, button);        
        	
	
        }
     
        
        
	    }


}) ;






</script>



</body>
</html>