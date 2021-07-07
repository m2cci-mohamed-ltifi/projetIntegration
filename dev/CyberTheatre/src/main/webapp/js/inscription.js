/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function inscription() {
    $.ajax({
        url: "InscriptionCtrl", // l'url de la servlet
        method: 'POST', // on utilise une méthode post
        data: {
            "nom": document.getElementById("nom").value,
            "prenom": document.getElementById("prenom").value,
            "login": document.getElementById("login").value,
            "email": document.getElementById("email").value,
            "mdp": document.getElementById("mdp").value
        }
    }).then( 
            function fullFillHandler(data) {
            // fonction appelée quand la requête AJAX a abouti
            // data contient le code HTML de la table que l'on insère
            // dans le div d'id 'tabres'
            document.getElementById("programmationFiltree").innerHTML = data;
            // window.scrollTo(0,0); 
        },
        function rejectHandler(jqXHR, textStatus, errorThrown) {
            // fonction appelée quand la requête AJAX a échoué
            alert("Rejet de la requête " + textSatus);
        }
            
    ).catch(function errorHandler(error) {
        alert("ERREUR " + error);

    });
}


document.getElementById("validationSInscrire").addEventListener("click", inscription());