package projetrpg3000;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int z=0;
        String Nom;

        Scanner Sc = new Scanner(System.in);
        System.out.println("Choisissez le nombre de votre équipe entre 1 et 4");
        int NJ = Sc.nextInt();

        while (NJ <= 0 || NJ > 4) {
            System.out.println("entre 1 et 4");
            NJ = Sc.nextInt();
        }
        ArrayList<Hero> LPlayer = new ArrayList<>();


        Sc.nextLine();
        for (int i = 0; i < NJ; i++) {

            System.out.println("choisissez la classe de vos joueur");

            String ik = Sc.nextLine();


            switch (ik) {
                case "Warrior":
                    Warrior warrior = new Warrior(100, 1, 10,  "lol",false);
                    System.out.println("Choisisez le nom de votre HERO Warrior");
                    Nom = Sc.nextLine();
                    warrior.setNom(Nom);
                    LPlayer.add(warrior);
                    break;
                case "Hunter":
                    Hunter hunter = new Hunter(100, 1, 1, 10,  "lol",false);
                    System.out.println("Choisisez le nom de votre HERO Hunter");
                    Nom = Sc.nextLine();
                    hunter.setNom(Nom);
                    LPlayer.add(hunter);
                    break;
                case "Mage":
                    Mage mage = new Mage(100, 1, 10, 1, 10, "lol",false);
                    System.out.println("Choisisez le nom de votre HERO Mage");
                    Nom = Sc.nextLine();
                    mage.setNom(Nom);
                    LPlayer.add(mage);
                    break;
                case "Healer":
                    Healer healer = new Healer(100, 1, 10, 1, 10,  "lol",false);
                    System.out.println("Choisisez le nom de votre HERO Healer");
                    Nom = Sc.nextLine();
                    healer.setNom(Nom);
                    LPlayer.add(healer);
                    break;
                default:
                    System.out.println("Classe invalide");
                    i--;
                    break;
            }

        }

        System.out.println(LPlayer);
        ArrayList<Enemy> LEnemy = new ArrayList<>();
        Random rand = new Random();
        int t = rand.nextInt(2);
        System.out.println("t = "+t );
        for(int p=1;p<6;p++){      // nombre de partis 4
            Consumable Lembas= Food.creatLembas();
            Consumable potion = Potion.creatpotion();

            if (p>1){
                for (int k=0;k<LPlayer.size();k++){
                    System.out.println("Choisissez un joueur a améliorer");
                    String POP = Sc.nextLine();


                    int w = 0;
                    boolean boucled = true;
                    for (int r = 0; boucled && r < LPlayer.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
                        if (LPlayer.get(r).getNom().equals(POP)) {
                            boucled = false;
                            w = r;
                            break;
                        }
                    }
                    System.out.print("choissisez votre amélioration DEGATS /RESISTANCE/SPECIAL/ITEM");
                    for (int yy=0;yy<1;yy++){
                        String AM = Sc.nextLine();

                        switch (AM){
                            case"ITEM": // amélioration
                                potion.Addnombre();
                                Lembas.Addnombre();
                                break;
                            case"DEGATS":
                                LPlayer.get(w).degatsAm();
                                break;
                            case"RESISTANCE":
                                LPlayer.get(w).ressistanceam();
                            case"SPECIAL":
                                if (LPlayer.get(w) instanceof Hunter){
                                    System.out.println("Voulez vous augmenter le nombre de flèche ? OUI/NON");
                                    String th= Sc.nextLine();
                                    if (th.equals("OUI")){
                                        LPlayer.get(w).amélioration();
                                        break;
                                    }else {
                                        System.out.println("retour au choix des amélioration");
                                        yy--;break;}


                                }else if(LPlayer.get(w) instanceof Hunter || LPlayer.get(w)instanceof Healer){
                                    System.out.println("Vous voulez 'DIMINUER' le coût en mana ? DIMINUER/NON");
                                    String ty= Sc.nextLine();
                                    switch (ty){
                                        case"DIMINUER":
                                            LPlayer.get(w).amélioration();
                                            System.out.println("Vous avez diminuer le cout en mana de 2");
                                            break;

                                        default:
                                            System.out.println("Retour aux choix des améliorations");
                                            yy--;break;
                                    }

                                }else{
                                    System.out.println("Choisisez un hero de classe Warrior,Hunter ou Healer pour le choiw Spéciale ");
                                    yy--;break;
                                }
                            default:
                                System.out.println("reponse invalide retour aux choix de l'amélioration ");
                                yy--;break;}
                    }

                }
            }
            ///code pour les améliorations



            if (LEnemy.size() == 0){
                for (int i = 0; i < NJ; i++) {
                    CC_7567 enemy = new CC_7567(1, 1, 10);
                    LEnemy.add(enemy);
                }

            } else if (LPlayer.size()==0) {
                break;
            }
            System.out.println("partie numéro :"+p);

            while (LEnemy.size() != 0 && LPlayer.size() != 0) {                                                       //Vérifie si les joueurs sont tous bien en vie avec la taille des listes
                System.out.println("je rentre une fois "+LPlayer.size());
                for (Combatant combatant : LPlayer) {combatant.setFalsebolean();}

                for (int i = 0 ; i < LPlayer.size(); i++) {                                                   // évite de rejouer le meme personnage chaque tour donc force à jouer plusieurs personnages
                    System.out.println("i = "+i );

                    if (t==0){
                        for(int l=0; l<1;l++) {
                            System.out.println("choisit ton hero a utilser");
                            String lol;
                            lol = Sc.nextLine();


                            int y = 0;
                            boolean boucle = true;
                            for (int r = 0; boucle && r < LPlayer.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
                                if (LPlayer.get(r).getNom().equals(lol)) {
                                    boucle = false;
                                    y = r;
                                    break;
                                }
                            }
                            System.out.println("y = " + y);


                            if (!LPlayer.get(y).getNom().equals(lol)) {                                              //vérifie si le nom correspond bien avec les joueurs de la liste LPlayer
                                System.out.println("Vous n'avez pas de hero avec ce nom, retour au choix ");
                                l--;

                            } else {
                                if (!LPlayer.get(y).getbolean() && LPlayer.get(y).getVie() > 0) {
                                    System.out.println("Voulez vous attaquer ou vous Défendre ou manger ?");
                                    String R = Sc.nextLine();


                                    switch (R) {
                                        case "Attaquer":                                                                 //on choisit l'action


                                            if (LPlayer.get(y) instanceof Healer) {                                         //code Healer
                                                System.out.println("choisi ton personnage a soigner  ");
                                                String NH;
                                                NH = Sc.nextLine();

                                                int h;
                                                h = 0;
                                                boolean boucleh = true;
                                                for (int r = 0; boucleh && r < LPlayer.size(); r++) {                               //  compare le nom des joueurs avec le nom rentré dans la console pour trouver l'emplacement dans la liste
                                                    if (LPlayer.get(r).getNom().equals(NH)) {
                                                        boucleh = false;
                                                        h = r;
                                                        break;
                                                    }
                                                }
                                                if (!LPlayer.get(h).getNom().equals(NH)) {                                                      //vérifie si le nom correspond bien avec les joueurs de la liste LPlayer
                                                    System.out.println("Vous n'avez pas de hero avec ce nom, retour au choix ");
                                                    l--;                                                                                           //l-- permet de reboucler si la réponse est invalide
                                                } else {
                                                    if (LPlayer.get(h).soigner(LPlayer.get(y).attaque1())) {
                                                        System.out.println("Vous avez soigner " + LPlayer.get(h).getNom());
                                                        LPlayer.get(y).setruebolean();

                                                        t=1;
                                                        break;
                                                    } else {
                                                        System.out.println("Vous navez pas assez de magie");
                                                        l--;
                                                    }
                                                }
                                            } else {                                                                                                  //code pour les autres hero
                                                System.out.println("choisiser le numero de l'adeversair a attaquer entre 1 et " + LEnemy.size());

                                                int NE = Sc.nextInt();
                                                while (NE <= 0 || NE > LEnemy.size()) {
                                                    System.out.println("entre 1 et  " + NJ);
                                                    NE = Sc.nextInt();
                                                }
                                                Sc.nextLine();

                                                if (!LEnemy.get(NE - 1).moinVie(LPlayer.get(y).attaque1(), LEnemy.get(NE-1).getRessistance())) {                //La méthode moinvie() sort un boolean et enlève la vie des enemies

                                                    l--;
                                                    break;

                                                } else  {
                                                    LPlayer.get(y).setruebolean();
                                                    t=1;



                                                    if (LEnemy.get(NE - 1).getVie() <= 0) {                                                             //permet de réduire la taille de la liste de l'ennemie
                                                        System.out.println("Vous avez tuer un enemies ");
                                                        LEnemy.remove(NE - 1);


                                                        break;
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            }


                                        case "Défendre":
                                            LPlayer.get(y).defendre();
                                            LPlayer.get(y).setruebolean();
                                            t=1;


                                            break;
                                        case "Manger":
                                            System.out.println("Voulez vous manger un lembas ou boir une potion ");
                                            System.out.println("Le lenbas augmente un peut votre vie alors que la potion augmente grandement votre vie mais diminue votre resistance ");
                                            System.out.println("écrivez 'Manger' pour le Lembas ou 'Boir' pour la potion ");
                                            String choix2= Sc.nextLine();
                                            switch (choix2){
                                                case "Manger":

                                                    if(Lembas.getnombre()>0 &&LPlayer.get(y).nourriture(Lembas)){
                                                        t=1;
                                                        Lembas.moinnombre();
                                                        System.out.println("Vous avez"+Lembas.getnombre()+"Lembas");
                                                        LPlayer.get(y).setruebolean();}
                                                    else {
                                                        l--;

                                                        if (Lembas.getnombre()==0){
                                                            System.out.println("tu nas pas assez de Lembas");

                                                        }}

                                                    break;

                                                case"Boir":

                                                    if (potion.getnombre()>0 &&LPlayer.get(y).potion(potion)){

                                                        t=1;
                                                        potion.moinnombre();
                                                        LPlayer.get(y).setruebolean();}
                                                    else{l--;if(potion.getnombre()==0){
                                                        System.out.println("tu as plus de potion");
                                                    }}

                                                    break;
                                                default:
                                                    System.out.println("Action invalide retour au choix du hero");
                                                    l--;
                                                    break;
                                            }

                                            break;
                                        default:
                                            System.out.println("Réponse invalide, retour aux choix du Hero");
                                            l--;
                                            break;


                                    }
                                } else {
                                    if (LPlayer.get(y).getbolean()) {
                                        System.out.println("vous avez deja utiliser ce personnage");

                                        l--;
                                    } else if (LPlayer.get(y).getVie() <= 0) {
                                        l--;

                                    }
                                }


                            }
                        }
                    }else if (t==1 && LEnemy.size()!=0 && LPlayer.size()!=0){

                        if(z>=LEnemy.size()){z=0;}
                        int Ne = rand.nextInt(LPlayer.size());
                        System.out.println("rentre dans l'ennemie");
                        for(int e=0;e<1;e++){
                            if (LPlayer.get(Ne).moinVie(LEnemy.get(z).getDegats(),LPlayer.get(Ne).getRessistance())){
                                z++;t=0;i--;
                                if (LPlayer.get(Ne).getVie()<=0){
                                    System.out.println("le joueur "+LPlayer.get(Ne).getNom()+" est mort :(");
                                    LPlayer.remove(Ne);
                                    t=0;

                                }
                            } else{e--;}
                        }

                    }

                }
            }
        }if(LPlayer.size()>0){
            System.out.println("tu as gagner lol");

        }else if (LEnemy.size()>0){
            System.out.println("tu as perdu noob");
        }

        Sc.close();
    }
}

