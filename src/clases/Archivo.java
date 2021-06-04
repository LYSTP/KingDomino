package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
	
	public Baraja leerArchivo(String path) throws FileNotFoundException {
		Scanner sc=new Scanner(new File(path));
		
		int cantDom=sc.nextInt();
		ArrayList<Domino> dominos=new ArrayList<Domino>();
		
		for(int i=0;i<cantDom;i++) {
			Elemento el1=new Elemento(sc.next(),sc.nextInt());
			Elemento el2=new Elemento(sc.next(),sc.nextInt());
			Domino d=new Domino(el1,el2);
			d.setNumero(i+1);
			dominos.add(d);
		}
		sc.close();
		
		return new Baraja(cantDom,dominos);
	}
}
