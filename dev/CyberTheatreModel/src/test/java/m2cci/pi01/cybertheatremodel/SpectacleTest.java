/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ltifi
 */
public class SpectacleTest {
    
    public SpectacleTest() {
    }

    /**
     * Test of getNumero method, of class Spectacle.
     */
    @Test
    public void testGetNumero() {
        //TypeDePublic t=TypeDePublic.TOUTPUBLIC;
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        assertEquals(s1.getNumero(),1);
    }

    /**
     * Test of getNom method, of class Spectacle.
     */
    @Test
    public void testGetNom() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        assertEquals(s1.getNom(),"Tosca");
    }

    /**
     * Test of getPublicCible method, of class Spectacle.
     */
    @Test
    public void testGetPublicCible() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        assertEquals(s1.getPublicCible(),TypeDePublic.TOUTPUBLIC);
    }

    /**
     * Test of getPrixDeBase method, of class Spectacle.
     */
//    @Test
//    public void testGetPrixDeBase() {
//        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25.0, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
//        assertEquals(s1.getPrixDeBase(),25,0.0);
//    } //TODO: uncomment

    /**
     * Test of getType method, of class Spectacle.
     */
    @Test
    public void testGetType() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        assertEquals(s1.getType(),TypeDeSpectacle.OPERA);
    }

    /**
     * Test of getDuree method, of class Spectacle.
     */
    @Test
    public void testGetDuree() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        assertEquals(s1.getDuree(),120);
    }

    /**
     * Test of getRepresentations method, of class Spectacle.
     */
    @Test
    public void testGetRepresentations() {
        ArrayList<Representation> representations = new ArrayList<>();
//        representations
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
     
        s1.ajouterRepresentation(LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        representations.add(new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1));
        assertEquals(s1.getRepresentations(), representations);
    }

    /**
     * Test of getDescription method, of class Spectacle.
     */
    @Test
    public void testGetDescription() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        assertEquals(s1.getDuree(),120);
    }

    /**
     * Test of getImageSource method, of class Spectacle.
     */
    @Test
    public void testGetImageSource() {
         Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        assertEquals(s1.getImageSource(),"data/images/vignette1.png");
    }

    /**
     * Test of setNom method, of class Spectacle.
     */
    @Test
    public void testSetNom() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        s1.setNom("Tosca 1");
        assertEquals(s1.getNom(),"Tosca 1");
    }

    /**
     * Test of setPublicCible method, of class Spectacle.
     */
    @Test
    public void testSetPublicCible() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        s1.setPublicCible(TypeDePublic.JEUNEPUBLIC);
        assertEquals(s1.getPublicCible(),TypeDePublic.JEUNEPUBLIC);
    }

    /**
     * Test of setPrixDeBase method, of class Spectacle.
     */
    @Test
    public void testSetPrixDeBase() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        s1.setPrixDeBase(50);
        assertEquals(50,s1.getPrixDeBase(),0.0);
    }

    /**
     * Test of setType method, of class Spectacle.
     */
    @Test
    public void testSetType() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        s1.setType(TypeDeSpectacle.MUSICAL);
        assertEquals(s1.getType(),TypeDeSpectacle.MUSICAL);
    }

    /**
     * Test of setDuree method, of class Spectacle.
     */
    @Test
    public void testSetDuree() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        s1.setDuree(150);
        assertEquals(s1.getDuree(),150);
    }

    /**
     * Test of setRepresentations method, of class Spectacle.
     */
    @Test
    public void testSetRepresentations() {
        ArrayList<Representation> representations = new ArrayList<>();
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        representations.add(new Representation(s1,LocalDate.of(2020, Month.MARCH, 29),LocalTime.of(20, 0), 1, 1));
        representations.add(new Representation(s1,LocalDate.of(2020, Month.MARCH, 30),LocalTime.of(18, 0), 1, 1));
        representations.add(new Representation(s1,LocalDate.of(2020, Month.MARCH, 29),LocalTime.of(20, 0), 1, 1));
        s1.setRepresentations(representations);
        assertEquals(s1.getRepresentations(), representations);
                
    }

    /**
     * Test of setDescription method, of class Spectacle.
     */
    @Test
    public void testSetDescription() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        s1.setDescription("C'est la toscane encore !!!");
        assertEquals(s1.getDescription(),"C'est la toscane encore !!!");
    }

    /**
     * Test of setImageSource method, of class Spectacle.
     */
    @Test
    public void testSetImageSource() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        s1.setImageSource("data/images/parDefault.png");
        assertEquals(s1.getImageSource(),"data/images/parDefault.png");
    }

    /**
     * Test of ajouterRepresentation method, of class Spectacle.
     */
    @Test
    public void testAjouterRepresentation() {
        ArrayList<Representation> representations = new ArrayList<>();
        Spectacle s2 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        representations.add(new Representation(s2,LocalDate.of(2020, Month.MARCH, 29),LocalTime.of(20, 0), 1, 1));
        s2.ajouterRepresentation(LocalDate.of(2020, Month.MARCH, 29),LocalTime.of(20, 0), 1, 1);
        assertEquals(s2.getRepresentations(), representations);
        
    }

    /**
     * Test of retirerRepresentation method, of class Spectacle.
     */
    @Test
    public void testRetirerRepresentation() {
        
    }
    
}
