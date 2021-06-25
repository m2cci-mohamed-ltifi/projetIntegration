#!/usr/bin/env bash

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


DATASET=$1

THISDIR="$( cd "$( dirname ${BASH_SOURCE[0]} )" && pwd )"

# The path to the database can be changed below
DATABASE="${THISDIR?}/bd.sqlite3"

# Path to the schema. Not reason to change it
SCHEMA="${THISDIR?}/schema/schema.sql"

# Path to the dataset file.
DATASET_FILE="${THISDIR?}/jdd/${DATASET?}.sql"

DATASET_ERRORS="${DATASET_FILE?}.err.txt"

echo -n "Nettoyage de la base de données ... "
rm -f "${DATABASE?}"
echo "fait."

echo "${DATABASE?}"
echo "${SCHEMA?}"
echo -n "Chargement du schéma ... "
sqlite3 "${DATABASE?}" < "${SCHEMA?}"
if [ $? -eq 0 ]; then
    echo "fait."
else
    echo "**** Erreur pendant le chargement du schéma"
fi



if [ "${DATASET}" = "" ]; then
    echo "Base de données vide créée."
else
    if [ -f "${DATASET_FILE}" ]; then
        echo -n "Chargement du jeu de données ${DATASET} ..."./can
        sqlite3 "${DATABASE?}" <  "${DATASET_FILE?}"
        if [ $? -eq 0 ]; then
            echo "fait."
            echo "Jeu de données ${DATASET} chargé dans la base de données."
        else
            echo "**** Erreur pendant le chargement du jeu de données"
        fi
    else
        echo "Le jeu de données '${DATASET?}' n'existe pas." >/dev/stderr
        echo "Fichier ${DATASET_FILE?} inexistant."  >/dev/stderr
        echo "La base de données est vide."
        exit 1
    fi
fi