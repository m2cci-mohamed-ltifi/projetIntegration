/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

package m2cci.pi01.cybertheatremodel;


public enum TypeDePublic {
    PUBLIC1A5ANS("Enfant de 1 à 5 ans"),
    JEUNEPUBLIC("Jeune public"),
    TOUTPUBLIC("Tout public"),
    ADULTE("Adulte");

    // Member to hold the name
    private String displayName;

    // constructor to set the string
    TypeDePublic(String string) {
        displayName = string;
    }

    // the toString just returns the given name
    @Override
    public String toString() {
        return displayName;
    }

}
