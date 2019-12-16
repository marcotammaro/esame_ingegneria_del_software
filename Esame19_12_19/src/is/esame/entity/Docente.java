package is.esame.entity;

public class Docente {
	
//ATTRIBUTES
	
	private Corso corso;
	private String nome;
	
	
//COSTRUTTORE
	
	public Docente(Corso corso, String nome) {
		this.corso = corso;
		this.nome = nome;
	}
	
	public Docente(String nome) {
		this.corso = new Corso();
		this.nome = nome;
	}
	
	public Docente() {
		this.corso = null;
		this.nome = null;
	}
	
	
//CORSO
	
	public Corso getCorso() {
		return this.corso;
	}
	public void setCorso(Corso newCorso) {
		this.corso = newCorso;
	}
	

//NOME
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String newNome) {
		this.nome = newNome;
	}
	
	
//OPERATIONS:	
	public String toString() {
				
		StringBuffer buf = new StringBuffer();
				
		buf.append("DOCENTE: " + "\n");
		buf.append("Nome: " + this.nome + "\t\n");
		buf.append(this.corso + "\t");
			
		buf.append("\n\n");
		return buf.toString();
	}
	
	public boolean compareWith(Docente otherDocente) {
		
		if (this.nome == otherDocente.getNome()) {
			//facendo l'assunzione che non possano esistere due docenti con lo stesso nome
			return true;
		} else {
			return false;
		}
		
	}
}
