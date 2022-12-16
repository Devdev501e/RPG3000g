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

import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class scene1controlleur implements Initializable {
       Scene scene;
       Stage stage;
       Scanner SC = new Scanner(System.in);
       Parent root;

    String MYnumber;  // nombre de joueur choisi.


      public void swichToScene2(ActionEvent event) throws IOException {
          String number = MYnumber;
          if (MYnumber!=null){
           FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
           root=loader.load();
           Scene2controleur scene2controleur=loader.getController();
           scene2controleur.displaunumber(number);
           stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
           scene = new Scene(root);
           scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

           stage.setScene(scene);
           stage.show();}
      }

    @FXML
    public Label myLabel;
    @FXML
    public ChoiceBox<String> myChoiceBox;
    public String[] NP ={"1","2","3","4"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(NP);//chose box
        myChoiceBox.setOnAction(this::getnumber);
    }
    public void getnumber(ActionEvent event){
         MYnumber=myChoiceBox.getValue();
        switch (MYnumber){
            case "1": myLabel.setText("Vous avez choisi un joueur");break;
            case "2": myLabel.setText("Vous avez choisi deux joueur");break;
            case "3": myLabel.setText("Vous avez choisi trois joueur");break;
            case "4": myLabel.setText("Vous avez choisi quatre joueur");break;

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


