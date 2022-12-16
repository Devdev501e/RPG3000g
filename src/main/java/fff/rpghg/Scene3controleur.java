package fff.rpghg;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import projetrpg3000.*;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
public class Scene3controleur implements Initializable {

    ArrayList<Hero> Player= new ArrayList<>();
    ArrayList<Combatant> Enemy=new ArrayList<>();
    int E;
    int w;
    int f;
    int z;
    int d;               //dans amèlioration pour choisir les perso
    String action;
    String Classe1;
    Stage stage;
    Scene scene;
    Parent root;

    Game game=new Game();
    Consumable lembas = Food.creatLembas();
    Consumable potion = Potion.creatpotion();
    Random rand =new Random();

    public void displaliste(ArrayList<Hero> displaliste) {
        int k= rand.nextInt(2);
        if(k==0){}
        choiceboxamèlioration.setVisible(false);
        choiceboxAm.setVisible(false);
        button6.setVisible(false);
        aplied.setVisible(false);
        choiceboxAction.setVisible(false);
        choiceboxEnemy.setVisible(false);
        Player = displaliste;
        if(Enemy.size()==0 && Player.size()!=0){
            Enemy=game.enemyCréation(Player,E);
            for (int i=0;i<Enemy.size();i++){
                enemynom.add(String.valueOf((Enemy.get(i))));
            }E++;}
        for (int i=0;i<Player.size();i++){Classe.add(Player.get(i).getNom());}
        labNombre.setText("Vous avez "+ Enemy.size()+" enemies en vie\n"+"Vous avez "+Player.size()+" joueurs en vie");
        choiceboxPersonage.getItems().clear();
        choiceboxPersonage.getItems().addAll(Classe);
        choiceboxPersonage.setOnAction(this::action);}



    @FXML
    Label mylab;
    @FXML
    Label labNombre;
    @FXML
    Label labAmèlioration;
    @FXML
    Label labVieJoueuers;

    @FXML
    ChoiceBox<String> choiceboxPersonage;
    @FXML
    ChoiceBox<String> choiceboxEnemy;
    @FXML
    ChoiceBox<String> choiceboxAction;
    @FXML
    ChoiceBox<String> choiceboxamèlioration;
    @FXML
    ChoiceBox<String> choiceboxAm;
    ArrayList<String> Classe= new ArrayList<>();
    ArrayList<String > enemynom=new ArrayList<>();
    ArrayList<String > classeSoin=new ArrayList<>();
    ArrayList<String> jo=new ArrayList<>();              //pour les améliorations
    @FXML
    Label statperso;
    @FXML
    Button aplied;
    @FXML
    Button button6;
    @FXML
    Label Statenemie;
    @FXML
    Label partieN;






   public void button4(ActionEvent event) {                          //teste
       System.out.println("lol");
       System.out.println(Enemy.size()+" nom= "+enemynom);


   }
    private void action(Event event) {
        choiceboxAction.setVisible(false);

        Classe1 = choiceboxPersonage.getValue();

        if (null != Classe1) {
            choiceboxAction.setVisible(true);
            w = game.listechoseP(Player,Classe1);            //new

            if (!Player.get(w).getNom().equals(Classe1)) {}
            else {

            statperso.setText(Player.get(w).stat1());

        }
            choiceboxAction.getItems().add("");
            choiceboxAction.getItems().clear();
        if (Player.get(w) instanceof Healer) {

            String[] ac = {"Soigner", "Manger", "Boire", "Défendre"};
            choiceboxAction.getItems().addAll(ac);
            choiceboxAction.setOnAction(this::action2);

        } else {
            String[] ac = {"Attaquer", "Manger", "Boire", "Défendre"};

            choiceboxAction.getItems().addAll(ac);
            choiceboxAction.setOnAction(this::action2);

        }}

    }

    private void action2(Event event){
        aplied.setVisible(false);
        choiceboxEnemy.setVisible(false);

       if(choiceboxAction.getValue()!=null){
        switch (choiceboxAction.getValue()){
            case("Attaquer"): choiceboxEnemy.getItems().clear();
                choiceboxEnemy.setVisible(true);
                aplied.setVisible(false);
                choiceboxEnemy.getItems().clear();
                choiceboxEnemy.getItems().addAll(enemynom);
                choiceboxEnemy.setOnAction(this::action3);

                System.out.println("c'est rentre dans attaquer");



                break;
            case("Soigner"):
                classeSoin.clear();
                for(int i=0;i<Player.size();i++){classeSoin.add(Player.get(i).getNom());}

                choiceboxEnemy.getItems().clear();
                aplied.setVisible(false);
                choiceboxEnemy.setVisible(true);
                System.out.println("c'est rentre dans soigner");
                choiceboxEnemy.getItems().addAll(classeSoin);
                choiceboxEnemy.setOnAction(this::action3);


                break;
            case("Manger"):aplied.setVisible(true); Statenemie.setText("Nombre de nourriture = "+lembas.getnombre());    break;
            case("Boire"):aplied.setVisible(true);Statenemie.setText("Nombre de potion = "+potion.getnombre());break;
            case("Défendre"):aplied.setVisible(true);break;
            default:break;
        }}

   }
    private void action3(Event event) {
       if (choiceboxAction.getValue()!=null && choiceboxEnemy.getValue()!=null){
       switch (choiceboxAction.getValue()){
           case"Attaquer":

               f=game.listechoseE(Enemy,choiceboxEnemy.getValue());

               if (f<Enemy.size()){Statenemie.setText(Enemy.get(f).stat1());} break;           //new


           case"Soigner":
               f=game.listechoseP(Player,choiceboxEnemy.getValue());

               if (f<Player.size()){Statenemie.setText(Player.get(f).stat1());}break;
       }



       try{
           aplied.setVisible(true);
       }
       catch (Exception e){}
    }}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }


    public void retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage1.setScene(scene);
        stage1.show();
    }
    public void button5(ActionEvent event)throws IOException{
       statperso.setText("");
       Statenemie.setText("");
       Boolean marche=false;
       aplied.setVisible(false);


          action=choiceboxAction.getValue();
          choiceboxEnemy.setVisible(false);
          choiceboxAction.setVisible(false);
          switch (action){
              case("Attaquer"):
                  if(game.Attaquer(Player,Enemy,w,f)){
                      marche=true;
                      if(Enemy.get(f).getVie()<=0){Enemy.remove(f);}
                  }
                  else{Statenemie.setText("Vous ne pouvez pas attaquer");
                      marche=false;
              }
                  break;
              case("Soigner"):if(game.Soigner(Player,w,f)){marche=true;Statenemie.setText("Vous avez soigné :"+Player.get(f).getNom());break;}else{marche=false;break;}
              case("Défendre"):Statenemie.setText(game.Défendre(Player,w));marche=true;break;
              case("Manger"):if(game.Manger(Player,w,lembas)){marche=true;break;}else{marche=false;Statenemie.setText("Vous ne pouvez pas manger");break;}
              case("Boire"):if(game.Boir(Player,w,potion)){marche=true;break;}else{marche=false;Statenemie.setText("Vous ne pouvez pas boire");break;}
          }

          if(marche && Enemy.size()!=0 &&Player.size()!=0){

             z=game.enemyplaynew(z,Player,Enemy);

              System.out.println("z = "+z);

          }
        if (Player.size()==0){
            System.out.println("Game over");
        }
        if (Enemy.size()==0){                                                           //amélioration

            choiceboxAm.setVisible(false);
            choiceboxPersonage.setDisable(true);
            for (Hero combatant : Player) {combatant.setFalsebolean();}
            choiceboxamèlioration.setVisible(true);
            for (int i=0;i<Player.size();i++){if(!Player.get(i).getbolean()){jo.add(Player.get(i).getNom());}}
            choiceboxamèlioration.getItems().clear();
            choiceboxamèlioration.getItems().addAll(jo);
            choiceboxamèlioration.setOnAction(this::actionAm);}
        if(Enemy.size()==0 && E<1){Enemy=game.enemyCréation(Player,E);E++;partieN.setText("Partie n° "+E);}    //codes enemies //nombre de partie
        if(Enemy.size()==0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene4.fxml"));
            root = loader.load();
            Scene4controleur scene4controleur=loader.getController();
            scene4controleur.boss(Player);
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();}    //code switch to final bosse

          Classe.clear();
          for (int i=0;i<Player.size();i++){if(!Player.get(i).getbolean()){Classe.add(Player.get(i).getNom());}}//premier choice box
          if (Classe.size()==0){for (Hero combatant : Player) {combatant.setFalsebolean();} for (int i=0;i<Player.size();i++){Classe.add(Player.get(i).getNom());}}

          enemynom.clear();
          for (int i=0;i<Enemy.size();i++){enemynom.add(String.valueOf((Enemy.get(i))));}  //troisième choice box

          choiceboxPersonage.getItems().clear();
          choiceboxPersonage.getItems().addAll(Classe);
        labNombre.setText("Vous avez "+ Enemy.size()+" enemies en vie\n"+"Vous avez "+Player.size()+" joueurs en vie");



    }
    public void actionAm(Event event){

        choiceboxAm.setVisible(true);
             String joueur = choiceboxamèlioration.getValue();

        boolean boucl = true;
        for (int r = 0; boucl && r < Player.size(); r++) {                                //  compare le nom des joueurs avec le nom rentré dans la console pour trouvé l'emplacement dans la liste
            if (Player.get(r).getNom().equals(joueur)) {
                boucl = false;
                 d= r;
                break;

    }}
            if (Player.get(d).getNom().equals(joueur)){
                choiceboxAm.getItems().clear();
                button6.setVisible(true);

                if(Player.get(d)instanceof Mage|| Player.get(d)instanceof Healer){
                    String[] spelcaster={"Items","Dégats","Resistances","Prix mana"};
                    choiceboxAm.getItems().addAll(spelcaster);
                    choiceboxAm.setOnAction(this::actionAm2);

                } else if (Player.get(d)instanceof Hunter) {
                    String[] Hunter={"Items","Dégâts","Resistances","Nombre de Flèche"};
                    choiceboxAm.getItems().addAll(Hunter);
                    choiceboxAm.setOnAction(this::actionAm2);
                } else if (Player.get(d)instanceof Warrior) {
                    String[] warrior={"Items","Dégâts","Resistances"};
                    choiceboxAm.getItems().addAll(warrior);
                    choiceboxAm.setOnAction(this::actionAm2);
                }

            }


   }
   public void Button6(Event event){

       String amélioration = choiceboxAm.getValue();
       switch (amélioration){
           case"Items":game.Items(d,Player,potion,lembas);break;
           case"Dégâts":Player.get(d).setruebolean();break;
           case"Resistances":game.Ressistance();break;
           case"Nombre de Flèche":game.upgrade(d,Player);break;
           case"Prix mana":game.upgrade(d,Player);break;

       }
       jo.clear();
       for (int i=0;i<Player.size();i++){if(!Player.get(i).getbolean()){jo.add(Player.get(i).getNom());}}
       choiceboxamèlioration.getItems().clear();
       choiceboxamèlioration.getItems().addAll(jo);
       button6.setVisible(false);
       choiceboxAm.setVisible(false);

       if(jo.size()==0){
           choiceboxPersonage.setDisable(false);
           choiceboxamèlioration.setVisible(false);
           choiceboxAm.setVisible(false);
           button6.setVisible(false);}




   }

   public void actionAm2(Event event){
       button6.setVisible(true);
   }




}

