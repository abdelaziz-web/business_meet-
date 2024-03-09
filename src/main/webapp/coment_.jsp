

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 
 <body>

    <c:forEach items="${maListe}" var="com">
 
    <div class="container">
        <div class="card text-center">
            <div class="card-header">
               Abdelaziz achendid
            </div>
            <div class="card-body">
              
                <p class="card-text">${com.description}</p>
            
            </div>
            <div class="card-footer text-body-secondary">
               ${com.date}
            </div>
        </div>
    </div>
 
</c:forEach>







<div class="container">
    <form  action="com_servlet" method="post">
       
     Commentaire :
    <input type="text" class="form-control" name="com">
    <input type="hidden" name="id_p_i" value="${sessionScope.p_i.id}">
    <input type="hidden" name="id_inv" value="${sessionScope.inv.id}">  
     <input type="hidden" name="id_ide" value="${id_ide}">  
    <input type="submit" class="form-control" value="submit">
 
    </form>
</div>









<style>
    body {
        background-image: url('');
        background-size: cover; /* Pour s'assurer que l'image de fond couvre toute la page */
        background-repeat: no-repeat; /* Pour éviter la répétition de l'image de fond */
    }


    

.container {
    background-color: rgba(255, 255, 255, 0.5); /* Couleur de fond transparente (blanc avec 50% d'opacité) */
    padding: 20px;
    border-radius: 10px;
    margin: 100px auto;
    width: 300px;
}

form {
    background-color: transparent; /* Fond du formulaire transparent */
}

label {
    color: #333;
}

.card {
            max-width: 400px; /* Taille maximale de la carte */
            margin: 0 auto; /* Centrage horizontal */
            margin-top: 50px; /* Marge supérieure pour l'espace */
        }

input[type="text"],
input[type="email"],
input[type="submit"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

</style>
<!-- Script de Bootstrap (facultatif, nécessaire uniquement pour les composants JavaScript de Bootstrap) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>



</body>




