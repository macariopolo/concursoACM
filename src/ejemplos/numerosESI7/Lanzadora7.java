package ejemplos.numerosESI7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import comunes.Primos;
import comunes.Ficheros;

public class Lanzadora7 {
	static int MAX;

	public static void main(String[] args) throws IOException {
		FileOutputStream fos=Ficheros.crearFichero("numerosESI.txt");
		for (int i=2; i<=1000000; i++) {
			if (esNumeroESI(i)) {
				fos.write((""+i+"\n").getBytes());
			}
		}
		fos.close();
	}

	private static boolean esNumeroESI(int n) {
		Vector<Integer> factoresPrimos=Primos.descomponerEnFactoresPrimos(n);
		int sumaFactoresPrimos=0;
		for (int i=0; i<factoresPrimos.size(); i++) {
			sumaFactoresPrimos+=factoresPrimos.get(i);
		}
		
		String sN=""+n;
		int sumaNumeros=0;
		for (int i=0; i<sN.length(); i++) {
			char c=sN.charAt(i);
			int digito=Integer.parseInt(""+c);
			sumaNumeros+=digito;
		}
		return sumaFactoresPrimos==sumaNumeros;
	}

}
