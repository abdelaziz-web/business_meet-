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
    <div class="container my-5">
        <div class="row">
        
            <div class="col-md-6 mx-auto text-center">
            <h4>  <c:if test="${not empty requestScope.message}">
            <!-- Si la variable existe, affichez-la -->
            <c:out value="${requestScope.message}" />
    </c:if>  </h4>
      <h4>Formulaire d'Informations</h4>
    <form action="servlet_ide" method="post"  enctype="multipart/form-data">
  <div class="mb-3">
<%@ page import="jakarta.servlet.http.HttpSession" %>  
 <% 
 HttpSession beta = request.getSession();
//Tester la présence de l'attribut "id" dans la session
 String id = (String) beta.getAttribute("id");
 %>
 
 
    <input type="hidden"  name="id" value="${sessionScope.p_i.id}">
    <label for="exampleInputEmail1" class="form-label">Titre</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="titre" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text"></div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">description</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="description">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Budget</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="Budget">
  </div>
  <div class="mb-3">
    <label for="exampleInputfile" class="form-label">business plan</label>
    <input type="file" class="form-control" id="exampleInputfile" name="plan">
  </div>
  <div>
  <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="cat">
  <option selected>Catégorie</option>
  <c:forEach var="cat" items="${cate}">
  <option value="${cat.id}">${cat.designation}</option>
        </c:forEach>
</select>
</div>
 
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


</div>
</div>
</div>

</body>
</html>
