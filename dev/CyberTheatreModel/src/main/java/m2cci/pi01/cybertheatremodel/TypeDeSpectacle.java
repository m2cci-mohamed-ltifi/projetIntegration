/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel;

public enum TypeDeSpectacle {
    OPERA("Opéra"),
    DRAME("Dramatique"),
    HUMORISTIQUE("Humoristique"),
    MUSICAL("Musical"),
    CIRQUE("Cirque");
    
    /**
     * Nom à afficher pour les type de spectacle
     * Le nom d'affichage est un adjectif qualificatif
     * prévu pour être précédé du mot 'spectacle'
     */
    private String displayName;
    
    TypeDeSpectacle(String string) {
        displayName = string;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}
