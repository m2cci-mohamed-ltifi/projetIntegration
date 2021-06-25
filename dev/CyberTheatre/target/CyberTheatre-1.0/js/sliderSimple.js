/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

//Without JQuery
//Paramètres et récupération de la valeur du slider simple (prix)

var slider = document.getElementById("slidePrix");
var output = document.getElementById("prix");
output.innerHTML = slider.value; // Display the default slider value

//met à jour la valeur courant du slider (chaque fois que le pointeur se déplace)
slider.oninput = function() {
  output.innerHTML = this.value;
}


