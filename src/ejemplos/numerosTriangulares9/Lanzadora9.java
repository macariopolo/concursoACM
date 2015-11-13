package ejemplos.numerosTriangulares9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import comunes.Ficheros;

public class Lanzadora9 {

	public static void main(String[] args) throws IOException {
		System.out.println(esTriangular(5));
		System.out.println(esTriangular(6));
		System.out.println(esTriangular(3));
		System.out.println(esTriangular(12));
		System.out.println(esTriangular(10));
		System.out.println(esTriangular(21));
		
		FileOutputStream fos = Ficheros.crearFichero("triangulares.txt");
		for (int i=1; i<=100; i++) {
			String cadena=getTriangulares(i) + "\n";
			fos.write(cadena.getBytes());
		}
		fos.close();
	}

	private static String getTriangulares(int n) {
		String result="";
		for (int i=0; i<=n; i++) {
			if (esTriangular(i)) {
				for (int j=0; j<=n; j++) {
					if (esTriangular(j)) {
						for (int k=0; k<=n; k++) {
							if (esTriangular(k)) {
								if (i+j+k==n) {
									Vector<Integer> r=new Vector<>();
									r.add(i); r.add(j); r.add(k);
									Collections.sort(r);
									return n + " = " + r.get(0) + " + " + r.get(1) + " + " + r.get(2);
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	private int siguienteTriangular(int n) {
		n=n+1;
		while (!esTriangular(n))
			n++;
		return n;
	}

	private static boolean esTriangular(int n) {
		if (n==0) return true;
		int suma=0;
		for (int i=0; i<=n; i++) {
			suma+=i;
			if (suma==n)
				return true;
		}
		return false;
	}
}
