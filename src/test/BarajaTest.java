package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

import clases.Archivo;
import clases.Baraja;
import clases.Domino;

public class BarajaTest {

	@Test
	public void testCrearBaraja() throws FileNotFoundException {
		Archivo a=new Archivo();
		
		Baraja b = a.leerArchivo("Archivo/Entrada/baraja.in");
		assertEquals(48, b.getSizeDominos());
	}

	@Test
	public void testMezclarBaraja() throws FileNotFoundException {
		Archivo a=new Archivo();
		
		Baraja b = a.leerArchivo("Archivo/Entrada/baraja.in");
		int numeroPrimerDomino = b.getMazo().get(0).getNumero();
		b.mezclar();
		assertNotEquals(numeroPrimerDomino, b.getMazo().get(0).getNumero());//podemos comparar todas las cartas
	}//puede pasar que justo te toca de nuevo la primera carta

	@Test
	public void testRepartirBaraja() throws FileNotFoundException {
		Archivo a=new Archivo();
		
		Baraja b = a.leerArchivo("Archivo/Entrada/baraja.in");
		List<Domino> l = b.repartir();
		assertEquals(4, l.size());//podemos probar 44 en dominos
	}
}
