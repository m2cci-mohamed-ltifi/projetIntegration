/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Un `spectacle`, identifié par son numéro. Il est composé de sa liste des
 * `représentations`. Une représentation est forcement construite à travers la
 * methode ajouterReprésentation
 */
public class Spectacle {

    /**
     * Numéro unique identifiant le `spectacle`. Non modifiable.
     */
    private final int numero;
    /**
     * Nom du `spectacle`
     */
    private String nom;
    /**
     * `TypeDePublic` le `spectacle` est destiné
     */
    private TypeDePublic publicCible;
    /**
     * `PrixDeBase` du `spectacle`. Modifié par les différent `tarifs` possible
     */
    private double prixDeBase;
    /**
     * `TypeDeSpectacle` auquel le `spectacle` appartient
     */
    private TypeDeSpectacle type;
    /**
     * Durrée, en minute, du `spectacle`
     */
    private int duree;
    /**
     * Description en texte du spectacle
     */
    private String description;
    private String imageSource;

    /**
     * Liste des représentations de ce spectacle.
     */
    private ArrayList<Representation> representations = new ArrayList<>();

    public Spectacle(int numero, String nom, TypeDePublic publicCible, double prixDeBase, TypeDeSpectacle type, int duree, String description, String imageSource) {
        this.numero = numero;
        this.nom = nom;
        this.publicCible = publicCible;
        this.prixDeBase = prixDeBase;
        this.type = type;
        this.duree = duree;
        this.description = description;
        this.imageSource = imageSource;
    }

    /*
    Liste des getters. Tous les attributs sont accessibles
     */
    // <editor-fold defaultstate="collapsed" desc="getters">
    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public TypeDePublic getPublicCible() {
        return publicCible;
    }

    public double getPrixDeBase() {
        return prixDeBase;
    }

    public TypeDeSpectacle getType() {
        return type;
    }

    public int getDuree() {
        return duree;
    }

    public ArrayList<Representation> getRepresentations() {
        return representations;
    }

    public String getDescription() {
        return description;
    }

    public String getImageSource() {
        return imageSource;
    }

    // </editor-fold>

    /*
    Liste des setters. Tous les attributs sont modifiables.
     */
    // <editor-fold defaultstate="collapsed" desc="setters">
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPublicCible(TypeDePublic publicCible) {
        this.publicCible = publicCible;
    }

    public void setPrixDeBase(double prixDeBase) {
        //TODO: Contrainte prix positif
        this.prixDeBase = prixDeBase;
    }

    public void setType(TypeDeSpectacle type) {
        this.type = type;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setRepresentations(ArrayList<Representation> representations) {
        this.representations = representations;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    // </editor-fold>
    /**
     * Créer une `représentation` et l'ajoute à la liste des `représentations`
     * pour ce spectacle.
     *
     * @param date
     * @param heure
     * @param tauxReductionExceptionnelle
     * @param nombrePlaceDisponible
     */
    public void ajouterRepresentation(LocalDate date, LocalTime heure, double tauxReductionExceptionnelle, int nombrePlaceDisponible) {
        this.representations.add(new Representation(this, date, heure, tauxReductionExceptionnelle, nombrePlaceDisponible));
    }

    public void ajouterRepresentation(LocalDate date, LocalTime heure, double tauxReductionExceptionnelle) {
        this.representations.add(new Representation(this, date, heure, tauxReductionExceptionnelle));
    }

    public void retirerRepresentation(Representation rep) {
        //search représentation. Delete if exists
    }
}
