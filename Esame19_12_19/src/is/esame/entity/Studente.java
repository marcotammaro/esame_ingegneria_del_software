package is.esame.entity;

//import java.util.ArrayList;

public class Studente {
		
//ATTRIBUTES
	
	private int pin;
	private String matricola;
	
	
//COSTRUTTORE
	
	public Studente(int pin, String matricola) {
		this.pin = pin;
		this.matricola = matricola;
	}
	
	public Studente() {
		this.pin = 0;
		this.matricola = null;
	}
	
	
//PIN 
	
	public int getPin() { 
		return this.pin; 
	}
	public void setPin(int pin) { 
		this.pin = pin; 
	}
	
	
//NOME
	
	public String getMatricola() {
		return this.matricola;
	}
	public void setMatricola(String newMatricola) {
		this.matricola = newMatricola;
	}
	
	
//OPERATIONS:	
	public String toString() {
					
		StringBuffer buf = new StringBuffer();
				
		buf.append("STUDENTE: " + "\n");
		buf.append("Matricola: " + this.matricola + "\t");
		buf.append("Pin: " + this.pin + "\t");
				
		buf.append("\n\n");
		return buf.toString();
	}
	

}
