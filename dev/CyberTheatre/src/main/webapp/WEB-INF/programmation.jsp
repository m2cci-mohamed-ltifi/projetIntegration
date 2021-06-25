<%-- Document : listeRepresentations Created on : 18 mars 2021, 14:37:48 Author : M2CCI 2021 projet d'intégration groupe 01 --%>

<%@page import="m2cci.pi01.cybertheatremodel.Representation" %>
<%@page import="java.util.List" %>
<%@page import="m2cci.pi01.cybertheatremodel.Spectacle" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="container-fluid">
    <% List<Spectacle> programmation = (List<Spectacle>) request.getAttribute("programmation");

        if (programmation.size() == 0) {
    %>
    <div class="row" id="noProgBox">
        <div class="border border-warning rounded" id="noProgMessage">
            Nous sommes désolé, aucun spectacle ne correspond à vos critères.
        </div>
    </div>
    <% }
        int i = 0;
        for (Spectacle s : programmation) {
            i++;%>
    <div class="row representation">
        <div class="col-md-2 d-flex align-items-center vignette">
            <img src=<%=s.getImageSource()%> onerror="this.onerror=null;
                 this.src='data/images/vignetteNonDefinie.png'" alt="vignette spectacle"
                 class="border border-warning rounded">
        </div>
        <div class="col-md-10 description border border-warning rounded">
            <h3>
                <%=s.getNom()%>
            </h3>
            <p>
                <%
                    if (s.getDescription() == null || s.getDescription() == "") {
                %>
                <i>Aucune description pour ce spectacle</i>
                <%
                } else {
                %>
                <%=s.getDescription()%>
                <% 
                    }
                %>
            </p>
            <div class="row">
                <div class="col-md-4">
                    <div class="duree">Durée : <b>
                            <%=s.getDuree()%> minutes
                        </b></div><br>
                    <div class="typeSpectacle">Type de spectacle : <b>
                            <%=s.getType()%>
                        </b></div>
                    <div class="typePublic">Type de public : <b>
                            <%=s.getPublicCible()%>
                        </b></div><br>
                </div>
                <div class="col-md-4 prixParCategorie">
                    <div><b>Prix par catégorie</b></div>
                    <div class="container-fluid">

                        <div class="row prixCatPoulailler">
                            <div class="col-md-6 prix">
                                <div class="prixPoulailler"
                                     onmouseover="mouseOnPoul(<%=i%>)"
                                     onmouseout="mouseOutPoul(<%=i%>)">
                                    <b>
                                        <%=s.getPrixDeBase()%>0
                                    </b>€
                                </div>
                            </div>
                            <div class="col-md-6 cat">
                                <div id="id_div_1<%=i%>" style="display:none;">
                                    <b>Poulailler</b>
                                </div>
                            </div>
                        </div>
                        <div class="row prixCatOrchestre">
                            <div class="col-md-6 prix">
                                <div class="prixOrchestre"
                                     onmouseover="mouseOnOrch(<%=i%>)"
                                     onmouseout="mouseOutOrch(<%=i%>)">
                                    <b>
                                        <%=s.getPrixDeBase() * 1.2%>0
                                    </b>€
                                </div>
                            </div>
                            <div class="col-md-6 cat">
                                <div id="id_div_2<%=i%>" style="display:none;">
                                    <b>Orchestre</b>
                                </div>
                            </div>
                        </div>
                        <div class="row prixCatBalcon">
                            <div class="col-md-6 prix">
                                <div class="prixBalcon" onmouseover="mouseOnBal(<%=i%>)"
                                     onmouseout="mouseOutBal(<%=i%>)">
                                    <b>
                                        <%=s.getPrixDeBase() * 1.5%>0
                                    </b>€
                                </div>
                            </div>
                            <div class="col-md-6 cat">
                                <div id="id_div_3<%=i%>" style="display:none;">
                                    <b>Balcon</b>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 Listerepresentation">
                    <div><b>Représentations</b></div>
                    <div class="Listerepresentation">
                        <% for (Representation r : s.getRepresentations()) { %>
                        <%if (r.getTauxReductionExceptionnelle() != 1) {%>
                        <div id="reduction" style="display: inline">
                            -
                            <%=(int) (Math.round((1 - r.getTauxReductionExceptionnelle()) * 100))%>
                            %
                        </div>
                        <%}%>
                        <%if (r.getNombePlaceDisponible()==0){%>
                        <span data-toggle="tooltip" title="Plus de place disponible!">
                            <%=r.getDateOptimised()%> à
                            <%=r.getHeure()%>
                        </span><br>
                        <%}else{%>
                        <a href="ChoixPlacesCtrl?spectacle=<%=r.getSpectacle().getNom()%>&date=<%=r.getDate()%>&heure=<%=r.getHeure()%>">
                            <%=r.getDateOptimised()%> à
                            <%=r.getHeure()%>
                        </a><br>
                        <%}%>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <% }%>
</div>