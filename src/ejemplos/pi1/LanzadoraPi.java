package ejemplos.pi1;

import java.io.IOException;
import java.util.Vector;

import comunes.Ficheros;


public class LanzadoraPi {
	public static void main(String[] args) throws IOException {
		Vector<String> seleccionados=new Vector<>();
		for (int i=1; i<10000; i++) {
			if (contiene7(i) || multiplo7(i) || cifrasSuman7(i) || esCapicua(i)) {
				seleccionados.add(i + " Pi\n");
			} else
				seleccionados.add(i + " " + i + "\n");
		}
		
		System.out.println(seleccionados.toString());
		Ficheros.save("pi.txt", seleccionados, false);
	}

	private static boolean esCapicua(int n) {
		String s="" + n;
		if (s.length()==1)
			return false;
		int longitud=s.length();
		for (int i=0; i<longitud/2; i++) {
			char c1=s.charAt(i);
			char c2=s.charAt(longitud-i-1);
			if (c1!=c2)
				return false;
		}
		return true;
	}

	private static boolean cifrasSuman7(int n) {
		String s="" + n;
		int suma=0;
		for (int i=0; i<s.length(); i++) {
			String sN=""+s.charAt(i);
			suma=suma+Integer.parseInt(sN);
		}
		if (suma==7)
			return true;
		return false;
	}

	private static boolean multiplo7(int n) {
		return n%7==0;
	}

	private static boolean contiene7(int n) {
		String s="" + n;
		return s.indexOf("7")!=-1;
	}
}
