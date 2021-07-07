/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

/* 
 * code javascript remplaçant le bouton 'valider' par la confirmation de la 
 * validation
 */

/* global fetch */

function validationDispatcher() {

    let nbBtnChoix = document.getElementsByClassName("choixTarifReduitBtn").length;
    for (let i = 1; i < nbBtnChoix + 1; i++) {
        document.getElementById("tarifReduit_" + i).disabled=true;
    }

    //emmène vers "acheter" ou vers "pré-reserver"
    if (document.getElementById('acheterRadio').checked) {
        acheter();
    } else if (document.getElementById('prereserverRadio').checked) {
        reserver(false);
    }


}

function acheter() {
    $.ajax({
        url: "AcheterCtrl", // l'url de la servlet
        method: 'POST', // on utilise une méthode post
        data: $('#acheterRadio').serialize()

    }).then(
            function fullFillHandler(data) {
                // fonction appelée quand la requête AJAX a abouti
                // data contient le code HTML de la table que l'on insère
                // dans le div d'id 'tabres'
                document.getElementById("validation").innerHTML = data;
                document.getElementById("formulairePaiement").addEventListener("submit", function (event) {
                    event.preventDefault();
                    reserver(true);
                });
            },
            function rejectHandler(jqXHR, textStatus, errorThrown) {
                // fonction appelée quand la requête AJAX a échoué
                alert("Rejet de la requête " + textSatus);
            }
    ).catch(function errorHandler(error) {
        alert("ERREUR " + error);
    });
}

function reserver(acheter) {
    let nbBtnChoix = document.getElementsByClassName("choixTarifReduitBtn").length;
    var tableauTarifReduit = new Array();

    for (let i = 1; i < nbBtnChoix + 1; i++) {
        tableauTarifReduit.push(document.getElementById("tarifReduit_" + i).value);
    }
    $.ajax({
        url: "ReserverCtrl", // l'url de la servlet
        method: 'POST', // on utilise une méthode post
        data: {
            "acheter": acheter,
            "tarifsReduits": tableauTarifReduit
        }
    }).then(
            function fullFillHandler(data) {
                // fonction appelée quand la requête AJAX a abouti
                // data contient le code HTML de la table que l'on insère
                // dans le div d'id 'tabres'
                document.getElementById("validation").innerHTML = data;
            },
            function rejectHandler(jqXHR, textStatus, errorThrown) {
                // fonction appelée quand la requête AJAX a échoué
                alert("Rejet de la requête " + textSatus);
            }
    ).catch(function errorHandler(error) {
        alert("ERREUR " + error);
    });
}

function afficherPrixSelectTarifReduit(i) {
    prix = Math.round(parseFloat(document.getElementById("prixPlaceSansReduction_" + i).innerHTML)*100)/100;

    reduction = document.getElementById("tarifReduit_" + i).value;

    if (reduction === "aucun") {
        prixReduit = Math.round(parseFloat(prix)*100)/100;
    } else {
        prixReduit = Math.round(parseFloat(prix) * 0.8*100)/100;
    }
    document.getElementById("prixPlaceReduit_" + i).innerHTML = parseFloat(prixReduit);

    calculerPrixTotal();
}

function calculerPrixTotal() {
    let nbBtnChoix = document.getElementsByClassName("choixTarifReduitBtn").length;
    let somme = 0;
    for (let i = 1; i < nbBtnChoix + 1; i++) {
        somme = somme + Math.round(parseFloat(document.getElementById("prixPlaceReduit_" + i).innerHTML)*100)/100;
    }

    document.getElementById("prixTotal").innerHTML = Math.round(parseFloat(somme)*100)/100;

}


let nbBtnChoix = document.getElementsByClassName("choixTarifReduitBtn").length;
for (let i = 1; i < nbBtnChoix + 1; i++) {
    afficherPrixSelectTarifReduit(i);
    document.getElementById("tarifReduit_" + i).addEventListener("change",
            function (onEnvent) {
                afficherPrixSelectTarifReduit(i);
            });
}


document.getElementById("achatOuPrereservatoionBtn").addEventListener("click", validationDispatcher);

    // Create an instance of the Stripe object with your publishable API key
    var stripe = Stripe("pk_test_51J6CxVCkLlQznzQ3cygztskZ6BeFfvFYHpGTQf1Vz6d2ss5tva7EXESfwdyAbUPWAbDnadPXQsPZPKa23lgrs5BL004oz9QErh");
    var checkoutButton = document.getElementById("validationAchat");

    checkoutButton.addEventListener("click", function () {
      fetch("/create-checkout-session", {
        method: "POST"
      })
        .then(function (response) {
          return response.json();
        })
        .then(function (session) {
          return stripe.redirectToCheckout({ sessionId: session.id });
        })
        .then(function (result) {
          // If redirectToCheckout fails due to a browser or network
          // error, you should display the localized error message to your
          // customer using error.message.
          if (result.error) {
            alert(result.error.message);
          }
        })
        .catch(function (error) {
          console.error("Error:", error);
        });
    });
  