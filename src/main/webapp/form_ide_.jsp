
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>The innovation form </title>
    <style>
      *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Segoe UI', sans-serif;
}

body{
    background-color: #dcdcdc;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
    padding: 0 20px;
}

.container{
    display: flex;
    gap: 20px;
    background-color: #fff;
    width: 100%;
    max-width: 920px;
    padding: 25px;
    border-radius: 10px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.container img{
    width: 50%;
    border-radius: 20px;
    object-fit: cover;
}

.container form{
    width: 50%;
}

form h2{
    text-align: center;
    margin-bottom: 20px;
}

.form-control{
    position: relative;
    margin-bottom: 15px;
}

.form-control label{
    display: block;
    margin-bottom: 5px;
}

.form-control input,
.form-control textarea{
    width: 100%;
    padding: 10px;
    padding-right: 40px;
    border: 2px solid #ddd;
    border-radius: 10px;
    outline: none;
}

button{
    width: 100%;
    border: none;
    padding: 10px;
    background-color: #77b7cd;
    color: #fff;
    border-radius: 10px;
    cursor: pointer;
    font-size: 16px;
    transition: all 0.3s ease;
}

button:hover{
    background-color: #295580;
}

.form-control .icon{
    position: absolute;
    right: 10px;
    top: 71%;
    transform: translateY(-50%);
    font-size: 20px;
    color: transparent;
    pointer-events: none;
}

.form-control.success input,
.form-control.success textarea{
    border-color: #2ecc71;
}

.form-control.success .icon{
    color: #2ecc71;
}

.form-control.error input,
.form-control.error textarea{
    border-color: #e74c3c;
}

.form-control.error .icon,
.form-control.error input::placeholder,
.form-control.error textarea::placeholder{
    color: #e74c3c;
}

.modal{
    display: none;
    position: fixed;
    z-index: 2;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.4);
}

.modal-content{
    background-color: #fefefe;
    margin: 15% auto;
    padding: 20px;
    width: 80%;
    border: 1px solid #888;
    max-width: 500px;
    border-radius: 10px;
    text-align: center;
}

.close-button{
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
    transition: all 0.3s ease;
}

.close-button:hover,
.close-button:focus{
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

@media screen and (max-width: 920px) {
    
    .container img{
        display: none;
    }

    .container form{
        width: 100%;
    }

}

      </style>
</head>

<body>

    


    <div class="col-md-6 mx-auto text-center">
        <h4>  <c:if test="${not empty requestScope.message}">
        <!-- Si la variable existe, affichez-la -->
        <c:out value="${requestScope.message}" />
</c:if>  </h4>

    <div class="container">
        <img src="bg.png">
        <form id="mainForm"  action="servlet_ide" method="post"  enctype="multipart/form-data"   novalidate>
            <h2>the innovation form</h2>
            

            
           
                <%@ page import="jakarta.servlet.http.HttpSession" %>  
                <% 
                HttpSession beta = request.getSession();
               //Tester la présence de l'attribut "id" dans la session
                String id = (String) beta.getAttribute("id");
                %>


           <input type="hidden"  name="id" value="${sessionScope.p_i.id}">


            <div class="form-control">
                <label >title</label>
                <input type="text"  name="titre" placeholder="Enter the title">
                <i class="icon"></i>
            </div>

            <div class="form-control">
                <label >description</label>            
                <input type="text" name="description">
            </div>

            <div class="form-control">
                <label >budget</label>  
                <input type="text" name="Budget">
              </div>

              <div class="form-control">
                <label >business plan</label>
                <input type="file"  name="plan">
              </div>

              <div>
                <select class="form-select form-select-lg mb-3" aria-label="Large select example" name="cat">
                <option selected>Category</option>
                <c:forEach var="cat" items="${cate}">
                <option value="${cat.id}">${cat.designation}</option>
                      </c:forEach>
               </select>
              </div>
               

            <button type="submit">Submit</button>

        </form>
    </div>

    <div id="successModal" class="modal">
        <div class="modal-content">
            <span class="close-button">&times;</span>
            <h2>Success!</h2>
            <p>Your form has been submitted successfully.</p>
        </div>
    </div>


    <script src="script.js"></script>
</body>

</html>