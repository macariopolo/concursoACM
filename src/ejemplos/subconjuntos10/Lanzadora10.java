package ejemplos.subconjuntos10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import combinaciones.Permutaciones;
import comunes.Ficheros;

public class Lanzadora10 {
	public static void main(String[] args) throws IOException {
		String fileName=args[0];
		Vector<String> lineas = Ficheros.readLines(fileName);
		FileOutputStream fos = Ficheros.crearFichero("subconjuntos.txt");
		for (String linea : lineas) {
			String[] numeros=linea.split(",");
			String resultado=buscarSubconjunto(numeros);
			resultado="[" + resultado + "]";
			fos.write(resultado.getBytes());
		}
		fos.close();
	}

	private static String buscarSubconjunto(String[] sNumeros) {
		Vector<Integer> numeros=new Vector<>();
		for (String s : sNumeros)
			numeros.add(Integer.parseInt(s));
		Vector<Object> result=new Vector<>();
		Permutaciones.getPermutacionesDeObjetos(result, numeros, 0, numeros.size());
		Vector<Object> permutacionCandidata=new Vector<>();
		for (int i=0; i<result.size(); i++) {
			Vector<Object> permutacion=(Vector<Object>) result.get(i);
			int longitud=Integer.MAX_VALUE;
			for (int j=0; j<permutacion.size(); j++) {
				int suma=suma(permutacion, j);
				if (suma==0 && permutacion.size()<longitud) {
					permutacionCandidata=recortar(permutacion, j);
					longitud=permutacion.size();
				}
			}
		}
		return permutacionCandidata.toString();
	}

	private static Vector<Object> recortar(Vector<Object> permutacion, int index) {
		Vector<Object> result=new Vector();
		for(int i=index; i<permutacion.size(); i++)
			result.add(permutacion.get(i));
		return result;
	}

	private static int suma(Vector<Object> permutacion, int index) {
		int suma=0;
		for (int i=index; i<permutacion.size(); i++)
			suma+=Integer.parseInt(permutacion.get(i).toString());
		return suma;
	}
}
