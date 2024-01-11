

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
 
<table border="1" class="table">
    <tr>
    
        <th>id</th>
        <th>id_ide</th>
        <th>id_inv</th>
        <th>id_p_i</th>
        <th>date</th>
        <th>commentaire</th>
        
        
        
    </tr>
    <c:forEach items="${maListe}" var="com">
    <tr>
        <td>${com.id}</td>
        <td>${com.id_ide}</td>
        <td>${com.id_inv}</td>
        <td>${com.date}</td>
        <td>${com.description}</td>
        <td>${com.id_p_i}</td>
        <c:set var="valeurId" value="${com.id_ide}" />
    </tr>
</c:forEach>

</table>

<form  action="com_servlet" method="post">
  <div class="mb-3">
     Commentaire :
    <input type="text" class="form-control" name="com">
    <input type="hidden" name="id_p_i" value="${sessionScope.p_i.id}">
    <input type="hidden" name="id_inv" value="${sessionScope.inv.id}">  
     <input type="hidden" name="id_ide" value="${id_ide}">  
    
  </div>
  
  <button type="submit" class="btn btn-primary">Envoyer</button>
</form>









