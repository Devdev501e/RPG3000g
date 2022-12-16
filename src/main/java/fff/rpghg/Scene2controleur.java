package fff.rpghg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projetrpg3000.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Scene2controleur implements Initializable {
    int i;
    ArrayList<Hero> player = new ArrayList<>();
    @FXML
    public Label myLabel;
    @FXML
    Label namelabel1;
    @FXML
    Label namelabel2;
    @FXML
    Label namelabel3;
    @FXML
    public ChoiceBox<String> myChoiceBox2;
    @FXML
    public TextField NOMCL;
    String nom;
    public String[] NP2 = {"Healer", "Hunter", "Warrior", "Mage"};
    String classe;
    Stage stage;
    Scene scene;
    Parent root;

    Game game;


    public int displaunumber(String number) {
        //bouton de validation du nombre
         i = Integer.parseInt(number);

        namelabel1.setText("Tu as choisi " + number + " joueurs "+"\nChoisissez maintenant la classe de vos personages");
        System.out.println(i);

        return i;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox2.getItems().addAll(NP2);//chose box
        myChoiceBox2.setOnAction(this::actionsekection);

    }

    private void actionsekection(ActionEvent event) {
        classe = myChoiceBox2.getValue();
        switch (classe){
            case "Hunter":myLabel.setText("Vous allez choisir Hunter");break;
            case "Warrior": myLabel.setText("Vous allez choisir Warrior");break;
            case "Healer":myLabel.setText("Vous allez choisir Healer");break;
            case "Mage": myLabel.setText("Vous allez choisir Mage");break;

        }


    }
    public void Button2(ActionEvent event) throws IOException {

        nom= NOMCL.getText().trim();
        NOMCL.clear();
        if (player.size() == i ) {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene3.fxml"));
            root= loader.load();
            Scene3controleur scene3controleur=loader.getController();
            scene3controleur.displaliste(player);
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();




    } else if (nom.equals("")) {
            namelabel3.setText("choisisez un nom!");
        } else if  (player.size() != i && !classe.equals("")) {
        switch (classe){
            case "Hunter": Hunter hunter=new Hunter(57,1,1,10,null,false);hunter.setNom(nom);player.add(hunter);break;
            case "Warrior": Warrior warrior=new Warrior(98,1,10,null,false);warrior.setNom(nom);player.add(warrior); break;
            case "Healer": Healer healer=new Healer(65,1,10,1,10,null,false);healer.setNom(nom);player.add(healer);break;
            case "Mage": Mage mage =new Mage(60,1,10,1,1,null,false);mage.setNom(nom);player.add(mage);break;
        }
        }namelabel2.setText("Vous avez "+player.size()+" joueurs choisi");
        System.out.println(player.get(0).getNom());
         myChoiceBox2.setValue("");
    }
    public void retour(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


}



