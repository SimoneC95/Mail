/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.client.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mail.email.Email;
import mail.client.Main;

/**
 * FXML Controller class
 *
 * @author thenikel
 */
public class ClientViewController implements Initializable {
    
    //LogIn
    @FXML
    private AnchorPane anchorLogIn;
    @FXML
    private TextField textLogIn;
    @FXML
    private Button buttonLogIn;
    
    //Read Email Sender
    @FXML
    private AnchorPane anchorReceiver;
    
    @FXML
    private Button buttonWrite;
    @FXML
    private TableView<Email> tableViewSender;
    @FXML
    private TableColumn<Email,String> tableColumnSender;
    @FXML
    private TableColumn<Email,String> tableColumnObjectS;
    @FXML
    private TableColumn<Email,String> tableColumnDateS;
    
    //Read Email Receiver
    @FXML
    private TableView<Email> tableViewReceiver;
    @FXML
    private TableColumn<Email,String> tableColumnReceiver;
    @FXML
    private TableColumn<Email,String> tableColumnObjectR;
    @FXML
    private TableColumn<Email,String> tableColumnDateR;
    
    //Print Email
    @FXML
    private Button buttonReply;
    @FXML
    private Button buttonForward;
    @FXML
    private Button buttonDelete;
    @FXML
    private Label from;
    @FXML
    private Label to;
    @FXML
    private Label date;
    @FXML
    private Label subject;
    @FXML
    private TextArea text;
    
    //Print Email
    @FXML
    private AnchorPane anchorSend;
    @FXML
    private Label fromSend;
    @FXML
    private TextField toSend;
    @FXML
    private TextField subjectSend;
    @FXML
    private TextArea textSend;
    @FXML
    private Button buttonSend;
    
    
    @FXML
    public void buttonLogInEvent(ActionEvent event){
        try {
            anchorLogIn.setDisable(true);
            anchorLogIn.setOpacity(0);
            anchorReceiver.setDisable(false);
            anchorReceiver.setOpacity(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    public void buttonWriteEvent(ActionEvent event){
        try {
            anchorReceiver.setDisable(true);
            anchorReceiver.setOpacity(0);
            anchorSend.setDisable(false);
            anchorSend.setOpacity(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    public void buttonSendEvent(ActionEvent event){
        try {
            anchorSend.setDisable(true);
            anchorSend.setOpacity(0);
            anchorReceiver.setDisable(false);
            anchorReceiver.setOpacity(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        anchorLogIn.setDisable(false);
        anchorLogIn.setOpacity(1);
        anchorReceiver.setDisable(true);
        anchorReceiver.setOpacity(0);
        anchorSend.setDisable(true);
        anchorSend.setOpacity(0);
    }    
    
}
