package ejemplos.numerosAltos3;

import java.io.IOException;
import java.util.Vector;

import combinaciones.Combinaciones;
import comunes.Ficheros;

public class LanzadoraNumerosAltos {
	public static void main(String[] args) throws IOException {
		Vector<String> lineas=Ficheros.readLines(args[0]);
		Combinaciones algorithm=new Combinaciones();
		int i=0;
		for (i=0; i<lineas.size(); i++) {
			String linea=lineas.get(i);
			String[] numeros=linea.split(" ");
			for (int j=0; j<numeros.length; j++) {
				String numero=numeros[j];
				for (int k=0; k<numero.length(); k++) {
					char n=numero.charAt(k);
					Object elemento=new Digito(n); 
				}
			}
		}
		
	}

}
