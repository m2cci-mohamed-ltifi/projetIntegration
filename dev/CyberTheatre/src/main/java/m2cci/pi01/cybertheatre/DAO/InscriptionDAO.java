/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import m2cci.pi01.cybertheatremodel.Utilisateur;
import javax.sql.DataSource;

public class InscriptionDAO {
    public static void ajouterUtilisateur(DataSource bdSQL, Utilisateur utilisateur)
    throws SQLException{
    String requeteAjoutUtilisateur = "INSERT INTO Utilisateurs VALUES (?,?,?,?,?);";
    try(
    Connection conn = bdSQL.getConnection();
    PreparedStatement stmtAjoutUtilisateur = conn.prepareStatement(requeteAjoutUtilisateur);)
    {
        stmtAjoutUtilisateur.setString(1, utilisateur.getLogin());
        stmtAjoutUtilisateur.setString(2, utilisateur.getMotDePasse());
        stmtAjoutUtilisateur.setString(3, utilisateur.getNom());
        stmtAjoutUtilisateur.setString(4, utilisateur.getPrenom());
        stmtAjoutUtilisateur.setString(5, utilisateur.getEmail());
        stmtAjoutUtilisateur.executeUpdate();
    }
    }
            
}
