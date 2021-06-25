<%-- 
    Document   : achatPlaces
    Cette page utilise le plugin jQuery jQuery Seat Charts pour afficher un
    plan de salle sur lequel l'utilisateur peut sélectionner ses places et
    les acheter.
    Cette page utilise JQuery pour à intervalles réguliers rafraichir le plan de
    salle afin de mettre à jour la liste des places disponibles.

    Author     : M2CCI 2021 projet d'intégration groupe 01
--%>
<%@page import="m2cci.pi01.cybertheatremodel.Representation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${representation.getSpectacle().getNom()} - Le ${representation.getDateOptimised()} à ${representation.getHeure()}</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"  crossorigin="anonymous"></script>
        <link href='http://fonts.googleapis.com/css?family=Lato:400,700' rel='stylesheet' type='text/css'>
        <link href="js/jQuery-Seat-Charts/jquery.seat-charts.css" rel="stylesheet" type="text/css"/>
        <link href="css/style-choixPlaces.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style-global.css">
        <link rel="stylesheet" href="css/style-listeSpectacles.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <header id="header-content">
            <div class="d-flex justify-content-between">
                <a href=".">
                    <img src="data/images/logo.png" alt="Logo MyTheatre" id="logo"
                         class="img-fluid rounded-circle img-thumbnail">
                </a>
                <div id="loginEtConnexions">
                    <a href="SInscrire.html"><button class="btn btn-warning">S'inscrire</button></a>
                    <a href="seConnecter.html"><button class="btn btn-warning">Se connecter</button></a>
                    <a href="acheterBilletPreReserve.html"><button class="btn btn-warning">Finaliser une commande</button></a>
                    <a href="ConnexionGerantCtrl"><button class="btn btn-warning">Administration</button></a>
                </div>
            </div>
        </header>
        <div class="wrapper">
            <h1>
                ${representation.getSpectacle().getNom()} - Le ${representation.getDateOptimised()} à ${representation.getHeure()}
            </h1>
            <div>
                <%
                    Representation r = (Representation) request.getAttribute("representation");
                %>
                <div class="prixDerepresentation">
                Le prix pour cette représentation est 
                <div id="prixRepresentation">
                    <%=r.getSpectacle().getPrixDeBase() * r.getTauxReductionExceptionnelle()%>
                </div>
                </div>
            </div>
                <div id="map-container" class="mapSalle">
                <!-- Le div qui contient le plan de la salle -->
                <div id="seat-map">
                    <div class="front-indicator">Scène</div>
                </div>
                <!-- Le div qui contient le récapitulatif des places sélectionnées par
                     l'utilisateur -->
                <div id="commande">
                    <div id="legend"></div>
                    <h3>Votre sélection</h3>
                    <div id="siegesSelectionnes"></div>
                    <p>Nombre de places: <strong><span id="nbplaces">0</span></strong></p>
                    <p>Prix Total: <strong><span id="prixtotal">0</span> €</strong></p>
                    <button id="achatBtn" class="btn btn-warning" disabled>Réserver</button>
                </div>
            </div>
            <hr>
        </div>
        <footer>
            <p>Abandon et <a href=".">retour à l'accueil</a></p>
        </footer>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="js/jQuery-Seat-Charts/jquery.seat-charts.min.js" type="text/javascript"></script>
        <script src="js/choixPlaces.js" type="text/javascript"></script>
    </body>
</html>

