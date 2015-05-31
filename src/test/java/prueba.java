package test.java;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class prueba {

	public prueba() {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		if (1 == 1) {
			System.out.println("Correcto");
		}
		//fail("Not yet implemented");
	}

}
