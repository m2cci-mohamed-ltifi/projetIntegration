/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ltifi
 */
public class RepresentationTest {
    
    public RepresentationTest() {
    }

    /**
     * Test of getSpectacle method, of class Representation.
     */
    @Test
    public void testGetSpectacle() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        assertEquals(representation1.getSpectacle(),s1);
    }

    /**
     * Test of getDate method, of class Representation.
     */
    @Test
    public void testGetDate() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        assertEquals(representation1.getDate(),LocalDate.of(2021, Month.APRIL, 04));        
    }

    /**
     * Test of getDateOptimised method, of class Representation.
     */
    
    /**
     * Test of getHeure method, of class Representation.
     */
    @Test
    public void testGetHeure() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        assertEquals(representation1.getHeure(),LocalTime.of(18, 0));
    }

    /**
     * Test of getTauxReductionExceptionnelle method, of class Representation.
     */
    @Test
    public void testGetTauxReductionExceptionnelle() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        assertEquals(representation1.getTauxReductionExceptionnelle(),1,0.0);
    }

    /**
     * Test of getNombePlaceDisponible method, of class Representation.
     */
    @Test
    public void testGetNombePlaceDisponible() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        assertEquals(representation1.getNombePlaceDisponible(),1);
    }

    /**
     * Test of setDate method, of class Representation.
     */
    @Test
    public void testSetDate() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        representation1.setDate(LocalDate.of(2021, Month.APRIL, 10));
        assertEquals(representation1.getDate(),LocalDate.of(2021, Month.APRIL, 10));
    }

    /**
     * Test of setHeure method, of class Representation.
     */
    @Test
    public void testSetHeure() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        representation1.setHeure(LocalTime.of(12, 0));
        assertEquals(representation1.getHeure(),LocalTime.of(12, 0));
    }

    /**
     * Test of setTauxReductionExceptionnelle method, of class Representation.
     */
    @Test
    public void testSetTauxReductionExceptionnelle() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        representation1.setTauxReductionExceptionnelle((double) 0.7);
        assertEquals(representation1.getTauxReductionExceptionnelle(),0.7,0.01);
    }

    /**
     * Test of setNombePlaceDisponible method, of class Representation.
     */
    @Test
    public void testSetNombePlaceDisponible() {
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2021, Month.APRIL, 04),LocalTime.of(18, 0), 1, 1);
        representation1.setNombePlaceDisponible(20);
        assertEquals(representation1.getNombePlaceDisponible(),20);
    }
    
}
