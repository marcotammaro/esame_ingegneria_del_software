package is.esame.test;

import static org.junit.Assert.*;

import is.esame.control.*;
import is.esame.entity.*;
import is.esame.enumeration.Luogo;
import is.esame.enumeration.Prova;
import is.esame.enumeration.StatoPrenotazione;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestVisualizzaStudentiPrenotatiPerAppello {
	
	
	GestioneAppelli gestoreAppelli = null;
	static DataAppello data = null;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		LocalDate dataAppello = LocalDate.of(2019, Month.DECEMBER, 20);
		Luogo sedeEsame = Luogo.AULA;
		Prova tipoDiProva = Prova.ORALE;
		
		data = new DataAppello(dataAppello, sedeEsame, tipoDiProva);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		data = null;
	}

	@Before
	public void setUp() throws Exception {
		gestoreAppelli = new GestioneAppelli();
	}

	@After
	public void tearDown() throws Exception {
		gestoreAppelli = null;
	}

	
	@Test
	public void test1() {
		System.out.print("\n\n[TEST 01]");
		Appello appello = null;
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertNull(result);
	}
	
	@Test
	public void test2() {
		System.out.print("\n\n[TEST 02]");
		Appello appello = new Appello();
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertNull(result);
	}
	
	@Test
	public void test3() {
		System.out.print("\n\n[TEST 03]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(null);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test4() {
		System.out.print("\n\n[TEST 04]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		Prenotazione prenotazione = new Prenotazione();
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test5() {
		System.out.print("\n\n[TEST 05]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setStato(null);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test6() {
		System.out.print("\n\n[TEST 06]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setStato(StatoPrenotazione.PROMOSSO);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test7() {
		System.out.print("\n\n[TEST 07]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setStato(StatoPrenotazione.BOCCIATO);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test8() {
		System.out.print("\n\n[TEST 08]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		Studente studente = null;
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setStato(StatoPrenotazione.PRENOTATO);
		prenotazione.setStudente(studente);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test9() {
		System.out.print("\n\n[TEST 09]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		Studente studente = new Studente(1234, "N46003672");
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setStato(StatoPrenotazione.PRENOTATO);
		prenotazione.setStudente(studente);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.contains(studente));
	}
	
	@Test
	public void test10() {
		System.out.print("\n\n[TEST 10]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		Studente studente = new Studente();
		
		Prenotazione prenotazione = new Prenotazione();
		prenotazione.setStato(StatoPrenotazione.PRENOTATO);
		prenotazione.setStudente(studente);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test11() {
		System.out.print("\n\n[TEST 11]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		
		Studente studente1 = new Studente(1234, "N46003672");
		Prenotazione prenotazione1 = new Prenotazione();
		prenotazione1.setStato(StatoPrenotazione.PRENOTATO);
		prenotazione1.setStudente(studente1);
		
		Studente studente2 = new Studente(5678, "N46003673");
		Prenotazione prenotazione2 = new Prenotazione();
		prenotazione2.setStato(StatoPrenotazione.PRENOTATO);
		prenotazione2.setStudente(studente2);
		
		Appello appello = new Appello(corso, data);
		appello.addPrenotazione(prenotazione1);
		appello.addPrenotazione(prenotazione2);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		boolean result1 = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello).contains(studente1);
		boolean result2 = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello).contains(studente2);
		
		assertTrue(result1 && result2);
	}
	
	@Test
	public void test12() {
		System.out.print("\n\n[TEST 12]");
		
		Docente docente = new Docente("docente A");
		Corso corso = new Corso("corsoA", docente, 9);
		
		Appello appello = new Appello(corso, data);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	
	
	

}
