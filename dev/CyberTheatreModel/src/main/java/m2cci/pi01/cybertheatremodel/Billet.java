/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel;

import java.time.LocalDateTime;
import java.util.Date;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;


public class Billet {

    protected Siege siege;
    protected Representation representation;
    protected DossierDAchat dossier;
    protected int numero;
    protected LocalDateTime dateAchat;
    protected double tarifReduit;
//    protected boolean Achete;

    /**
     *
     * @param siege le siège mentionné dans le billet
     * @param representation la representation
     * @param dossier le dossier du billet
     * @param numero
     * @param dateAchat la date d'achat du billet
     * @param tarifReduit le tarif réduit accordé
     * @param Achete billet achete ou juste réservé
     */
    public Billet(Siege siege, Representation representation, DossierDAchat dossier, int numero, LocalDateTime dateAchat, double tarifReduit) {
        this.siege = siege;
        this.representation = representation;
        this.dossier = dossier;
        this.numero = numero;
        this.dateAchat = dateAchat;
        this.tarifReduit = tarifReduit;
    }
    // <editor-fold defaultstate="collapsed" desc="getters">

    public Siege getSiege() {
        return siege;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public DossierDAchat getDossier() {
        return dossier;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getDateAchat() {
        return dateAchat;
    }

    public double getTarifReduit() {
        return tarifReduit;
    }

//    public boolean isAchete() {
//        return Achete;
//    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="setters">

    public void setSiege(Siege siege) {
        this.siege = siege;
    }

    public void setRepresentation(Representation representation) {
        this.representation = representation;
    }

    public void setDossier(DossierDAchat dossier) {
        this.dossier = dossier;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDateAchat(LocalDateTime dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setTarifReduit(double tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

//    public void setAchete(boolean Achete) {
//        this.Achete = Achete;
//    }

    // </editor-fold>
}
