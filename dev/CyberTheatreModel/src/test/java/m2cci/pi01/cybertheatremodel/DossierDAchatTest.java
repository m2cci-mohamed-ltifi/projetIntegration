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
public class DossierDAchatTest {
    
    public DossierDAchatTest() {
    }

    /**
     * Test of getNumero method, of class DossierDAchat.
     */
    @Test
    public void testGetNumero() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        assertEquals(dossier1.getNumero(),4070);
    }

    /**
     * Test of getUtilisateur method, of class DossierDAchat.
     */
    @Test
    public void testGetUtilisateur() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        assertEquals(dossier1.getUtilisateur() ,utilisateur1);
    }

    /**
     * Test of setNumero method, of class DossierDAchat.
     */
    @Test
    public void testSetNumero() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        dossier1.setNumero(2566);
        assertEquals(dossier1.getNumero(),2566);
    }

    /**
     * Test of setUtilisateur method, of class DossierDAchat.
     */
    @Test
    public void testSetUtilisateur() {
        Utilisateur utilisateur1=new Utilisateur("inconnu1", "inconnu_in2", "inconnu", "inconnu", "inconnu@domaine.com");
        Utilisateur utilisateur2=new Utilisateur("inconnu2", "inconnu_in8", "inconnu2", "inconnu2", "inconnu2@domaine.com");
        DossierDAchat dossier1 = new DossierDAchat(4070,false,utilisateur1);
        dossier1.setUtilisateur(utilisateur2);
        assertEquals(dossier1.getUtilisateur(),utilisateur2);
    }
    
}
