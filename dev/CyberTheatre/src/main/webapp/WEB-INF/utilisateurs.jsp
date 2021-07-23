
<%@page import="m2cci.pi01.cybertheatremodel.Utilisateur"%>
<%@page import="java.util.List" %>
<div><% List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("utilisateurs");

    if (utilisateurs == null) {
    %>
    } 
    <div class="border border-warning rounded" id="noProgMessage">
        Nous sommes désolé, aucun spectacle ne correspond à vos critères.
    </div><% } else {%>

    <div class="container-fluid">
        <%
            for (Utilisateur u : utilisateurs) {

        %>
        <div class="row">
            <div class="col-md-6" text-align: "center">
                <h1> <%=u.getNom()%>
                </h1><br>

            </div>
            <div class="col-md-6" text-align: "center">
                <h1>
                <%=u.getPrenom()%>
                
                </h1><br>
            </div>
        </div>
                <% }
                    }%>


    </div>
</div>

