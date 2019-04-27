/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.client.model;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.synchronizedObservableList;
import mail.email.Email;


/**
 *
 * @author thenikel
 */
public class ClientModel {
    private ObservableList<Email> input;
    private ObservableList<Email> output;
    private ObjectProperty<Email> current = new SimpleObjectProperty<>(null);
    private String account;

    public ClientModel(String account) {
        this.account = account;
        this.input = FXCollections.observableArrayList((Email m) -> {
            return new javafx.beans.Observable[]{m.getDestinatarioP(), m.getOggettoP(), m.getDataP()};
            
        });
        
        output = synchronizedObservableList(FXCollections.observableArrayList((Email m) -> {
            return new javafx.beans.Observable[]{m.getMittenteP(), m.getOggettoP(), m.getDataP()};
        }));
        
    }
}
