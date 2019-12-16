package is.esame.entity;

import java.time.LocalDate;

import is.esame.enumeration.Luogo;
import is.esame.enumeration.Prova;

public class DataAppello {

//ATTRIBUTES
	
	private LocalDate data;
	private Luogo luogo;
	private Prova prova;
	

//COSTRUTTORE
	
	public DataAppello(LocalDate data, Luogo luogo, Prova prova) {
		this.data = data;
		this.luogo = luogo;
		this.prova = prova;
	}
	
	public DataAppello() {
		this.data = null;
		this.luogo = null;
		this.prova = null;
	}
	
	
//DATA 
		
	public LocalDate getData() {
		return this.data;
	}
	public void setData(LocalDate newData) {
		this.data = newData;
	}
		
		
//LUOGO	
		
	public Luogo getLuogo() {
		return this.luogo;
	}
	public void setLuogo(Luogo newLuogo) {
		this.luogo = newLuogo;
	}
		
		
//PROVA
		
	public Prova getProva() {
		return this.prova;
	}
	public void setProva(Prova newProva) {
		this.prova = newProva;
	}
	
	
//OPERATIONS:	
	
	public String toString() {
			
		StringBuffer buf = new StringBuffer();
			
		buf.append("DATA APPELLO: " + "\n");
		buf.append("Data: " + this.data + "\t");
		buf.append("Luogo: " + this.luogo + "\t");
		buf.append("Tipo di prova: " + this.prova + "\t");	
	
		buf.append("\n\n");
		return buf.toString();
	}
		
		
}
