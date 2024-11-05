# TP2 - : Compréhension des Programmes

## Objectifs
Vise à explorer et mesurer le couplage entre classes dans une application Java, à implémenter un algorithme de regroupement (clustering) pour identifier les modules, et à automatiser l'analyse du code en utilisant l'outil **Spoon**.

## Contenu

### Exercice 1 : Calcul du Couplage entre Classes
- **But** : Calculer une métrique de couplage entre classes et générer un graphe de couplage pondéré.
- **Détails** :
  - La métrique de couplage entre deux classes A et B est définie comme le rapport entre le nombre de relations d’appel entre les méthodes de A et B et le nombre total de relations binaires d’appel entre toutes les classes.
  - **Graphe de Couplage** : Chaque classe est représentée comme un nœud, et les arêtes entre les nœuds sont pondérées par le couplage calculé.

### Exercice 2 : Identification de Modules
- **But** : Implémenter un algorithme de regroupement hiérarchique pour identifier des modules de classes fortement couplées.
- **Détails** :
  - **Regroupement Hiérarchique** : Cet algorithme fusionne les classes les plus couplées en clusters, permettant de visualiser les relations de couplage sous forme de dendrogramme.
  - **Identification des Modules** : À partir du dendrogramme, des modules sont créés selon des contraintes spécifiques :
    - L'application ne doit pas comporter plus de \(M/2\) modules (où \(M\) est le nombre de classes).
    - Chaque module doit regrouper des classes appartenant à une seule branche du dendrogramme.
    - Le couplage moyen au sein d’un module doit dépasser un seuil défini \(CP\).

### Exercice 3 : Utilisation de Spoon
- **But** : Utiliser **Spoon**, un framework Java pour l'analyse statique de code, pour automatiser l'identification des relations d’appel et générer le graphe de couplage.
- **Détails** :
  - Spoon permet de construire le modèle abstrait d'une application Java, d'extraire les relations d’appel, et de faciliter le calcul des métriques de couplage pour les exercices précédents.

## Résultats
- **Graphe de Couplage Pondéré** : Généré pour visualiser le couplage entre classes.
- **Dendrogramme de Clustering** : Permet d’illustrer les regroupements hiérarchiques des classes.
- **Identification des Modules** : Modules identifiés respectant les contraintes définies, afin de faciliter la compréhension et la modularité de l’application.

## Prérequis
- **Java** : Le code d’analyse et de calcul est implémenté en Java.
- **Spoon** : Nécessaire pour l'extraction des relations d’appel (peut être installé via Maven).
- **LaTeX** : Utilisé pour la rédaction du rapport.

## Utilisation
1. **Exécuter le code d’analyse de couplage** pour générer la métrique de couplage entre classes.
2. **Exécuter le code de clustering** pour identifier les modules.
3. **Utiliser Spoon** pour automatiser la génération des données de couplage (Exercice 3).
4. **Compiler le rapport en LaTeX** avec les résultats et graphiques.

AZOUZE Ibrahim
