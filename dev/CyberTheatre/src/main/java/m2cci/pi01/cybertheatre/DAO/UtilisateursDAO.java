/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatre.DAO;

/**
 *
 * @author Ltifi
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatremodel.Utilisateur;
import javax.sql.DataSource;


public class UtilisateursDAO {
    public static List<Utilisateur> chargerUtilisateurs(DataSource bdSQL, String nom)
    throws SQLException{
        List<Utilisateur> listeUtilisateurs = new ArrayList<>();
        String requeteChargeUtilisateur = "SELECT * FROM Utilisateurs ";
                if (nom!=null ){
                    requeteChargeUtilisateur+= "WHERE nomUtilisateur LIKE  ?" ;
                }
    try(
    Connection conn = bdSQL.getConnection();
    PreparedStatement stmtChargeUtilisateur = conn.prepareStatement(requeteChargeUtilisateur);)
    {
        if (nom!=null ){
        stmtChargeUtilisateur.setString(1,"%"+nom+"%");
        }
        ResultSet rs_listeUtilisateurs = stmtChargeUtilisateur.executeQuery();
        while (rs_listeUtilisateurs.next()){
        Utilisateur currentUtilisateur = new Utilisateur(
                rs_listeUtilisateurs.getString("loginUtilisateur"),
                rs_listeUtilisateurs.getString("motDePasseUtilisateur"),
                rs_listeUtilisateurs.getString("nomUtilisateur"),
                rs_listeUtilisateurs.getString("prenomUtilisateur"),
                rs_listeUtilisateurs.getString("eMailUtilisateur")
        );
        listeUtilisateurs.add(currentUtilisateur);
            
    }
    }
    return listeUtilisateurs;
    }
}
