<%-- Document : listeRepresentations Created on : 18 mars 2021, 14:37:48 Author : M2CCI 2021 projet d'intégration groupe 01 --%>

<%@page import="m2cci.pi01.cybertheatremodel.Representation" %>
<%@page import="java.util.List" %>
<%@page import="m2cci.pi01.cybertheatremodel.Spectacle" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

    <head>
        <title>MyTheatre - Liste des représentations</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Scripts -->
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        <script
        src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/11.0.2/bootstrap-slider.min.js"></script>
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/11.0.2/css/bootstrap-slider.min.css">
        <link rel="stylesheet" href="css/style-global.css">
        <link rel="stylesheet" href="css/style-listeSpectacles.css">
    </head>

    <body>
        <div>
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

            <br>
            <br>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-9 offset-md-3">
                        <h1>Programmation des spectacles</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3" id="filtresBox">
                        <div class="border rounded sticky-top">
                            <form class="form-horizontal" id="filtresForm">
                                <div class="row">
                                    <div class="col-md-6" id="choixSpectales">
                                        <label class="form-label">Choisissez votre spectacle :</label>
                                    </div>
                                    <div class="col-md-6">


                                        <div class="col-md-6" id="triBox"> 
                                            <div class="dropdown"> 
                                                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" 
                                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
                                                    Trier Par : </button> <div class="dropdown-menu" aria-labelledby="dropdownMenuButton"> 
                                                    <div class="form-check"> 
                                                        <input type="radio" class=".form-check-input" id="trierParNom" 
                                                               name="buttonTri" value="nomSpectacle" checked> 
                                                        <label for="tri_nom" class="form-check-label">Nom</label> 
                                                    </div> 
                                                    <div class="form-check"> 
                                                        <input type="radio" class=".form-check-input" id="trierParPrix" 
                                                               name="buttonTri" value="prixDeBaseSpectacle"> 
                                                        <label for="tri_PrixDeBase" class="form-check-label">Prix</label> 
                                                    </div> 
                                                    <div class="form-check"> 
                                                        <input type="radio" class=".form-check-input" id="trierParDuree" 
                                                               name="buttonTri" value="dureeSpectacle"> 
                                                        <label for="tri_Duree" class="form-check-label">Duree</label> 
                                                    </div> 
                                                </div> 
                                            </div> 
                                        </div>
                                    </div>
                                </div>

                                  
                                <div class="form-group">
                                    <label for="site-search"><b>Titre</b></label><br>
                                    <input type="search" id="site-search" name="titreSpectacle"
                                           aria-label="Rechercher un spectacle"><br>
                                </div>

                                <div class="form-group">
                                    <label class="form-label"><b>Dates</b></label>
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <label for="premierJour">Entre le</label>
                                            </div>
                                            <div class="col-md-8">
                                                <input class="form-control" type="date" id="premierJour"
                                                       name="premierJour">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <label for="dernierJour">et le</label>
                                            </div>
                                            <div class="col-md-8">
                                                <input class="form-control" type="date" id="dernierJour"
                                                       name="dernierJour">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label><b>Plage horaire</b></label><br>Début du spectacle entre
                                    <span id="debutPlage" name="debutPlage">10</span>h et <span
                                        id="finPlage">24</span>h<br>
                                    <div class="sliderHeureContainer">
                                        <input id="sliderHeures" type="text" name="plageHoraire" data-slider-handle="custom" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="form-label"><b>Type de spectacle</b></label>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_typeOpera" name="checkTypeSpectacle"
                                               value="opera">
                                        <label for="filtre_typeOpera"
                                               class="form-check-label">Opéra</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_typeDrame" name="checkTypeSpectacle"
                                               value="drame">
                                        <label for="filtre_typeDrame"
                                               class="form-check-label">Drame</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_typeHumoristique" name="checkTypeSpectacle"
                                               value="humoristique">
                                        <label for="filtre_typeHumoristique"
                                               class="form-check-label">Humoristique</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_typeMusical" name="checkTypeSpectacle"
                                               value="musical">
                                        <label for="filtre_typeMusical"
                                               class="form-check-label">Musical</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_typeCirque" name="checkTypeSpectacle"
                                               value="cirque">
                                        <label for="filtre_typeCirque"
                                               class="form-check-label">Cirque</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="form-label"><b>Public cible</b></label>

                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_public1-5ans" name="checkPublicCible"
                                               value="public1a5Ans">
                                        <label for="filtre_public1-5ans" class="form-check-label">Enfant
                                            entre 1 et 5
                                            ans</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_publicJeunes" name="checkPublicCible"
                                               value="jeunePublic">
                                        <label for="filtre_publicJeunes" class="form-check-label">Jeune
                                            public</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_publicAll" name="checkPublicCible"
                                               value="toutPublic">
                                        <label for="filtre_publicAll" class="form-check-label">Tout
                                            public</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class=".form-check-input"
                                               id="filtre_publicAdulte" name="checkPublicCible"
                                               value="adulte">
                                        <label for="filtre_publicAdulte"
                                               class="form-check-label">Adultes</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="slidecontainer">
                                        <p><b>Prix maximum: </b> <span id="prix"></span>€</p>
                                        <input type="range" min="10" max="250" value="80" class="slider"
                                               id="slidePrix" name="prixChoisi">
                                    </div>
                                </div>

                                <br>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-9" id="programmationFiltree">
                    </div>
                </div>
            </div>
        </div>
        <footer>
        </footer>
        <script src="js/sliderSimple.js"></script>
        <script src="js/sliderDouble.js"></script>
        <script src="js/dateRecherche.js"></script>
        <script src="js/programmationLoader.js"></script>
        <script src="js/prixParCategorie.js" type="text/javascript"></script>
    </body>
</html>