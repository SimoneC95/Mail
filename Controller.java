package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends Main implements Initializable {

    @FXML
    private TextField TextFieldLogInId;
    @FXML
    private Button ButtonLogInId;
    @FXML
    private void ButtonLogIn(ActionEvent e){
        try {
            Stage stage = (Stage) ButtonLogInId.getScene().getWindow();
            stage.close();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Client.fxml"));
            Parent root1 = (Parent) Loader.load();
            Stage MailClient = new Stage();
            MailClient.setTitle("List Mail");
            MailClient.setScene(new Scene(root1));
            MailClient.sizeToScene();
            MailClient.show();
            System.out.println(TextFieldLogInId.getText());
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("");
    }


}
