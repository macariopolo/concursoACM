package ejemplos.contarPalabras2;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import comunes.Ficheros;

public class LanzadoraContarPalabras {
	private static Hashtable<String, Palabra> palabras;
	
	public static void main(String[] args) throws IOException {
		palabras=new Hashtable<>();
		Vector<String> lineas=Ficheros.readLines(args[0]);
		int i=0;
		for (i=0; i<lineas.size(); i++) {
			String linea=lineas.get(i);
			String[] palabras=linea.split(" ");
			for (int j=0; j<palabras.length; j++) {
				addPalabra(palabras[j]);
			}
		}
		
		Enumeration<Palabra> ePalabras=palabras.elements();
		Vector<Palabra> vPalabras=new Vector<>();
		while (ePalabras.hasMoreElements()) {
			Palabra sPalabra=ePalabras.nextElement();
			vPalabras.add(sPalabra);
		}
		Collections.sort(vPalabras, new ComparadorPalabras());
		Ficheros.save("contadorPalabras.txt", vPalabras, false);
	}

	private static void addPalabra(String texto) {
		String r="";
		for (int i=0; i<texto.length(); i++) {
			if (Character.isLetter(texto.charAt(i)))
				r=r+texto.charAt(i);
		}
		r=r.toLowerCase();
		Palabra p=palabras.get(r);
		if (p!=null)
			p.veces++;
		else {
			p=new Palabra();
			p.texto=r;
			p.veces=1;
		}
		palabras.put(r, p);
	}
}
