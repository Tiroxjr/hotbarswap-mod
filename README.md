# Hotbar Swap Mod — NeoForge 1.21.11

Ce mod ajoute une touche qui échange la hotbar avec la dernière rangée de l'inventaire.

**Bonne nouvelle :** tu n'as besoin ni du jeu, ni de Java installé sur ton PC. Tout se
compile en ligne via GitHub Actions (gratuit). Tu n'as qu'à récupérer le fichier `.jar`
final et l'envoyer à ton pote.

---

## Étape 1 — Récupérer le MDK officiel (une seule fois)

1. Va sur https://neoforged.net/ → *Download* → télécharge le **MDK** pour
   Minecraft **1.21.11** / NeoForge **21.11.x** (c'est juste un zip, pas besoin de
   l'installer, juste de le télécharger et le décompresser).
2. Décompresse-le dans un dossier, par exemple `mon-mod/`.

## Étape 2 — Fusionner avec ce zip

1. Décompresse **ce zip** (`hotbarswap-mod.zip`).
2. Copie tout son contenu (`src/`, `.github/`, `README.md`) **par-dessus** le dossier
   `mon-mod/` du MDK, en remplaçant les fichiers d'exemple qui portent le même nom.
3. Tu dois maintenant avoir un dossier `mon-mod/` qui contient à la fois les fichiers du
   MDK (`build.gradle`, `gradlew`, `gradle/`, `settings.gradle`, etc.) ET nos fichiers
   (`src/main/java/...`, `.github/workflows/build.yml`).

## Étape 3 — Mettre ça sur GitHub

1. Crée un compte gratuit sur https://github.com si tu n'en as pas.
2. Clique sur **New repository** (bouton vert), donne-lui un nom (ex: `hotbarswap-mod`),
   laisse-le en *Public* ou *Private* (les deux marchent), ne coche aucune case
   d'initialisation, clique **Create repository**.
3. Sur la page qui s'affiche, utilise le lien **"uploading an existing file"**
   (ou glisse-dépose directement le contenu du dossier `mon-mod/` dans la zone prévue
   sur la page GitHub). Envoie tous les fichiers du dossier.
4. Valide l'envoi (**Commit changes**).

## Étape 4 — Récupérer le fichier compilé

1. Sur ton dépôt GitHub, va dans l'onglet **Actions** (en haut de la page).
2. Tu verras une exécution en cours (ou terminée) nommée *Build Mod*. Clique dessus.
   Ça prend en général 2 à 5 minutes.
3. Une fois que c'est vert (terminé avec succès), descends en bas de la page : tu verras
   un fichier téléchargeable nommé **`hotbarswap-mod-jar`**. Télécharge-le, dézippe-le :
   à l'intérieur se trouve le vrai fichier `.jar` du mod.

⚠️ Si l'exécution est rouge (échec), clique dessus pour voir le message d'erreur — le
plus souvent ça vient d'une étape mal copiée à l'Étape 2, ou d'un renommage de classe
propre à 1.21.11 qui aurait changé depuis (voir la note en bas de ce fichier).

## Étape 5 — Envoyer le jeu à ton pote

Envoie-lui uniquement le fichier `.jar` récupéré à l'étape 4 (pas besoin du reste).
Explique-lui :

- Installer **NeoForge 21.11** pour Minecraft **1.21.11** (installeur officiel sur
  https://neoforged.net/).
- Lancer une fois Minecraft avec le profil NeoForge pour que le dossier `mods` se crée.
- Fermer le jeu, mettre le `.jar` dans le dossier `mods` :
  - Windows : `%appdata%/.minecraft/mods`
  - Mac/Linux : `~/.minecraft/mods`
- Relancer avec le profil NeoForge. La touche **R** (par défaut) échange la hotbar avec
  la rangée juste au-dessus. Modifiable dans *Options > Contrôles > Touches >
  Hotbar Swap Mod*.

---

## Rappel rapide sur ce que fait le mod

- Touche par défaut : **R**
- Échange les 9 slots de la hotbar avec les 9 slots de la rangée d'inventaire juste
  au-dessus (indices 27 à 35).
- Pour échanger avec la toute première rangée du haut à la place : dans
  `src/main/java/com/example/hotbarswap/network/NetworkHandler.java`, change
  `ROW_START = 27` en `ROW_START = 9`.

## Note technique

Le code utilise `Identifier` (et non `ResourceLocation`), qui est le nom officiel
depuis NeoForge 21.11 / Minecraft 1.21.11. Si NeoForge sort une nouvelle version entre
temps avec d'autres renommages, il faudra peut-être ajuster deux-trois noms de classes
— le message d'erreur dans l'onglet Actions de GitHub indiquera précisément où.
