package pizzeria;
import java.util.*;
import java.io.*;

public class Tp3Gr20 {

    public static void main(String[] args) {
        Pizza[] pTraitees = new Pizza[10];
        Pizza[] pEnCours = new Pizza[10];
        Pizza[] pLivrees = new Pizza[10];
        int choice = 0;
        welcome();
        do {
            choice = choisirOptionMenu();
            switch (choice) {
                case 1:
                    afficherOptionCourante("Commande de Pizza");
                    ajouterPizza(pTraitees,
                        nouvellePizza(Pizza.CROUTE_DEFAUT, Pizza.VIANDE_DEFAUT,
                            Pizza.GRANDEUR_DEFAUT, Pizza.GARNITURE_DEFAUT,
                            Pizza.EXTRA_DEFAUT, Pizza.EXTRA_DEFAUT,
                            "Pizza cree avec succes", null
                            )
                        );
                    break;
                case 2:
                    afficherOptionCourante("Commandes en Cours de Traitement");
                    afficherTableauPizza(pTraitees, "Il n'y pas de commande en traitement");
                    break;
                case 3:
                    afficherOptionCourante("Modification de pizza");
                    modifierPizza(pTraitees);
                    break;
                case 4:
                    afficherOptionCourante("Envoi de commande a la livraison");
                    transposer(pTraitees, pEnCours, "traitement", "Il n'y pas de commande en traitement");
                    break;
                case 5:
                    afficherOptionCourante("Commandes En Cours de Livraison");
                    afficherTableauPizza(pEnCours, "Il n'y a pas de commande en cours de livraison.");
                    break;
                case 6:
                    afficherOptionCourante("Confirmation de livraison");
                    transposer(pEnCours, pLivrees, "cours de livraison", "Il n'y pas de commande en cours de livraison");
                    break;
                case 7:
                    afficherOptionCourante("Commandes Livrees");
                    afficherTableauPizza(pLivrees, "Il n'y a pas de commande livree.");
                    break;
                default:
                    break;
            }
            System.out.println("=====================================================================");
        } while (choice != 8);
        System.out.println("FIN NORMALE DU PROGRAMME\n");
        saveAndExit(pTraitees, pEnCours, pLivrees);
    }


    // Methodes obligatoires
    public static Pizza obtenirPizza(Pizza[] tab, int no) {
        Pizza value = null;
        for (Pizza piz: tab) {
            if (piz != null) {
                int id = piz.getId();
                if (no == id)
                    value = piz;
            }
        }
        return value;
    }

    public static void afficherTableauPizza(Pizza[] tab, String msgTabVide) {
        int nbAffiche = 0; //Compteurs d'occurences affichés
        if (tab == null || tab.length == 0) {
            System.out.println( "\t|" + msgTabVide);
        }
        else {
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] != null) {
                    nbAffiche = nbAffiche + 1;
                    String desc = tab[i].toString();
                    System.out.println(desc);
                    System.out.println(
                    "\t|-------------------------------------------------\n");
                    //Affichage limité à 2
                    if (nbAffiche % 2 == 0 && i != tab.length - 1)
                    {
                        System.out.print("\t|Appuyer Entree pour continuer...");
                        Clavier.lireFinLigne();
                    }
                }
            }
            if (nbAffiche == 0) {
                System.out.println( "\t|" + msgTabVide);
            }
        }
    }

    public static Pizza[] augmenterTailleTableau(Pizza[] tab) {
        if (tab == null || tab.length == 0) {
            return new Pizza[5];
        }
        else {
            Pizza[] newTab = new Pizza[tab.length + 5];
            for (int i = 0; i < tab.length; i++)
            {
                newTab[i] = tab[i];
            }
            return newTab;
        }
    }

    // Methodes ajoutees
    public static void welcome() {
        System.out.println("      _______ ");
        System.out.println(
        " ____|__   __|_______                     ___        ___ __________");
        System.out.println(
        "|  ___  | |  |_____  |                   |   \\      /   |   _______|");
        System.out.println(
        "| |___| | |       / /                    |    \\____/    |  |");
        System.out.println(
        "| ______| |      / /       /__________\\  |   \\______/   " +
            "|  |  _____");
        System.out.println(
        "| |   __| |__   / /        \\          /  |  |        |  |  | " +
            "|__   |");
        System.out.println(
        "|_|  |_______| / /_______                |  |        |  |  |____|  |");
        System.out.println(
        "              |__________|               |__|        |__|__________|");
        System.out.println(" __   __");
        System.out.println("| |  / /");
        System.out.println("| | / /");
        System.out.println("| |/ /_");
        System.out.println("|___/|_| BETA(1.0.0)");
        System.out.println("======================================" +
            "===============================");
    }

    public static int choisirOptionMenu() {
        int value = 0;
        boolean arreter = false;
        System.out.println("MENU PRINCIPAL\n");
        System.out.println("1 - Commander une pizza");
        System.out.println("2 - Afficher les commandes en cours de traitements");
        System.out.println("3 - Modifier une pizza (commande en cours de traitement seulement)");
        System.out.println("4 - Envoyer une commande a la livraison");
        System.out.println("5 - Afficher les livraisons en cours");
        System.out.println("6 - Confirmer une livraison");
        System.out.println("7 - Afficher les pizzas qui ont ete livrees");
        System.out.println("8 - Quitter le programme");
        System.out.println("[Choisissez le chiffre correspondant a l'operation a effectuer]");
        do {
            try {
                System.out.print("[Option]>>> ");
                value = Clavier.lireInt();
                if (value >= 1 && value <= 8)
                arreter = true;
                else
                System.out.println("![La valeur doit etre en 1 et 8]");
            }
            catch (NumberFormatException e) {
                System.out.println("![Entree incorrecte! Veuillez reessayer.]");
            }
        } while(!arreter);
        return value;
    }

    public static int choisirOptionSousMenu(int min, int max) {
        int choice = -1;
        do {
            try {
                System.out.print("\t|[Choix]>>> ");
                choice = Clavier.lireInt();
                if (!(min <= choice && choice <= max)) {
                    System.out
                    .println("\t|![La valeur doit etre entre " + min
                        + " et " + max + "]");
                }
            }
            catch (NumberFormatException e) {
                System.out
                .println("\t|![Entree incorrecte! Veuillez reessayer.]");
            }
        } while (!(min <= choice && choice <= max));
        return choice;
    }

    public static void afficherOptionCourante(String option) {
        System.out
        .println("_________________________________________________\n");
        System.out.println(option);
        System.out
        .println("_________________________________________________\n");
    }

    public static boolean confirmer() {
        Character reponse;
        boolean rep = false;
        do {
            System.out.print("\t|[Confirmer (O/o) -> oui | (N/n) -> non]");
            reponse = Clavier.lireChar();
            if (reponse != 'O' && reponse != 'o' &&
                    reponse != 'N' && reponse != 'n') {
                System.out.println("\t|![La valeur doit etre O/o/N/n]");
            }
        } while (reponse != 'O' && reponse != 'o' &&
            reponse != 'N' && reponse != 'n');
        if (reponse == 'O' || reponse == 'o')
            rep = true;
        else if (reponse == 'N' || reponse == 'n')
            rep = false;
        return rep;
    }

    public static void afficherDescPizza(int croute, int viande, int grandeur,
            int garniture, int eV, int eG) {
        String description = "";
        description += "\t|Croute ==> " + Pizza.croute(croute) +
            '(' + croute + ')' + '\n';
        description += "\t|Viande ==> " + Pizza.viande(viande) +
            '(' + viande + ')' + '\n';
        description += "\t|Grandeur ==> " + Pizza.grandeur(grandeur) +
            '(' + grandeur + ')' + '\n';
        description += "\t|Garniture ==> " + Pizza.garniture(garniture) +
            '(' + garniture + ')' + '\n';
        description += "\t|Extra-viande ==> " + Pizza.viande(eV) +
            '(' + eV + ')' + '\n';
        description += "\t|Extra-garniture ==> " +
            Pizza.garniture(eG) + '(' + eG + ')' + '\n';
        System.out.println(description);
    }

    public static void ajouterPizza(Pizza[] tab, Pizza piz) {
        int index = indexFin(tab);
        if (index < tab.length) {
            tab[index] = piz;
        }
        else {
            tab = augmenterTailleTableau(tab);
            tab[index] = piz;
        }
    }

    public static void modifierPizza(Pizza[] tab) {
        int n = -1, index;
        Pizza elt, nvo;
        if (estVide(tab)) {
            System.out.println("\t|Il n'y pas de commande en traitement a modifier");
        }
        else {
            System.out.println("\t|Voici les commandes en traitement");
            System.out.println("\t|[Entrez l'id de la pizza corrrespondante]");
            afficherTableauPizza(tab,
                "\t|Il n'y pas de commande en traitement a modifier"
            );
            do {
                try {
                    System.out.print("\t|[Id]>>> ");
                    n = Clavier.lireInt();
                    if (obtenirPizza(tab, n) == null) {
                        System.out.println("![Aucun id ne correspond]");
                    }
                }
                catch (NumberFormatException e) {
                    System.out
                    .println("![Entree incorrecte! Veuillez reessayer.]");
                }
            }while(obtenirPizza(tab, n) == null);
            index = obtenirIndexPizza(tab, n);
            elt = tab[index];
            elt = nouvellePizza(
                elt.getCroute(),
                elt.getViande(),
                elt.getGrandeur(),
                elt.getGarniture(),
                elt.getExtraViande(),
                elt.getExtraGarniture(),
                " Pizza modifiee avec succes",
                elt
            );
        }
    }

    public static Pizza nouvellePizza(int crouteDefaut, int viandeDefaut,
            int grandeurDefaut, int garnitureDefaut, int extraViande,
            int extraGarniture, String desc, Pizza pizzaInitial) {
        int croute, viande, grandeur, garniture, eV, eG;
        Pizza piz = null;
        boolean confirme;
        System.out.println("\t* Choix de croute");
        for(int i = Pizza.MIN_CROUTE; i <= Pizza.MAX_CROUTE; i++) {
            if (i == crouteDefaut)
                System.out.println("\t|" + i + " -> " + Pizza.croute(i) + "[Valeur par defaut]");
            else
                System.out.println("\t|" + i + " -> " + Pizza.croute(i));
        }
        croute = choisirOptionSousMenu(Pizza.MIN_CROUTE, Pizza.MAX_CROUTE);
        System.out.println("\t===========================================" +
            "==================");
        System.out.println("\t* Choix de viande");
        for(int i = Pizza.MIN_VIANDE; i <= Pizza.MAX_VIANDE; i++) {
            if (i == viandeDefaut)
                System.out.println("\t|" + i + " -> " + Pizza.viande(i) + "[Valeur par defaut]");
            else
                System.out.println("\t|" + i + " -> " + Pizza.viande(i));
        }
        viande = choisirOptionSousMenu(Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        System.out.println("\t===========================================" +
            "==================");
        System.out.println("\t* Choix de garniture");
        for(int i = Pizza.MIN_GARN; i <= Pizza.MAX_GARN; i++) {
            if (i == garnitureDefaut)
                System.out.println("\t|" + i + " -> " + Pizza.garniture(i) + "[Valeur par defaut]");
            else
                System.out.println("\t|" + i + " -> " + Pizza.garniture(i));
        }
        garniture = choisirOptionSousMenu(Pizza.MIN_GARN, Pizza.MAX_GARN);
        System.out.println("\t==========================================" +
            "===================");
        System.out.println("\t* Choix de grandeur");
        for(int i = Pizza.MIN_GRANDEUR; i <= Pizza.MAX_GRANDEUR; i++) {
            if (i == grandeurDefaut)
                System.out.println("\t|" + i + " -> " + Pizza.grandeur(i) + "[Valeur par defaut]");
            else
                System.out.println("\t|" + i + " -> " + Pizza.grandeur(i));
        }
        grandeur = choisirOptionSousMenu(Pizza.MIN_GRANDEUR,
            Pizza.MAX_GRANDEUR);
        System.out.println("\t=========================================" +
            "====================");
        System.out.println("\t* Choix de extraViande");
        for(int i = Pizza.MIN_VIANDE; i <= Pizza.MAX_VIANDE; i++) {
            if (i == viandeDefaut)
                System.out.println("\t|" + i + " -> " + Pizza.viande(i) + "[Valeur par defaut]");
            else
                System.out.println("\t|" + i + " -> " + Pizza.viande(i));
        }
        eV = choisirOptionSousMenu(Pizza.MIN_VIANDE, Pizza.MAX_VIANDE);
        System.out.println("\t=======================================" +
            "======================");
        System.out.println("\t* Choix de extraGarniture");
        for(int i = Pizza.MIN_GARN; i <= Pizza.MAX_GARN; i++) {
            if (i == garnitureDefaut)
                System.out.println("\t|" + i + " -> " + Pizza.garniture(i) + "[Valeur par defaut]");
            else
                System.out.println("\t|" + i + " -> " + Pizza.garniture(i));
        }
        eG = choisirOptionSousMenu(Pizza.MIN_GARN, Pizza.MAX_GARN);
        System.out.println("\t=======================================" +
            "======================");
        System.out.println("\t|Le resultat obtenu sera le suivant.");
        afficherDescPizza(croute, viande, grandeur, garniture, eV, eG);
        confirme = confirmer();
        if (confirme) {
            if (pizzaInitial == null) {
                piz = new Pizza(viande, garniture, grandeur, croute, eV, eG);
            }
            else {
                pizzaInitial.setCroute(croute);
                pizzaInitial.setViande(viande);
                pizzaInitial.setGrandeur(grandeur);
                pizzaInitial.setGarniture(garniture);
                pizzaInitial.setExtraViande(eV);
                pizzaInitial.setExtraGarniture(eG);
                piz = pizzaInitial;

            }
            System.out.println("\t|[Operation effectuee]");
        }
        else {
            System.out.println("\t|[Operation annulee]");
        }
        return piz;

    }


    public static void transposer(Pizza[] tabInitial, Pizza[] tabFinal,
            String desc, String fallback)  {
        int indexSuivant, indexDepart, n = 0;
        boolean confirme;
        if (estVide(tabInitial)) {
            System.out
            .println("\t|Il n'y pas de commande en" + desc +
                "a envoyer en livraison"
            );
        }
        else {
            System.out.println("\t|Voici les commandes en " + desc);
            System.out.println("\t|[Entrez l'id de la pizza corrrespondante]");
            afficherTableauPizza(tabInitial, fallback);
            do {
                try {
                    System.out.print("\t|[Id]>>> ");
                    n = Clavier.lireInt();
                    if (obtenirPizza(tabInitial, n) == null) {
                        System.out.println("\t|![Aucun id ne correspond]");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("\t|![Entree incorrecte! Veuillez reessayer.]");
                }
            }while(obtenirPizza(tabInitial, n) == null);
            confirme = confirmer();
            if (confirme) {
                indexSuivant = indexFin(tabFinal);
                //Ajout au tableau de destination
                if (indexSuivant < tabFinal.length) {
                    tabFinal[indexSuivant] = obtenirPizza(tabInitial, n);
                }
                else {
                    tabFinal = augmenterTailleTableau(tabFinal);
                    tabFinal[indexSuivant] = obtenirPizza(tabInitial, n);
                }
                //Suppression du tableau d'origine
                indexDepart = obtenirIndexPizza(tabInitial, n);
                for (int i = indexDepart; i < indexFin(tabInitial) - 1; i++) {
                    tabInitial[i] = tabInitial[i + 1];
                }
                tabInitial[indexFin(tabInitial) - 1] = null;
                System.out.println("\t|[Operation effectuee]");
            }
            else {
                System.out.println("\t|[Operation annulee]");
            }

        }
    }

    public static boolean estVide(Pizza[] tab) {
        boolean estVide = true;
        for (Pizza piz: tab) {
            if (piz != null) {
                estVide = false;
            }
        }
        return estVide;
    }

    public static int indexFin(Pizza[] tab) {
        boolean trouve = false; //Limitation a la premiere occurence
        int index = tab.length;
        for(int i = 0; (i < tab.length && !trouve); i++) {
            if (tab[i] == null) {
                trouve = true;
                index = i;
            }
        }
        return index;
    }

    //Obtenir l'index d'un elt a partir de son id
    public static int obtenirIndexPizza(Pizza[] tab, int no) {
        boolean trouve = false; //Limiter la recherche a la premiere occurence
        int value = -1;
        for (int i = 0; (i < tab.length && !trouve); i++) {
            if (tab[i] != null) {
                int id = tab[i].getId();
                if (no == id) {
                    value = i;
                    trouve = true;
                }
            }
        }
        return value;
    }

    public static void saveAndExit(Pizza[] pTraitees, Pizza[] pEnCours,
            Pizza[] pLivrees) {
        try {
            // On verifie si les fichiers de sauvegarde existent,
            // sinon, on les crée.
            File enTraitement = new File("CommandesEnTraitement.txt");
            if (!enTraitement.exists())
                enTraitement.createNewFile();
            File enCours = new File("CommandesEnCoursDeLivraison.txt");
            if (!enCours.exists())
                enCours.createNewFile();
            File livrees = new File("CommandesLivrees.txt");
            if (!livrees.exists())
                livrees.createNewFile();

            //Ecriture dans les fichiers
            FileWriter wEnTraitement = new
                FileWriter("CommandesEnTraitement.txt");
            FileWriter wEnCours = new
                FileWriter("CommandesEnCoursDeLivraison.txt");
            FileWriter wLivrees = new FileWriter("CommandesLivrees.txt");

            //CommandesEnTraitement.txt
            if (pTraitees.length == 0)
                wEnTraitement.write(
                    "Il n'y a pas de commande en traitement.\n"
                );
            else
                for (Pizza piz: pTraitees)
                {
                    if (piz != null) {
                        String desc = piz.toString();
                        wEnTraitement.write(desc);
                        wEnTraitement.write(
                            "=============================================\n"
                        );
                    }
                }

            //CommandesEnCoursDeLivraison.txt
            if (pEnCours.length == 0)
                wEnCours.write(
                    "Il n'y a pas de commande en cours de livraison.\n"
                );
            else
                for (Pizza piz: pEnCours)
                {
                    if (piz != null) {
                        String desc = piz.toString();
                        wEnCours.write(desc);
                        wEnCours.write(
                            "=============================================\n"
                        );
                    }
                }

            //CommandesLivrees.txt
            if (pLivrees.length == 0)
                wLivrees.write("Il n'y a pas de commande livree.\n");
            else
                for (Pizza piz: pLivrees)
                {
                    if (piz != null) {
                        String desc = piz.toString();
                        wLivrees.write(desc);
                        wLivrees.write(
                        "=============================================\n"
                        );
                    }
                }

            //Fermeture des fichiers
            wEnTraitement.close();
            wEnCours.close();
            wLivrees.close();

        }
        catch(IOException e) {
            System.out.println("Une erreur est survenue:");
            e.printStackTrace();
        }
    }
}
