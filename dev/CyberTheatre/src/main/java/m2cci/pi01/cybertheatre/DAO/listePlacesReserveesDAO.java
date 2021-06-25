/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

/*
Permet de récupérer les places déjà réservées pour les afficher sur la page de séléction des sièges
 */
package m2cci.pi01.cybertheatre.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatremodel.Billet;
import m2cci.pi01.cybertheatremodel.Representation;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DAO proposant différentes méthodes concernant les spectacles proposés.
 *
 * @author M2CCI 2021 projet d'intégration groupe 01
 */
public class listePlacesReserveesDAO {

    public static JSONArray listePlaceReserveesJSON(DataSource bdSQL, Representation representation)
            throws SQLException {
        String requete = "SELECT *\n"
                + "FROM Billets_base JOIN Sieges USING (numeroSiege, rangSiege)\n"
                + "JOIN Zones USING (numeroZone)\n"
                + "WHERE dateRepresentation = ? AND heureDebutRepresentation = ?";

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatHeure = DateTimeFormatter.ofPattern("HH:mm:ss");

        String stringDate = representation.getDate().format(formatDate);
        String stringHeure = representation.getHeure().format(formatHeure);

        try (
                 Connection conn = bdSQL.getConnection();  PreparedStatement stmt = conn.prepareStatement(requete)) {
            stmt.setString(1, stringDate);
            stmt.setString(2, stringHeure);

            ResultSet rs = stmt.executeQuery();

            JSONArray resultats = new JSONArray();

            while (rs.next()) {
//                resultats.add(new Siege(rs.getInt("numeroSiege"), rs.getInt("rangSiege")));
                String bddCat = rs.getString("nomCategorie");
                String jsCat;
                if (bddCat.equals("poulailler")) {
                    jsCat = "C";
                } else if(bddCat.equals("balcon")) {
                    jsCat = "A";
                } else {
                    jsCat = "B";
                }
                JSONObject siege = new JSONObject();
                siege.put("numero", rs.getInt("numeroSiege"));
                siege.put("rang", rs.getInt("rangSiege"));
                siege.put("categorie", jsCat);
                resultats.add(siege);
            }
            return resultats;
        }
    }
}

//        JSONArray ja = new JSONArray();
//        ja.add(Boolean.TRUE);
//        ja.add("lorem ipsum");
//
//        JSONObject jo = new JSONObject();
//        jo.put("name", "jon doe");
//        jo.put("age", "22");
//        jo.put("city", "chicago");
//
//        ja.add(jo);
//        String jsonstring = ja.toString();
