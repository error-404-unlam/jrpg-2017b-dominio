package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.Alianza;
import dominio.Asesino;
import dominio.Guerrero;
import dominio.Humano;
import dominio.MyRandomStub;

public class TestAliarCombatir {

	@Test
	public void testCrearAlianza() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 1);

		Assert.assertNull(h.getClan());
		Assert.assertNull(h2.getClan());
		h.aliar(h2);
		Assert.assertNotNull(h.getClan());
		Assert.assertNotNull(h2.getClan());
	}
	

	@Test
	public void testDaniar() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Asesino(), 1);
		h.setRandom(new MyRandomStub(0.49, 3));
		h2.setRandom(new MyRandomStub(0.49, 3));
		Assert.assertTrue(h2.getSalud() == 105);
		if (h.atacar(h2) != 0)
			Assert.assertTrue(h2.getSalud() < 105);
		else
			Assert.assertTrue(h2.getSalud() == 105);
	}

	@Test
	public void testAliar() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Humano h2 = new Humano("Lautaro", new Guerrero(), 1);
		Alianza a1 = new Alianza("Los CacheFC");
		h.setRandom(new MyRandomStub(0.49, 3));
		h2.setRandom(new MyRandomStub(0.49, 3));
		Assert.assertNull(h2.getClan());
		Assert.assertNull(h.getClan());
		h.setClan(a1);
		Assert.assertNotNull(h.getClan());
		h.aliar(h2);
		Assert.assertTrue(h.getClan() == h2.getClan());
	}

}
