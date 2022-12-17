package fff.rpghg;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;
import projetrpg3000.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setTitle("RPG3000");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {

        int numb = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("[1] pour jouer sur console ou [2] pour jouer sur la version graphique");
         while(numb<1 ||numb>2){
        try{
            numb=sc.nextInt();

        }catch (Exception e){
            System.out.print("un nombre stp entre 1 et 2");
            sc.nextLine();
        }}


        if (numb == 2) {launch();}

        else if(numb==1){
            int z=0;
            Random rand = new Random();
            ArrayList<Combatant> enemy = new ArrayList<>();
            Consumable lembas = Food.creatLembas();
            Consumable potion = Potion.creatpotion();
            Game game = new Game();
            int number = game.choicePerso();

            ArrayList<Hero> Player = game.joueurClasse(number);
            int t = rand.nextInt(2);
            for (int p = 1; p < 6; p++) {

                if (p > 1) {
                    game.améliorations(Player, potion, lembas);
                }

                if (enemy.size() == 0) {
                    enemy = game.enemyCréation(Player, p);

                } else if (Player.size() == 0) {
                    break;
                }

                while (enemy.size() != 0 && Player.size() != 0) {
                    for (Hero combatant : Player) {combatant.setFalsebolean();}
                    for (int i = 0; i < Player.size(); i++) {
                        for (int j = 0; j < Player.size(); j++) {
                            System.out.println(Player.get(i).stat1());
                        }

                        if (t == 0  ) {
                            game.Joueurplay( Player, enemy, potion, lembas);
                            t=1;
                        }else if(t==1 && enemy.size()!=0 &&Player.size()!=0){
                            game.enemieplay(z,Player,enemy);
                            t=0;
                            i--;
                        }
                    }

                }
            }
            if (Player.size()==0){
                System.out.println("tas perdu lol");

            }else if(enemy.size()==0){
                ArrayList<Grievous>enemies=new ArrayList<>();
                Grievous grievous=new Grievous(200,15,15,"Grievous",0,true);
                enemies.add(grievous);
                while (enemies.size() != 0 && Player.size() != 0){
                game.Joueurplay(Player,enemy,potion,lembas);
                game.bossCombat(Player,enemies);

            }
            if(Player.isEmpty()){
                System.out.println("vous avez pedu");

            }else if (enemies.isEmpty()){
                System.out.println("vous avez gagner");
            }



































        }
    }
}}