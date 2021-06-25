/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatremodel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import m2cci.pi01.cybertheatremodel.Sieges.Categorie;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;
import m2cci.pi01.cybertheatremodel.Sieges.Zone;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Ltifi
 */
public class BilletTest {
    
    public BilletTest() {
    }

    /**
     * Test of getSiege method, of class Billet.
     */
    @Test
    public void testGetSiege() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        assertEquals(billet1.getSiege(),siege1);
    }

    /**
     * Test of getRepresentation method, of class Billet.
     */
    @Test
    public void testGetRepresentation() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        assertEquals(billet1.getRepresentation(),representation1);
    }

    /**
     * Test of getDossier method, of class Billet.
     */
    @Test
    public void testGetDossier() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        assertEquals(billet1.getDossier(),dossier1);
    }

    /**
     * Test of getNumero method, of class Billet.
     */
    @Test
    public void testGetNumero() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        assertEquals(billet1.getNumero(),1);
    }

    /**
     * Test of getDateAchat method, of class Billet.
     */
    @Test
    public void testGetDateAchat() {
       Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        assertEquals(billet1.getDateAchat(),LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)));
    }

    /**
     * Test of getTarifReduit method, of class Billet.
     */
    @Test
    public void testGetTarifReduit() {
       Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        assertEquals(billet1.getTarifReduit(),1,0.0); 
    }

    /**
     * Test of setSiege method, of class Billet.
     */
    @Test
    public void testSetSiege() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Siege siege2= new Siege(1,5,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        billet1.setSiege(siege2);
        assertEquals(billet1.getSiege(),siege2);
    }

    /**
     * Test of setRepresentation method, of class Billet.
     */
    @Test
    public void testSetRepresentation() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Representation representation2=new Representation(s1,LocalDate.of(2020, Month.APRIL, 3),LocalTime.of(16, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        billet1.setRepresentation(representation2);
        assertEquals(billet1.getRepresentation(),representation2);
    }

    /**
     * Test of setDossier method, of class Billet.
     */
    @Test
    public void testSetDossier() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        DossierDAchat dossier3 = new DossierDAchat(2566,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        billet1.setDossier(dossier3);
        assertEquals(billet1.getDossier(),dossier3);
    }

    /**
     * Test of setNumero method, of class Billet.
     */
    @Test
    public void testSetNumero() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        billet1.setNumero(20);
        assertEquals(billet1.getNumero(),20);
    }

    /**
     * Test of setDateAchat method, of class Billet.
     */
    @Test
    public void testSetDateAchat() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        billet1.setDateAchat(LocalDateTime.of(LocalDate.of(2021,03,28), LocalTime.of(14,0)));
        assertEquals(billet1.getDateAchat(),LocalDateTime.of(LocalDate.of(2021,03,28), LocalTime.of(14,0)));
        
        
    }

    /**
     * Test of setTarifReduit method, of class Billet.
     */
    @Test
    public void testSetTarifReduit() {
        Zone zone1 = new Zone(1,Categorie.BALCON);
        Siege siege1= new Siege(1,1,zone1);
        Spectacle s1 = new Spectacle(1, "Tosca",TypeDePublic.TOUTPUBLIC , 25, TypeDeSpectacle.OPERA, 120,"C'est la toscane !!!" , "data/images/vignette1.png");
        Representation representation1=new Representation(s1,LocalDate.of(2020, Month.MARCH, 31),LocalTime.of(20, 0), 1, 1);
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        Billet billet1=new Billet( siege1, representation1, dossier1, 1, LocalDateTime.of(LocalDate.of(2021,03,25), LocalTime.of(13,5)), 1) ;
        billet1.setTarifReduit((double) 0.9);
        assertEquals(billet1.getTarifReduit(),0.9,0.1);    
    }
}
