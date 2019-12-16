
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
		
		Docente docente = gestoreDati.creaDocente("R. Natella");
		Corso corso = gestoreDati.creaCorso("Ingegneria del Software", docente, 9);
		
		System.out.print(docente);
		
		
		
//CREAZIONE DI UN APPELLO RELATIVO AD UN CORSO
		
		LocalDate dataAppello1 = LocalDate.of(2019, Month.DECEMBER, 16);
		Luogo sedeEsame1 = Luogo.LABORATORIO;
		Prova tipoDiProva1 = Prova.CALCOLATORE;
		DataAppello data1 = new DataAppello(dataAppello1, sedeEsame1, tipoDiProva1);
		
		Appello appello = gestoreAppelli.creaAppello(corso, data1);
		
		LocalDate dataAppello2 = LocalDate.of(2019, Month.DECEMBER, 20);
		Luogo sedeEsame2 = Luogo.AULA;
		Prova tipoDiProva2 = Prova.ORALE;
		DataAppello data2 = new DataAppello(dataAppello2, sedeEsame2, tipoDiProva2);
		
		appello.addData(data2);
		
		
		System.out.print(corso);

		
//PRENOTAZIONE DI UNO STUDENTE AD UN APPELLO
		
		Studente studente1 = gestoreDati.creaStudente(12321, "N46000001");
		Studente studente2 = gestoreDati.creaStudente(34543, "N46000002");
		Studente studente3 = gestoreDati.creaStudente(56765, "N46000003");
		Studente studente4 = gestoreDati.creaStudente(78987, "N46000004");
		
		gestoreAppelli.prenotaAppello(appello, studente1);
		gestoreAppelli.prenotaAppello(appello, studente2);
		gestoreAppelli.prenotaAppello(appello, studente3);
		gestoreAppelli.prenotaAppello(appello, studente4);
		
		
		
//CONSULTAZIONE DEGLI STUDENTI PRENOTATI AD UN APPELLO
		
		gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);

		
	}

}
