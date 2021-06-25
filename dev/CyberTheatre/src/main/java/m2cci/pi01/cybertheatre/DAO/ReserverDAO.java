/*
 Permet de créer des billets et de les ajouter dans la base de données
 */
package m2cci.pi01.cybertheatre.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatremodel.Billet;
import m2cci.pi01.cybertheatremodel.DossierDAchat;
import m2cci.pi01.cybertheatremodel.Representation;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;


public class ReserverDAO {

    public static ArrayList<Billet> reserverPlaces(DataSource bdSQL, Boolean acheter, Representation representation, ArrayList<Siege> sieges, Double[] tarifsReduits)
            throws SQLException {

        String requeteDossier = "INSERT INTO DossierDachats_base(acheteDossier) VALUES (?);";
        Integer numeroDossier;

        try (
                 Connection conn = bdSQL.getConnection();  PreparedStatement stmtDossier = conn.prepareStatement(requeteDossier);) {
            if (acheter) {
                stmtDossier.setInt(1, 1);
            } else {
                stmtDossier.setInt(1, 0);
            }
            stmtDossier.executeUpdate();

            try ( ResultSet keys = stmtDossier.getGeneratedKeys()) {
                keys.next();
                numeroDossier = keys.getInt(1);
            }
        }

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatHeure = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatDateHeure = DateTimeFormatter.ofPattern("dd-MM-yyy_HH:mm:ss");

        DossierDAchat dossier = new DossierDAchat(numeroDossier, acheter);
        LocalDateTime dateHeureAchat = LocalDateTime.now();
        String requeteBillets = "INSERT INTO Billets_base(dateRepresentation,"
                + "heureDebutRepresentation,"
                + "numeroSiege,"
                + "rangSiege,"
                + "numeroDossier,"
                + "dateAchatBillet,"
                + "tarifReduitBillet) "
                + "VALUES ('"
                + representation.getDate().format(formatDate) + "','"
                + representation.getHeure().format(formatHeure) + "',?,?,"
                + numeroDossier + ",'"
                + dateHeureAchat.format(formatDateHeure) + "',"
                + "?);";

        System.out.println(requeteBillets);
        
        ArrayList<Billet> billets = new ArrayList<>();
        ArrayList<Integer> numerosBillets = new ArrayList<>();
        try (
                 Connection conn = bdSQL.getConnection();  PreparedStatement stmtBillets = conn.prepareStatement(requeteBillets);) {

            for (int i = 0; i < sieges.size(); i++) {
                stmtBillets.setInt(1, sieges.get(i).getNumero());
                stmtBillets.setInt(2, sieges.get(i).getRang());
                stmtBillets.setDouble(3, tarifsReduits[i]);

                stmtBillets.executeUpdate();

                try ( ResultSet keys = stmtBillets.getGeneratedKeys()) {
                    keys.next();
                    billets.add(new Billet(sieges.get(i), representation, dossier, keys.getInt(1), dateHeureAchat, tarifsReduits[i]));
                }
            }

        }

        return billets;
    }
}
