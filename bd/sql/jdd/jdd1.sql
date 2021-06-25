PRAGMA foreign_keys = ON;

---------Sièges-----------------
-- Pour des raisons pratiques, ce jeu de donnée ne contients pas les sièges, zones et catégories
-- Le jeu de données jdd1_sieges.sql qui contient ces données doit être chargé AVANT ce jeu de données
--------------------------------

--------------------------------------------------------------------------------------
--Insertion des données d'après les Scénarios-----------------------------------------
--------------------------------------------------------------------------------------

--Scenario S1 et S1bis
INSERT INTO Spectacles VALUES (1,'La Somnanbule','adulte',20,60 ,'opera',0,0,
    "La Somnambule, créée quelques mois avant Norma, connut un succès considérable durant tout le XIXe siècle. Le thème du 
    somnambulisme fascinait en effet l’époque romantique avide de phénomènes mystérieux. Bellini a exploré ici toutes les 
    possibilités musicales susceptibles de traduire les états d’âme complexes de son héroïne, victime innocente d’un mal 
    inconnu. L’ouvrage offre quelques-uns parmi les plus beaux airs de soprano du répertoire bel canto.", 
    "data/images/laSomnanbule.jpg");
INSERT INTO Spectacles VALUES (2,'Le malade imaginaire','toutPublic',45,120,'humoristique',0,0,
    "Le Malade imaginaire, dernière œuvre dramatique écrite par Molière, est une comédie-ballet en trois actes et en prose, 
    créée le 10 février 1673 par la Troupe du Roi sur la scène du Palais-Royal à Paris, avec une musique de scène composée 
    par Marc-Antoine Charpentier et des ballets réglés par Pierre Beauchamp.", 
    "data/images/leMaladeImaginaire.jpg");
INSERT INTO Spectacles VALUES (3,'Pour moi, ce sera sans chausettes','toutPublic',35,120,'opera',0,1 ,"L'envie d'aventures et la curiosité d'Oulaya 
l'a amenée à vouloir parcourir les montagnes grenobloises. Arrivée face à la neige elle se rend compte qu'il lui manque... des chausettes. 
Cet opéra avec orchestre met en scène l'aventure de cette jeune fille qui, malgré ce problème technique, contemple la beauté des Alpes.","data/images/sansChaussettes.jpg");

INSERT INTO Representations_Base VALUES ('26-05-2021', '18:00:00', 1, 1);
INSERT INTO Representations_Base VALUES ('27-05-2021', '17:00:00', 1, 1);

INSERT INTO Representations_Base VALUES ('17-04-2021', '21:00:00', 2, 1);
INSERT INTO Representations_Base VALUES ('15-04-2021', '20:30:00', 2, 1);
INSERT INTO Representations_Base VALUES ('10-05-2021', '14:00:00', 2, 1);

INSERT INTO Representations_Base VALUES ('27-05-2021', '22:30:00', 3, 1);
INSERT INTO Representations_Base VALUES ('28-05-2021', '10:00:00', 3, 1);

    --4 billets en préréservations
    --Un dossier d'achat est automatiquement créé
INSERT INTO DossierDachats_base VALUES (222, 0);
    
    --Pour la représentation du 27-03 à 18h, siège 20,21,22 et 23 rang 2. Billet n°50 à 53, dossier 222.
    --Acheté le 25-03, pas de tarif réduit, précommandés.
INSERT INTO Billets_base VALUES('27-05-2021', '17:00:00', 20, 2, 50, 222, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('27-05-2021', '17:00:00', 21, 2, 52, 222, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('27-05-2021', '17:00:00', 22, 2, 51, 222, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('27-05-2021', '17:00:00', 23, 2, 53, 222, '25-03-2021', 1);

    --Confirmation des billets le lendemain
UPDATE DossierDachats_base SET acheteDossier=1 WHERE numeroDossier=222;


--Scenario S2
INSERT INTO Spectacles VALUES (4,'L’Avare','toutPublic',25,120,'humoristique',0,0,"L'Avare est une comédie de Molière en cinq actes et en prose, adaptée de La Marmite (Aulularia) 
de Plaute1 et représentée pour la première fois sur la scène du Palais-Royal le 9 septembre 16682. Il s'agit d'une comédie de caractère dont le personnage principal, Harpagon, est 
caractérisé par son avarice caricaturale. Harpagon tente de marier sa fille de force, tout en protégeant obstinément une cassette pleine d'or. Les cinq actes comportent respectivement cinq, cinq, neuf, sept, et six scènes.", "data/images/lavare.jpg");
INSERT INTO Spectacles VALUES (5,"Aujourd'hui, j'ai perdu mon bras",'toutPublic',15,140,'humoristique',0,0,
    "C'est l'histoire d'Émilie, qui a deux bras, mais en fait non. Une comédie poignante sur la vie en millieu hospitalier. 
    Naviguant adroitement entre cliché et anectode réelles, la compagnie nous livre avec humour et brio un autre regard sur 
    ceux qui nous sauvent la vie. Légère, touchante, cette comédie destinée à tous vous ferra réfléchir en vous apportant le sourire.", "data/images/emilie.jpg");

INSERT INTO Representations_Base VALUES ('06-04-2021', '19:00:00', 5, 1);
INSERT INTO Representations_Base VALUES ('12-03-2021', '19:00:00', 5, 0.8);
INSERT INTO Representations_Base VALUES ('01-05-2021', '19:00:00', 5, 0.8);


    --8 billets réservés, dont deux en tarif étudiant
    --Un dossier d'achat est automatiquement créé
INSERT INTO DossierDachats_base VALUES (234, 1);

    --Pour la représentation du 28-03 à 19h, siège 1 à 8 rang 5. Billet n°100 à 108, dossier 234.
    --Acheté le 25-03, tarif étudiant (-20%) pour les deux derniers, réservés.
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 1, 5, 100, 234, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 2, 5, 101, 234, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 3, 5, 102, 234, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 4, 5, 103, 234, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 5, 5, 104, 234, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 7, 5, 105, 234, '25-03-2021', 1);
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 8, 5, 106, 234, '25-03-2021', 0.8);
INSERT INTO Billets_base VALUES('12-03-2021', '19:00:00', 9, 5, 107, 234, '25-03-2021', 0.8);


--Scenario S3
INSERT INTO Spectacles VALUES (6,'La musique et moi','toutPublic' ,25,80,'musical',0,0,"Comment une simple mélodie peut-elle changer toute votre vie ?", "data/images/musique.jpg");
INSERT INTO Spectacles VALUES (7,'Perdu','adulte',25,100,'drame',0,0,"C'est tragique, c'est dramatique, mais c'est la vie : parfois il faut se perdre pour vraiment se retrouver...","data/images/perdu.jpg");
INSERT INTO Spectacles VALUES (8,'Pourquoi Papa fait du chocolat ?','jeunePublic',25,120,'humoristique',0,0,"Venez découvrir le nouveau spectacle associatif de la troupe 'Les acteurs aiment les fleurs' !", "data/images/chocolat.jpg");

INSERT INTO Representations_Base VALUES ('01-04-2021', '21:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('02-04-2021', '21:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('03-04-2021', '21:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('04-04-2021', '18:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('08-04-2021', '21:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('09-04-2021', '21:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('10-04-2021', '21:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('11-04-2021', '18:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('15-04-2021', '14:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('16-04-2021', '21:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('17-04-2021', '17:00:00', 6, 1);
INSERT INTO Representations_Base VALUES ('18-04-2021', '18:00:00', 6, 1);

INSERT INTO Representations_Base VALUES ('01-05-2021', '17:00:00', 7, 1);
INSERT INTO Representations_Base VALUES ('08-05-2021', '19:00:00', 7, 1);
INSERT INTO Representations_Base VALUES ('15-05-2021', '19:00:00', 7, 1);

INSERT INTO Representations_Base VALUES ('29-05-2021', '19:00:00', 8, 1);
INSERT INTO Representations_Base VALUES ('30-05-2021', '19:00:00', 8, 1);
INSERT INTO Representations_Base VALUES ('31-05-2021', '15:00:00', 8, 1);


--//TODO:
--Scenario S4
--Scenatio S4 bis


--------------------------------------------------------------------------------------
--Insertions de données fictives complémentaires--------------------------------------
--------------------------------------------------------------------------------------

--Création des spectacles
INSERT INTO Spectacles VALUES (9,'Là-bas, de l’autre côté de l’eau','adulte',20,180,'drame',0,0,"De l'autre côté de l'eau, il n'y a plus d'eau. Ce drame poétique rappelle à chacun les véritables priorités de la vie.", "data/images/eau.jpg");
INSERT INTO Spectacles VALUES (10,'Le Rock de la sorcière','public1a5Ans',15,60,'musical',0,0, NULL,"data/images/rockSorciere.jpg");
INSERT INTO Spectacles VALUES (11,'Grattouillis','public1a5Ans' ,15,90, 'musical',0,0, "Attention les enfants, ça fait des gillis, ça chatouille et MOUHAHAHA !","data/images/gratouillis.jpg");
INSERT INTO Spectacles Values (12,'L’amour est une fumée faite de la vapeur des souvenirs','adulte',25,150,'drame',0,0,"L'amour est quelque chose de nouveau, mais en fait non. Déprimant comme pensée mais bon c'est la vie.", "data/images/amourFumee.jpg");
INSERT INTO Spectacles Values (13, 'Cirque Phoénix','toutPublic',20,120,'cirque',0,0,"La fameux Cirque Phoénix revient cette saison pour un nouveau spectacle des plus époustoufflants !","data/images/phoenix.jpg");
INSERT INTO Spectacles Values (14, 'Comment mes cheveux m’ont sauvé','toutPublic',45,120,'humoristique',1 ,0,"L'humoriste Ayoub nous raconte dans ce One Man Show exceptionnel son histoire avec ses cheveux... Plutôt courts ? Plutôt longs ?
Des histoires à se tordre de rire qui vous ferons voir vos cheveux différemment... !", "data/images/ayoub.png");
INSERT INTO Spectacles Values (15, 'Push-Up','adulte',45,120,'musical',0 ,0,"Philémon porte quelque chose qu'il ne devrait pas porter. Mais après tout, qui sommes-nous pour juger ? Une comédie musicale vraiment pas comme les autres.", "data/images/philemon.jpg");

--Création des représentations pour les spectacles
INSERT INTO Representations_Base VALUES ('14-07-2021', '21:00:00',9 ,1);
INSERT INTO Representations_Base VALUES ('15-07-2021', '20:15:00',9 ,1);
INSERT INTO Representations_Base VALUES ('17-07-2021', '18:15:00',9 ,1);
INSERT INTO Representations_Base VALUES ('21-07-2021', '22:15:00',9 ,1);
INSERT INTO Representations_Base VALUES ('22-07-2021', '16:15:00',9 ,1);
INSERT INTO Representations_Base VALUES ('23-07-2021', '19:15:00',9 ,1);
INSERT INTO Representations_Base VALUES ('12-07-2021', '18:30:00',10,0.7);
INSERT INTO Representations_Base VALUES ('13-07-2021', '19:30:00',10,1);
INSERT INTO Representations_Base VALUES ('16-07-2021', '19:00:00',10,1);
INSERT INTO Representations_Base VALUES ('19-07-2021', '17:30:00',10,1);
INSERT INTO Representations_Base VALUES ('20-07-2021', '18:30:00',10,1);
INSERT INTO Representations_Base VALUES ('23-07-2021', '14:00:00',10,1);
INSERT INTO Representations_Base VALUES ('19-08-2021', '16:00:00',11,0.95);
INSERT INTO Representations_Base VALUES ('20-08-2021', '20:00:00',11,1);
INSERT INTO Representations_Base VALUES ('21-08-2021', '21:00:00',11,1);
INSERT INTO Representations_Base VALUES ('20-09-2021', '19:00:00',12,1);
INSERT INTO Representations_Base VALUES ('22-09-2021', '17:00:00',12,1);
INSERT INTO Representations_Base VALUES ('23-09-2021', '18:00:00',12,1);
INSERT INTO Representations_Base VALUES ('28-09-2021', '20:00:00',13,1);
INSERT INTO Representations_Base VALUES ('29-09-2021', '18:00:00',13,1);
INSERT INTO Representations_Base VALUES ('30-09-2021', '21:15:00',13,1);
INSERT INTO Representations_Base VALUES ('25-10-2021', '16:00:00',14,1);
INSERT INTO Representations_Base VALUES ('26-10-2021', '14:45:00',14,0.6);
INSERT INTO Representations_Base VALUES ('27-10-2021', '17:00:00',14,0.9);
INSERT INTO Representations_Base VALUES ('28-10-2021', '17:00:00',15,0.9);

-- INSERT INTO DossierDachats_base VALUES (2566);
-- INSERT INTO DossierDachats_base VALUES (4070);
-- INSERT INTO Billets_base VALUES ('08-03-2021', '18:00:00',8 ,2 ,2520 ,4070 ,'5-3-2021T15:31:20' ,0.25 ,1);
-- INSERT INTO Billets_base VALUES ('08-03-2021', '18:00:00',9 ,2 ,2521 ,4070 ,'5-3-2021T15:31:20' ,0.25 ,1);
-- INSERT INTO Billets_base VALUES ('08-03-2021', '18:00:00',10 ,2 ,2522 ,4070 ,'5-3-2021T15:31:20' ,0.25 ,1);
-- INSERT INTO Utilisateurs VALUES ('util_inconnu', 'Utilinconnu1', 'Utilisateur', 'Inconnu', 'utilisateur_inconnu@domaine.com'); 
-- INSERT INTO Adherents VALUES ('util_inconnu', '25/01/2021', 2.0) ;
