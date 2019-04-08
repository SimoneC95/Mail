package Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.*;

public class ClientController_Login implements Observer {

    @FXML
    private TextField TextFieldLogInId;
    @FXML
    private Button ButtonLogInId;


    //Login iniziale
    @FXML
    private void ButtonLogIn(ActionEvent e){
        try {
            Stage stage = (Stage) ButtonLogInId.getScene().getWindow();
            stage.close();
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("Client.fxml"));
            Parent root1 = (Parent) Loader.load();
            Stage MailClient = new Stage();
            MailClient.setTitle(TextFieldLogInId.getText());
            MailClient.setScene(new Scene(root1));
            MailClient.sizeToScene();
            MailClient.show();
            System.out.println(TextFieldLogInId.getText());
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
