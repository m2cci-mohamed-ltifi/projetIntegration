/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
 */
package m2cci.pi01.cybertheatre.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import m2cci.pi01.cybertheatremodel.Spectacle;



public class AjoutSpectacleDAO {

    public static void ajouterSpectacle(DataSource bdSQL, Spectacle spectacle)
            throws SQLException {
        String requeteAjoutSpectacle = "INSERT INTO Spectacles VALUES ('500',?,?,?,?,?,0,0,?,?);";
        try (
                 Connection conn = bdSQL.getConnection();  PreparedStatement stmtAjoutSpectacle = conn.prepareStatement(requeteAjoutSpectacle);) {
            //stmtAjoutSpectacle.setInt(1, spectacle.getNumero());
            stmtAjoutSpectacle.setString(1, spectacle.getNom());
            stmtAjoutSpectacle.setString(2, spectacle.getPublicCible().toString());
            stmtAjoutSpectacle.setDouble(3, spectacle.getPrixDeBase());
            stmtAjoutSpectacle.setInt(4, spectacle.getDuree());
            stmtAjoutSpectacle.setString(5, spectacle.getType().toString());
            stmtAjoutSpectacle.setString(6, spectacle.getDescription());
            stmtAjoutSpectacle.setString(7, spectacle.getImageSource());
//            stmtAjoutSpectacle.setString(8, oneManShow);
//            stmtAjoutSpectacle.setString(9, orchestre);
            
            stmtAjoutSpectacle.executeUpdate();
        }
    }

}
