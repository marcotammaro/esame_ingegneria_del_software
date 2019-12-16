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
	static Corso corso = null;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		LocalDate dataAppello = LocalDate.of(2019, Month.DECEMBER, 20);
		Luogo sedeEsame = Luogo.AULA;
		Prova tipoDiProva = Prova.ORALE;
		
		data = new DataAppello(dataAppello, sedeEsame, tipoDiProva);
		
		Docente docente = new Docente("docente A");
		corso = new Corso("corsoA", docente, 9);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		data = null;
		corso = null;
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
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test2() {
		System.out.print("\n\n[TEST 02]");
		
		Appello appello = new Appello(corso, data);
		appello.setPrenotazioni(null);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test3() {
		System.out.print("\n\n[TEST 03]");
		
		Appello appello = new Appello(corso, data);
		appello.setPrenotazioni(new ArrayList<Prenotazione>());
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test4() {
		System.out.print("\n\n[TEST 04]");
		
		Appello appello = new Appello(corso, data);
		
		Prenotazione newPrenotazione = new Prenotazione(null, null);
		appello.addPrenotazione(newPrenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test5() {
		System.out.print("\n\n[TEST 05]");
		
		Appello appello = new Appello(corso, data);
		
		Studente studente = new Studente(1234, "N46003672");
		
		Prenotazione newPrenotazione = new Prenotazione(null, studente);
		appello.addPrenotazione(newPrenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test6() {
		System.out.print("\n\n[TEST 06]");
		
		Appello appello = new Appello(corso, data);
		
		Studente studente = new Studente(1234, "N46003672");
		
		Prenotazione newPrenotazione = new Prenotazione(StatoPrenotazione.PRENOTATO, studente);
		appello.addPrenotazione(newPrenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		
		assertTrue(result.contains(studente));
	}
	
	@Test
	public void test7() {
		System.out.print("\n\n[TEST 07]");
		
		Appello appello = new Appello(corso, data);
		
		Studente studente = new Studente(1234, "N46003672");
		
		Prenotazione newPrenotazione = new Prenotazione(StatoPrenotazione.PROMOSSO, studente);
		appello.addPrenotazione(newPrenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test8() {
		System.out.print("\n\n[TEST 08]");
		
		Appello appello = new Appello(corso, data);
		
		Studente studente = new Studente(1234, "N46003672");
		
		Prenotazione newPrenotazione = new Prenotazione(StatoPrenotazione.BOCCIATO, studente);
		appello.addPrenotazione(newPrenotazione);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void test9() {
		System.out.print("\n\n[TEST 09]");
		
		Appello appello = new Appello(corso, data);
		
		Studente studente1 = new Studente(1234, "N46000001");
		Studente studente2 = new Studente(5678, "N46000002");
		
		Prenotazione newPrenotazione1 = new Prenotazione(StatoPrenotazione.PRENOTATO, studente1);
		Prenotazione newPrenotazione2 = new Prenotazione(StatoPrenotazione.PRENOTATO, studente2);
		
		appello.addPrenotazione(newPrenotazione1);
		appello.addPrenotazione(newPrenotazione2);
		
		ArrayList<Studente> result = gestoreAppelli.visualizzaStudentiPrenotatiPerAppello(appello);
		System.out.print("\n\t -> [RESULT]: " + result + "\n");
		
		boolean result1 = result.contains(studente1);
		boolean result2 = result.contains(studente2);
		
		assertTrue(result1 && result2);
	}
	

}
