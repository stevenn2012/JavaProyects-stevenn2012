package co.edu.usa.adf.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JuegoDeTenisTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void deberiaCantarSirveNatiSiJuegoCeroCero() {
		JuegoDeTenis juego = new JuegoDeTenis("Nati", "Danilo");
		String respuesta=juego.cantar();
		assertEquals("Sirve Nati", respuesta);
	}
}
