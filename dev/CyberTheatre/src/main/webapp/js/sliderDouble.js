/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

//Without JQuery
//Paramètres et récupération des valeurs du slider double (horaires)

var sliderB = new Slider("#sliderHeures", { min: 10, max: 24, value: [10, 24], focus: true });
sliderB.on("change", 
    function(evt) {
        console.log("change slider");
        document.getElementById("debutPlage").innerHTML = evt.newValue[0];
        document.getElementById("finPlage").innerHTML = evt.newValue[1];
    }
);
sliderB.on("slideStop", function(evt) { 
    document.getElementById("debutPlage").value = evt[0];
    document.getElementById("finPlage").value = evt[1];
    chargerProgrammation();
});