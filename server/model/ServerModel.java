/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.server.model;

/**
 *
 * @author thenikel
 */
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Observable;

public class ServerModel extends Observable {
    
    private String currentString;
    private ObservableList<String> logList;
    
    public ServerModel(){
        logList = FXCollections.observableArrayList();
        currentString = null;
    }
    
    public void addString(String a){
        logList.add(a);
    }
    
    public ObservableList<String> getLogList(){
        return this.logList;
    }

}


