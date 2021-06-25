/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel;

import java.util.Date;


public class Adherent extends Utilisateur {
    protected Date dateDAdhesion;
    protected int duree;
    /**
     * 
     * @param dateDAdhesion le jour exacte quand l'utilisateur est devenu adhérent 
     * @param duree la duree de son adhesion
     * @param login le login d'adherent
     * @param motDePasse le mot de passe d'adhérent
     * @param nom le nom d'adhérent
     * @param prenom le prenom d'adhérent
     * @param email l'email d'adherent
     */
    public Adherent(Date dateDAdhesion, int duree, String login, String motDePasse, String nom, String prenom, String email) {
        super(login, motDePasse, nom, prenom, email);
        this.dateDAdhesion = dateDAdhesion;
        this.duree = duree;
    }   
}
