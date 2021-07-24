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
import m2cci.pi01.cybertheatremodel.DossierDAchat;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatremodel.Utilisateur;

/**
 *
 * @author Ltifi
 */
public class AcheterBilletPreReserveDAO {
    public static void AcheterBilletPreReserve(DataSource bdSQL, String numeroDossier)
    throws SQLException{
        String requeteUpdateDossier = " UPDATE DossierDAchats SET acheteDossier=1 WHERE numeroDossier = ?";
        try(
    Connection conn = bdSQL.getConnection();
    PreparedStatement stmtUpdateDossier = conn.prepareStatement(requeteUpdateDossier);)
    {
        stmtUpdateDossier.setString(1, numeroDossier);
        
        stmtUpdateDossier.executeUpdate();
    }
}
}
