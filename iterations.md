# Qualité logicielle

## Itération 1

### Données du jeu

- Plateau : Cases indéxées
- Pions
  - Bateau, Dé à coudre, Chien, Chapeau, Chaussure
  - 🚢 | 🗑️ | 🐕 | 🎩 | 👞
- 2 dés
- Deux joueurs

### Règle

Les joueurs sont positionnés à la case départ (case 0).
A chaque tour, le joueur lance les dés et déplace son pion.
Le premier à faire 3 tours de plateau gagne.

### Scénario

Nombre de tour peut être choisi avant le début de la partie.
Les joueurs se déplace tour à tour.
La partie s'arrête lorsque le premier joueur à effectuer le nombre de tour défini.

### Interface

CLI

---

## Itération 2

### Données du jeu

- Argent : 1, 5, 10, 20, 50, 100, 500
- Plateau : Ajout des noms de rue, groupe de couleurs et propriétés
  - Couleurs : marron, bleu ciel, magenta, orange, rouge, jaune, vert, bleu

### Règle

A chaque début de partie un montant fixé à 1500$ répartis de la façon suivante :

- 5 \* 1$
- 1 \* 5$
- 2 \* 10$
- 1 \* 20$
- 1 \* 50$
- 4 \* 100$
- 2 \* 500$

Le joueur peut acheter des propriétés après avoir fait un tour de plateau.
La partie s'arrête lorsque toutes les propriétés sont vendus.

---

## Itération 3

### Données du jeu

- Plateau : Type de cases : Propriété, gares, companies, chance, communauté
- Cartes : Chance & Communauté

### Règle

Les cartes chances et communautés peuvent être tirés par les joueurs qui sont tombés sur une des cases prévus à cette effet sur le plateau.

---

## Itération 4

### Données du jeu

- Ajout des maisons et hôtels dans les propriétés

### Règle

Les joueurs peuvent acheter des maisons et des hôtels pour augmenter le loyer des propriétés.

---