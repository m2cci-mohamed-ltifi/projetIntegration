/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel.Sieges;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ltifi
 */
public class SiegeTest {
    
    public SiegeTest() {
    }

    /**
     * Test of getNumero method, of class Siege.
     */
    @Test
    public void testGetNumero() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        assertEquals(siege1.getNumero(),1);
    }

    /**
     * Test of getRang method, of class Siege.
     */
    @Test
    public void testGetRang() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        assertEquals(siege1.getRang(),1);
    }

    /**
     * Test of getZone method, of class Siege.
     */
    @Test
    public void testGetZone() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        assertEquals(siege1.getZone(),zone1);
    }

    /**
     * Test of setZone method, of class Siege.
     */
    @Test
    public void testSetZone() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Zone zone2 = new Zone(4,Categorie.BALCON);
        siege1.setZone(zone2);
        assertEquals(siege1.getZone(),zone2);
    }
    
}
