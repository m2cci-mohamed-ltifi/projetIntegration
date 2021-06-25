Exigences liées aux données
===========================

*   (ED1) Un directeur de théâtre désire informatiser son système de réservation de billets pour les `spectacles` qui se déroulent dans son théâtre au cours d’une même saison.

*   (ED2) A la fin d’une saison, le contenu de la base de données est archivé et vidé.

*   (ED3) Pour les besoins du sujet les données de l’application décrites ci-après ont été simplifiées.

*   (ED4) Dans le cadre de réunions avec le directeur les différents incréments ont été définis.


I1_LesSpectacles
----------------

*   (ED5) Un `spectacle` est identifié par un `NuméroDeSpectacle` et on connaı̂t son nom, son `TarifPlein`, le public cible (1-5 ans, jeune public, tout public ou adultes) et le `typeDeSpectacle` (opéra, drame, humoristique, musical ou cirque).

*   (ED6) Sur les `spectacles` du type opéra, on indique s’il s'agit d'un `SpectacleAvecOrchestre`.

*   (ED7) Sur les `spectacles` du type humoristique on indique s’il s’agit d’un `OneWoman`Show.

*   (ED8) Un `spectacle` fait généralement l’objet de plusieurs `représentations` proposées à des moments différents.

*   (ED9) Il y a au plus une `représentation` par `spectacle` et par jour.

*   (ED10) Une `représentation` débute à un moment donné exprimé à la granularité de l’heure (par exemple 28/11/2007 20H).



I2_LesPlaces
------------

*   (ED11) La seule `salle` du théâtre est partitionnée en `zones` numérotées, regroupant chacune un ensemble de `sièges`.

*   (ED12) Un `siège` est identifié par un `Rang` (unique par `salle`), et un `NuméroDeSiège` dans le `rang`.

*   (ED13) Une `zone` est associée à une seule `CatégorieDeSièges` (orchestre, balcon, poulailler, etc).

*   (ED14) Une `CatégorieDeSièges` peut être associé à plusieurs `zones`.

*   (ED15) Toutes les places de la même `zone` sont dans la même `CatégorieDeSièges`.

*   (ED16) Un taux par rapport au prix de base est associé à chaque `CatégorieDeSièges` (ex. 1 pour le poulailler, 1.2 pour l’orchestre et 1.5 pour le balcon).

*   (ED17) Ce taux est fixé pour l’ensemble des `spectacles`.



I3_LesBillets
-------------

*   (ED18) Chaque billet vendu par `représentation` fait l’objet de l’émission d’un billet identifié par un `NuméroDeBillet` et estampillé par la date au moment de l’emission (instant à la granularité de la seconde).

*   (ED19) Un `achat` concerne un ou plusieurs billets se traduisant par la création d’un `DossierAchat` identifié par un `NuméroDossierAchat` auquel est associé le prix global des billets.

*   (ED20) Un suivi du nombre de `sièges` disponibles pour chaque `représentation` programmée pour un `spectacle` est envisagé.



I5_LesUtilisateurs
------------------

*   (ED21) L’application doit être mise en ligne afin de permettre à des utilisateurs identifiés ou non d’acheter des billets.

*   (ED22) Les utilisateurs sont identifiés par leur login.

*   (ED23) Ils sont décrits par leur nom, leur prénom, leur adresse électronique et leur mot de passe.

*   (ED24) Un utilisateur identifié peut réserver des billets avant de procéder à leur `achat`.

*   (ED25) Une place préréservée ne peut être réservée que par l’utilisateur identifié qui a effectué la préréservation.

*   (ED26) Une préréservation pourrait être ensuite rendue disponible par l'utilisateur qui l’a préréservée.



I6_LesConfigurations
--------------------

*   (ED27) Selon les `spectacles`, tous les `sièges` de certaines `zones` sont retirées de la vente : en effet, dans certaines mises en scène, une partie des tribunes est occupée par le spectacle.

*   (ED28) La `configuration` de la `salle`, c’est-à-dire l’ensemble des `zones` dont les `sièges` sont mises à la vente, est la même pour toutes les `représentations` d’un même spectacle.