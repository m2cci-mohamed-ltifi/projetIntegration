#!/usr/bin/env bash

# Modification du script creer-la-bd.sh pour fonctionner avec plusieurs jeux de données
# et indiquer si le nombre de mention @violates correspond au nombre d'erreur dans le jddn

# USAGE : 
#       cd bd/sql
#       ./cree-la-bd_v2.sh jdd/jdd1_sieges.sql jdd/jdd1.sql jdd/jdd1_spectaclePlein.sql

# Si dessous l'en-tête du script original.
# -----
# Version française 2.4. Dernière version dans ModelScript
#
# Crée la base de donnée avec le schéma de données et éventuellement
# un jeu de données spécifié.
# usage:  cree-la-bd.sh [ jddX ]
#     Crée la base de données bd.sqlite3
#     Un jeu de données peut être spécifié de manière optionnelle.
#
# Ce script exécute essentiellement les commandes suivantes :
#
#     sqlite3 bd.sqlite3 < schema.sql
#     sqlite3 bd.sqlite3 < jdd/jddX.sql
#
# Si nécessaire l'emplacement de la base de données peut être modifié
# en changeant la variable $DATABASE ci-dessous.
# -----

NOMBRE_DATASET=$#
# DATASET=$1

THISDIR="$(cd "$(dirname ${BASH_SOURCE[0]})" && pwd)"

# The path to the database can be changed below
DATABASE="${THISDIR?}/bd.sqlite3"

# Path to the schema. Not reason to change it
SCHEMA="${THISDIR?}/schema/schema.sql"

# Path to the dataset file.
# DATASET_FILE="${THISDIR?}/jdd/${DATASET?}.sql"

# DATASET_ERRORS="${DATASET_FILE?}.err.txt"

echo -n "Nettoyage de la base de données ... "
rm -f "${DATABASE?}"
echo "fait."

echo -n "Chargement du schéma... "
sqlite3 "${DATABASE?}" <"${SCHEMA?}"
if [ $? -eq 0 ]; then
    echo "fait."
else
    echo "**** Erreur pendant le chargement du schéma"
fi

if [ "${NOMBRE_DATASET}" -eq 0 ]; then
    echo "Base de données vide créée."
else
    for i in "$@"; do
        DATASET_FILE="$i"
        DATASET_ERRORS="${DATASET_FILE?}.err.txt"
        if [ -f "${DATASET_FILE?}" ]; then
            echo -n "Chargement du jeu de données ${DATASET_FILE?}... "
            NB_ERRORS_EXPECTED=$(grep -o -c violates ${DATASET_FILE?})
            ERROR_MESSAGES=$(sqlite3 "${DATABASE?}" < "${DATASET_FILE?}" 2>&1)
            
            echo ${ERROR_MESSAGES} | sed -e 's/Error/\nError/g'
            NB_ERRORS=$(echo ${ERROR_MESSAGES} | sed -e 's/Error/\nError/g' | wc -l)
            NB_ERRORS=$((NB_ERRORS-1))
            if [ ${NB_ERRORS} -eq 0 ]; then
                echo "fait."
                echo "Jeu de données ${DATASET_FILE?} chargé dans la base de données."
            else
                echo "**** ${NB_ERRORS} erreurs pendant le chargement du jeu de données"
                if [ ${NB_ERRORS_EXPECTED} -eq ${NB_ERRORS} ]; then
                    echo -e "\n**** Le fichier contient le nombre d'erreurs attendues\n"
                else
                    echo -e "\n********** Attentions : ${NB_ERRORS_EXPECTED} erreurs attentues (mentions @ violates), mais ${NB_ERRORS} erreurs à l'execution **********\n"
                fi
            fi
        else
            echo "Le jeu de données '${DATASET_FILE?}' n'existe pas." >/dev/stderr
            echo "Fichier ${DATASET_FILE?} inexistant." >/dev/stderr
            echo "La base de données est vide."
            exit 1
        fi
    done
fi
