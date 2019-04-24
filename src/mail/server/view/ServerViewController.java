/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.server.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import mail.email.Email;

/**
 * FXML Controller class
 *
 * @author thenikel
 */
public class ServerViewController implements Initializable,Observer,Runnable {

    /**
     * Initializes the controller class.
     */
     
    @FXML
    private ListView listViewArea;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    @Override
    public void run() {
        System.out.println("Finestra del socket server");
        try {
            ServerSocket serverSocket = new ServerSocket(9865);
            System.out.println("LOG SERVER MAIL");
            System.out.println("Waiting for client connection");

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Connection request accepted");
                try {
                    in = new ObjectInputStream(client.getInputStream());
                    out = new ObjectOutputStream(client.getOutputStream());
                    //Email m = ((Email)in.readObject());
                    //writeMessages(m,m.sender);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("SERVER AVVIATO \n");
        Thread thread = new Thread(this);
        thread.start();
    }  

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
