/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validerConnexion() {
    $.ajax({
        url: "LoginGerant", // l'url de la servlet
        method: 'POST', // on utilise une méthode post
        data: {
            "id": document.getElementById("identifiant").value,
            "mdp": document.getElementById("mdp").value
        }
    }).then( 
            function(reponseServeur) {
                if (reponseServeur !== 'OK') {
                    alert('identifiants incorrects');
                } else {
                    window.location.replace("pageGerant");
                }
            },
            function(jqXHR, textStatus, errorThrown) {
                alert("erreur serveur " + textStatus);
            }
            
    ).catch(function errorHandler(error) {
        alert("ERREUR " + error);

    });
}


document.getElementById("seConnecter").addEventListener("click", validerConnexion);