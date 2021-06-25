/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel;

public class DossierDAchat {

    private int numero;
    private boolean achete;
    private Utilisateur utilisateur;

    public DossierDAchat(int numero, boolean achete, Utilisateur utilisateur) {
        this.numero = numero;
        this.achete = achete;
        this.utilisateur = utilisateur;
    }

    public DossierDAchat(int numero, boolean achete) {
        this.numero = numero;
        this.achete = achete;
    }

    // <editor-fold defaultstate="collapsed" desc="getters">
    public int getNumero() {
        return numero;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public boolean isAchete() {
        return achete;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="setters">
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setAchete(boolean achete) {
        this.achete = achete;
    }

    // </editor-fold>
}
