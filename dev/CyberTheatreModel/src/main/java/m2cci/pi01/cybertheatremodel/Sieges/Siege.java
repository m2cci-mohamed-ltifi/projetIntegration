/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel.Sieges;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Un `siege` du théatre, identifié par son `rang` et son `numéroDeSiège` dans
 * le rang et appartent à une `zone`. Tous les attributs sont final, un siège
 * créé n'est pas modifiable.
 *
 */
public class Siege {

    /**
     * `NumeroDeSiège` dans le `rang`
     */
    private final int numero;
    /**
     * `NuméroDeRang`
     */
    private final int rang;
    /**
     * Zone à laquelle appartient le siège
     */
    private Zone zone;

    /**
     * Constructeur de siège
     *
     * @param numero
     * @param rang
     * @param zone
     */
    public Siege(int numero, int rang, Zone zone) {
        this.numero = numero;
        this.rang = rang;
        this.zone = zone;
    }

    public Siege(int numero, int rang) {
        this.numero = numero;
        this.rang = rang;
    }

    /*
    Liste des getters
     */
    public int getNumero() {
        return numero;
    }

    public int getRang() {
        return rang;
    }

    public Zone getZone() {
        return zone;
    }

    /*
    Liste des setters
     */
    public void setZone(Zone zone) {
        this.zone = zone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.numero;
        hash = 97 * hash + this.rang;
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
        final Siege other = (Siege) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.rang != other.rang) {
            return false;
        }
        if (!Objects.equals(this.zone, other.zone)) {
            return false;
        }
        return true;
    }
    
    /**
     * contruit un siège à partir de son id issu de javascript, càd sous la
     * forme "S5-19" pour le siège n°19 rang 5
     *
     * @return object siege créé
     */
    public static Categorie categorieFromJsonId(String jsonid) {
        Pattern pattern = Pattern.compile("Cat(.)_");

        Matcher matcher = pattern.matcher(jsonid);

        if (matcher.find()) {
            String string = matcher.group(1);
            if (string.equals("A")) {
                return Categorie.BALCON;
            }
            if (string.equals("B")) {
                return Categorie.ORCHESTRE;
            }
            if (string.equals("C")) {
                return Categorie.POULAILLER;
            }
        }
        return null;
    }

//    public static Integer numeroZoneFromJsonId(String jsonid) {
//        Pattern pattern = Pattern.compile("Z(\\d*)_");
//        Matcher matcher = pattern.matcher(jsonid);
//
//        if (matcher.find()) {
//            String string = matcher.group(1);
//            return Integer.parseInt(string);
//        }
//        return null;
//    }

    public static Integer rangSiegeFromJsonId(String jsonid) {
        Pattern pattern = Pattern.compile("R(\\d*)_");
        Matcher matcher = pattern.matcher(jsonid);

        if (matcher.find()) {
            String string = matcher.group(1);
            return Integer.parseInt(string);
        }
        return null;
    }

    public static Integer numeroSiegeFromJsonId(String jsonid) {
        Pattern pattern = Pattern.compile("S(\\d*)");
        Matcher matcher = pattern.matcher(jsonid);

        if (matcher.find()) {
            String string = matcher.group(1);
            return Integer.parseInt(string);
        }
        return null;
    }
}
