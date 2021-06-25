/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ltifi
 */
public class SpectacleOperaTest {
    
    public SpectacleOperaTest() {
    }

    /**
     * Test of isOrchestreSpectacle method, of class SpectacleOpera.
     */
    @Test
    public void testIsOrchestreSpectacle() {
        SpectacleOpera s1= new SpectacleOpera(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png",false);
        assertEquals(s1.isOrchestreSpectacle(),false);
    }

    /**
     * Test of setOrchestreSpectacle method, of class SpectacleOpera.
     */
    @Test
    public void testSetOrchestreSpectacle() {
        SpectacleOpera s1= new SpectacleOpera(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png",false);
        s1.setOrchestreSpectacle(true);
        assertEquals(s1.isOrchestreSpectacle(),true);
    }
    
}
