package is.esame.entity;

import java.util.ArrayList;

public class Appello {

//ATTRIBUTES
	
	private Corso corso;
	private ArrayList<DataAppello> dateAppelli;
	private ArrayList<Prenotazione> prenotazioni;
	
	
//COSTRUTTORE	
	
	public Appello(Corso corso, ArrayList<DataAppello> date ) {
		this.corso = corso;
		this.dateAppelli = date;
		this.prenotazioni = new ArrayList<Prenotazione>();
	}
	
	public Appello(Corso corso, DataAppello data ) {
		this.corso = corso;
		this.dateAppelli = new ArrayList<DataAppello>();
		this.prenotazioni = new ArrayList<Prenotazione>();
		
		this.dateAppelli.add(data);
	}
	
	/*
	public Appello() {
		this.corso = null;
		this.dateAppelli = new ArrayList<DataAppello>();
		this.prenotazioni = new ArrayList<Prenotazione>();
	}
	*/
	
	
//CORSO
	
	public Corso getCorso() {
		return this.corso;
	}
	public void setCorso(Corso newCorso) {
		this.corso = newCorso;
	}
	

//PRENOTAZIONI
		
	public void addPrenotazione(Prenotazione newPrenotazione) {
		this.prenotazioni.add(newPrenotazione);
	}
	public ArrayList<Prenotazione> getAllPrenotazioni() {
		return this.prenotazioni;
	}
	public Prenotazione removePrenotazione(int index) {
		return this.prenotazioni.remove(index);
	}
	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	
//DATE
	
	public void addData(DataAppello newData) {
		this.dateAppelli.add(newData);
	}
	public ArrayList<DataAppello> getAllDate() {
		return this.dateAppelli;
	}
	
	
	
//OPERATIONS:	
	
	public String toString() {
		
		StringBuffer buf = new StringBuffer();
		
		buf.append("APPELLI: " + "\n");
		
		for ( DataAppello item : this.dateAppelli ) {
			buf.append(item);
		}
		
		buf.append("\n\n");
		return buf.toString();
	}
	
}
