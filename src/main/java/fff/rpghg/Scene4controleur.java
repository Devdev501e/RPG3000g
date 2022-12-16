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
    Scene scene;



    int emplacement1;
    int emplacement2;
    Game game=new Game();
    ArrayList<Grievous> enemie =new ArrayList<>();
    ArrayList<String> classeSoin=new ArrayList<>();
    ArrayList<Hero> player=new ArrayList<>();
    ArrayList<String> classe =new ArrayList<>();
       public void boss(ArrayList<Hero>Player){
           valider.setVisible(false);
           choseboxAction.setVisible(false);
           choiceBoxSoin.setVisible(false);
           player=Player;
           Grievous grievous=new Grievous(1,1,1,"Grievous",0,true);
           for (int i=0;i<Player.size();i++){classe.add(Player.get(i).getNom());}
           enemie.add(grievous);
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
                   case"Manger":break;
                   case"Boire":action.setText(" pour augmenter la barre de resistance de 7 ");break;
                   case"Défendre":action.setText(" pour augmenter\n la barre de \nresistance de 7 ");break;
                   case"Soigner":

                       classeSoin.clear();
                       choiceBoxSoin.getItems().clear();
                       for(int i=0;i<player.size();i++){classeSoin.add(player.get(i).getNom());}

                       valider.setVisible(false);
                       choiceBoxSoin.setVisible(true);
                       System.out.println("c'est rentre dans soigner");
                       choiceBoxSoin.getItems().addAll(classeSoin);
                       choiceBoxSoin.setOnAction(this::Action3);
                       choiceBoxSoin.setVisible(true);


                       break;
                   case"Observer": enemie.get(0).Setobserver(); break;
               }
           }

       }
       public void Action3(Event event){
           if(choiceBoxSoin.getValue()!=null) {
               emplacement2 = game.listechoseP(player, choiceBoxSoin.getValue());
               if (emplacement2 < player.size())
                   action.setText(player.get(emplacement2).stat1());
           }
       }
public void ButtonV(Event event){

           boolean marche =false;
        switch (choseboxAction.getValue()){
            case"Attaquer":break;
            case"Manger":break;
            case"Boire":break;
            case"Défendre": game.Défendre(player,emplacement1);marche=true;action.setText(" Votre barre de\n resistance à augmenter de 7 ");break;
            case"Soigner": break;
            case"Observer": enemie.get(0).Setobserver(); break;
        }

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
