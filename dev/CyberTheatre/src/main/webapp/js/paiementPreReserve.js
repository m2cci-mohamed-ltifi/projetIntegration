function AcheterBilletPreReserve() {
    $.ajax({
        url: "AcheterCtrl", // l'url de la servlet
        method: 'POST', // on utilise une méthode post
        data: {
            nom : document.getElementById("numeroDossier").value
        }
        

        //$('#formSem').serializeArray()  // les données envoyée avec la requête
        // ici les paramètres du formulaire d'id 'formSem' c'est à dire
        // les couples nom, valeur des différents inputs du formulaire
    }
            ).then(
        function fullFillHandler(data) {
            // fonction appelée quand la requête AJAX a abouti
            // data contient le code HTML de la table que l'on insère
            // dans le div d'id 'tabres'
            document.getElementById("paiementDiv").innerHTML = data;
            // window.scrollTo(0,0); 
            console.log(data);
        },
        function rejectHandler(jqXHR, textStatus, errorThrown) {
            // fonction appelée quand la requête AJAX a échoué
            alert("Rejet de la requête " + textSatus);
        }
    ).catch(function errorHandler(error) {
        alert("ERREUR " + error);
    });
    }

document.getElementById("validationAcheterBilletPrereserve").addEventListener('click',AcheterBilletPreReserve);
