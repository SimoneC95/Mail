package Server;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.io.*;
import java.net.*;
import java.util.*;

public class ServerController implements Initializable, Runnable, Observer {

    @FXML
    private TextArea log_area;

    @Override
    public void run() {
        System.out.println("Finestra del socket server");
        try {
            ServerSocket serverSocket = new ServerSocket(9865);
            System.out.println("LOG SERVER MAIL");
            addText("Waiting for client connection");

            while(true) {
                Socket client = serverSocket.accept();
                addText("Connection request accepted");
                try {
                    ObjectInputStream inStream = new ObjectInputStream(client.getInputStream());
                    OutputStream outStream = client.getOutputStream();

                    PrintWriter out = new PrintWriter(outStream, true );

                    out.println( "Hello! Waiting for data." );

                    try {
                        Date date = ((Date)inStream.readObject());
                        System.out.println("Echo: " + date.toString());
                        out.println("Echo: " + date.toString());
                    } catch (ClassNotFoundException e) {System.out.println(e.getMessage());}
                } finally {
                    serverSocket.close();
                }
            }
        }catch (Exception e){
            System.out.println("Chiusura server: "+e.getMessage());
        }finally {
        }
    }
    @FXML
    synchronized public void addText(String text){
        log_area.appendText(text);
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log_area.setText("SERVER AVVIATO \n");
        Thread thread = new Thread(this);
        thread.start();
    }

}
