//=========================================================================
//                      Participant model
//-------------------------------------------------------------------------
// This glossary model is expressed in ParticipantScript
// See https://modelscript.rtfd.io/en/latest/languages/participants/index.html
//=========================================================================

participant model MyTheatre
import glossary model from "../glossaries/glossaries.gls"

//--- actors --------------------------------------------------------------
actor Gérant
    | Le gérant est responsable de `MyTheatre` et choisit le `Représentations` qui s'y déroulent

actor Utilisateur
    | Un utilisateur est une personne souhaite consuler les `Programmations` ou réserver des `Places`
    | au théâtre `MyTheatre`


//--- team roles -------------------------------------------------------------
team role développeur
    | Un `développeur` est un informaticien qui réalise et conçoit des logiciels et  
    | les met en oeuvre à l`aide des langages de programmation.

//--- Instance ------------------------------------------------------------
person emilieSirot : développeur
    name : "Emilie Sirot"
    trigram : EST
person oulayaBakka : développeur
    name : "Oulaya Bakka"
    trigram : OBA
person philémonGiraud : développeur
    name : "Philémon Giraud"
    trigram : PGD
person mohamedLtifi : développeur
    name : "Mohamed Ayoub Ltifi"
    trigram : MLI
    

personna Paul : Utilisateur
    | Paul est un homme qui souhaite emmener sa soeur et le conjoint de celle-ci au théâtre

personna Janine : Utilisateur
    | Janine est une infirmière souhaitant organiser une sortie pour son équipe de 8 personnes

personna Bernard : Gérant
    | Bernard est le directeur de `MyTheatre`