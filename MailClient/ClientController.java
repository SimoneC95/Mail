package Client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientController implements Initializable, Observer {


    @FXML
    private TextField receiver;
    @FXML
    private TextField sender;
    @FXML
    private TextField object;
    @FXML
    private TextField text;
    @FXML
    private Button send;

    //Apertura della socket del client
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            String nomeHost = InetAddress.getLocalHost().getHostName();
            Socket clientSocket = new Socket(nomeHost,9865);
            System.out.println("Ho aperto la socket");
            try {

                InputStream inStream = clientSocket.getInputStream();
                Scanner in = new Scanner(inStream);

                ObjectOutputStream outStream = new ObjectOutputStream(clientSocket.getOutputStream());

                System.out.println("Sto per ricevere dati dal socket server!");

                String line = in.nextLine();
                System.out.println(line);

                boolean done = false;
                outStream.writeObject(new Date());

                line = in.nextLine();
                System.out.println(line);
            } finally {
                clientSocket.close();
            }
            send.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                }
            });
        }catch (Exception e){
            System.out.println("ee"+e.getMessage());
        }
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
