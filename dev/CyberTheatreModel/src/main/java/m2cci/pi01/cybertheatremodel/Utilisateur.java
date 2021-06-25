/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel;
/**
 *
 * @author oulay
 */
public class Utilisateur {
    protected String login;
    protected String motDePasse;
    protected String nom;
    protected String prenom;
    protected String email;
 /**
    *
     * @param login le login d'utilisateur
     * @param motDePasse le mot de passe de l'utilisateur
     * @param nom le nom d'utilisateur
     * @param prenom le prenom d'utilisateur
     * @param email l'email d'utilisateur
    */
    public Utilisateur(String login, String motDePasse, String nom, String prenom, String email) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    // <editor-fold defaultstate="collapsed" desc="getters">

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="setters">

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   // </editor-fold>   
}
