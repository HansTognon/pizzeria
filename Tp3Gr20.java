package pizza;
import java.util.*;
import java.io.*;

public class Tp3Gr20 {
    public static Pizza[] pTraitees = new Pizza[3];
    public static Pizza[] pEnCours = new Pizza[2];
    public static Pizza[] pLivrees = new Pizza[0];
    public static Scanner stdIn = new Scanner(System.in);

    public static void main(String[] args) {
        welcome();
        pTraitees[0] = new Pizza(1,4,5,2);
        pEnCours[1] = new Pizza(1,2,3,4);
        pTraitees[1] = new Pizza();
        pTraitees[2] = new Pizza(1,3,4,2,3,4);
        pEnCours[0] = new Pizza();
        boolean no_stop = true;
        int choice = 0;
        Pizza n = new Pizza();
        System.out.println(n.toString());
        saveAndExit();
        pEnCours = new Pizza[0];
        pTraitees = new Pizza[pTraitees.length + 5];
        pTraitees[0] = new Pizza(1,4,5,2);
        pTraitees[6] = new Pizza(1,2,3,4);
        pTraitees[3] = new Pizza();
        pTraitees[2] = new Pizza(1,3,4,2,3,4);
        pTraitees[0] = new Pizza();
        saveAndExit();
        // do {
        //     choice = chooseOption();
        //     switch (choice) {
        //         case 1:
        //             // commander();
        //             break;
        //         case 2:
        //             afficher(2);
        //             break;
        //         case 3:
        //             // modifier();
        //             break;
        //         case 4:
        //             // livrerPizza();
        //             System.out.println("Great");
        //             break;
        //         case 5:
        //             afficher(5);
        //             break;
        //         case 6:
        //             //confirmerLivraison();
        //             break;
        //         case 7:
        //             afficher(7);
        //             break;
        //         case 8:
        //             saveAndExit();
        //             no_stop = false;
        //         default:
        //             break;
        //     }
        // } while (no_stop);
    }

    public static void welcome() {
        System.out.println("      _______ ");
        System.out.println(" ____|__   __|_______                     ___        ___ __________");
        System.out.println("|  ___  | |  |_____  |                   |   \\      /   |   _______|");
        System.out.println("| |___| | |       / /                    |    \\____/    |  |");
        System.out.println("| ______| |      / /       /__________\\  |   \\______/   |  |  _____");
        System.out.println("| |   __| |__   / /        \\          /  |  |        |  |  | |__   |");
        System.out.println("|_|  |_______| / /_______                |  |        |  |  |____|  |");
        System.out.println("              |__________|               |__|        |__|__________|");
        System.out.println(" __   __");
        System.out.println("| |  / /");
        System.out.println("| | / /");
        System.out.println("| |/ /_");
        System.out.println("|___/|_| BETA(1.0.0)");
        System.out.println("=====================================================================");
    }

    public static int chooseOption() {
        System.out.println("MENU PRINCIPAL\n");
        System.out.println("1 - Commander une pizza");
        System.out.println("2 - Afficher les commandes en cours de traitements");
        System.out.println("3 - Modifier une pizza (commande en cours de traitement seulement)");
        System.out.println("4 - Envoyer une commande a la livraison");
        System.out.println("5 - Afficher les livraisons en cours");
        System.out.println("6 - Confirmer une livraison");
        System.out.println("7 - Afficher les pizzas qui ont ete livrees");
        System.out.println("8 - Quitter le programme");
        System.out.print(">>>");
        int value = 0;
        value = stdIn.nextInt();
        return value;
    }

    public static void afficher(int n) {

    }

    public static void saveAndExit() {
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
            FileWriter wEnTraitement = new FileWriter("CommandesEnTraitement.txt");
            FileWriter wEnCours = new FileWriter("CommandesEnCoursDeLivraison.txt");
            FileWriter wLivrees = new FileWriter("CommandesLivrees.txt");

            //CommandesEnTraitement.txt
            if (pTraitees.length == 0)
                wEnTraitement.write("Il n'y a pas de commande en traitement.\n");
            else
                for (Pizza piz: pTraitees)
                {
                    if (piz != null) {
                        String desc = piz.toString();
                        wEnTraitement.write(desc);
                        wEnTraitement.write("=============================================\n");
                    }
                }

            //CommandesEnCoursDeLivraison.txt
            if (pEnCours.length == 0)
                wEnCours.write("Il n'y a pas de commande en cours de livraison.\n");
            else
                for (Pizza piz: pEnCours)
                {
                    if (piz != null) {
                        String desc = piz.toString();
                        wEnCours.write(desc);
                        wEnCours.write("=============================================\n");
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
                        wLivrees.write("=============================================\n");
                    }
                }

            //Fermeture des fichiers
            wEnTraitement.close();
            wEnCours.close();
            wLivrees.close();

        }
        catch(IOException e) {
            System.out.println("Exists");
        }
        System.out.println("FIN NORMALE DU PROGRAMME");
    }
}
