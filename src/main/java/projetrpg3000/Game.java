package projetrpg3000;


import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public Game() {
    }

    public int choicePerso() {

        System.out.println("Choisissez le nombre de votre équipe entre 1 et 4");
        int NJ=0;


        while (NJ <= 0 || NJ > 4) {

           try{
            NJ = sc.nextInt();
            if(NJ<=0 ||NJ>4){
                System.out.println("entre 1 et 4");
            }
           }
           catch (Exception e){
               System.out.println("un nombre entre 1 et 4");
               sc.nextLine();
           }
        }
        sc.nextLine();
        return NJ;


    }

    public ArrayList<Hero> joueurClasse(int NJ) {
        String Nom;
        ArrayList<Hero> player = new ArrayList<>();
        for (int i = 0; i < NJ; i++) {

            System.out.println("choisissez la classe de vos joueur Warrior/Mage/Hunter/Healer");

            String ik = sc.nextLine();


            switch (ik) {
                case "Warrior":
                    Warrior warrior = new Warrior(100, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Warrior");
                    Nom = sc.nextLine();
                    warrior.setNom(Nom);
                    player.add(warrior);
                    break;
                case "Hunter":
                    Hunter hunter = new Hunter(100, 1, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Hunter");
                    Nom = sc.nextLine();
                    hunter.setNom(Nom);
                    player.add(hunter);
                    break;
                case "Mage":
                    Mage mage = new Mage(100, 1, 10, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Mage");
                    Nom = sc.nextLine();
                    mage.setNom(Nom);
                    player.add(mage);
                    break;
                case "Healer":
                    Healer healer = new Healer(100, 1, 10, 1, 10, "lol", false);
                    System.out.println("Choisisez le nom de votre HERO Healer");
                    Nom = sc.nextLine();
                    healer.setNom(Nom);
                    player.add(healer);
                    break;
                default:
                    System.out.println("Classe invalide");
                    i--;
                    break;
            }

        }
        return player;


    }

    public ArrayList<Combatant> enemyCréation(ArrayList<Hero> Player, int P) {
        ArrayList<Combatant> Enemy = new ArrayList<>();
        if (P <= 4 && Player.size() != 0) {
            for (int i = 0; i < Player.size(); i++) {
                CC_7567 cc_7567 = new CC_7567(20*(P+1), 5*(P+1), 5*(P+1));
                Enemy.add(cc_7567);
            }
            return Enemy;
        } else {

            return Enemy;
        }
    }

    public void améliorations(ArrayList<Hero> player, Consumable potion, Consumable lembas) {


        for (int k = 0; k < player.size(); k++) {
            System.out.println("Choisissez un joueur a améliorer");
            String POP = sc.nextLine();


            int w = 0;
            boolean boucled = true;
            for (int r = 0; boucled && r < player.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
                if (player.get(r).getNom().equals(POP)) {
                    boucled = false;
                    w = r;
                    break;
                }
            }
            if (!player.get(w).getNom().equals(POP)) {                                              //vérifie si le nom correspond bien avec les joueurs de la liste player
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
                            player.get(w).degatsAm();
                            break;
                        case "RESISTANCE":
                            player.get(w).ressistanceam();
                        case "SPECIAL":
                            if (player.get(w) instanceof Hunter) {
                                System.out.println("Voulez vous augmenter le nombre de flèche ? OUI/NON");
                                String th = sc.nextLine();
                                if (th.equals("OUI")) {
                                    player.get(w).amélioration();
                                    break;
                                } else {
                                    System.out.println("retour au choix des amélioration");
                                    yy--;
                                    break;
                                }


                            } else if (player.get(w) instanceof Mage || player.get(w) instanceof Healer) {
                                System.out.println("Vous voulez 'DIMINUER' le coût en mana ? DIMINUER/NON");
                                String ty = sc.nextLine();
                                switch (ty) {
                                    case "DIMINUER":
                                        player.get(w).amélioration();
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
    public int enemyplaynew(int z, ArrayList<Hero> player, ArrayList<Combatant> enemy, Label label) {
        if (z >= enemy.size()) {
            z = 0;
        }
        int Ne = rand.nextInt(player.size());
        System.out.println("rentre dans l'ennemie");
        for (int e = 0; e < 1; e++) {
            if (player.get(Ne).moinVie(enemy.get(z).getDegats(), player.get(Ne).getRessistance())) {
                z++;
                label.setText("le joueur " + player.get(Ne).getNom() + " a été attaqué  ");
                if (player.get(Ne).getVie() <= 0) {
                    label.setText("le joueur " + player.get(Ne).getNom() + " est mort ");
                    player.remove(Ne);


                }
            } else {
                e--;
            }

        }return z;
    }

    public void enemieplay(int z, ArrayList<Hero> player, ArrayList<Combatant> enemy) {
        if (z >= enemy.size()) {
            z = 0;
        }
        int Ne = rand.nextInt(player.size());
        System.out.println("rentre dans l'ennemie");
        for (int e = 0; e < 1; e++) {
            if (player.get(Ne).moinVie(enemy.get(z).getDegats(), player.get(Ne).getRessistance())) {
                z++;
                if (player.get(Ne).getVie() <= 0) {
                    System.out.println("le joueur " + player.get(Ne).getNom() + " est mort :(");
                    player.remove(Ne);


                }
            } else {
                e--;
            }
        }


    }

    public void Joueurplay(ArrayList<Hero> player, ArrayList<Combatant> enemy, Consumable potion, Consumable lembas) {

        for (int l = 0; l < 1; l++) {
            System.out.println("choisit ton hero a utilisé");
            String lol;
            lol = sc.nextLine();


            int y = 0;
            boolean boucle = true;
            for (int r = 0; boucle && r < player.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
                if (player.get(r).getNom().equals(lol)) {
                    boucle = false;
                    y = r;
                    break;
                }
            }
            System.out.println("y = " + y);


            if (!player.get(y).getNom().equals(lol)) {                                              //vérifie si le nom correspond bien avec les joueurs de la liste player
                System.out.println("Vous n'avez pas de hero avec ce nom, retour au choix ");
                l--;

            } else {
                if (!player.get(y).getbolean() && player.get(y).getVie() > 0) {
                    System.out.println("Voulez vous Attaquer ou vous Défendre ou Manger ?");
                    String R = sc.nextLine();


                    switch (R) {
                        case "Attaquer":                                                                 //on choisit l'action


                            if (player.get(y) instanceof Healer) {                                         //code Healer
                                System.out.println("choisi ton personnage a soigner  ");
                                String NH;
                                NH = sc.nextLine();

                                int h;
                                h = 0;
                                boolean boucleh = true;
                                for (int r = 0; boucleh && r < player.size(); r++) {                               //  compare le nom des joueurs avec le nom rentré dans la console pour trouver l'emplacement dans la liste
                                    if (player.get(r).getNom().equals(NH)) {
                                        boucleh = false;
                                        h = r;
                                        break;
                                    }
                                }
                                if (!player.get(h).getNom().equals(NH)) {                                                      //vérifie si le nom correspond bien avec les joueurs de la liste player
                                    System.out.println("Vous n'avez pas de hero avec ce nom, retour au choix ");
                                    l--;                                                                                           //l-- permet de reboucler si la réponse est invalide
                                } else {
                                    if (player.get(h).soigner(player.get(y).attaque1())) {
                                        System.out.println("Vous avez soigner " + player.get(h).getNom());
                                        player.get(y).setruebolean();
                                        break;
                                    } else {
                                        System.out.println("Vous n'avez pas assez de magie");
                                        l--;
                                    }
                                }
                            } else {                                                                                                  //code pour les autres hero
                                System.out.println("Choisissez le numero de l'adversaire a attaquer entre 1 et " + enemy.size());

                                int NE = sc.nextInt();
                                while (NE <= 0 || NE > enemy.size()) {
                                    System.out.println("entre 1 et  " + enemy.size());
                                    NE = sc.nextInt();
                                }
                                sc.nextLine();

                                if (!enemy.get(NE - 1).moinVie(player.get(y).attaque1(), enemy.get(NE - 1).getRessistance())) {                //La méthode moinvie() sort un boolean et enlève la vie des enemies

                                    l--;
                                    break;

                                } else {
                                    player.get(y).setruebolean();


                                    if (enemy.get(NE - 1).getVie() <= 0) {                                                             //permet de réduire la taille de la liste de l'ennemie
                                        System.out.println("Vous avez tuer un ennemie ");
                                        enemy.remove(NE - 1);


                                        break;
                                    } else {
                                        break;
                                    }
                                }
                            }


                        case "Défendre":
                            player.get(y).defendre();
                            player.get(y).setruebolean();


                            break;
                        case "Manger":
                            System.out.println("Voulez vous manger un lembas ou boir une potion ");
                            System.out.println("Le lembas augmente un peut votre vie alors que la potion augmente grandement votre vie mais diminue votre resistance ");
                            System.out.println("écrivez 'Manger' pour le Lembas ou 'Boire' pour la potion ");
                            String choix2 = sc.nextLine();
                            switch (choix2) {
                                case "Manger":

                                    if (lembas.getnombre() > 0 && player.get(y).nourriture(lembas)) {

                                        lembas.moinnombre();
                                        System.out.println("Vous avez" + lembas.getnombre() + "Lembas");
                                        player.get(y).setruebolean();
                                    } else {
                                        l--;

                                        if (lembas.getnombre() == 0) {
                                            System.out.println("tu nas pas assez de Lembas");

                                        }
                                    }

                                    break;

                                case "Boire":

                                    if (potion.getnombre() > 0 && player.get(y).potion(potion)) {


                                        potion.moinnombre();
                                        player.get(y).setruebolean();
                                    } else {
                                        l--;
                                        if (potion.getnombre() == 0) {
                                            System.out.println("tu n'as plus de potion");
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
                    if (player.get(y).getbolean()) {
                        System.out.println("vous avez deja utiliser ce personnage");

                        l--;
                    } else if (player.get(y).getVie() <= 0) {
                        l--;

                    }
                }


            }
        }
    }

    public boolean Attaquer(ArrayList<Hero> player, ArrayList<Combatant> enemy, int joueur, int f) {
        if (enemy.get(f).moinVie(player.get(joueur).attaque1(), player.get(f).getRessistance())){
        player.get(joueur).setruebolean();return true;}
        else{return false;}
    }

    public String Défendre(ArrayList<Hero> player, int joueur) {
        player.get(joueur).setruebolean();
        return player.get(joueur).defendre();


    }

    public boolean Soigner(ArrayList<Hero> player,int joueur, int soigner) {
        if(player.get(soigner).soigner(player.get(joueur).attaque1())){
            player.get(joueur).setruebolean();return true;
        }else {return false;}
    }

    public boolean Manger(ArrayList<Hero> player,int joueur,Consumable Lembas) {
        if(Lembas.getnombre()>0 &&player.get(joueur).nourriture(Lembas)){
            Lembas.moinnombre();
            System.out.println("Vous avez"+Lembas.getnombre()+"Lembas");
            player.get(joueur).setruebolean(); return true;}
        else {
            return false;
        }
    }

    public boolean Boir(ArrayList<Hero> player,int joueur,Consumable potion) {
        if (potion.getnombre()>0 &&player.get(joueur).potion(potion)){
            potion.moinnombre();
            player.get(joueur).setruebolean();
            return true;
         }else{ return false;}

        }
        public void Ressistance(ArrayList<Hero> player,int joueur){
            player.get(joueur).ressistanceam();
            player.get(joueur).setruebolean();
        }
        public void Items(int d,ArrayList<Hero> player,Consumable potion, Consumable lembas){ potion.Addnombre(); lembas.Addnombre(); player.get(d).setruebolean();}
        public void Degats(int d,ArrayList<Hero> player){player.get(d).degatsAm();player.get(d).setruebolean();}
        public void upgrade(int d ,ArrayList<Hero> player){player.get(d).amélioration();player.get(d).setruebolean();}







        public int listechoseP(ArrayList<Hero>player,String nomP){
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
    public void bossCombat(ArrayList<Hero>player,ArrayList<Grievous>enemies ){
        if(player.size()!=0 &&enemies.size()!=0){
        for (int i=0;i<player.size();i++){
                 player.get(i).moinVie(enemies.get(0).getDegats(),player.get(i).getRessistance());

                 if(player.get(i).getVie()<=0){
                     System.out.println(enemies.get(0).getNom()+" a tué" +player.get(i).getNom());
                     player.remove(i);
                 }else{
                     System.out.println(enemies.get(0).getNom()+" a attaqué" +player.get(i).getNom());
                 }

        }}

    }
    public boolean Attaqueboss(ArrayList<Grievous>enemie,ArrayList<Hero> player,int emplacement1){
        if (enemie.get(0).moinVie(player.get(emplacement1).getDegats(),enemie.get(0).getRessistance())){
            player.get(emplacement1).setruebolean();

            System.out.println(player.get(emplacement1).getbolean());
            return true;
        }
        else {
            return false;
        }

    }

    }
