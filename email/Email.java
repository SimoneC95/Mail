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
 * @author thenikel,
 */
public class Email {

    private IntegerProperty id;
    private StringProperty subject;
    private StringProperty sender;
    private StringProperty receiver;
    private StringProperty text;
    private LocalDateTime date;

    public Email(int id, String sender, String receiver, String subject, String text) {

        this.id = new SimpleIntegerProperty(id);
        this.sender = new SimpleStringProperty(sender);
        this.receiver = new SimpleStringProperty(receiver);
        this.subject = new SimpleStringProperty(subject);
        this.text = new SimpleStringProperty(text);
        this.date = LocalDateTime.now();
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

    public String getSender() {
        return sender.get();
    }

    public void setSender(String value) {
        sender.set(value);
    }

    public StringProperty senderProperty() {
        return sender;
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

    public String getSubject() {
        return subject.get();
    }

    public void setSubject(String value) {
        subject.set(value);
    }

    public StringProperty subjectProperty() {
        return subject;
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
    
    public LocalDateTime getTimeSendend(){
        return date;
    }
    
    @Override
    public String toString() {
        return "Email{"+getId()+getSender()+getReceiver()+getSubject()+getText()+getTimeSendend().toString()+'}';
    }
}
