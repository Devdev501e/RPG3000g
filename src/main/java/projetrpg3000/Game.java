package projetrpg3000;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public Game() {
    }

    public int choiceperso() {

        System.out.println("Choisissez le nombre de votre équipe entre 1 et 4");
        int NJ;

        NJ = sc.nextInt();

        while (NJ <= 0 || NJ > 4) {
            System.out.println("entre 1 et 4");
            NJ = sc.nextInt();
            sc.nextLine();
        }
        sc.nextLine();
        return NJ;


    }

    public ArrayList<Combatant> JoueurClasse(int NJ) {
        String Nom;
        ArrayList<Combatant> LPlayer = new ArrayList<>();
        for (int i = 0; i < NJ; i++) {

            System.out.println("choisissez la classe de vos joueur");

            String ik = sc.nextLine();


            switch (ik) {
                case "Warrior":
                    Warrior warrior = new Warrior(100, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Warrior");
                    Nom = sc.nextLine();
                    warrior.setNom(Nom);
                    LPlayer.add(warrior);
                    break;
                case "Hunter":
                    Hunter hunter = new Hunter(100, 1, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Hunter");
                    Nom = sc.nextLine();
                    hunter.setNom(Nom);
                    LPlayer.add(hunter);
                    break;
                case "Mage":
                    Mage mage = new Mage(100, 1, 10, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Mage");
                    Nom = sc.nextLine();
                    mage.setNom(Nom);
                    LPlayer.add(mage);
                    break;
                case "Healer":
                    Healer healer = new Healer(100, 1, 10, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Healer");
                    Nom = sc.nextLine();
                    healer.setNom(Nom);
                    LPlayer.add(healer);
                    break;
                default:
                    System.out.println("Classe invalide");
                    i--;
                    break;
            }

        }
        return LPlayer;


    }

    public ArrayList<Combatant> Enemycréation(ArrayList<Combatant> Player, int P) {
        ArrayList<Combatant> Enemy = new ArrayList<>();
        if (P <= 4 && Player.size() != 0) {
            for (int i = 0; i < Player.size(); i++) {
                CC_7567 cc_7567 = new CC_7567(1, 1, 10);
                Enemy.add(cc_7567);
            }
            return Enemy;
        } else {

            return Enemy;
        }
    }

    public void améliorations(ArrayList<Combatant> LPlayer, Consumable potion, Consumable lembas) {


        for (int k = 0; k < LPlayer.size(); k++) {
            System.out.println("Choisissez un joueur a améliorer");
            String POP = sc.nextLine();


            int w = 0;
            boolean boucled = true;
            for (int r = 0; boucled && r < LPlayer.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
                if (LPlayer.get(r).getNom().equals(POP)) {
                    boucled = false;
                    w = r;
                    break;
                }
            }
            if (!LPlayer.get(w).getNom().equals(POP)) {                                              //vérifie si le nom correspond bien avec les joueurs de la liste LPlayer
                System.out.println("Vous n'avez pas de hero avec ce nom, retour au choix ");
                k--;
            } else {
                System.out.print("choisisez votre amélioration DEGATS /RESISTANCE/SPECIAL/ITEM");
                for (int yy = 0; yy < 1; yy++) {
                    String AM = sc.nextLine();

                    switch (AM) {
                        case "ITEM": // amélioration
                            potion.Addnombre();
                            lembas.Addnombre();
                            break;
                        case "DEGATS":
                            LPlayer.get(w).Degatsam();
                            break;
                        case "RESISTANCE":
                            LPlayer.get(w).ressistanceam();
                        case "SPECIAL":
                            if (LPlayer.get(w) instanceof Hunter) {
                                System.out.println("Voulez vous augmenter le nombre de flèche ? OUI/NON");
                                String th = sc.nextLine();
                                if (th.equals("OUI")) {
                                    LPlayer.get(w).amélioration();
                                    break;
                                } else {
                                    System.out.println("retour au choix des amélioration");
                                    yy--;
                                    break;
                                }


                            } else if (LPlayer.get(w) instanceof Mage || LPlayer.get(w) instanceof Healer) {
                                System.out.println("Vous voulez 'DIMINUER' le coût en mana ? DIMINUER/NON");
                                String ty = sc.nextLine();
                                switch (ty) {
                                    case "DIMINUER":
                                        LPlayer.get(w).amélioration();
                                        System.out.println("Vous avez diminuer le cout en mana de 2");
                                        break;

                                    default:
                                        System.out.println("Retour aux choix des améliorations");
                                        yy--;
                                        break;
                                }

                            } else {
                                System.out.println("Choisissez un hero de classe Hunter ou Healer pour le choix Spéciale retour aux choix des améloriation");
                                yy--;
                                break;
                            }
                        default:
                            System.out.println("réponse invalide retour aux choix de l'amélioration ");
                            yy--;
                            break;
                    }
                }

            }

        }
    }

    public void combatSys(ArrayList<Combatant> LPlayer, ArrayList<Combatant> LEnemy, Consumable potion, Consumable lembas, int z, int t) {
        while (LEnemy.size() != 0 && LPlayer.size() != 0) {                                                       //Vérifie si les joueurs sont tous bien en vie avec la taille des listes
            System.out.println("je rentre une fois " + LPlayer.size());
            for (Combatant combatant : LPlayer) {
                combatant.setFalsebolean();
            }

            for (int i = 0; i < LPlayer.size(); i++) {                                                   // évite de rejouer le meme personnage chaque tour donc force à jouer plusieurs personnages
                System.out.println("i = " + i);

                if (t == 0) {
                    for (int l = 0; l < 1; l++) {
                        System.out.println("choisit ton hero a utilser");
                        String lol;
                        lol = sc.nextLine();


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
                                String R = sc.nextLine();


                                switch (R) {
                                    case "Attaquer":                                                                 //on choisit l'action


                                        if (LPlayer.get(y) instanceof Healer) {                                         //code Healer
                                            System.out.println("choisi ton personnage a soigner  ");
                                            String NH;
                                            NH = sc.nextLine();

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

                                                    t = 1;
                                                    break;
                                                } else {
                                                    System.out.println("Vous navez pas assez de magie");
                                                    l--;
                                                }
                                            }
                                        } else {                                                                                                  //code pour les autres hero
                                            System.out.println("choisiser le numero de l'adeversair a attaquer entre 1 et " + LEnemy.size());

                                            int NE = sc.nextInt();
                                            while (NE <= 0 || NE > LEnemy.size()) {
                                                System.out.println("entre 1 et  " + LEnemy.size());
                                                NE = sc.nextInt();
                                            }
                                            sc.nextLine();

                                            if (!LEnemy.get(NE - 1).moinvie(LPlayer.get(y).attaque1(), LEnemy.get(NE - 1).getRessistance())) {                //La méthode moinvie() sort un boolean et enlève la vie des enemies

                                                l--;
                                                break;

                                            } else {
                                                LPlayer.get(y).setruebolean();
                                                t = 1;


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
                                        t = 1;


                                        break;
                                    case "Manger":
                                        System.out.println("Voulez vous manger un lembas ou boir une potion ");
                                        System.out.println("Le lenbas augmente un peut votre vie alors que la potion augmente grandement votre vie mais diminue votre resistance ");
                                        System.out.println("écrivez 'Manger' pour le Lembas ou 'Boir' pour la potion ");
                                        String choix2 = sc.nextLine();
                                        switch (choix2) {
                                            case "Manger":

                                                if (lembas.getnombre() > 0 && LPlayer.get(y).nourriture(lembas)) {
                                                    t = 1;
                                                    lembas.moinnombre();
                                                    System.out.println("Vous avez" + lembas.getnombre() + "Lembas");
                                                    LPlayer.get(y).setruebolean();
                                                } else {
                                                    l--;

                                                    if (lembas.getnombre() == 0) {
                                                        System.out.println("tu nas pas assez de Lembas");

                                                    }
                                                }

                                                break;

                                            case "Boir":

                                                if (potion.getnombre() > 0 && LPlayer.get(y).potion(potion)) {

                                                    t = 1;
                                                    potion.moinnombre();
                                                    LPlayer.get(y).setruebolean();
                                                } else {
                                                    l--;
                                                    if (potion.getnombre() == 0) {
                                                        System.out.println("tu as plus de potion");
                                                    }
                                                }

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
                } else if (t == 1 && LEnemy.size() != 0 && LPlayer.size() != 0) {

                    if (z >= LEnemy.size()) {
                        z = 0;
                    }
                    int Ne = rand.nextInt(LPlayer.size());
                    System.out.println("rentre dans l'ennemie");
                    for (int e = 0; e < 1; e++) {
                        if (LPlayer.get(Ne).moinvie(LEnemy.get(z).getdegats(), LPlayer.get(Ne).getRessistance())) {
                            z++;
                            t = 0;
                            i--;
                            if (LPlayer.get(Ne).getVie() <= 0) {
                                System.out.println("le joueur " + LPlayer.get(Ne).getNom() + " est mort :(");
                                LPlayer.remove(Ne);
                                t = 0;

                            }
                        } else {
                            e--;
                        }
                    }

                }

            }
        }
    }


    public int enemyplaynew(int z,ArrayList<Combatant> player,ArrayList<Combatant> enemy) {
        if (z >= enemy.size()) {
            z = 0;
        }
        int Ne = rand.nextInt(player.size());
        System.out.println("rentre dans l'ennemie");
        for (int e = 0; e < 1; e++) {
            if (player.get(Ne).moinvie(enemy.get(z).getdegats(), player.get(Ne).getRessistance())) {
                z++;
                if (player.get(Ne).getVie() <= 0) {
                    System.out.println("le joueur " + player.get(Ne).getNom() + " est mort :(");
                    player.remove(Ne);


                }
            } else {
                e--;
            }

        }return z;
    }

    public void enemieplay(int z, ArrayList<Combatant> LPlayer, ArrayList<Combatant> LEnemy) {
        if (z >= LEnemy.size()) {
            z = 0;
        }
        int Ne = rand.nextInt(LPlayer.size());
        System.out.println("rentre dans l'ennemie");
        for (int e = 0; e < 1; e++) {
            if (LPlayer.get(Ne).moinvie(LEnemy.get(z).getdegats(), LPlayer.get(Ne).getRessistance())) {
                z++;
                if (LPlayer.get(Ne).getVie() <= 0) {
                    System.out.println("le joueur " + LPlayer.get(Ne).getNom() + " est mort :(");
                    LPlayer.remove(Ne);


                }
            } else {
                e--;
            }
        }


    }

    public void Joueurplay(ArrayList<Combatant> LPlayer, ArrayList<Combatant> LEnemy, Consumable potion, Consumable lembas) {

        for (int l = 0; l < 1; l++) {
            System.out.println("choisit ton hero a utilser");
            String lol;
            lol = sc.nextLine();


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
                    String R = sc.nextLine();


                    switch (R) {
                        case "Attaquer":                                                                 //on choisit l'action


                            if (LPlayer.get(y) instanceof Healer) {                                         //code Healer
                                System.out.println("choisi ton personnage a soigner  ");
                                String NH;
                                NH = sc.nextLine();

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
                                        break;
                                    } else {
                                        System.out.println("Vous navez pas assez de magie");
                                        l--;
                                    }
                                }
                            } else {                                                                                                  //code pour les autres hero
                                System.out.println("choisiser le numero de l'adeversair a attaquer entre 1 et " + LEnemy.size());

                                int NE = sc.nextInt();
                                while (NE <= 0 || NE > LEnemy.size()) {
                                    System.out.println("entre 1 et  " + LEnemy.size());
                                    NE = sc.nextInt();
                                }
                                sc.nextLine();

                                if (!LEnemy.get(NE - 1).moinvie(LPlayer.get(y).attaque1(), LEnemy.get(NE - 1).getRessistance())) {                //La méthode moinvie() sort un boolean et enlève la vie des enemies

                                    l--;
                                    break;

                                } else {
                                    LPlayer.get(y).setruebolean();


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


                            break;
                        case "Manger":
                            System.out.println("Voulez vous manger un lembas ou boir une potion ");
                            System.out.println("Le lenbas augmente un peut votre vie alors que la potion augmente grandement votre vie mais diminue votre resistance ");
                            System.out.println("écrivez 'Manger' pour le Lembas ou 'Boir' pour la potion ");
                            String choix2 = sc.nextLine();
                            switch (choix2) {
                                case "Manger":

                                    if (lembas.getnombre() > 0 && LPlayer.get(y).nourriture(lembas)) {

                                        lembas.moinnombre();
                                        System.out.println("Vous avez" + lembas.getnombre() + "Lembas");
                                        LPlayer.get(y).setruebolean();
                                    } else {
                                        l--;

                                        if (lembas.getnombre() == 0) {
                                            System.out.println("tu nas pas assez de Lembas");

                                        }
                                    }

                                    break;

                                case "Boir":

                                    if (potion.getnombre() > 0 && LPlayer.get(y).potion(potion)) {


                                        potion.moinnombre();
                                        LPlayer.get(y).setruebolean();
                                    } else {
                                        l--;
                                        if (potion.getnombre() == 0) {
                                            System.out.println("tu as plus de potion");
                                        }
                                    }

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
    }

    public ArrayList<Combatant> Enemycreatorgraph(ArrayList<Combatant> Player) {
        ArrayList<Combatant> Enemy = null;
        for (int i = 0; i < Player.size(); i++) {
            CC_7567 cc_7567 = new CC_7567(1, 1, 1);
            Enemy.add(cc_7567);
        }
        return Enemy;
    }

    public boolean Attaquer(ArrayList<Combatant> player, ArrayList<Combatant> enemy, int joueur, int f) {
        if (enemy.get(f).moinvie(player.get(joueur).attaque1(), player.get(f).getRessistance())){
        player.get(joueur).setruebolean();return true;}
        else{return false;}
    }

    public void Défendre(ArrayList<Combatant> player, int joueur) {
        player.get(joueur).defendre();
        player.get(joueur).setruebolean();
    }

    public boolean Soigner(ArrayList<Combatant> player,int joueur, int soigner) {
        if(player.get(soigner).soigner(player.get(joueur).attaque1())){
            player.get(joueur).setruebolean();return true;
        }else {return false;}
    }

    public boolean Manger(ArrayList<Combatant> player,int joueur,Consumable Lembas) {
        if(Lembas.getnombre()>0 &&player.get(joueur).nourriture(Lembas)){
            Lembas.moinnombre();
            System.out.println("Vous avez"+Lembas.getnombre()+"Lembas");
            player.get(joueur).setruebolean(); return true;}
        else {
            return false;
        }
    }

    public boolean Boir(ArrayList<Combatant> player,int joueur,Consumable potion) {
        if (potion.getnombre()>0 &&player.get(joueur).potion(potion)){
            potion.moinnombre();
            player.get(joueur).setruebolean();
            return true;
         }else{ return false;}

        }
        public void Ressistance(){

        }
        public void Items(int d,ArrayList<Combatant> player,Consumable potion, Consumable lembas){ potion.Addnombre(); lembas.Addnombre(); player.get(d).setruebolean();}
        public void Degats(int d,ArrayList<Combatant> player){player.get(d).Degatsam();}
        public void upgrade(int d ,ArrayList<Combatant> player){player.get(d).amélioration();player.get(d).setruebolean();}







        public int listechoseP(ArrayList<Combatant>player,String nomP){
            int y=0;
            boolean boucle = true;
            for (int r = 0; boucle && r < player.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
                if (player.get(r).getNom().equals(nomP)) {
                    boucle = false;
                    y = r;

                    break;
                }
            }if (player.get(y).getNom().equals(nomP)){
            return y;}
            else{return player.size();}
        }
        public int listechoseE(ArrayList<Combatant> enemie,String nomE){
        int y=0;
        boolean boucle = true;
        for (int r = 0; boucle && r < enemie.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
            if (String.valueOf(enemie.get(r)).equals(nomE)) {
                boucle = false;
                y = r;

                break;
            }
        }if (String.valueOf(enemie.get(y)).equals(nomE)){
            return y;}
        else{return enemie.size();}
    }
    public void bossCombat(ArrayList<Combatant>player,ArrayList<Combatant>enemies ){
        if(player.size()!=0 &&enemies.size()!=0){
        for (int i=0;i<player.size();i++){
                 player.get(i).moinvie(enemies.get(0).getdegats(),player.get(i).getRessistance());

                 if(player.get(i).getVie()<=0){
                     System.out.println(enemies.get(0).getNom()+" a tuer" +player.get(i).getNom());
                     player.remove(i);
                 }else{
                     System.out.println(enemies.get(0).getNom()+" a attaquer" +player.get(i).getNom());
                 }

        }}
        if(enemies.get(0).getVie()<=0){
            enemies.remove(0);
        }
    }

    }
