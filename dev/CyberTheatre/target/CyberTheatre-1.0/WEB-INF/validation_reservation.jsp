<%-- 
    Document   : validation_prereserver
    Created on : 30 mars 2021, 09:16:52
    Author     : M2CCI 2021 projet d'intégration groupe 01
--%>

<%@page import="m2cci.pi01.cybertheatremodel.Billet"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div>
    <%
        ArrayList<Billet> billets = (ArrayList<Billet>) request.getAttribute("billets");
        Boolean achete = (Boolean) request.getAttribute("achete");

        if (achete) {
    %>
    Félicitation, votre commande est validée !
    <%
        } else {
    %>
    Votre préréservation à été enregistrée. Revenez au plus vite pour la valider !
    <%
        }
    %>
    <br>
    Votre dossier d'achat est le <b>n° <%=billets.get(0).getDossier().getNumero()%></b><br>
    Pensez à le noter pour retrouver votre billet ! <br>
    <br>
    Vous pouvez télécharger votre billet en cliquant <a href="billetPDF">ici</a>
    <br>
    Merci, et à bientôt !
</div>
