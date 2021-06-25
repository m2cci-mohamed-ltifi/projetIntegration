-------------------------------------------------------------------------------------------------------------
--Sommaire :
--  Tables
--      1.Spectacles et représentation
--      2.Sièges      & dépendances
--      3.Billets     & dépendances
--      4.Utilisateur & dépendances
--  Vues
--  Triggers

--------------------------------Tables------------------------------------------------------------------------

--------Spectacles et représentations------------

CREATE TABLE Spectacles(
    numeroSpectacle INTEGER,
    nomSpectacle VARCHAR(100),
    publicCibleSpectacle VARCHAR(100),
    prixDeBaseSpectacle NUMBER(4,2) NOT NULL,
    dureeSpectacle INTEGER NOT NULL,
    typeSpectacle VARCHAR(100),
    oneManShowSpectacle BOOLEAN,
    orchestreSpectacle BOOLEAN,
    descriptionSpectacle VARCHAR(100),
    imageSourceSpectacle VARCHAR(100),
    CONSTRAINT PK_Spectacles
        PRIMARY KEY (numeroSpectacle),
    CONSTRAINT UNI_NomSpectacleUnique
        UNIQUE(nomSpectacle),
    CONSTRAINT CK_typeSpectacleOk CHECK (typeSpectacle IN ("humoristique", "drame", "opera", "musical", "cirque")),
    CONSTRAINT CK_publicSpectacleOk CHECK (publicCibleSpectacle IN ("public1a5Ans", "jeunePublic", "toutPublic","adulte"))
);

CREATE TABLE Representations_Base (
    dateRepresentation DATE,
    heureDebutRepresentation TIME,
    numeroSpectacle INTEGER NOT NULL,
    tauxReductionExceptionnelleRepresentation NUMBER(4,2),
    CONSTRAINT PK_Representation
        PRIMARY KEY (dateRepresentation,heureDebutRepresentation),
    CONSTRAINT FK_RepresentationSpectaclesExiste
        FOREIGN KEY (numeroSpectacle) REFERENCES Spectacles(numeroSpectacle) ON DELETE CASCADE,
    CONSTRAINT CK_RepresentationTauxCoherent CHECK (tauxReductionExceptionnelleRepresentation >= 0 AND tauxReductionExceptionnelleRepresentation <= 1)
    CONSTRAINT UNI_UneSeuleRepresentationParSpectacleParJour
        UNIQUE(dateRepresentation,numeroSpectacle)
);


--------Sièges------------
CREATE TABLE Zones(
    numeroZone INTEGER,
    nomCategorie VARCHAR(100) NOT NULL,
    CONSTRAINT PK_Zones
        PRIMARY KEY (numeroZone),
    CONSTRAINT CK_nomCategorieExiste
        CHECK (nomCategorie IN ("poulailler","orchestre","balcon"))
);

CREATE TABLE Sieges(
    numeroSiege INTEGER,
    rangSiege INTEGER,
    numeroZone INTEGER NOT NULL,
    CONSTRAINT PK_Sieges
        PRIMARY KEY (numeroSiege, rangSiege)
    CONSTRAINT FK_SiegeZoneExiste
        FOREIGN KEY (numeroZone) REFERENCES Zones(numeroZone)
);

--------Configuration de la salle------------
-- PAS ENCORE IMPLÉMENTÉ
-- CREATE TABLE Configurations_base(
--     numeroSpectacle INTEGER,
--     numeroZone INTEGER,
--     CONSTRAINT PK_Configurations
--         PRIMARY KEY (numeroSpectacle, numeroZone)
--     CONSTRAINT FK_ConfigurationNumeroSpectacleExiste 
--         FOREIGN KEY (numeroSpectacle) REFERENCES Spectacles(numeroSpectacle)
--     CONSTRAINT FK_ConfigurationNumeroZoneExiste 
--         FOREIGN KEY (numeroZone) REFERENCES Zones(numeroZone)
-- );

--------Billets------------
CREATE TABLE DossierDachats_base(
    numeroDossier INTEGER PRIMARY KEY AUTOINCREMENT,
    acheteDossier BOOLEAN NOT NULL
);

CREATE TABLE Billets_base(
    dateRepresentation DATE,
    heureDebutRepresentation TIME,
    numeroSiege INTEGER,
    rangSiege INTEGER,
    numeroBillet INTEGER PRIMARY KEY AUTOINCREMENT,
    numeroDossier INTEGER NOT NULL,
    dateAchatBillet DATETIME NOT NULL,
    tarifReduitBillet NUMBER(4,2),
    CONSTRAINT UNI_Billets
        UNIQUE (dateRepresentation,heureDebutRepresentation,numeroSiege,rangSiege),
    CONSTRAINT FK_BilletRepresentationExiste
        FOREIGN KEY (dateRepresentation,heureDebutRepresentation) REFERENCES Representations_Base(dateRepresentation,heureDebutRepresentation),
    CONSTRAINT FK_BilletSiegeExiste
        FOREIGN KEY (numeroSiege,rangSiege) REFERENCES Sieges(numeroSiege,rangSiege),
    CONSTRAINT FK_BilletDossierExiste
        FOREIGN KEY (numeroDossier) REFERENCES DossierDachats_base(numeroDossier),
    CONSTRAINT CK_tarifReduitBilletCoherent
        CHECK (tarifReduitBillet>= 0 AND tarifReduitBillet<= 1)
);

--------Utilisateurs------------
-- PAS ENCORE IMPLÉMENTÉ
-- CREATE TABLE Utilisateurs(
--     loginUtilisateur VARCHAR(100),
--     motDePasseUtilisateur VARCHAR(100) CONSTRAINT Utilisateurs_c0 NOT NULL,
--     nomUtilisateur VARCHAR(100) CONSTRAINT Utilisateurs_c1 NOT NULL,
--     prenomUtilisateur VARCHAR(100) CONSTRAINT Utilisateurs_c2 NOT NULL,
--     emailUtilisateur VARCHAR(100) CONSTRAINT Utilisateurs_c3 NOT NULL,
--     CONSTRAINT PK_Utilisateurs
--         PRIMARY KEY (loginUtilisateur),
--     CONSTRAINT CK_EMAIL
--         UNIQUE (emailUtilisateur)
-- );

-- CREATE TABLE Adherents(
--     loginAdherent VARCHAR(100),
--     dateDAdhesionAdherent DATE,
--     dureeAdherent NUMBER(5,2) CONSTRAINT Adherents_co NOT NULL,
--     CONSTRAINT PK
--         PRIMARY KEY (loginAdherent, dateDAdhesionAdherent),
--     CONSTRAINT FK_Adherents
--         FOREIGN KEY (loginAdherent) REFERENCES Utilisateurs(loginUtilisateur)
-- ); 

-- CREATE TABLE Possessions(
--     loginUtilisateur VARCHAR(100),
--     numeroDossierUtilisateur INTEGER,
--     CONSTRAINT PK
--         PRIMARY KEY (loginUtilisateur, numeroDossierUtilisateur),
--     CONSTRAINT FK_Utilisateurs
--         FOREIGN KEY (loginUtilisateur) REFERENCES Utilisateurs(loginUtilisateur) ON DELETE CASCADE,
--     CONSTRAINT FK_Dossiers
--         FOREIGN KEY (numeroDossierUtilisateur) REFERENCES DossierDachats_base(numeroDossier) ON DELETE CASCADE
-- );



----------------------Vues-----------------------------------------------------------------

CREATE VIEW Representations(
        dateRepresentation, heureDebutRepresentation,
        numeroSpectacle,
        tauxReductionExceptionnelleRepresentation,
		nombreBilletsRepresentation,
		nombrePlacesRestanteRepresentation
        ) AS
    WITH NombreSiegesTotal AS (
            SELECT COUNT(*) AS nombreSiegesTotal
            FROM Sieges
    ),
    NombreBillets AS (
        SELECT dateRepresentation,heureDebutRepresentation, COUNT(numeroBillet) AS nombreBillets
        FROM Billets_base
        GROUP BY dateRepresentation,heureDebutRepresentation
    )
    SELECT 
	    dateRepresentation, heureDebutRepresentation,
        numeroSpectacle,
        tauxReductionExceptionnelleRepresentation,
		COALESCE(nombreBillets, 0) AS nombreBilletsRepresentation,
		(nombreSiegesTotal-COALESCE(nombreBillets, 0)) AS nombrePlacesRestanteRepresentation
    FROM Representations_Base JOIN NombreSiegesTotal LEFT OUTER JOIN NombreBillets USING (dateRepresentation,heureDebutRepresentation)
;

CREATE VIEW Billets(
        dateRepresentation, heureDebutRepresentation, 
        numeroSiege, rangSiege, 
        numeroBillet, 
        numeroDossier, 
        dateAchatBillet, 
        tarifReduitBillet,
		prixBillet
        ) AS
    WITH PrixParRepresentation AS(
        SELECT 
            dateRepresentation, heureDebutRepresentation, 
            numeroSpectacle, 
            (prixDeBaseSpectacle*tauxReductionExceptionnelleRepresentation) AS prixDeLaRepresentation
        FROM Spectacles JOIN Representations_Base USING (numeroSpectacle)
        GROUP BY dateRepresentation, heureDebutRepresentation, numeroSpectacle
        )
    SELECT 
        dateRepresentation, heureDebutRepresentation, 
        numeroSiege, rangSiege, 
        numeroBillet, 
        numeroDossier, 
        dateAchatBillet, 
        tarifReduitBillet,
		(prixDeLaRepresentation*tarifReduitBillet) AS prixBillet
    FROM Billets_base JOIN PrixParRepresentation  USING (dateRepresentation, heureDebutRepresentation)
;

CREATE VIEW DossierDachats(
        numeroDossier, 
        acheteDossier,
        nombreBillets,
        prixTotal
    ) AS
    SELECT 
        numeroDossier, 
        acheteDossier,
        COUNT(*) AS nombreBillet,
        SUM(prixBillet) AS prixTotal
    FROM DossierDachats_base JOIN Billets USING (numeroDossier)
    GROUP BY numeroDossier, acheteDossier
;


----------------------Triggers-----------------------------------------------------------------
----------------------Triggers Spectacles------------------
--Empêche la création d'un oneManShow non-humoristique
CREATE TRIGGER oneManShowEstHumoristique
    BEFORE INSERT ON Spectacles
BEGIN
    SELECT
        CASE
	WHEN NEW.typeSpectacle NOT IN ('humoristique') AND NEW.oneManShowSpectacle  THEN
        RAISE (ABORT,"TRIGGER : Un spectacle de OneManShow doit être humoristique")
    END;
END;

--Empêche la création d'un spectacle avec orchestre qui n'est pas d'opéra
CREATE TRIGGER orchestreEstOpera
    BEFORE INSERT ON Spectacles
BEGIN
    SELECT
        CASE
	WHEN NEW.typeSpectacle NOT IN ('opera') AND NEW.orchestreSpectacle  THEN
        RAISE (ABORT,"TRIGGER : Un spectacle avec Orchestre doit être un opéra")
    END;
END;

----------------------Triggers Representation------------------
--Empêche d'ajouter un spectacle dont le début chevauche une représentation existante
CREATE TRIGGER chevauchementRepresentationPost
    BEFORE INSERT ON Representations_Base
    WHEN (SELECT COUNT(*)
        FROM Spectacles JOIN Representations_Base USING(numeroSpectacle)
        WHERE NEW.dateRepresentation = dateRepresentation AND 
            time(heureDebutRepresentation, '+'||CAST(dureeSpectacle AS CHAR)||' minutes') > NEW.heureDebutRepresentation AND
            heureDebutRepresentation < NEW.heureDebutRepresentation
        )> 0
    BEGIN
        SELECT RAISE(ABORT, "TRIGGER : Impossible d'ajouter une représentation commençant durant une représentation existante");
    END
;

--Empêche d'ajouter un spectacle dont la fin chevauche une représentation existante
CREATE TRIGGER chevauchementRepresentationPre
    BEFORE INSERT ON Representations_Base
    WHEN (SELECT COUNT(*)
        FROM Spectacles JOIN Representations_Base ON (Spectacles.numeroSpectacle = NEW.numeroSpectacle)
        WHERE NEW.dateRepresentation = dateRepresentation AND 
            time(NEW.heureDebutRepresentation, '+'||CAST(dureeSpectacle AS CHAR)||' minutes') > heureDebutRepresentation AND
            heureDebutRepresentation > NEW.heureDebutRepresentation
        )> 0
    BEGIN
        SELECT RAISE(ABORT, "TRIGGER : impossible d'ajouteur une représentation terminant durant une représentation existante");
    END
;

CREATE TRIGGER fermetureSalle 
    BEFORE INSERT ON Representations_Base
    WHEN (SELECT COUNT(*)
        FROM Spectacles JOIN Representations_Base USING(numeroSpectacle)
        WHERE time(heureDebutRepresentation, '+'||CAST(dureeSpectacle AS CHAR)||' minutes') > '02:30:00' 
                AND  time(heureDebutRepresentation, '+'||CAST(dureeSpectacle AS CHAR)||' minutes') < '10:00:00') >0
    BEGIN
        SELECT RAISE(ABORT, 'TRIGGER : Fermeture de la salle prévu');
    END
;


    



