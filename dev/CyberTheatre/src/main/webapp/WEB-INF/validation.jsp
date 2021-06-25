<%-- 
    Document   : resumeAvantValidation
    Created on : 28 mars 2021, 15:21:30
    Author     : M2CCI 2021 projet d'intégration groupe 01
--%>

<%@page import="m2cci.pi01.cybertheatremodel.Representation"%>
<%@page import="m2cci.pi01.cybertheatremodel.Sieges.Siege"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validation de votre commande</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style-global.css">
        <link rel="stylesheet" href="css/style-validation.css">
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
                    <div class="container border border-warning rounded" id="resume">
                        <div class="row">
                            <p>Résumé de votre commande</p>
                            <%
                    Representation r = (Representation) request.getAttribute("representation");
                %>
            </div>
            <div class="row">
                <h2>${representation.getSpectacle().getNom()}, le ${representation.getDateOptimised()} à ${representation.getHeure()} </h2>
            </div>
            <div class="row" style="margin: auto">
                <%
                    ArrayList<Siege> siegesSelectionnes = (ArrayList<Siege>) request.getAttribute("siegesSelectionnes");
                %>
                <ul class="list-group">
                    <%
                        int i = 0;
                        for (Siege s : siegesSelectionnes) {
                            i++;
                    %>
                    <li class="list-group-item">

                        Siege
                        <%=s.getNumero()%> rang <%=s.getRang()%> (Categorie <%=s.getZone().getCategorie().toString().toLowerCase()%>) :
                        <%
                            float coefficient;
                            coefficient = (float)s.getZone().getCategorie().getCoefficientCategorie();
                            
                        %>
                        <span id="prixPlaceSansReduction_<%=i%>" class="prixToHide"><%=(double)Math.round(r.getSpectacle().getPrixDeBase() * r.getTauxReductionExceptionnelle() * coefficient*100)/100%></span>
                        <span id="prixPlaceReduit_<%=i%>" class="prixToShow">0</span>€
                        <span class="choixTarifReduit">
                            <select class="choixTarifReduitBtn" name="tarifReduit" id="tarifReduit_<%=i%>">
                                <option value="aucun">plein tarif</option>
                                <option value="etudiant">etudiant</option>
                                <option value="famille_nombreuse">famille nombreuse</option>
                                <option value="militaire">militaire</option>
                                <option value="senior">senior</option>
                            </select>
                        </span>
                    </li>
                    <%
                        }
                    %>
                </ul>
                <p>  </p>
            </div>
            <div class="row">
                Prix total :&nbsp <span id="prixTotal"></span>€
            </div>
        </div>
        <br>
        <div class="container border border-warning rounded" id="validation">
            <input class="form-check-input" type="radio" name="achatVSPrereservation" id="acheterRadio" />
            <label class="form-check-label" for="acheterRadio"> Acheter maintenant </label>
            <br>
            <input class="form-check-input" type="radio" name="achatVSPrereservation" id="prereserverRadio" checked />
            <label class="form-check-label" for="prereserverRadio"> Réserver les places pour acheter plus tard </label>
            <br>
            <button id="achatOuPrereservatoionBtn" class="btn btn-warning">Valider</button>
        </div>
        <footer>
            <p>Abandon et <a href=".">retour à l'accueil</a></p>
        </footer>
        <script src="js/validation.js" type="text/javascript"></script>
        <script src="../js/choixPlaces.js" type="text/javascript"></script>
        <script src="/js/TarifReduit.js" type="text/javascript"></script>
    </body>
</html>