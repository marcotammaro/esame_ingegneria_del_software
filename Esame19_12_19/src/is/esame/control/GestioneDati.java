package is.esame.control;

import is.esame.entity.*;
import java.util.ArrayList;


public class GestioneDati {
	
	
//ATTRIBUTES
	
	public ArrayList<Docente> docenti;
	public ArrayList<Studente> studenti;
	
	
//COSTRUTTORE
	
	public GestioneDati(){
		this.docenti = new ArrayList<Docente>();
		this.studenti = new ArrayList<Studente>();
	}
    
    
//OPERATIONS:
    
	public void addSampleData() {
		
		//creazione di dati esempio
		
		creaStudente(1234, "N46003672");
		creaStudente(5678, "N46003591");
		creaStudente(9012, "N46003611");
		creaStudente(3456, "N46004567");
		
		Docente docenteA = creaDocente("Docente A");
		Docente docenteB = creaDocente("Docente B");
		Docente docenteC = creaDocente("Docente C");
		Docente docenteD = creaDocente("Docente D");
		
		creaCorso("Ingegneria Del Software", docenteA, 9);
		creaCorso("Sistemi Operativi", docenteB, 9);
		creaCorso("Analisi II", docenteC, 6);
		creaCorso("Laboratorio Di Misure", docenteD, 3);
	}
    
	public Corso creaCorso(String nome, Docente docente, int cfu) {
		
		if (nome == null || nome == "" || docente == null || cfu == 0) {return null;}
		
		Corso newCorso = new Corso(nome, docente, cfu);
		
		if (docenti.contains(docente)) {
			for (Docente item : docenti) {
				if (item.compareWith(docente)) {
					item.setCorso(newCorso);
				}
			}
		} else {
			Docente newDocente = creaDocente(docente.getNome());
			newDocente.setCorso(newCorso);
		}
		
		
		return newCorso;
	}
	
	public Studente creaStudente(int pin, String matricola) {
		
		if (pin == 0 || matricola == "" || matricola == null) {return null;}
		
		Studente newStudente = new Studente(pin, matricola);
		studenti.add(newStudente);
		return newStudente;
	}
	
	public Docente creaDocente(String nome) {
		
		if (nome == "" || nome == null) {return null;}
		
		Docente newDocente = new Docente(nome);
		docenti.add(newDocente);
		return newDocente;
	}

}
