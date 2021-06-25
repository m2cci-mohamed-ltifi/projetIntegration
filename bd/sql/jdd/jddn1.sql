PRAGMA foreign_keys = ON;

---Nombre de test échouant : 16

--------------------------Table Spectacles------------------------------------------
-- fonctionne
INSERT INTO Spectacles VALUES (1,'La Somnanbule','toutPublic',20,60 ,'opera',FALSE,FALSE,"Description","path/to/vignette.png");
--@ violates PK_Spectacles
INSERT INTO Spectacles VALUES (1,'Le malade imaginaire de Molière','Adultes',45,120,'humoristique',FALSE,FALSE,"Description","path/to/vignette.png");
--@ violates UNI_NomSpectacleUnique
INSERT INTO Spectacles VALUES (2,'La Somnanbule','adulte',20,120,'musical',FALSE,FALSE,NULL,NULL);
--@ violates CK_typeSpectacleOk
INSERT INTO Spectacles VALUES (2,'Le malade imaginaire de Molière','Adultes',45,120,'humoristique',FALSE,FALSE,NULL,NULL);
--@ violates CK_publicSpectacleOk
INSERT INTO Spectacles VALUES (2,'Le malade imaginaire de Molière','adulte',45,120,'humoristiques',FALSE,FALSE,NULL,NULL);
--@ violates Spectacles.prixDeBaseSpectacle NOT NULL
INSERT INTO Spectacles VALUES (2,'Le malade imaginaire de Molière','adulte',NULL,120,'humoristiques',FALSE,FALSE,NULL,NULL);
--@ violates Spectacles.dureeSpectacle NOT NULL
INSERT INTO Spectacles VALUES (2,'Le malade imaginaire de Molière','adulte',45,NULL,'humoristiques',FALSE,FALSE,NULL,NULL);

--@ violates Trigger oneManShowEstHumoristique
INSERT INTO Spectacles VALUES (3,'Tosca','toutPublic',35,120,'musical',TRUE,FALSE,NULL,NULL);
--@ violates Trigger orchestreEstOpera
INSERT INTO Spectacles VALUES (3,'Tosca','toutPublic',35,120,'musical',FALSE,TRUE,NULL,NULL);


--------------------------Table Representations_base------------------------------------------

--fonctionne
INSERT INTO Representations_Base VALUES ('26-03-2021', '18:00:00', 1, 1);
--@ violates PK_representation
INSERT INTO Representations_Base VALUES ('26-03-2021', '18:00:00', 1, 1);
--@ violates UNI_UneSeuleRepresentationParSpectacleParJour
INSERT INTO Representations_Base VALUES ('26-03-2021', '22:00:00', 1, 1);
--@ violates FK_RepresentationSpectacleExiste
INSERT INTO Representations_Base VALUES ('27-03-2021', '18:00:00', 2, 1);
--@ violates CK_RepresentationTauxCoherent
INSERT INTO Representations_Base VALUES ('27-03-2021', '18:00:00', 1, -0.1);
--@ violates CK_RepresentationTauxCoherent
INSERT INTO Representations_Base VALUES ('27-03-2021', '18:00:00', 1, 1.1);
--@ violates Representation.numeroSpectacle NOT NULL
INSERT INTO Representations_Base VALUES ('27-03-2021', '18:00:00', NULL, 1);

--Spectacles de test pour les chevauchements
INSERT INTO Spectacles VALUES (2,'Spectacle2','toutPublic',35,60,'opera' ,FALSE,FALSE,NULL,NULL);
INSERT INTO Spectacles VALUES (3,'Spectacle3','toutPublic',35,120,'opera',FALSE,FALSE,NULL,NULL);
INSERT INTO Spectacles VALUES (4,'Spectacle4','toutPublic',35,120,'opera',FALSE,FALSE,NULL,NULL);

-- Representations pour tester les chevauchements
INSERT INTO Representations_Base VALUES ('27-03-2021', '12:00:00', 2, 1);
-- @ violates Trigger chevauchementRepresentationPost
INSERT INTO Representations_Base VALUES ('27-03-2021', '12:59:00', 3, 1);
-- @ violates Trigger chevauchementRepresentationPre
INSERT INTO Representations_Base VALUES ('27-03-2021', '10:01:00', 3, 1);
-- Representation insérable
INSERT INTO Representations_Base VALUES ('27-03-2021', '13:00:00', 3, 1);
-- Representation insérable
INSERT INTO Representations_Base VALUES ('27-03-2021', '10:00:00', 4, 1);


--------------------------Table Zones------------------------------------------

--fonctionne
INSERT INTO Zones VALUES (1,"poulailler");
INSERT INTO Zones VALUES (2,"orchestre");
INSERT INTO Zones VALUES (3,"balcon");
--@ violates PK_Zones
INSERT INTO Zones VALUES (1,"orchestre");
--@ violates CK_nomCategorieExiste
INSERT INTO Zones VALUES (4,"test");
--@ violates Zones.nomCategorie NOT NULL
INSERT INTO Zones VALUES (4,NULL);


--------------------------Table Sieges------------------------------------------

--fonctionne
INSERT INTO Sieges VALUES (1, 1, 1);
INSERT INTO Sieges VALUES (2, 1, 1);
INSERT INTO Sieges VALUES (3, 1, 1);
INSERT INTO Sieges VALUES (4, 1, 1);
--@ violates PK_Sieges
INSERT INTO Sieges VALUES (1, 1, 1);
--@ violates FK_SiegeZoneExiste
INSERT INTO Sieges VALUES (5, 1, 99);
--@ violates Sieges.numeroZone NOT NULL
INSERT INTO Sieges VALUES (4, 1, NULL);


--------------------------Table DossierDAchat-----------------------------------
-- Pour mieux lire les données, on utilisera les numéros de dossier à partir 222

--fonctionne
INSERT INTO DossierDachats_base VALUES (222,TRUE);
--@ violates PK_DossierDAchats
INSERT INTO DossierDachats_base VALUES (222,TRUE);
--@ violates DossierDAchats.acheteDossier NOT NULL
INSERT INTO DossierDachats_base VALUES (223,NULL);


--------------------------Table Billet------------------------------------------
-- utilise les représentations, sièges et dossiers d'achat créés ci-dessus
-- Pour mieux lire les données, on utilisera les numéros de billet à partir 20

--fonctionne. 
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 1, 1, 20, 222, '25-03-2021', 1);
--@ violates PK_Billets
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 1, 1, 21, 222, '25-03-2021', 1);
--@ violates FK_BilletsRepresentationExiste
INSERT INTO Billets_base VALUES ('01-01-2021', '18:00:00', 2, 1, 21, 222, '25-03-2021', 1);
--@ violates FK_BilletsSiegeExiste
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 99, 1, 21, 222, '25-03-2021', 1);
--@ violates FK_BilletsDossierExiste
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 2, 1, 21, 999, '25-03-2021', 1);
--@ violates UNI_numeroBilletUnique
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 2, 1, 20, 222, '25-03-2021', 1);
--@ violates CK_tarifReduitBilletCoherent
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 2, 1, 21, 222, '25-03-2021', 1.1);
--@ violates CK_tarifReduitBilletCoherent
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 2, 1, 21, 222, '25-03-2021', -0.1);
--@ violates Billets_base.numeroDossier NOT NULL
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 2, 1, 21, NULL, '25-03-2021', 1);
--@ violates Billets_base.dateAchatBillet NOT NULL
INSERT INTO Billets_base VALUES ('26-03-2021', '18:00:00', 2, 1, 21, 222, NULL, 1);