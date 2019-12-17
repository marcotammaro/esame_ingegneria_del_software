package is.esame.control;

import java.util.ArrayList;
import is.esame.entity.*;
import is.esame.enumeration.*;

public class GestioneAppelli {
	
	
//ATTRIBUTES	
	private ArrayList<Appello> appelli;
	
	
//COSTRUTTORE
	
	public GestioneAppelli() {
		this.appelli = new ArrayList<Appello>();
	}
	
	
//OPERATIONS
	
	public Appello creaAppello(Corso corso, DataAppello data) {
		
		if (corso == null || corso.getNome() == "" || corso.getCfu() == 0) {return null;}
		
		Appello newAppello = new Appello(corso, data);
		
		appelli.add(newAppello);
		corso.addAppello(newAppello);
		
		return newAppello;
	}
	
	
	public void elencaAppelli() {
		for (Appello item : this.appelli) {
			 System.out.print(item);
		}
	}

	
	public ArrayList<Studente> visualizzaStudentiPrenotatiPerAppello(Appello appello) {
		
		ArrayList<Studente> studentiPrenotati = new ArrayList<Studente>();

		if (appello == null || appello.getCorso() == null) {return studentiPrenotati;}
		
		Corso corso = appello.getCorso();
		ArrayList<Prenotazione> prenotazioni = appello.getAllPrenotazioni();
		
		if (prenotazioni == null) {
			
			return studentiPrenotati;
			
		} else if (prenotazioni.isEmpty()) {
			
			System.out.print("\nNon sono presenti prenotazioni all'appello di " + corso.getNome());
			return studentiPrenotati;
			
		} else {
			
			System.out.print("\nGli studenti prenotati all'appello di " + corso.getNome() + " sono: \n");
			
			for (Prenotazione prenotazione : prenotazioni) {
				
				if (prenotazione != null) { 
					
					if (prenotazione.getStato() == StatoPrenotazione.PRENOTATO) {
						
						Studente studente = prenotazione.getStudente();
						
						if (studente != null && studente.getMatricola() != null) {
							
							studentiPrenotati.add(studente);
							System.out.print(studente);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		
		//controlla che l'array da ritornare non sia vuoto
		if (studentiPrenotati.isEmpty()) {
			System.out.print("\nNon sono presenti studenti prenotati");
		}
		
		return studentiPrenotati;
		
	}
	
	
	public Prenotazione prenotaAppello(Appello appello, Studente studente) {
		
		if (appello == null || studente == null) {return null;}
		
		Prenotazione prenotazione = new Prenotazione(StatoPrenotazione.PRENOTATO, studente);
		
		if (appelli.contains(appello)) {
			
			appello.addPrenotazione(prenotazione);
			
		} else {
			
			appello.addPrenotazione(prenotazione);
			appelli.add(appello);
			
		}
		
		return prenotazione;
		
	}

}
