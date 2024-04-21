Bien sûr, voici une version corrigée de votre README.md :

# Projet Tournoi

## Groupe
* Guyot Clément (SIR) o2163453
* Poudroux Mickael (SIR) o2173838
* Blot Benjamin (SIR) o2198535
* Cholley Yohann (SIMSA) o22107014
* ADIGOUN Daniel (SIMSA) o2193070

## Sujet
En tant qu'organisateur de tournois pour plusieurs jeux e-Sport, notre application vise à permettre l'organisation de tournois par catégorie de joueur sous forme de Tenkaichi. Chaque jeu disposera de son propre micro-service (League of Legends, Yu-Gi-Oh Master Duel, Valorant, etc.). Les joueurs pourront organiser des tournois en catégorie professionnelle ou occasionnelle, ainsi qu'en fonction de leur rang (bronze, argent, or, platine, Master/Challenger). Un tournoi devra indiquer le nombre de participants, sera toujours public et devra spécifier le jeu mis en avant pour le tournoi.

### Joueurs
Les joueurs souhaitant participer aux tournois devront être identifiés. Ils auront un pseudo, un mot de passe, une adresse e-mail, une catégorie (professionnel ou occasionnel), des sponsors, une image de profil et leur âge.

### Jeux
Chaque jeu aura son titre, son type, son classement PEGI, ses rangs (bronze, argent, or, platine, Master/Challenger), le nombre maximum de joueurs, et son mode de jeu (ARAM, 5v5, 3v3, 50cc, 100cc, 200cc, etc.).

### Historique des Tournois
L'historique des tournois comprendra les détails tels que le match, le nom du jeu, le nom de l'équipe, le résultat, les noms des joueurs (s'il s'agit d'une équipe), les scores des joueurs et le résultat final.

## Services
- Un service d'organisation de tournois.
- Un service de joueurs (authentification).
- Un service de jeux.
- Un service de chat.

## Comment lancer l'application
Tout d'abord, vous devez cloner le projet :

```bash
git clone https://github.com/Clemguy45/projetTournoi.git
```

Pour lancer le projetTournoi, exécutez la commande suivante à la racine du projet :

```bash
docker-compose up --build -d
```

Attendez que la compilation se termine.

## Tester l'application
Pour tester l'application, suivez les étapes de la vidéo (envoyée par e-mail) en utilisant le fichier `projetTournois.http` pour effectuer différents appels d'API.

## Technologies utilisées
- Un service en .Net
- Trois services en Java SpringBoot
- Dockerisation des Micro-services
- Différentes bases de données MySQL

## Attention
Même si les services sont lancés, certains services se relanceront automatiquement pour se connecter à la base de données, car les bases de données ne se compilent pas assez vite par rapport à la compilation des services.

### Solution
Attendez quelques minutes ou consultez Consul. Une fois prête, les bases de données apparaîtront sur la page de Consul.