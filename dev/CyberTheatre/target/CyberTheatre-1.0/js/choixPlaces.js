/* 
 * Copyright (C) M2CCI 2021 projet d'intégration groupe 01
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

$(document).ready(function() {

    //    let seatNumber = 1; // numéro utilisé pour associer un label aux sièges
    //    let seatId = 1; // numero utilisé pour associer un id aux sièges
    
    let $detailCategorie = $('#detail-categories');
    let $nbPlaces = $('#nbplaces');
    let $prixTotal = $('#prixtotal');
    let $cart = $('#siegesSelectionnes');
    let prixR = document.getElementById("prixRepresentation").innerHTML;
    let prixBalcon = Math.round(prixR*1.5*100)/100;
    let prixOrchestre = Math.round(prixR*1.2*100)/100;
    let prixPoulailler = Math.round(prixR*1.0*100)/100;
    
    let sc = $('#seat-map').seatCharts({
        map: [
            'CCCCC_BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB_CCCCC',
            'CCCCC_BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB_CCCCC',
            'CCCCC_BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB_CCCCC',
            'CCCCC_BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB_CCCCC',
            'CCCCC_BBBBBBBBBBBBBBBBBBBBBBBBBBBBBB_CCCCC',

            '____________________________________________',
            'AAAAA_CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC_AAAAA',
            'AAAAA_CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC_AAAAA',
            'AAAAA_CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC_AAAAA',
            'AAAAA_CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC_AAAAA',
            'AAAAA_CCCCCCCCCCCCCCCCCCCCCCCCCCCCCC_AAAAA',
            '____________________________________________',

            'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA',
            'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA',
            'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA',
            'AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA',

        ],
        seats: {
            A: {
                classes: 'categorieBalcon', // votre classe CSS spécifique
                category: 'Balcon',
                price: prixBalcon

            },
            B: {
                classes: 'categorieOrchestre', // votre classe CSS spécifique
                category: 'Orchestre',
                price: prixOrchestre
            },
            C: {
                classes: 'categoriePoullailer', // votre classe CSS spécifique
                category: 'Poullailer',
                price: prixPoulailler
            }
        },
        naming: {
            top: false,
            getLabel: function(character, row, column) {
                return column;
            },
            getId: function(character, row, column) {
                return "Cat"+character+"_R"+row+"_S"+column;
            }
        },
        legend: {
            node: $('#legend'),
            items: [
                ['A', 'available', 'Catégorie Balcon'],
                ['B', 'available', 'Catégorie Orchestre'],
                ['C', 'available', 'Catégorie Poulailler'],
                [, 'unavailable', 'Place réservée']
            ]
        },
        click: function() {
            if (this.status() === 'available') {
                /*
                 * Une place disponible a été sélectionnée
                 * Mise à jour du nombre de places et du prix total
                 *
                 * Attention la fonction .find  ne prend pas en compte 
                 * la place qui vient d'être selectionnée, car la liste des
                 * places sélectionnées ne sera modifiée qu'après le retour de cette fonction.
                 * C'est pourquoi il est nécessaire d'ajouter 1 au nombre de places et le prix
                 * de la place sélectionnée au prix calculé.
                 */
                let prix=Math.round(this.data().price*100)/100;
                $('<div> Siege ' + this.settings.column + ' rang ' + (this.settings.row + 1) + ' (' + this.data().category + ') :<b> ' + prix +' €' + '</b>')
                    .attr('id', 'cart-item-' + this.settings.id)
                    .data('seatId', this.settings.id)
                    .appendTo($cart);

                $nbPlaces.text(sc.find('selected').length + 1);
                let prixAjout = Math.round((calculerPrixTotal(sc) + prix)*100)/100;
                $prixTotal.text(prixAjout);
                $("#achatBtn").prop("disabled", false);
                return 'selected';
            } else if (this.status() === 'selected') {
                // la place est désélectionnée
                $('#cart-item-' + this.settings.id).remove();
                let nbPlaceSelectionees = sc.find('selected').length - 1;
                $nbPlaces.text(nbPlaceSelectionees);

                if (nbPlaceSelectionees === 0) {
                    $("#achatBtn").prop("disabled", true);
                    $prixTotal.text(0);
                } else {
                    let prixApresAnnulation = Math.round(calculerPrixTotal(sc) - this.data().price*100)/100;
                    $prixTotal.text(prixApresAnnulation);
                }
                return 'available';
            } else if (this.status() === 'unavailable') {
                // la place a déjà été achetée.
                return 'unavailable';
            } else {
                return this.style();
            }
        }
    });



    $("#achatBtn").click(function() {
        acheter(sc);
    });

    //    creerPlanSalle();
    majPlanSalle();
    //    setInterval(majPlanSalle, 10000); // le plan de salle est mis à jour toutes les 10 secondes


    //    function creerPlanSalle() {
    //
    //        $.ajax({
    //            type: 'post',
    //            url: 'CreationPlanSaleService',
    //            dataType: 'json',
    //            success: function (reponse) {
    //            }
    //        });
    //    }

    /**
     * met à jour le status des places. Cette mise à jour est effectuée par un 
     * appel ajax au service d'url placesNonDisponibles.
     * La réponse de ce service est un objet JSON contenant un tableau placesVendues
     * @returns {undefined}
     */
    function majPlanSalle() {
        $.ajax({
            type: 'post',
            url: 'listePlacesReserveesService',
            dataType: 'json',
            success: function(reponse) {
                // iteration sur toutes les places vendues contenue dans l'objet reponse

                $.each(reponse, function(index, siege) {
                    //mettre à jour le status de l'objet Seat correspondant à la place vendue
                    try {
//                        return "Cat"+character+"_R"+row+"_S"+column;
                        sc.status('Cat'+siege.categorie+'_R' + siege.rang + '_S' + siege.numero, 'unavailable'); // le premier paramètre 
                    } catch (exception) {
                        console.log('siege S' + siege.rang + '-' + siege.numero + ' non trouvé.');
                    }
                    // de status est l'identifiant de la place (siège) pour laquelle on souhaite
                    // modifier le status. Ce paramètre est un chaîne, placeVendue.placeID est 
                    // de type number (entier), ''+ placeVendue.placeId permet de le convertir
                    // en chaîne de caractères (on aurait aussi pu utiliser placeVendue.placeId.toString())
                });

                let nbPlaceSelectionees = sc.find('selected').length;
                $('#nbplaces').text(nbPlaceSelectionees);
                if (nbPlaceSelectionees === 0) {
                    // le bouton achatBtn est désactivé
                    $("#achatBtn").prop("disabled", true);
                    $prixTotal.text(0);
                } else {
                    // le bouton achatBtn est activé
                    $("#achatBtn").prop("disabled", false);
                    $prixTotal.text(calculerPrixTotal(sc));
                }
            }
        });
    }
});

function majPanier(sc) {
    let nbPlaceSelectionees = sc.find('selected').length;
    $('#nbplaces').text(nbPlaceSelectionees);
    if (nbPlaceSelectionees === 0) {
        $("#achatBtn").prop("disabled", true);
        $prixTotal.text(0);
    } else {
        $("#achatBtn").prop("disabled", false);
        $prixTotal.text(calculerPrixTotal(sc));
    }
}



function calculerPrixTotal(sc) {
    let total = 0.0;
    //retrouver toutes les places sélectionnées et sommer leur prix
    sc.find('selected').each(function() {
        total = total+this.data().price;
    });
    total=Math.round(total*100)/100;
    return total;
}

function acheter(sc) {
    let params = "";
    let premier = true;
    sc.find('selected').each(function() {
        if (premier) {
            params = params + "siege=";
            premier = false;
        } else {
            params = params + "&siege=";
        }
        params = params + this.node().attr('id'); // this est un objet de type Seat
        // this.node() donne l'objet JQuery correspondant à l'élément HTML matérialisant le siège
        // .attr('id') donne la valeur de la propriété 'id" de cet élément
    });
    location.replace("ValidationCtrl?" + params);
}