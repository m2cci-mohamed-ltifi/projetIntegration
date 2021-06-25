/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * Une représentation est identifiée par le `spectacle` auquel elle appartient,
 * et par la date et l'heure de la `représentation`.
 */
public class Representation {

    /**
     * `Spectacle` auquel appartient la `représentation` Il n'est pas modifiable
     * après création.
     */
    private final Spectacle spectacle;
    /**
     * Date de la `représentation`. Le couple [date,heure] l'identifie de
     * manière unique
     */
    private LocalDate date;
    /**
     * Heure de la `représentation`. Le couple [date,heure] l'identifie de
     * manière unique
     */
    private LocalTime heure;
    /**
     * Taux de réduction appliqué.
     */
    private double tauxReductionExceptionnelle;
    /**
     * Nombre de places disponibles, calculée en fonction de la `configuration`
     * de la salle par la bdd
     */
    private int nombePlaceDisponible;
    
    String  [] mois = {" Janvier ", " Fevrier ", " Mars ", " Avril "," Mai ", " Juin " , " Juillet "," Aout "," Septembre "," Octobre "," Novembre "," Decembre "};

    /**
     * Constructeur de représentation. Ce constructeur DOIT être appelé par un
     * spectacle, de manière à ce que la représentation soit connue du spectacle
     * correspondant. Visibilité 'package' pour forcer au respect de cette
     * règle.
     *
     * @param spectacle
     * @param date
     * @param heure
     * @param tauxReductionExceptionnelle
     * @param nombePlaceDisponible
     */
    Representation(Spectacle spectacle, LocalDate date, LocalTime heure, double tauxReductionExceptionnelle, int nombePlaceDisponible) {
        this.spectacle = spectacle;
        this.date = date;
        this.heure = heure;
        this.tauxReductionExceptionnelle = tauxReductionExceptionnelle;
        this.nombePlaceDisponible = nombePlaceDisponible;
    }

    public Representation(Spectacle spectacle, LocalDate date, LocalTime heure, double tauxReductionExceptionnelle) {
        this.spectacle = spectacle;
        this.date = date;
        this.heure = heure;
        this.tauxReductionExceptionnelle = tauxReductionExceptionnelle;
    }

    
    
    /*
    Liste des getters. Tous les attribut sont accesseibles.
     */
    // <editor-fold defaultstate="collapsed" desc="getters">
    public Spectacle getSpectacle() {
        return spectacle;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public String getDateOptimised(){
        int jourInt=this.date.getDayOfMonth();
        int moisInt=this.date.getMonthValue();
        int anneeInt=this.date.getYear();
        
        return jourInt + mois[moisInt-1] + anneeInt;
        
    }

    public LocalTime getHeure() {
        return heure;
    }

    public double getTauxReductionExceptionnelle() {
        return tauxReductionExceptionnelle;
    }

    public int getNombePlaceDisponible() {
        return nombePlaceDisponible;
    }
    // </editor-fold>

    /*
    Liste des setter. Le `spectacle` auquel appartient une `représentation` n'est 
    pas modifiable.
     */
    // <editor-fold defaultstate="collapsed" desc="setters">
    public void setDate(LocalDate dateEtHeure) {
        this.date = dateEtHeure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public void setTauxReductionExceptionnelle(double tauxReductionExceptionnelle) {
        this.tauxReductionExceptionnelle = tauxReductionExceptionnelle;
    }

    public void setNombePlaceDisponible(int nombePlaceDisponible) {
        this.nombePlaceDisponible = nombePlaceDisponible;
    }
    // </editor-fold>

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.spectacle);
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + Objects.hashCode(this.heure);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.tauxReductionExceptionnelle) ^ (Double.doubleToLongBits(this.tauxReductionExceptionnelle) >>> 32));
        hash = 59 * hash + this.nombePlaceDisponible;
        hash = 59 * hash + Arrays.deepHashCode(this.mois);
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
        final Representation other = (Representation) obj;
        if (Double.doubleToLongBits(this.tauxReductionExceptionnelle) != Double.doubleToLongBits(other.tauxReductionExceptionnelle)) {
            return false;
        }
        if (this.nombePlaceDisponible != other.nombePlaceDisponible) {
            return false;
        }
        if (!Objects.equals(this.spectacle, other.spectacle)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.heure, other.heure)) {
            return false;
        }
        if (!Arrays.deepEquals(this.mois, other.mois)) {
            return false;
        }
        return true;
    }

    
    
}
