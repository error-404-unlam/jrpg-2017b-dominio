package edu.unlam.wome.dominio.tests;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.wome.dominio.main.Asesino;
import edu.unlam.wome.dominio.main.Elfo;
import edu.unlam.wome.dominio.main.Guerrero;
import edu.unlam.wome.dominio.main.Hechicero;
import edu.unlam.wome.dominio.main.Humano;
import edu.unlam.wome.dominio.main.Orco;
import edu.unlam.wome.dominio.main.Personaje;

public class TestRefactoreoAtributos {

	/**
	 * Se verifica que la destreza del asesino
	 * es la correcta
	 */
	@Test
	public void testDestrezaAsesino() {
		Personaje p = new Humano("Ben Affleck", new Asesino(), 1);
		Assert.assertEquals(15, p.getDestreza());
	}

	/**
	 * Se verifica que la fuerza del guerrero
	 * es la correcta
	 */
	@Test
	public void testFuerzaGuerrero() {
		Personaje p = new Humano("Ben Affleck", new Guerrero(), 1);
		Assert.assertEquals(15, p.getFuerza());
	}

	/**
	 * Se verifica que la inteligencia del guerrero
	 * es la correcta
	 */
	@Test
	public void testInteligenciaHechicero() {
		Personaje p = new Humano("Ben Affleck", new Hechicero(), 1);
		Assert.assertEquals(15, p.getInteligencia());
	}

	/**
	 * Verifica que las habilidades de raza y casta
	 * sean las correctas.
	 */
	@Test
	public void testFullHumano() {
		Personaje p = new Humano("Ben Affleck", new Asesino(), 1);
		Personaje p1 = new Humano("Ben Affleck", new Hechicero(), 1);
		Personaje p2 = new Humano("Ben Affleck", new Guerrero(), 1);
		// Testeo que sin importar la casta, sigue teniendo la misma energia y
		// salud porque eso depende de la Raza
		Assert.assertEquals(105, p.getSaludTope());
		Assert.assertEquals(105, p.getEnergiaTope());
		Assert.assertEquals(105, p1.getSaludTope());
		Assert.assertEquals(105, p1.getEnergiaTope());
		String[] hCastaA = { "Golpe Critico", "Aumentar Evasion", "Robar" };
		String[] hCastaH = { "Bola de Fuego", "Curar Aliado", "Robar Energia y Salud" };
		String[] hCastaG = { "Ataque Doble", "Aumentar Defensa", "Ignorar Defensa" };
		String[] hRaza = { "Incentivar", "Golpe Fatal" };
		Assert.assertArrayEquals(hCastaA, p.getHabilidadesCasta());
		Assert.assertArrayEquals(hCastaH, p1.getHabilidadesCasta());
		Assert.assertArrayEquals(hCastaG, p2.getHabilidadesCasta());
		Assert.assertArrayEquals(hRaza, p.getHabilidadesRaza());

	}

	@Test
	public void testFullOrco() {
		Personaje p = new Orco("Ben Affleck", new Asesino(), 1);
		Personaje p1 = new Orco("Ben Affleck", new Hechicero(), 1);
		Personaje p2 = new Orco("Ben Affleck", new Guerrero(), 1);
		// Testeo que sin importar la casta, sigue teniendo la misma energia y
		// salud porque eso depende de la Raza
		Assert.assertEquals(110, p.getSaludTope());
		Assert.assertEquals(100, p.getEnergiaTope());
		Assert.assertEquals(110, p1.getSaludTope());
		Assert.assertEquals(100, p1.getEnergiaTope());
		String[] hCastaA = { "Golpe Critico", "Aumentar Evasion", "Robar" };
		String[] hCastaH = { "Bola de Fuego", "Curar Aliado", "Robar Energia y Salud" };
		String[] hCastaG = { "Ataque Doble", "Aumentar Defensa", "Ignorar Defensa" };
		String[] hRaza = { "Golpe Defensa", "Mordisco de Vida" };
		Assert.assertArrayEquals(hCastaA, p.getHabilidadesCasta());
		Assert.assertArrayEquals(hCastaH, p1.getHabilidadesCasta());
		Assert.assertArrayEquals(hCastaG, p2.getHabilidadesCasta());
		Assert.assertArrayEquals(hRaza, p.getHabilidadesRaza());
	}

	@Test
	public void testFullElfo() {
		Personaje p = new Elfo("Ben Affleck", new Asesino(), 1);
		Personaje p1 = new Elfo("Ben Affleck", new Hechicero(), 1);
		Personaje p2 = new Elfo("Ben Affleck", new Guerrero(), 1);
		// Testeo que sin importar la casta, sigue teniendo la misma energia y
		// salud porque eso depende de la Raza
		Assert.assertEquals(100, p.getSaludTope());
		Assert.assertEquals(110, p.getEnergiaTope());
		Assert.assertEquals(100, p1.getSaludTope());
		Assert.assertEquals(110, p1.getEnergiaTope());
		String[] hCastaA = { "Golpe Critico", "Aumentar Evasion", "Robar" };
		String[] hCastaH = { "Bola de Fuego", "Curar Aliado", "Robar Energia y Salud" };
		String[] hCastaG = { "Ataque Doble", "Aumentar Defensa", "Ignorar Defensa" };
		String[] hRaza = { "Golpe Level", "Ataque Bosque" };
		Assert.assertArrayEquals(hCastaA, p.getHabilidadesCasta());
		Assert.assertArrayEquals(hCastaH, p1.getHabilidadesCasta());
		Assert.assertArrayEquals(hCastaG, p2.getHabilidadesCasta());
		Assert.assertArrayEquals(hRaza, p.getHabilidadesRaza());
	}
}
