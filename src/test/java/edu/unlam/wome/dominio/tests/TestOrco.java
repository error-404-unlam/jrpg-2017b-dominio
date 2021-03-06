package edu.unlam.wome.dominio.tests;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.wome.dominio.main.Asesino;
import edu.unlam.wome.dominio.main.Guerrero;
import edu.unlam.wome.dominio.main.Hechicero;
import edu.unlam.wome.dominio.main.Humano;
import edu.unlam.wome.dominio.main.MyRandomStub;
import edu.unlam.wome.dominio.main.Orco;

public class TestOrco {

	/**
	 * Verifica que la habilidad "golpe defensivo"
	 * del Orco, funciona correctamente
	 */
	@Test
	public void testGolpeDefensivo() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Orco o = new Orco("Hernan", new Guerrero(), 1);
		h.setRandom(new MyRandomStub(0.49, 3));
		o.setRandom(new MyRandomStub(0.49, 3));
		Assert.assertTrue(h.getSalud() == 105);
		if (o.habilidadRaza1(h))
			Assert.assertTrue(h.getSalud() == 95);
		else
			Assert.assertTrue(o.getSalud() == 105);
	}

	/**
	 * Verifica que la habilidad "Mordisco de Vida"
	 * del Orgo, debilita al enemigo
	 */
	@Test
	public void testMordiscoDeVida() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		h.setRandom(new MyRandomStub(0.49, 3));
		o.setRandom(new MyRandomStub(0.49, 3));

		Assert.assertTrue(h.getSalud() == 100);
		if (o.habilidadRaza2(h)) {
			Assert.assertEquals(40, h.getSalud());
			Assert.assertTrue(o.getSalud() == 100);
		} else {
			Assert.assertTrue(o.getSalud() == 100);
			Assert.assertTrue(h.getSalud() == 100);
		}
	}
}
