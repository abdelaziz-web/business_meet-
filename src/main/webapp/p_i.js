document.getElementById('p_i').addEventListener('click', function(event) {
        // Empêcher le comportement par défaut de la balise <a>
        event.preventDefault();

        // Récupérer les données à envoyer
        var param1 = this.getAttribute('data-param1');
        var param2 = this.getAttribute('data-param2');

        // Effectuer une requête AJAX
        var xhr = new XMLHttpRequest();
        var url = 'p_i_crud?id=' + encodeURIComponent(param1) + '&type=' + encodeURIComponent("Modifier");

        xhr.open('GET', url, true);
        xhr.setRequestHeader('Content-Type', 'text/html');

        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // Insérer le contenu HTML dans la div
            document.documentElement.innerHTML = xhr.responseText;     
       }
        };
        xhr.setRequestHeader('Content-Type', 'text/html');
        // Envoyer la requête
        xhr.send();
    });
    
    
   