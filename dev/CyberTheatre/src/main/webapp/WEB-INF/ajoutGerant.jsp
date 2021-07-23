<%-- 
    Document   : ajoutGerant
    Created on : 31 mars 2021, 15:59:55
    Author     : im2ag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MyTheatre - Ajout Spectacles et/ou Représentations par le Gérant</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap -->
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

        <link rel="stylesheet" href="css/style-global.css">
        <link href="css/style-ajoutGerant.css" rel="stylesheet" type="text/css"/>
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
        <div id='ajoutSpectacle' class="container border border-warning rounded">
            
            <button onclick="afficherFormulaireSpectacle()" id="btnSpectacle" class="btn btn-warning">Ajouter un spectacle</button>
            <div id="formulaireSpectacle">
                <form>
                <table>
                    <tr>
                        <td><p><b>*</b>Nom du spectacle</td><td> <input id='nomSpectacle' required type='text' name='nomSpectacle' value='' placeholder="M2CCI groupe 01"></p></td>
                    </tr>
                    <tr>
                        <td><p><b>*</b>Public ciblé</td><td> <select id='publicCible' type='text' name='publicCible' size='1'>
                                <option value="TOUTPUBLIC"> Tout public
                                <option value="ADULTE"> Adulte
                                <option value="JEUNEPUBLIC"> Jeune Public
                                <option value="PUBLIC1A5ANS"> 1 à 5 ans

                            </select></p></td>

                    <tr>
                        <td><p><b>*</b>Prix de base</td><td> <input id='prixBase' required type='text' name='prixBase' value='' placeholder="45"></p></td>
                    </tr>
                    <tr>
                        <td><p><b>*</b>Durée du spectacle en minutes</td><td> <input id='dureeSpectacle' required type='text' name='dureeSpectacle' value='' placeholder="160"></p></td>    
                    </tr>
                    <tr>
                        <td><p><b>*</b>Type de Spectacle</td><td> <select id='typeSpectacle' type='text' name='typeSpectacle' size='1'>
                                <option value="HUMORISTIQUE"> Humoristique
                                <option value="DRAME"> Drame
                                <option value="OPERA"> Opéra
                                <option value="MUSICAL"> Musical
                                <option value="CIRQUE"> Cirque
                                    </tr>
                                <tr>
                                    <td><p><b>*</b>One-Man-Show</td><td> <select id='oneManShow' type='text' name='oneManShow' size='1'>
                                            <option> oui
                                            <option> non
                                        </select></p></td>
                                </tr>
                                <tr>
                                    <td><p><b>*</b>Orchestre</td><td> <select id='orchestre' type='text' name='orchestre' size='1'>
                                            <option> oui
                                            <option> non
                                        </select></p></td>
                                </tr>
                                <tr>
                                    <td><p>Description Spectacle</td><td> <textarea id='descriptionSpectacle' name='descriptionSpectacle' cols="40" rows="5" placeholder="C'est l'histoire d'Oulaya, Ayoub, Philémon et Emilie qui essaient de créer un site internet."></textarea></p></td>
                                </tr>
                                <tr>
                                    <td><p>Image du spectacle</td><td> <input id='imageSpectacle' required type='file' name='imageSpectacle' accept="image/png, image/jpeg, image/jpg"</td></p>
                                </tr>
                </table>
                <div id='validerAjoutSpectacle'>
                    
                    <button id="validationAjoutSpectacle" name="validationAjoutSpectacle" class="btn btn-warning">Valider</button>
                </div>
                </form>
            </div>
        </div>
        <br>
        
        <div id='ajoutRepresentation' class="container border border-warning rounded">
            
            <button onclick="afficherFormulaireRepresentation()" id="btnRepresentation" class="btn btn-warning">Ajouter une représentation</button>
            <div id="formulaireRepresentation">
                <form>
                <table>
                    <tr>

                        <td>
                            <p><b>*</b>Sélectionnez un spectacle pour ajouter une représentation :
                        </td>
                        <td> <select id='spectacle' type='text' name='spectacle' size='1'>
                                <option> ---
                                <option> ---
                            </select></p>
                        </td>
                    </tr>
                    <tr>
                        <td><p><b>*</b>Date Representation</td><td> 
                            <input required class="form-control" type="date" id="dateRepresentation"
                                   name="dateRepresentation">
                            </p></td>
                    </tr>
                    <tr>
                        <td><p><b>*</b>Heure Début Representation</td><td> 
                            <input required class="form-control" type="time" id="heureDebutRepresentation"
                                   name="heureDebutRepresentation">
                            </p></td>
                    </tr>
                    <tr>
                        <td><p><b>*</b>Taux de réduction exceptionnelle</td><td> 
                            <input required class="form-control" type="number" step="0.1" id="tauxReductionExceptionnelle"
                                   name="tauxReductionExceptionnelle">
                            </p></td>
                    </tr>
                </table>
                <div id='validerAjoutRepresentation'>
                    <button id="validationAjoutRepresentation" class="btn btn-warning">Valider</button>
                </div>
                </form>
            </div>
            
        </div>
        <br>
        <div class="container border border-warning rounded" id="usersList">
            <button id="btnUsers" class="btn btn-warning">
                <a href="ConsulterUtilisateurs">Consulter les utilisateurs</a>
            </button>
        </div>

        <script src="js/formulairesGerant.js" type="text/javascript"></script>
    </body>
    <footer>
        </footer>
</html>
