package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ull.etsii.modelado.clasificador.herramientas.Aleatorio;


public class pruebaTests {

	public pruebaTests() {
	}

	@Before
	public void setUp() throws Exception { 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Aleatorio rand = new Aleatorio();
		rand.generarAleatorios(5);
		//fail("Not yet implemented");
	}

}
