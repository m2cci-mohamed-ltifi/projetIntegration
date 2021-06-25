/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel.Sieges;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Une `zone` du théatre regrouppant des siège et appartenant à une `catégorie`.
 *
 * @author philemon Tous les attributs sont final, une zone créé n'est pas
 * modifiable.
 */
public class Zone {

    /**
     * Numéro identifiant la zone
     */
    private final int numero;
    /**
     * `Categorie` à l'aquelle appartient la zone
     */
    private final Categorie categorie;
    /**
     * Liste des `siège` contenus dans la `zone`
     */
    private final ArrayList<Siege> sieges = new ArrayList<>();

    /**
     * Constructeur de zone
     *
     * @param numero
     * @param categorie
     * @param sieges
     */
    public Zone(int numero, Categorie categorie) {
        this.numero = numero;
        this.categorie = categorie;
    }

    /*
    Liste des getters. Touts les attributs sont accessibles.
     */
    public int getNumero() {
        return numero;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public ArrayList<Siege> getSieges() {
        return sieges;
    }
    
    

    /*
    Aucun setter : les zones sont créés definitivement et fixe.
     */
    
    /**
     * Ajouter le siege s à la liste des siege de la zone
     * @param s siege à ajouter à la liste
     */
    public void ajouterSiege(Siege s) {
        this.sieges.add(s);
        s.setZone(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.numero;
        hash = 97 * hash + Objects.hashCode(this.categorie);
        hash = 97 * hash + Objects.hashCode(this.sieges);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zone other = (Zone) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.categorie != other.categorie) {
            return false;
        }
        if (!Objects.equals(this.sieges, other.sieges)) {
            return false;
        }
        return true;
    }
}
