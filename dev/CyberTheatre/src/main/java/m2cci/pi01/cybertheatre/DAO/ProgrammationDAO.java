/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
 */

/* Récupère les informations des spectacles et de leurs représentations pour les afficher */


package m2cci.pi01.cybertheatre.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatremodel.Representation;
import m2cci.pi01.cybertheatremodel.Spectacle;
import m2cci.pi01.cybertheatremodel.TypeDePublic;
import m2cci.pi01.cybertheatremodel.TypeDeSpectacle;


public class ProgrammationDAO {

    public static List<Spectacle> getProgrammation(DataSource bdSQL, String typeDeSpectacle[], String typeDePublic[], String titre, int prixMax, LocalDate datePremierJour, LocalDate dateDernierJour, LocalTime heureDebut, LocalTime heureFin, String trierPar)
            throws SQLException {
        String requeteRepresentations
                = "SELECT * "
                + "FROM Spectacles JOIN Representations USING (numeroSpectacle) "
                + "WHERE numeroSpectacle = ? ";
        String requeteSpectacles = "SELECT * FROM Spectacles";
        //Format de date utlisé
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int nombre_parametresSpectacles = 0;
        boolean firstfilter = Boolean.TRUE;

//requête fitlre type de spectacle
        ArrayList<Integer> position_typeSpectacle = new ArrayList<Integer>();
        if (typeDeSpectacle != null && typeDeSpectacle.length > 0) {
            firstfilter = Boolean.FALSE;
            requeteSpectacles += " WHERE (typeSpectacle = ? ";
            nombre_parametresSpectacles++;
            position_typeSpectacle.add(nombre_parametresSpectacles);
            for (int i = 1; i < typeDeSpectacle.length; i++) {
                requeteSpectacles += " OR typeSpectacle = ? ";
                nombre_parametresSpectacles++;
                position_typeSpectacle.add(nombre_parametresSpectacles);
            }
            requeteSpectacles += " ) ";
        }
//requête filtre type de public
        ArrayList<Integer> position_typePublic = new ArrayList<Integer>();
        if (typeDePublic != null && typeDePublic.length > 0) {
            if (firstfilter) {
                requeteSpectacles += " WHERE ";
                firstfilter = Boolean.FALSE;
            } else if (typeDeSpectacle.length > 0) {
                requeteSpectacles += " AND ";
            }
            requeteSpectacles += "(publicCibleSpectacle = ? ";
            nombre_parametresSpectacles++;
            position_typePublic.add(nombre_parametresSpectacles);
            for (int i = 1; i < typeDePublic.length; i++) {
                requeteSpectacles += " OR publicCibleSpectacle = ? ";
                nombre_parametresSpectacles++;
                position_typePublic.add(nombre_parametresSpectacles);
            }
            requeteSpectacles += " ) ";
        }
// requête filtre titre de spectacle
        //Le parametre "nomSpectacle LIKE '%mystring%'
        //(au lieu de nomSpectacle = 'myString')
        //permet de rechercher les éléments contenant myString, pas l'égalité exacte
        Integer position_titre = null;
        if (titre != null && titre.length() > 0) {
            //Supprimer les espace en déut et fin de la chaine
            titre = titre.trim();
            if (firstfilter) {
                requeteSpectacles += " WHERE nomSpectacle LIKE ? ";
                firstfilter = Boolean.FALSE;
            } else {
                requeteSpectacles += " AND nomSpectacle LIKE ? ";
            }
            nombre_parametresSpectacles++;
            position_titre = nombre_parametresSpectacles;
        }
// requête filtre prix maximal
        Integer position_prix = null;
        if (prixMax != 0) {
            if (firstfilter) {
                requeteSpectacles += " WHERE prixDeBaseSpectacle <= ? ";
                firstfilter = Boolean.FALSE;
            } else {
                requeteSpectacles += " AND prixDeBaseSpectacle <= ? ";
            }
            nombre_parametresSpectacles++;
            position_prix = nombre_parametresSpectacles;
            //requeteSpectacles += "ORDER BY nomSpectacle";
        }
        requeteSpectacles += "ORDER BY " + trierPar;
// filtre dates 
        System.out.println(requeteRepresentations);

        // Première requête : liste des spectacles
        try (
                Connection conn = bdSQL.getConnection(); PreparedStatement stmtSpectacles = conn.prepareStatement(requeteSpectacles); PreparedStatement stmtRepresentations = conn.prepareStatement(requeteRepresentations)) {

            for (int i = 0; i < position_typeSpectacle.size(); i++) {
                stmtSpectacles.setString(position_typeSpectacle.get(i), typeDeSpectacle[i]);
            }

            for (int i = 0; i < position_typePublic.size(); i++) {
                stmtSpectacles.setString(position_typePublic.get(i), typeDePublic[i]);
            }

            if (position_titre != null) {
                stmtSpectacles.setString(position_titre, "%" + titre + "%");
            }

            if (position_prix != null) {
                stmtSpectacles.setInt(position_prix, prixMax);
            }

            List<Spectacle> programmation = new ArrayList<>();
            Spectacle currentSpectacle;
            ResultSet rs_listeSpectacles = stmtSpectacles.executeQuery();
            while (rs_listeSpectacles.next()) {
                currentSpectacle = new Spectacle(
                        rs_listeSpectacles.getInt("numeroSpectacle"),
                        rs_listeSpectacles.getString("nomSpectacle"),
                        TypeDePublic.valueOf(rs_listeSpectacles.getString("publicCibleSpectacle").toUpperCase()),
                        rs_listeSpectacles.getDouble("prixDeBaseSpectacle"),
                        TypeDeSpectacle.valueOf(rs_listeSpectacles.getString("typeSpectacle").toUpperCase()),
                        rs_listeSpectacles.getInt("dureeSpectacle"),
                        rs_listeSpectacles.getString("descriptionSpectacle"),
                        rs_listeSpectacles.getString("imageSourceSpectacle")
                );
                programmation.add(currentSpectacle);
                //Seconde requette : liste des représentations pour chaque spectacle
                stmtRepresentations.setInt(1, rs_listeSpectacles.getInt("numeroSpectacle"));

                ResultSet rs_representationsParSpectacle = stmtRepresentations.executeQuery();

                while (rs_representationsParSpectacle.next()) {
                    LocalDate dateRepresentation = LocalDate.parse(
                            rs_representationsParSpectacle.getString("dateRepresentation"), formatDate);
                    LocalTime heureRepresentation = LocalTime.parse(
                            rs_representationsParSpectacle.getString("heureDebutRepresentation"));

                    if (LocalDate.now().isBefore(dateRepresentation)) {
                        if ((datePremierJour == null || (datePremierJour.isBefore(dateRepresentation) || datePremierJour.isEqual(dateRepresentation)))) {
                            if (dateDernierJour == null || (dateDernierJour.isAfter(dateRepresentation) || dateDernierJour.isEqual(dateRepresentation))) {
                                if (heureFin.equals(LocalTime.of(00, 00, 00))) {
                                    heureFin = LocalTime.of(23, 59, 59);
                                }//Pour qu'il affiche les représentation jusqu'à minuit
                                if ((heureDebut.isBefore(heureRepresentation) || heureDebut.equals(heureRepresentation)) && (heureFin.isAfter(heureRepresentation) || heureFin.equals(heureRepresentation))) {
                                    currentSpectacle.ajouterRepresentation(
                                            dateRepresentation,
                                            heureRepresentation,
                                            rs_representationsParSpectacle.getDouble("tauxReductionExceptionnelleRepresentation"),
                                            rs_representationsParSpectacle.getInt("nombrePlacesRestanteRepresentation")
                                    );
                                }
                            }
                        }
                    }
                }

                //Supprime le spectacle de la programmation retournée s'il n'y a aucune représentation valide
                if (currentSpectacle.getRepresentations().size() == 0) {
                    programmation.remove(currentSpectacle);
                }
            }
            return programmation;
        }
    }

    public static Representation getRepresentation(DataSource bdSQL, LocalDate date, LocalTime heure)
            throws SQLException {

        String requete
                = "SELECT *\n"
                + "FROM Spectacles JOIN Representations USING (numeroSpectacle)\n"
                + "WHERE dateRepresentation = ? AND heureDebutRepresentation = ?";

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatHeure = DateTimeFormatter.ofPattern("HH:mm:ss");
        String stringDate = date.format(formatDate);
        String stringHeure = heure.format(formatHeure);

        try (
                Connection conn = bdSQL.getConnection(); PreparedStatement stmt = conn.prepareStatement(requete)) {
            stmt.setString(1, stringDate);
            stmt.setString(2, stringHeure);

            ResultSet rs = stmt.executeQuery();
            rs.next(); //Lit la première ligne de résultat. Il y a toujours une seule ligne ici.

            Spectacle spectacle = new Spectacle(
                    rs.getInt("numeroSpectacle"),
                    rs.getString("nomSpectacle"),
                    TypeDePublic.valueOf(rs.getString("publicCibleSpectacle").toUpperCase()),
                    rs.getDouble("prixDeBaseSpectacle"),
                    TypeDeSpectacle.valueOf(rs.getString("typeSpectacle").toUpperCase()),
                    rs.getInt("dureeSpectacle"),
                    rs.getString("descriptionSpectacle"),
                    rs.getString("imageSourceSpectacle")
            );

            LocalDate dateRepresentation = LocalDate.parse(rs.getString("dateRepresentation"), formatDate);
            LocalTime heureRepresentation = LocalTime.parse(rs.getString("heureDebutRepresentation"));

            Representation representation = new Representation(spectacle,
                    dateRepresentation,
                    heureRepresentation,
                    rs.getDouble("tauxReductionExceptionnelleRepresentation")
            );

            //Renvoi une erreur si les résultats contiennent plus que 1 ligne
            if (rs.next()) {
                throw new SQLException("Erreur : plusieurs représentation on été trouvé alors qu'une seule était attendue.\n"
                        + "Le couple {date,heure} n'est pas clé de la table Représentations.");
            }
            return representation;
        }
    }
}
