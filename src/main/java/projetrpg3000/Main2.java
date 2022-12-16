package projetrpg3000;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    Game game=new Game();
    Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z=0;
        Random rand = new Random();
        ArrayList<Combatant> Enemy = new ArrayList<>();
        Game game = new Game();
        int number = game.choiceperso();

        ArrayList<Combatant> Player = game.JoueurClasse(number);
        int t = rand.nextInt(2);
        for (int p = 1; p < 6; p++) {
            Consumable lembas = Food.creatLembas();
            Consumable potion = Potion.creatpotion();
            if (p > 1) {
                game.améliorations(Player, potion, lembas);
            }

            if (Enemy.size() == 0) {
                Enemy = game.Enemycréation(Player, p);

            } else if (Player.size() == 0) {
                break;
            }

        while (Enemy.size() != 0 && Player.size() != 0) {
            for (Combatant combatant : Player) {combatant.setFalsebolean();}
            for (int i = 0; i < Player.size(); i++) {
                if (t == 0  ) {
                    game.Joueurplay( Player, Enemy, potion, lembas);
                    t=1;
                }else if(t==1 && Enemy.size()!=0 &&Player.size()!=0){
                    game.enemieplay(z,Player,Enemy);
                    t=0;
                    i--;
                }
            }

        }
    }
        if (Player.size()==0){
            System.out.println("tas perdu lol");

        }else if(Enemy.size()==0){
            System.out.println("tas gagner lol");
        }
}
}
