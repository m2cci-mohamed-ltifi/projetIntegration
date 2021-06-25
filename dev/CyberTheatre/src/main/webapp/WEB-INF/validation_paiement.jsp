<%-- 
    Document   : validation_confirmee
    Created on : 30 mars 2021, 08:41:22
    Author     : M2CCI 2021 projet d'intégration groupe 01
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <form id="formulairePaiement">
            <div id="titrePaiement">
                <b>Paiement sécurisé par carte bancaire</b> <img src="data/images/cartes.png" alt="cartes" id="imageCartes" class="img-fluid">
            </div><br>
            <div id='entreeInformations'>
                <table>
                    <tr>
                        <td>
                            <p><b>*</b>Titulaire du compte</td>
                        <td> <input required type='text' name='entreeTitulaire' value='' placeholder="Jean Dupont"></p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p><b>*</b>Numéro de carte</td>
                        <td> <input type='text' required name='entreeNumeroCarte' value='' placeholder="5135 4685 5146 5412"></p>
                            <td>
                    </tr>
                    <tr>
                        <td>
                            <p><b>*</b>Date d'expiration</td>
                        <td> <select id='dateMois' type='text' name='entreeDateExpirationMois' size='1'></p> 
                        <option> 01
                        <option> 02
                        <option> 03
                        <option> 04
                        <option> 05
                        <option> 06
                        <option> 07
                        <option> 08
                        <option> 09
                        <option> 10
                        <option> 11
                        <option> 12
                    </select>
                            <select id='dateAnnee' type='text' name='entreeDateExpirationAnnee' size='1'></p>
                        <option> 2021
                        <option> 2022
                        <option> 2023
                        <option> 2024
                        <option> 2025
                    </select></td>
                    </tr>
                    <tr>
                        <td>
                            <p><b>*</b>Cryptogramme Visuel</td>
                        <td> <input required name='entreeTitulaire' value='' placeholder='521'></p>
                        </td>
                    </tr>
                </table>
                <div id='validerEtPayer'>
                    <button id="validationAchat" class="btn btn-warning">Valider et Payer</button>
                </div>
            </div>
        </form>