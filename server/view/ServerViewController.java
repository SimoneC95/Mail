/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.server.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import mail.server.model.ServerModel;
import mail.email.Email;

/**
 * FXML Controller class
 *
 * @author thenikel
 */
public class ServerViewController implements Initializable, Observer, Runnable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ListView<String> listViewArea;

    private ServerModel model;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private ServerSocket serverSocket;

    //private ListN<String> listNNormal = new ArrayListN<String>();
    @Override
    public void run() {

        model.addString("Finestra del socket server");
        //listNViewArea.setItems().addAll(listN);
        try {
            serverSocket = new ServerSocket(9865);
            model.addString("LOG SERVER MAIL");
            model.addString("Waiting for client connection");

            while (true) {
                Socket client = serverSocket.accept();
                model.addString("Connection request accepted");
                try {
                    in = new ObjectInputStream(client.getInputStream());
                    out = new ObjectOutputStream(client.getOutputStream());
                    /*try {
                        Email m = ((Email)in.readObject());
                        writeMessages(m,m.getSender());   
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }*/
                } catch (IOException e) {
                    model.addString(e.getMessage());
                } finally {
                    client.close();
                }

            }

        } catch (IOException e) {
            model.addString(e.getMessage());
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                model.addString(e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new ServerModel();
        model.addString("SERVER AVVIATO");
        listViewArea.setItems(model.getLogList());
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void update(Observable observable, Object o) {
    }
    /*public void writeMessages(Email m, String name) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        PrintWriter csvMessages;
        String nameMessagges = m.getSender().concat("messages.csv");
        csvMessages = new PrintWriter(new FileWriter(nameMessagges, true));
        PrintWriter csvLogFile;
        csvLogFile = new PrintWriter(new FileWriter("logFile.csv", true));

        //gestione file messaggi
        sb.append(m.sender);
        sb.append(',');
        sb.append(m.receiver);
        sb.append(',');
        sb.append(m.object);
        sb.append(',');
        sb.append(m.text);
        sb.append(',');
        sb.append(m.creation_date.toString());
        sb.append(',');
        if (m.spedition_date != null)
            sb.append(m.spedition_date.toString());
        sb.append(',');
        sb.append(m.sended);
        sb.append('\n');

        //gestione logfile
        sb2.append(m.sender);
        sb2.append(',');
        if(!m.sended) {
            sb2.append("ACTION: created a message in draft");
            sb2.append(',');
            sb2.append(m.creation_date.toString());
            sb2.append('\n');
        } else {
            sb2.append("ACTION: sended a message");
            sb2.append(',');
            sb2.append(m.spedition_date.toString());
            sb2.append('\n');
        }

        csvLogFile.write(sb2.toString());
        csvMessages.write(sb.toString());
        csvLogFile.flush();
        csvMessages.flush();
        csvLogFile.close();
        csvMessages.close();
    }*/

}
