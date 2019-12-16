
import is.esame.control.*;
import is.esame.entity.*;
import is.esame.enumeration.*;

import java.time.LocalDate;
import java.time.Month;

public class Main {

	public static void main(String[] args) {
		
		GestioneAppelli gestoreAppelli = new GestioneAppelli();
		GestioneDati gestoreDati = new GestioneDati();

		
		
//CREAZIONE DI UN CORSO
		
		Docente docente1 = gestoreDati.creaDocente("Luca Maresca");
		Corso corso = gestoreDati.creaCorso("Basi di Dati", docente1, 9);
		
		System.out.print(docente1);
		
		
		
//CREAZIONE DI UN APPELLO RELATIVO AD UN CORSO
		
		LocalDate dataAppello0 = LocalDate.of(2019, Month.DECEMBER, 16);
		Luogo sedeEsame0 = Luogo.LABORATORIO;
		Prova tipoDiProva0 = Prova.CALCOLATORE;
		DataAppello data0 = new DataAppello(dataAppello0, sedeEsame0, tipoDiProva0);
		
		Appello appello = gestoreAppelli.creaAppello(corso, data0);
		
		LocalDate dataAppello1 = LocalDate.of(2019, Month.DECEMBER, 20);
		Luogo sedeEsame1 = Luogo.AULA;
		Prova tipoDiProva1 = Prova.ORALE;
		DataAppello data1 = new DataAppello(dataAppello1, sedeEsame1, tipoDiProva1);
		
		appello.addData(data1);
		
		System.out.print(corso);

		
//PRENOTAZIONE DI UNO STUDENTE AD UN APPELLO
		
		Studente studente1 = gestoreDati.creaStudente(12321, "N46000001");
		gestoreAppelli.prenotaAppello(appello, studente1);
		
		Studente studente2 = gestoreDati.creaStudente(98789, "N46000002");
		gestoreAppelli.prenotaAppello(appello, studente2);
		
		Studente studente3 = gestoreDati.creaStudente(56765, "N46000003");
		gestoreAppelli.prenotaAppello(appello, studente3);
		
		Studente studente4 = gestoreDati.creaStudente(99999, "N46000004");
		gestoreAppelli.prenotaAppello(appello, studente4);
		
		
		
//CONSULTAZIONE DEGLI STUDENTI PRENOTATI AD UN APPELLO
		
		gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);

		
	}

}
