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


<form method ="post" action="auth_p_i">
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email"  class="form-control" id="staticEmail" name="email" placeholder="email@example.com">
    </div>
  </div>
  <br>
  <br>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword" name="password"  placeholder="Password">
    </div>
  </div>
    <br>
    <br><br>
  <button type="submit" class="btn btn-primary">Envoyer</button>
  
</form>

</body>
</html>