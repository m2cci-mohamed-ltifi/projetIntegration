/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class SpectacleHumoristique extends Spectacle {
    boolean oneManShowSpectacle;
    public SpectacleHumoristique (int numero, String nom, TypeDePublic publicCible, double prixDeBase, TypeDeSpectacle type, int duree, String description,String imageSource, boolean oneManShowSpectacle){
        super(numero,nom,publicCible,prixDeBase,type,duree,description,imageSource);
        this.oneManShowSpectacle=oneManShowSpectacle;
    }
    

    public boolean isOneManShowSpectacle() {
        return oneManShowSpectacle;
    }

    public void setOneManShowSpectacle(boolean oneManShowSpectacle) {
        this.oneManShowSpectacle = oneManShowSpectacle;
    }
    
}
