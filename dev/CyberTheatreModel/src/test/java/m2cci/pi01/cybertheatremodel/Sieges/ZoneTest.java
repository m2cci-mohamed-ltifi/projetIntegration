/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel.Sieges;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ltifi
 */
public class ZoneTest {
    
    public ZoneTest() {
        
    }

    /**
     * Test of getNumero method, of class Zone.
     */
    @Test
    public void testGetNumero() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        assertEquals(zone1.getNumero(),1) ;       
    }

    /**
     * Test of getCategorie method, of class Zone.
     */
    @Test
    public void testGetCategorie() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        assertEquals(zone1.getCategorie(),Categorie.BALCON) ;       
    }

    /**
     * Test of getSieges method, of class Zone.
     */
    @Test
    public void testGetSieges() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        ArrayList<Siege> sieges = new ArrayList<>();
        sieges.add(new Siege(1,1,zone1));
        zone1.ajouterSiege(new Siege(1,1));
        assertEquals(zone1.getSieges(),sieges) ;   
    }

    /**
     * Test of ajouterSiege method, of class Zone.
     */
    @Test
    public void testAjouterSiege() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        ArrayList<Siege> sieges = new ArrayList<>();
        sieges.add(new Siege(1,1,zone1));
        zone1.ajouterSiege(new Siege(1,1));
        zone1.ajouterSiege(new Siege(2,1));
        sieges.add(new Siege(2,1,zone1));
        assertEquals(zone1.getSieges(),sieges) ;
    }
    
}
