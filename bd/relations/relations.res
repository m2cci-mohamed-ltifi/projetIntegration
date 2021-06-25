//=========================================================================
//                      Relation model
//-------------------------------------------------------------------------
// This relation model is expressed in RelationScript
// See https://modelscript.rtfd.io/en/latest/languages/relations/index.html
//=========================================================================

relation model MyTheatre
import glossary model from "../glossaries/glossaries.gls"
import class model from "../classes/classes.cl1"


--------------------------------------------------------------------------------------------
Relation Spectacles(numeroSpectacle_, nomSpectacle, publicCibleSpectacle, prixDeBaseSpectacle, dureeSpectacle, typeSpectacle, OneManShowSpectacle, OrchestreSpectacle, descriptionSpectacle, imageSourceSpectacle)
    intention
        (nu, no, pc, pb, m, t, oms, or, ds, img) dans <=>
        | Le spectacle de numero <nu>, du nom <no> et de type <t>, a pour publc cible <pc>
        | Son prix de base est <pb>. Il dure <m> minutes. Un spectacle peut être
        | un One Man Show <oms> ou un orchestre <or> ou pas.
        | Le spectacle est décrit par une description <ds>, il correspond à l'image <img>.
    examples
            (3000,'Le Malade imaginaire', 'Adulte', 20.0, '02:30:00', 'humourstique', False, False, "Ma description", "lien/vers/une/image.png")
    constraints
            dom(numeroSpectacle,nombrebPlacesMaxSpectacle) = Integer
            dom(prixDeBaseSpectacle) = Real
            dom(OneManShowSpectacle,OrchestreSpectacle) = Boolean
            dom(nomSpectacle, dureeSpectacle, descriptionSpectacle, imageSourceSpectacle) = String
            dom(typeSpectacle) = TypeDeSpectacle
            dom(publicCibleSpectacle) = TypeDePublic
            key numero


Relation Representations(dateRepresentation_,heureDebutRepresentation_, numeroSpectacle, tauxReductionExceptionnelleRepresentation, nombreBilletsRepresentaion, nombrePlacesRestanteRepresentation)
    intention
        (d, h, nu, tre, nb, npr) dans <=>
        | Le spectacle de numero <nu>, aura lieu à la date <d> et à l'heure <h>. Il a un taux de réduction
        | exceptionnelle <tre>. <nb> billets ont déjà été réservés ou pré-réservé, il reste <npr> sièges libres
    examples
        ('12-03-2021','18:00:00', 3000, 15.0, 100, 500)
    constraints    
        dom(dateRepresentation,heureRepresentation) = String
        dom(numeroRepresentation, nombreBilletsRepresentation, nombrePlacesRestanteRepresentation) = Integer
        dom(tauxReductionExceptionnelleRepresentation) = Real
        Representation[numeroRepresentation] C= Spectacle[numeroSpectacle]
        key date,heure

Relation Zones(numeroZone, nomCategorie)
    intention
        (nz, nc) dans <=>
        | La zone du théatre numéro <nz> appartient à la catégorie <nc>
    exemples
        (5, "orchestre")
    constraints
        dom(numeroZone) = Integer
        dom(nomCategorie) = NomCategorie
        key numeroZone

Relation Sieges(numeroSiege, rangSiege, numeroZone)
    intention
        (ns, rs, nz ) dans <=>
        | Le siège de numero <ns> est situé au rang <nr>. Il appartient à
        | la zone nz
    examples
        (5, 6, 1)
    constraints
        dom(numeroSiege, rangSiege, numeroZone) = Integer
        Siege[numeroZone] C= Zones[numeroZone]
        key numeroSiege, rangSiege

Relation DossierDAchats_base(numeroDossier, acheteDossier, nombreBilletsDossier_d, prixTotalDossier_d)
    intention
        (nd, ac, nb, pt) dans <=>
        | Le `dossierDAchat` de numero <nd> contient <nb> `Billets` avec un prix total <pt>
        | Il à le statut acheté (ac=TRUE) ou pré-réservé (ac=FALSE)
    exemples
        (2566, TRUE, 5, 120)
    constraints
        dom(numeroDossier,nombreDeBilletsDossier) = Integer
        dom(prixTotalDossier) = Real
        dom(acheteDossier) = Boolean
        dom(prixTotalDossier) = Real
        key numeroDossier

Relation Billets_base(dateRepresentation_2, heureDebutRepresentation_2, numeroSiege_2, rangSiege_2, numeroBillet_1, numeroDossier, dateAchatBillet, tarifReduitBillet, prixBillet)
    | Les billets vendus ou réservés relatifs aux différents spectacles
    intention
        (d, h, ns, nr, nb, nd, da, tr, p) dans <=>
        | Le `Billet` numero <nb> concerne le `Spectacle` qui prendra lieu à la date <d>
        | à l'heure <h>. Il appartient au `Dossier Achat` <nd> pour réserver le `Siege` <ns>
        | situé au `Rang` <nr>. Le `Billet` est rempli à la date <da> avec un tarif reduit <tr>.
        | Il vaut un prix p
    examples 
        ('08-03-2021', '20:00:00', 3, 20, 2520, 50, '05-03-2021', 0.8, 50)
    constraints
        dom(dateRepresentation,heureDebutRepresentation,dateAchatBillet) = String
        dom(numeroSiege, rangSiege, numeroBillet, numeroDossier) = Integer
        dom(tarifReduitBillet, prixBillet) = Real
        Billets_base[dateRepresentation] C= Representation[dateRepresentation]
        Billets_base[heureRepresentation] C= Representation[heureRepresentation]
        Billets_base[numeroSiege] C= Siege[numeroSiege]
        Billets_base[rangSiege] C= Siege[rangSiege]
        Billets_base[numeroDossier] C= DossierDachats_base[numeroDossier]
        key dateRepresentation, heureRepresentation, rangSiege, numeroSiege
        key numeroBillet
        
// PAS ENCORE IMPLÉMENTÉ
// Relation Utilisateurs(loginUtilisateur,motDePasseUtilisateur,nomUtilisateur,prenomUtilisateur,emailUtilisateur)
//     intention
//         (l,mdp,nomU,pu,emu) dans <=>
//         | L'`Utilisateur` de nom <n>, et de prenom <p> est inscrit
//         | avec son e-mail <em>. Il peut se connecter avec le login <l> et 
//         | le mot de passe <mdp>.
//     exemples
//         ('util_inconnu', 'Utilinconnu1', 'Utilisateur', 'Inconnu', 'utilisateur_inconnu@domaine.com')
//     constraints
//         dom(loginUtilisateur, motDePasseUtilisateur, nomUtilisateur, prenomUtilisateur, emailUtilisateur) = String
//         key login
        
// Relation Possessions(loginUtilisateur,numeroDossierDAchat)
//     intention
//         (lu,nd) dans <=>
//         | le dossier de numero <nd> correspond à l'utilisateur <lu>.
//     exemples
//         ('util_inconnu', 2566)
//     constraints
//         key loginUtilisateur, numeroDossierDAchat
//         UtiPossedeDoss[loginUtilisateur] C= Utilisateurs[loginUtilisateur]
//         UtiPossedeDoss[numeroDossierDAchat] C= DossierDachat_base[numeroDossierDAchat]
        
// Relation Adherents(loginAdherent,dateDAdhesionAdherent,dureeDAdherent)
//     intention
//         (l,da,d) dans <=>
//         | l'utilisateur <l> a adheré à la date <da> pour une durée <d>
//     exemples
//         | ('util_inconnu', '25-01-2021', 2.0)
//     constraints:
//         dom(dateDAdhesionAdherent) = String
//         dom(dureeAdherent) = Real
//         Adherent[loginAdherent] C= Utilisateur[loginAdherent]
//         key loginAdherent, dateDadhesionAdherent
