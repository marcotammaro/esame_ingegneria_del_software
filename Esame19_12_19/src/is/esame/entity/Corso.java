package is.esame.entity;

import java.util.ArrayList;

public class Corso {

//ATTRIBUTES
	
	private String nome;
	private int cfu;
	private ArrayList<Appello> appelli;
	
	
//COSTRUTTORE
	
	public Corso(String nome, Docente docente, int cfu) {
		this.nome = nome;
		this.cfu = cfu;
		this.appelli = new ArrayList<Appello>();			
	}
	
	public Corso() {
		this.nome = null;
		this.cfu = 0;
		this.appelli = new ArrayList<Appello>();			
	}
	
	
//NOME
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String newNome) {
		this.nome = newNome;
	}
	
	
//CFU	
	
	public int getCfu() {
		return this.cfu;
	}
	public void setCfu(int newCfu) {
		this.cfu = newCfu;
	}
	
	
//APPELLI	
	
	public void addAppello(Appello newAppello) {
		this.appelli.add(newAppello);
	}
	public ArrayList<Appello> getAllAppelli() {
		return this.appelli;
	}
	public Appello removeAppello(int index) {
		return this.appelli.remove(index);
	}
	
	
//OPERATIONS:	
	public String toString() {
			
		StringBuffer buf = new StringBuffer();
			
		buf.append("CORSO: " + "\n");
		buf.append("Nome: " + this.nome + "\t");
		buf.append("CFU: " + this.cfu + "\t\n\n");
		
		for ( Appello item : this.appelli ) {
			buf.append(item);
		}
		
		buf.append("\n\n");
		return buf.toString();
	}
}
