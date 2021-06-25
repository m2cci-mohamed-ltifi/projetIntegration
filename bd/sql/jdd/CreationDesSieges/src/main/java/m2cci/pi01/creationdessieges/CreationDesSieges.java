/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.creationdessieges;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import m2cci.pi01.cybertheatremodel.Sieges.Categorie;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;
import m2cci.pi01.cybertheatremodel.Sieges.Zone;

/**
 *
 * @author phil
 */
public class CreationDesSieges {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zone poul_gauche = new Zone(1, Categorie.POULAILLER);
        CompleterZone(poul_gauche, 1, 5, 1, 5);
        Zone poul_centre = new Zone(2, Categorie.POULAILLER);
        CompleterZone(poul_centre, 7, 36, 7, 11);
        Zone poul_droite = new Zone(3, Categorie.POULAILLER);
        CompleterZone(poul_droite, 38, 42, 1, 5);

        Zone orchestre = new Zone(4, Categorie.ORCHESTRE);
        CompleterZone(orchestre, 7, 36, 1, 5);
//        Zone orchestre = new Zone(4, Categorie.ORCHESTRE);    //WARNING choix ces deux lignes ou les deux ligne au dessus
//        CompleterZone(orchestre, 6, 25, 1, 5);

        Zone balcon_gauche = new Zone(5, Categorie.BALCON);
        CompleterZone(balcon_gauche, 1, 5, 7, 11);
        Zone balcon_centre = new Zone(6, Categorie.BALCON);
        CompleterZone(balcon_centre, 1, 42, 13, 16);
        Zone balcon_droite = new Zone(7, Categorie.BALCON);
        CompleterZone(balcon_droite, 38, 42, 7, 11);
        try {
            FileWriter outputFile = new FileWriter("../jdd1_sieges.sql");

            outputFile.write("PRAGMA foreign_keys = ON;\n\n");

            outputFile.write(ZoneToInsert(poul_gauche));
            outputFile.write(ZoneToInsert(poul_centre));
            outputFile.write(ZoneToInsert(poul_droite));
            outputFile.write(ZoneToInsert(orchestre));
            outputFile.write(ZoneToInsert(balcon_gauche));
            outputFile.write(ZoneToInsert(balcon_centre));
            outputFile.write(ZoneToInsert(balcon_droite));

            outputFile.write("\n");
            int i=200;
            for (Siege s : poul_gauche.getSieges()) {
                i++;
                outputFile.write(SiegeToInsert(s,i));
            }
            for (Siege s : poul_centre.getSieges()) {
                i++;
                outputFile.write(SiegeToInsert(s,i));
            }
            for (Siege s : poul_droite.getSieges()) {
                i++;
                outputFile.write(SiegeToInsert(s,i));
            }
            for (Siege s : orchestre.getSieges()) {
                i++;
                outputFile.write(SiegeToInsert(s,i));
            }
            for (Siege s : balcon_gauche.getSieges()) {
                i++;
                outputFile.write(SiegeToInsert(s,i));
            }
            for (Siege s : balcon_centre.getSieges()) {
                i++;
                outputFile.write(SiegeToInsert(s,i));
            }
            for (Siege s : balcon_droite.getSieges()) {
                i++;
                outputFile.write(SiegeToInsert(s,i));
            }
            outputFile.close();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'ecritue du fichier SQL");
            System.out.println("erreur : " + e.getMessage());
        }
    }

    public static String SiegeToInsert(Siege s, int i) {
//        return "INSERT INTO Billets_base VALUES ('23-09-2021', '18:00:00', " + s.getNumero() + "," + s.getRang() + "," + i + ", 1,'"+ LocalDate.now()+"',1);\n";
        return "INSERT INTO Sieges VALUES ("+s.getNumero()+","+s.getRang()+","+s.getZone().getNumero()+");\n";
    }

    public static String ZoneToInsert(Zone z) {
        return "INSERT INTO Zones VALUES (" + z.getNumero() + ", '" + z.getCategorie().toString().toLowerCase() + "');\n";
    }

    public static void CompleterZone(Zone z, int numeroMin, int numeroMax, int rangMin, int rangMax) {
        for (int rang = rangMin; rang <= rangMax; rang++) {
            for (int numero = numeroMin; numero <= numeroMax; numero++) {
                z.ajouterSiege(new Siege(numero, rang, z));
            }
        }
    }
}
