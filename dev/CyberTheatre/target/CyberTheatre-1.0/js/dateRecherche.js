/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

/* 
 * Empeche de choisir un premier jour inférieure à la date d'aujourd'hui
 * et empeche de choisir le deuxieme jour inférieure au premier jour.
 */
var today = new Date().toISOString().split('T')[0];
document.getElementById("premierJour").setAttribute('min', today);
document.getElementById("premierJour").addEventListener("change", dateUlterieure);
function dateUlterieure(){
    var minDay=document.getElementById("premierJour").value;    
    document.getElementById("dernierJour").setAttribute('min', minDay);
}


