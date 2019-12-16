package is.esame.entity;

import is.esame.enumeration.*;

public class Prenotazione {
	

//ATTRIBUTES
	
	private StatoPrenotazione stato;
	private Studente studente;
	
	
//COSTRUTTORE
	
	public Prenotazione(StatoPrenotazione stato, Studente studente) {
		this.stato = stato;
		this.studente = studente;
	}
	
	public Prenotazione() {
		this.stato = null;
		this.studente = null;
	}

	
//STATO
		
	public StatoPrenotazione getStato() {
		return this.stato;
	}
	public void setStato(StatoPrenotazione newStato) {
		this.stato = newStato;
	}
	
	
//STUDENTE
	
	public Studente getStudente() {
		return this.studente;
	}
	public void setStudente(Studente newStudente) {
		this.studente = newStudente;
	}
	
	
//OPERATIONS:	
	
	public String toString() {
			
		StringBuffer buf = new StringBuffer();
			
		buf.append("PRENOTAZIONE: " + "\n");
		buf.append("Stato: " + this.stato + "\t");
		buf.append("Studente: " + this.studente + "\t");
			
		buf.append("\n\n");
		return buf.toString();
	}
	
}
