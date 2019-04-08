import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 *  I messaggi di posta elettronica sono
	istanze di una classe Email che specifica ID, mittente, destinatario/i,
	argomento, testo e data di spedizione del messaggio.
 * 
 */

public class Email {
	
	//OGNI VARIABILE VA DICHIARATA CON @FXML E VA RIFERITA DAL FXML STESSO
	
	private int local_ID = 0; //se faccio così creo id locale ne voglio uno globale
	private String sender;
	private String receiver;
	private String title;
	private String text;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private LocalDateTime spedition_date;
	private boolean sended; //bozza
	
	public Email(String sender) {
		this.local_ID += 1;
		this.spedition_date = LocalDateTime.now();
		this.sender = sender;
		this.sended = false; 
	}
	
	protected void setText(String text) {
		try {
			this.text = text;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected void setTitle(String title) {
		try {
			this.title = title;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected void setReceiver(String receiver) {
		try {
			this.receiver = receiver;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	protected boolean getSended() {
		return this.sended;
	}
	
	protected void sended() {
		try {
			this.sended = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
