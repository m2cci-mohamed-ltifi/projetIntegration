<%@page import="m2cci.pi01.cybertheatremodel.Utilisateur"%>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style-global.css">
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
<html lang="fr">
    <head>
        <title>MyTheatre - Liste des utilisateurs</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/users.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
        
            <input type="text" value='' name="nom" id="nom">
            <button id="validationSInscrire" class="btn btn-warning">search</button>
       
        </div>
        <div id="userList">
            Les utilisateurs
        </div>
    </body>
</html>
