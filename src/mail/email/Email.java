/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.email;

import java.time.LocalDateTime;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author thenikel
 */
public class Email {

    private final IntegerProperty id ;
    private final StringProperty subject ;
    private final StringProperty sender ;
    private final StringProperty receiver ;
    private final StringProperty text ;
    private final LocalDateTime date;
    
    
   public Email(int id, String sender, String receiver, String subject, String text) {
       
       this.id = new SimpleIntegerProperty(id);
       this.sender = new SimpleStringProperty(sender);
       this.receiver = new SimpleStringProperty(receiver);
       this.subject = new SimpleStringProperty(subject);
       this.text = new SimpleStringProperty(text);
        
       this.date = LocalDateTime.now();
   }


    public String getReceiver() {
        return receiver.get();
    }

    public void setReceiver(String value) {
        receiver.set(value);
    }

    public StringProperty ReceiverProperty() {
        return receiver;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String value) {
        subject.set(value);
    }

    public StringProperty subjectProperty() {
        return subject;
    }
    

    public String getSender() {
        return sender.get();
    }

    public void setSender(String value) {
        sender.set(value);
    }

    public StringProperty senderProperty() {
        return sender;
    }
   

    public String getText() {
        return text.get();
    }

    public void setText(String value) {
        text.set(value);
    }

    public StringProperty TextProperty() {
        return text;
    }
   
   
    @Override
    public String toString() {
        return "Email{" + '}';
    }
}
