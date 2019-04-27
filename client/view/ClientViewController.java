/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.client.view;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
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
import java.util.*;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import mail.email.Email;
import mail.client.Main;

/**
 * FXML Controller class
 *
 * @author thenikel
 */
public class ClientViewController implements Initializable, Externalizable {

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
    private TableColumn<Email, String> tableColumnSender;
    @FXML
    private TableColumn<Email, String> tableColumnObjectS;
    @FXML
    private TableColumn<Email, String> tableColumnDateS;

    //Read Email Receiver
    @FXML
    private TableView<Email> tableViewReceiver;
    @FXML
    private TableColumn<Email, String> tableColumnReceiver;
    @FXML
    private TableColumn<Email, String> tableColumnObjectR;
    @FXML
    private TableColumn<Email, String> tableColumnDateR;

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

    private Socket clientSocket;

    @FXML
    public void buttonLogInEvent(ActionEvent event) {
        if (controlMail(textLogIn.getText()) == false) {
            errorAlert();
        } else {
            try {
                anchorLogIn.setDisable(true);
                anchorLogIn.setOpacity(0);
                anchorReceiver.setDisable(false);
                anchorReceiver.setOpacity(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @FXML
    public void buttonWriteEvent(ActionEvent event) {
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
    public void buttonSendEvent(ActionEvent event) {
        try {
            anchorSend.setDisable(true);
            anchorSend.setOpacity(0);
            anchorReceiver.setDisable(false);
            anchorReceiver.setOpacity(1);
            send.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    String s = getText_(fromSend);
                    String r = getText_(toSend);
                    String o = getText_(subjectSend);
                    String t = getText_(textSend);

                    ArrayList<String> input = new ArrayList<>(Arrays.asList(r.split(";")));
                    Email email = new Email(s, r, o, t);
                    try {
                        oStream.writeObject(email);
                        //model.addSended(email);
                    }catch(IOException e){
                        System.out.println("Error SEND"+e.getMessage());
                    }
                    System.out.println("handle2");


                    System.out.println(email.toString());
                    /*try {
                        writeMessages(email,"simo");
                    } catch (IOException e) {
                        System.out.println("error write"+e.getMessage());
                    }*/
                }
            });
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
        try {
            String nomeHost = InetAddress.getLocalHost().getHostName();
            clientSocket = new Socket(nomeHost, 9865);

            // Controllo Apertura
            System.out.println("Open SOCKET");
            InputStream iStream = clientSocket.getInputStream();
            Scanner in = new Scanner(iStream);
            ObjectOutputStream oStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean controlMail(String test) {
        boolean tot = false;
        if (test.equals("simo.cannizzo@gmail.com")
                || test.equals("niccolo.mondino@gmail.com")
                || test.equals("name95@gmail.com")) {
            tot = true;
        }
        return tot;
    }

    public void errorAlert() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error Email");
        error.setHeaderText(null);
        error.setContentText("You inserted a wrong mail");
        error.showAndWait();
    }
    public String getText_(TextField elem){
        String output= elem.getText();
        return  output ;
    }

}
