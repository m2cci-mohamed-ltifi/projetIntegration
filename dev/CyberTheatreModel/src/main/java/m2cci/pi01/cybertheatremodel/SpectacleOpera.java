/* 
 *Un `spectacleOpera`, est une classe qui herite de la classe spectacle. Il peut etre 
 * un Orchestre ou pas.
*/
package m2cci.pi01.cybertheatremodel;

/**
 *
 * @author Ltifi
 */
/* 
 *Un `spectacleHumorstique`, est une classe qui herite de la classe spectacle. Il peut etre 
 * un oneManShow ou pas
*/
public class SpectacleOpera extends Spectacle{
    boolean orchestreSpectacle;
    public SpectacleOpera (int numero, String nom, TypeDePublic publicCible, double prixDeBase, TypeDeSpectacle type, int duree, String description,String imageSource, boolean orchestreSpectacle){
        super(numero,nom,publicCible,prixDeBase,type,duree,description,imageSource);
        this.orchestreSpectacle=orchestreSpectacle;
    }

    public boolean isOrchestreSpectacle() {
        return orchestreSpectacle;
    }

    public void setOrchestreSpectacle(boolean orchestreSpectacle) {
        this.orchestreSpectacle = orchestreSpectacle;
    }
}
