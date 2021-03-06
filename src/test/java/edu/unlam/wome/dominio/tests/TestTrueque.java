package edu.unlam.wome.dominio.tests;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.wome.dominio.main.Asesino;
import edu.unlam.wome.dominio.main.Humano;
import edu.unlam.wome.dominio.main.Item;
import edu.unlam.wome.dominio.main.Personaje;

public class TestTrueque {

	/**
	 * Se verifa que se saquen y coloquen los items
	 * correctos pertenecientes a las listas.
	 */
	@Test
	public void testTrueque() {
		Personaje p1 = new Humano("Ben Affleck", new Asesino(), 2);
		ArrayList<Item> aPoner = new ArrayList<Item>();
		DefaultListModel<String> aSacar = new DefaultListModel<String>();
		aSacar.addElement("NombreItem1");
		try {
			Item item1 = new Item(20, "NombreItem1", 0, 10, 0, 0, 0, 0, "foto1", "fotoE1");
			Item item3 = new Item(20, "NombreItem3", 0, 10, 0, 0, 0, 0, "foto3", "fotoE3");

			//Agregados a la Lista
			Item item5 = new Item(20, "NombreItem5", 0, 10, 0, 0, 0, 0, "foto5", "fotoE5");
			Item item6 = new Item(20, "NombreItem6", 0, 10, 0, 0, 0, 0, "foto6", "fotoE6");

			aPoner.add(item5);
			aPoner.add(item6);
			p1.anadirItem(new Item(20, "NombreItem1", 0, 10, 0, 0, 0, 0, "foto1", "fotoE1"));
			p1.anadirItem(new Item(20, "NombreItem2", 0, 10, 0, 0, 0, 0, "foto2", "fotoE2"));
			p1.anadirItem(item3);
			p1.anadirItem(new Item(20, "NombreItem4", 0, 10, 0, 0, 0, 0, "foto4", "fotoE4"));
			p1.trueque(p1.getItems(), aPoner, aSacar);
			Assert.assertTrue(p1.getItems().contains(item5));
			Assert.assertTrue(p1.getItems().contains(item6));
			Assert.assertTrue(p1.getItems().contains(item3));
			Assert.assertFalse(p1.getItems().contains(item1));

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falló");
		}

	}

	/**
	 * Verifica que le saco los items correspondientes,
	 * sin sacar items adicionales.
	 */
	@Test
	public void testTrueque2() {
		Personaje p1 = new Humano("Ben Affleck", new Asesino(), 2);

		ArrayList<Item> aPoner = new ArrayList<Item>();
		DefaultListModel<String> aSacar = new DefaultListModel<String>();
		aSacar.addElement("NombreItem1");
		aSacar.addElement("NombreItem3");
		try {
			Item item1 = new Item(20, "NombreItem1", 0, 10, 0, 0, 0, 0, "foto1", "fotoE1");
			Item item3 = new Item(20, "NombreItem3", 0, 10, 0, 0, 0, 0, "foto3", "fotoE3");

			Item item5 = new Item(20, "NombreItem5", 0, 10, 0, 0, 0, 0, "foto5", "fotoE5");

			aPoner.add(item5);
			p1.anadirItem(new Item(20, "NombreItem1", 0, 10, 0, 0, 0, 0, "foto1", "fotoE1"));
			p1.anadirItem(new Item(20, "NombreItem2", 0, 10, 0, 0, 0, 0, "foto2", "fotoE2"));
			p1.anadirItem(item3);
			p1.anadirItem(new Item(20, "NombreItem4", 0, 10, 0, 0, 0, 0, "foto4", "fotoE4"));
			p1.trueque(p1.getItems(), aPoner, aSacar);
			Assert.assertTrue(p1.getItems().contains(item5));
			Assert.assertFalse(p1.getItems().contains(item3));
			Assert.assertFalse(p1.getItems().contains(item1));

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falló");
		}

	}

}
