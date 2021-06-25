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
public class UtilisateurTest {
    
    public UtilisateurTest() {
    }

    /**
     * Test of getLogin method, of class Utilisateur.
     */
    @Test
    public void testGetLogin() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        assertEquals(utilisateur1.getLogin(),"inconnu1");
    }

    /**
     * Test of getMotDePasse method, of class Utilisateur.
     */
    @Test
    public void testGetMotDePasse() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        assertEquals(utilisateur1.getMotDePasse(),"inconnu_in2");
    }

    /**
     * Test of getNom method, of class Utilisateur.
     */
    @Test
    public void testGetNom() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        assertEquals(utilisateur1.getNom(),"inconnu");
    }

    /**
     * Test of getPrenom method, of class Utilisateur.
     */
    @Test
    public void testGetPrenom() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        assertEquals(utilisateur1.getPrenom(),"inconnu");
    }

    /**
     * Test of getEmail method, of class Utilisateur.
     */
    @Test
    public void testGetEmail() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        assertEquals(utilisateur1.getEmail(),"inconnu@domaine.com");
    }

    /**
     * Test of setLogin method, of class Utilisateur.
     */
    @Test
    public void testSetLogin() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        utilisateur1.setLogin("Philemon2");
        assertEquals(utilisateur1.getLogin(),"Philemon2");
    }

    /**
     * Test of setMotDePasse method, of class Utilisateur.
     */
    @Test
    public void testSetMotDePasse() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        utilisateur1.setMotDePasse("Philemon123");
        assertEquals(utilisateur1.getMotDePasse(),"Philemon123");
    }

    /**
     * Test of setNom method, of class Utilisateur.
     */
    @Test
    public void testSetNom() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        utilisateur1.setNom("Giraud");
        assertEquals(utilisateur1.getNom(),"Giraud");
    }

    /**
     * Test of setPrenom method, of class Utilisateur.
     */
    @Test
    public void testSetPrenom() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        utilisateur1.setPrenom("Philemon");
        assertEquals(utilisateur1.getPrenom(),"Philemon");
    }

    /**
     * Test of setEmail method, of class Utilisateur.
     */
    @Test
    public void testSetEmail() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        utilisateur1.setEmail("philemon.giraud@gmail.com");
        assertEquals(utilisateur1.getEmail(),"philemon.giraud@gmail.com");
    }
    
}
