package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import clases.Elemento.tiposElementos;

public class Archivo {
	
	public Baraja leerArchivo(String path) {
		Scanner sc = null;
		int cantDom = 0;
		ArrayList<Domino> dominos = null;
		
		try {
			sc = new Scanner(new File(path));
			cantDom=sc.nextInt();
			dominos=new ArrayList<Domino>();
			
			for(int i=0;i<cantDom;i++) {
				tiposElementos value = tiposElementos.valueOf(sc.next().toUpperCase());
				Elemento el1=new Elemento(value,sc.nextInt());
				value = tiposElementos.valueOf(sc.next().toUpperCase());
				Elemento el2=new Elemento(value,sc.nextInt());
				Domino d=new Domino(el1,el2);
				d.setNumero(i+1);
				dominos.add(d);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		sc.close();
		

		return new Baraja(cantDom,dominos);
	}
}