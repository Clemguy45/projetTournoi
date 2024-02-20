# Projet Tournoi

## Groupe
 * Guyot Clément (SIR) o2163453
 * Poudroux Mickael (SIR)
 * Blot Benjamin (SIR)
 * Cholley Yohann (SIMSA)
 * ADIGOUN Daniel (SIMSA)


## Sujet :
**Organisateur de tournois** pour plusieurs jeux e-Sport, l'application aura pour objectif de pouvoir faire des tournois 
par catégorie de joueur sous forme de Tenkaichi. Les jeux auront chacun un micro-service 
(League of Legende, Yu-Gi-Oh Master Duel, Valorante, ...). 
Les joueurs pourront organiser les tournois en catégorie pro ou casual. Ils pourront aussi organiser en fonction de leur 
Rang (bronze, silver, or, platinium, Master/Challenger). Un tournoi devra renseigner le nombre de participants au 
tournoi et sera toujours public, il devra renseigner le jeu mise en avant pour le tournoi.

**Les Joueurs** pour participer aux tournois devront être identifié, ils auront un pseudo, mot de passe, adresse mail, 
une catégorie (pro ou casual), des sponsors, image de profil, l'Age.

**Les Jeux** auront leur titre, type de jeux, PEGI, les rangs (Bronze, silver, or, Platinum, Master/Challenger), 
nombre de joueurs max, mode de jeux (ARAM, 5v5, 3v3, 50cc, 100cc, 200cc,...).

**L'historique de Tournois** : le match, le nom du jeu, nom de l'équipe, le résultat
dans le détail : les noms des joueurs (si équipe), score des joueurs, résultat.

## Service

- un service de d'organisation de tournois.
- un service de joueur (authentification)
- un service par Jeux (minimum 2 jeux)
- un service Historique de Tournois

## Techno utiliser

- Un service en .Net
- Un service en Java SpringBoot
- Dockerisation des Micro-service
- Diférente base de donnée