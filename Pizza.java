package pizzeria;
    /**
     * I N F 1 1 2 0
     *
     * Classe servant a faire des pizzas.
     *
     * Les informations a conserver sur une pizza sont les suivantes:
     *
     * Le type de viande, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (pepperoni), 2 (bacon), 3 (jambon),
     *                               4 (viande fumee),  5 (poulet), 6 (saucisses italiennes).
     *                               La valeur par defaut est 1.
     *
     * Le type de garniture, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (champignons), 2 (piments), 3 (oignons), 4 (olives),
     *                               5 (ananas).  La valeur par defaut est 2.
     *
     * La grandeur, un entier.
     * Les valeurs possibles sont�:  0  (Extra petite), 1 (Petite), 2 (Moyenne), 3 (Grande),
     *                               4 (Jumbo). La valeur par defaut est 2.
     *
     * Un extra de viande, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (pepperoni), 2 (bacon), 3 (jambon), 4 (viande fumee),
     *                               5 (poulet), 6 (saucisses italiennes). La valeur par defaut est 0.
     *
     * Une garniture en extra, un entier.
     * Les valeurs possibles sont�:  0 (Aucune), 1 (champignons), 2 (piments), 3 (oignons), 4 (olives),
     *                               5 (ananas).   La valeur par defaut est 0.
     *
     * Un type de cro�te, un entier.
     * Les valeurs possibles sont�:  0 (Ordinaire), 1 (Mince), 2 (Trois Cereales), 3 (Epaisse), 4 (Fromage).
     *                               La valeur par defaut est 0.
     *
     * Un numero d�identification distinct (nombre entier positif).
     * Les numeros debutent a 1 et sont consecutifs. Chaque pizza a un numero DIFFERENT qui lui est propre.
     * Les numeros sont generes automatiquement par la classe Pizza.
     *
     */

    public class Pizza {


        //Constantes de classe privees
        private static final String [] GARNITURES = {"Aucune", "champignons", "piments", "oignons", "olives", "ananas"};
        private static final String [] VIANDES = {"Aucune", "pepperoni", "bacon", "jambon", "viande fumee", "poulet", "saucisses italiennes"};
        private static final String [] GRANDEURS = {"Extra petite", "Petite", "Moyenne", "Grande", "Jumbo"};
        private static final String [] CROUTES = {"Ordinaire", "Mince", "Trois Cereales", "Epaisse", "Fromage"};


        //Constantes de classe publiques
        public static final int VIANDE_DEFAUT = 1;
        public static final int GARNITURE_DEFAUT = 2;
        public static final int EXTRA_DEFAUT = 0;
        public static final int GRANDEUR_DEFAUT = 2;
        public static final int CROUTE_DEFAUT = 0;

        public static final int MIN_GARN = 0;
        public static final int MAX_GARN = GARNITURES.length - 1;
        public static final int MIN_VIANDE = 0;
        public static final int MAX_VIANDE = VIANDES.length - 1;
        public static final int MIN_GRANDEUR = 0;
        public static final int MAX_GRANDEUR = GRANDEURS.length - 1;
        public static final int MIN_CROUTE = 0;
        public static final int MAX_CROUTE = CROUTES.length - 1;


        //Methodes de classe

        ////////////////////////////////////////////////////////////////////////////
        // Retourne la chaine de caractere corrrespondant au numero de garniture
        // recu en parametre. Si le no ne correspond pas a une garniture existante,
        // la methode retourne la chaine vide.
        ////////////////////////////////////////////////////////////////////////////

        public static String garniture (int no){
            return (MIN_GARN <= no && no <= MAX_GARN) ? GARNITURES[no] : "";
        }


        /////////////////////////////////////////////////////////////////////////
        // Retourne la chaine de caractere corrrespondant au numero de viande
        // recu en parametre. Si le no ne correspond pas a une viande existante,
        // la methode retourne la chaine vide.
        /////////////////////////////////////////////////////////////////////////
        public static String viande (int no){

            return (MIN_VIANDE <= no && no <= MAX_VIANDE) ? VIANDES[no] : "";
        }


        //////////////////////////////////////////////////////////////////////////
        // Retourne la chaine de caractere corrrespondant au numero de grandeur
        // recu en parametre. Si le no ne correspond pas a une grandeur existante,
        // la methode retourne la chaine vide.
        //////////////////////////////////////////////////////////////////////////
        public static String grandeur (int no){

            return (MIN_GRANDEUR <= no && no <= MAX_GRANDEUR) ? GRANDEURS[no] : "";
        }



        ////////////////////////////////////////////////////////////////////////
        // Retourne la chaine de caractere corrrespondant au numero de croute
        // recu en parametre. Si le no ne correspond pas a une croute existante,
        // la methode retourne la chaine vide.
        ////////////////////////////////////////////////////////////////////////
        public static String croute (int no){

            return (MIN_CROUTE <= no && no <= MAX_CROUTE) ? CROUTES[no] : "";
        }


        /////////////////
        /////////////////
        //CONSTRUCTEURS//
        /////////////////
        /////////////////

        //////////////////////////////////////////////////////////////////
        //Le mot clé `this` là où il peut avoir des
        //ambigutïteś dues aux noms de variables identiques
        //////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////
        // Cree une pizza avec tous les attributs aux valeurs par defaut
        /////////////////////////////////////////////////////////////////
        public Pizza(){
            croute = CROUTE_DEFAUT;
            viande = VIANDE_DEFAUT;
            grandeur = GRANDEUR_DEFAUT;
            garniture = GARNITURE_DEFAUT;
            extraViande = extraGarniture = EXTRA_DEFAUT;
            id = idOffset;
            idOffset = idOffset + 1;
        }


        /////////////////////////////////////////////////////////////////
        // Cree une pizza avec AUCUN extra et les informations en
        // parametre.
        // Lorsqu'un parametre est invalide, l'attribut correspondant est
        // mis a la valeur par defaut.
        /////////////////////////////////////////////////////////////////
        public Pizza(int viande, int garniture, int grandeur, int croute){
            this.croute = (MIN_CROUTE <= croute && croute <= MAX_CROUTE) ? croute : CROUTE_DEFAUT;
            viande = (MIN_VIANDE <= viande && viande <= MAX_VIANDE) ? viande : VIANDE_DEFAUT;
            this.grandeur = (MIN_GRANDEUR <= grandeur && grandeur <= MAX_GRANDEUR) ? grandeur : GRANDEUR_DEFAUT;
            this.garniture = (MIN_GARN <= garniture && garniture <= MAX_GARN) ? garniture : GARNITURE_DEFAUT;
            this.extraViande = this.extraGarniture = EXTRA_DEFAUT;
            id = idOffset;
            idOffset = idOffset + 1;


        }


        /////////////////////////////////////////////////////////////////
        // Cree une pizza avec les informations en parametre.
        // Lorsqu'un parametre est invalide, l'attribut correspondant est
        // mis a la valeur par defaut.
        /////////////////////////////////////////////////////////////////
        public Pizza(int viande, int garniture, int grandeur, int croute, int extraViande, int extraGarniture){
            this.croute = (MIN_CROUTE <= croute && croute <= MAX_CROUTE) ? croute : CROUTE_DEFAUT;
            this.viande = (MIN_VIANDE <= viande && viande <= MAX_VIANDE) ? viande : VIANDE_DEFAUT;
            this.grandeur = (MIN_GRANDEUR <= grandeur && grandeur <= MAX_GRANDEUR) ? grandeur : GRANDEUR_DEFAUT;
            this.garniture = (MIN_GARN <= garniture && garniture <= MAX_GARN) ? garniture : GARNITURE_DEFAUT;
            this.extraViande = (MIN_VIANDE <= viande && viande <= MAX_VIANDE) ? extraViande : EXTRA_DEFAUT;
            this.extraGarniture = (MIN_GARN <= garniture && garniture <= MAX_GARN) ? extraGarniture : EXTRA_DEFAUT;
            this.id = idOffset;
            idOffset = idOffset + 1;
        }



        /////////////////////////////
        //SEPT ACCESSEURS (GETTERS)//
        // a ajouter...            //
        /////////////////////////////
        public int getCroute(){ return croute; }

        public int getViande(){ return viande; }

        public int getGrandeur(){ return grandeur; }

        public int getGarniture(){ return garniture; }

        public int getExtraViande(){ return extraViande; }

        public int getExtraGarniture(){ return extraGarniture; }

        public int getId(){ return id; }


        ///////////////////////////
        //MODIFICATEURS (SETTERS)//
        ///////////////////////////


        //////////////////////////////////////////////////////
        //  Modifie la croute de la pizza.
        //  Si la valeur recu en parametre ne fait pas
        //  partie des valeurs permises, aucune modification
        //  n'est effectuee et aucun message d'erreur n'est
        //  affiche.
        //////////////////////////////////////////////////////

        public void setCroute(int c){
            croute = (MIN_CROUTE <= c && c <= MAX_CROUTE) ? c : croute;
        }


        //////////////////////////////////////////////////////
        //  Modifie la grandeur de la pizza.
        //  Si la valeur recu en parametre ne fait pas
        //  partie des valeurs permises, aucune modification
        //  n'est effectuee et aucun message d'erreur n'est
        //  affiche.
        //////////////////////////////////////////////////////
        public void setGrandeur(int g){
            grandeur = (MIN_GRANDEUR <= g && g <= MAX_GRANDEUR) ? g : grandeur;
        }


        //////////////////////////////////////////////////////
        //  Modifie la viande de la pizza.
        //  Si la valeur recu en parametre ne fait pas
        //  partie des valeurs permises, aucune modification
        //  n'est effectuee et aucun message d'erreur n'est
        //  affiche.
        //////////////////////////////////////////////////////
        public void setViande(int v){
            viande = (MIN_VIANDE <= v && v <= MAX_VIANDE) ? v : viande;
        }


        //////////////////////////////////////////////////////
        //  Modifie la garniture de la pizza.
        //  Si la valeur recu en parametre ne fait pas
        //  partie des valeurs permises, aucune modification
        //  n'est effectuee et aucun message d'erreur n'est
        //  affiche.
        //////////////////////////////////////////////////////
        public void setGarniture(int g){
            garniture = (MIN_GARN <= g && g <= MAX_GARN) ? g : garniture;
        }

        //////////////////////////////////////////////////////
        //  Modifie la viande en extra de la pizza.
        //  Si la valeur recu en parametre ne fait pas
        //  partie des valeurs permises, aucune modification
        //  n'est effectuee et aucun message d'erreur n'est
        //  affiche.
        //////////////////////////////////////////////////////
        public void setExtraViande(int eV){
            extraViande = (MIN_VIANDE <= eV && eV <= MAX_VIANDE) ? eV : extraViande;
        }


        //////////////////////////////////////////////////////
        //  Modifie la garniture en extra de la pizza.
        //  Si la valeur recu en parametre ne fait pas
        //  partie des valeurs permises, aucune modification
        //  n'est effectuee et aucun message d'erreur n'est
        //  affiche.
        //////////////////////////////////////////////////////
        public void setExtraGarniture(int eG){
            extraGarniture = (MIN_GARN <= eG && eG <= MAX_GARN) ? eG : extraGarniture;
        }


        /////////////////////////////////////
        /// METHODE UTILITAIRE D'INSTANCE ///
        /////////////////////////////////////


        //////////////////////////////////////////////////////
        //  Retourne une chaine de caracteres contenant les
        //  caracteristiques de la pizza.
        //  Pour chacune des informations, on doit mettre une
        //  description de l'information, suivie de sa valeur.
        //  Chaque information doit �tre sur une ligne
        //  differente (utilisez \n la ou cela s'applique).
        //////////////////////////////////////////////////////
        public String toString(){
            String description = "";
            description += "Id ==> " + id + '\n';
            description += "Croute ==> " + CROUTES[croute] + '(' + croute + ')' + '\n';
            description += "Viande ==> " + VIANDES[viande] + '(' + viande + ')' + '\n';
            description += "Grandeur ==> " + GRANDEURS[grandeur] + '(' + grandeur + ')' + '\n';
            description += "Garniture ==> " + GARNITURES[garniture] + '(' + garniture + ')' + '\n';
            description += "Extra-viande ==> " + VIANDES[extraViande] + '(' + extraViande + ')' + '\n';
            description += "Extra-garniture ==> " + GARNITURES[extraGarniture] + '(' + extraGarniture + ')' + '\n';
            return description;

        }



        //Variable de CLASSE pour generer le numero de pizza
        //Pour usage INTERNE seulement.

        private static int idOffset = 1;



        //Variables d'instance
        private int croute;
        private int grandeur;
        private int viande;
        private int garniture;
        private int extraViande;
        private int extraGarniture;
        private int id; //identifiant fourni par la classe;


    } // Pizza
