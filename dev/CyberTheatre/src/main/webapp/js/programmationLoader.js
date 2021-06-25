/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

/* 
 * code JavaScript pour charger les programmations en utilsiant AJAX
 */
function chargerProgrammation() {
    $.ajax({
        url: "ProgrammationCtrl", // l'url de la servlet
        method: 'POST', // on utilise une méthode post
        data: $('#filtresForm').serialize()

        //$('#formSem').serializeArray()  // les données envoyée avec la requête
        // ici les paramètres du formulaire d'id 'formSem' c'est à dire
        // les couples nom, valeur des différents inputs du formulaire
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

// Au chargement de la page, on récupère la liste des programmation 
chargerProgrammation();

//A chaque modification dans le formulaire, on recharge la liste des représentations
document.getElementById("filtresForm").addEventListener("change", chargerProgrammation);
document.getElementById("site-search").addEventListener("search", chargerProgrammation);