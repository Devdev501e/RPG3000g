package fff.rpghg;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import projetrpg3000.*;

import java.io.IOException;
import java.util.ArrayList;

public class Scene4controleur {
    @FXML
    ChoiceBox<String> choseboxPerso;
    @FXML
    ChoiceBox<String> choseboxAction;
    @FXML
    Label vieHero;
    @FXML
    Button valider;
    @FXML
     Label action;
    @FXML
    ChoiceBox<String> choiceBoxSoin =new ChoiceBox<>();
    @FXML
     Label vieBoss;
    @FXML
     Label mort;
    Scene scene;
    boolean marche;



    int emplacement1;
    int emplacement2;
    Game game=new Game();
    ArrayList<Grievous> enemie =new ArrayList<>();
    ArrayList<String> classeSoin=new ArrayList<>();
    ArrayList<Hero> player=new ArrayList<>();
    ArrayList<String> classe =new ArrayList<>();
    Consumable lembas = Food.creatLembas();
    Consumable potion = Potion.creatpotion();
       public void boss(ArrayList<Hero>Player,Consumable lem,Consumable pot){
           valider.setVisible(false);
           choseboxAction.setVisible(false);
           choiceBoxSoin.setVisible(false);
           player=Player;
           for (int i = 0; i < player.size(); i++) {
               for (Hero combatant : Player) {
                   combatant.setFalsebolean();
               }
               }

           lembas=lem;
           potion=pot;
           Grievous grievous=new Grievous(200,20,15,"Grievous",0,false);
           for (int i=0;i<Player.size();i++){classe.add(Player.get(i).getNom());}
           enemie.add(grievous);
           vieBoss.setText(enemie.get(0).stat1());
           choseboxPerso.getItems().addAll(classe);
           choseboxPerso.setOnAction(this::Action);
       }
       public void Action(Event event){
           if (choseboxPerso.getValue()!=null){
               choseboxAction.setVisible(true);
               emplacement1 = game.listechoseP(player,choseboxPerso.getValue());
               if (emplacement1<player.size()) {
                   vieHero.setText(player.get(emplacement1).stat1());
                   choseboxAction.getItems().clear();
                   if (player.get(emplacement1) instanceof Healer){

                       String[] ac = {"Soigner", "Manger", "Boire", "Défendre","Observer"};
                       choseboxAction.getItems().addAll(ac);
                       choseboxAction.setOnAction(this::Action2);

                   } else {
                       String[] ac = {"Attaquer", "Manger", "Boire", "Défendre","Observer"};

                       choseboxAction.getItems().addAll(ac);
                       choseboxAction.setOnAction(this::Action2);
               }}

       }

}
public void Action2 (Event event){
           valider.setVisible(true);
           if(choseboxAction.getValue()!=null){
               switch (choseboxAction.getValue()){
                   case"Attaquer":break;
                   case"Manger":action.setText(" Vous avez "+lembas.getnombre()+" de nourriture ");break;
                   case"Boire":action.setText(" Vous avez "+potion.getnombre()+" Potion");break;
                   case"Défendre":action.setText(" pour augmenter\n la barre de \nresistance de 7 ");break;
                   case"Soigner":

                       classeSoin.clear();
                       choiceBoxSoin.getItems().clear();
                       for(int i=0;i<player.size();i++){classeSoin.add(player.get(i).getNom());}

                       valider.setVisible(false);
                       choiceBoxSoin.setVisible(true);
                       choiceBoxSoin.getItems().addAll(classeSoin);
                       choiceBoxSoin.setOnAction(this::Action3);
                       choiceBoxSoin.setVisible(true);


                       break;
                   case"Observer": action.setText("observez l'ennemie pour\n trouver sont point faible "); break;
               }
           }

       }
       public void Action3(Event event){
           valider.setVisible(true);
           if(choiceBoxSoin.getValue()!=null) {
              emplacement2=game.listechoseP(player,choiceBoxSoin.getValue());
               if (emplacement2 < player.size())
                   action.setText(player.get(emplacement2).stat1());
           }
       }
public void ButtonV(Event event) throws IOException {
          action.setText("");
          valider.setVisible(false);
          choiceBoxSoin.setVisible(false);
          choseboxAction.setVisible(false);




        switch (choseboxAction.getValue()){
            case"Attaquer":if(game.Attaqueboss(enemie,player,emplacement1)){marche=true;}else{marche=false;};break;
            case"Manger":
                if (game.Manger(player, emplacement1, lembas)) {
                    action.setText("Vous avez manger ");
                    marche = true;
                    break;
                } else {
                    marche = false;
                    action.setText("Vous ne pouvez pas manger");break;}
            case"Boire":
                if (game.Boir(player, emplacement1, potion)) {
                    action.setText("vous avez augmenter votre vie de"+potion.getBitem()+"\nmais vous avez perdu ");
                    marche = true;
                    break;
                } else {
                    marche = false;
                    action.setText("Vous ne pouvez pas boire");
                    break;
                }
            case"Défendre": game.Défendre(player,emplacement1);marche=true;action.setText(" Votre barre de\n resistance à augmenter de 7 ");break;
            case"Soigner":
                if (game.Soigner(player,emplacement1,emplacement2)) {
                    marche = true;
                    action.setText("Vous avez soigné :" + player.get(emplacement2).getNom());
                    break;
                } else {
                    marche = false;
                    action.setText("Vous ne pouvez pas soigner ce joueur");
                    break;
                }
            case"Observer": enemie.get(0).Setobserver();player.get(emplacement1).setruebolean();marche=true; break;
        }

        if(enemie.get(0).getobserver()==player.size()){
            if(player.size()>1){
            enemie.get(0).moinVie(50,enemie.get(0).getRessistance());
            for (int i = 0; i < player.size(); i++) {
                player.get(i).soigner(30);

            }}else{enemie.get(0).moinVie(18,enemie.get(0).getRessistance());player.get(emplacement1).soigner(50);}
            action.setText("Vous avez trouver sont point faible\n et vous avez gagner de la vie");
            enemie.get(0).Setobserver0();
        }

        if(enemie.get(0).getVie()<=0){
            Parent root = FXMLLoader.load(getClass().getResource("Fin.fxml"));
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage1.setScene(scene);
            stage1.show();

        }




    if (marche && enemie.size() != 0 && player.size() != 0) {          //enemie
        for (int i = 0; i < player.size(); i++) {
            player.get(i).moinVie(enemie.get(0).getDegats(),player.get(i).getRessistance());
            marche=false;
            if(player.get(i).getVie()<=0){
                mort.setText("Le joueur "+player.get(i).getNom()+"est mort");
                player.remove(i);
            }
        }
    }
    if(player.size()==0){
        Parent root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage1.setScene(scene);
        stage1.show();
    }
    vieBoss.setText(enemie.get(0).stat1());
    classe.clear();
    for (int i = 0; i < player.size(); i++) {
        if(!player.get(i).getbolean()){
            classe.add(player.get(i).getNom());
        }

    }
    if (classe.size() == 0) {
        for (Hero combatant : player) {
            combatant.setFalsebolean();
        }
        for (int i = 0; i < player.size(); i++) {
            classe.add(player.get(i).getNom());
        }
    }
    choseboxPerso.getItems().clear();
    choseboxPerso.getItems().addAll(classe);

    }
    public void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage1.setScene(scene);
        stage1.show();
    }
}
