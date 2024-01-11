

<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Les demandes </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="projet">Les projets </a>
        </li>
        <li class="nav-item">
        <%
    // R�cup�ration de la session
        HttpSession alpha = request.getSession();
        %>
        <%  
       if (alpha.getAttribute("p_i") != null) {
        %>
          <a class="nav-link" href="#" id="p_i" data-param1="${sessionScope.p_i.id}"  data-param2="Modifier"  >Profil</a>
       
        <% }
        else if (alpha.getAttribute("inv") != null){
        %>
    
         <a class="nav-link" href="alpha" id="inv" data-param1="${sessionScope.inv.id}"  data-param2="Modifier"  >Profil</a>
        <%}
        %>
        </li>
        
    <%  if (alpha.getAttribute("inv") == null)  {   %>
        <li class="nav-item">
          <a class="nav-link" href="servlet_ide"  >Ajouetr un projet</a>
        </li>
      <% }  %>  
        
        <li class="nav-item">
          <a class="nav-link" href="de" id="deco"  data-param2="deconnecte">D�connecter</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


<script>
document.getElementById('inv').addEventListener('click', function(event) {
    // Emp�cher le comportement par d�faut de la balise <a>
    event.preventDefault();

    // R�cup�rer les donn�es � envoyer
    var param1 = this.getAttribute('data-param1');
 //   var param2 = this.getAttribute('data-param2');

    // Effectuer une requ�te AJAX
    var xhr = new XMLHttpRequest();
    var url = 'servlet?id=' + encodeURIComponent(param1) + '&type=' + encodeURIComponent("Modifier");

    xhr.open('GET', url, true);
    xhr.setRequestHeader('Content-Type', 'text/html');

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Ins�rer le contenu HTML dans la div
        document.documentElement.innerHTML = xhr.responseText;  
   }
    };
    xhr.setRequestHeader('Content-Type', 'text/html');
    // Envoyer la requ�te
    xhr.send();
});



</script>
