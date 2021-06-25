/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel.Sieges;

/**
 * `Categorie` de siège possible. Seule trois catégories sont possible, l'objet
 * est donc une énumération. Chaque éléments de l'énumération possède un
 * attributs `zones` qui est une liste des zones contenues dans cette catégorie.
 *
 * @author philemon
 */
public enum Categorie {
    POULAILLER(1, "Poulailler"),
    BALCON(1.5, "Balcon"),
    ORCHESTRE(1.2, "Orchestre");
    
    private double coefficientCategorie;
    private String displayName;
    
    Categorie(double coefficient, String string) {
        this.coefficientCategorie = coefficient;
        this.displayName = string;
    }
    

    public double getCoefficientCategorie() {
        return coefficientCategorie;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
