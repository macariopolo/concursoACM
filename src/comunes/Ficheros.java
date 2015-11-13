package comunes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Ficheros {
	public static Vector<String> readLines(String fileName) throws IOException {
		FileInputStream fi=new FileInputStream(fileName);
		BufferedReader br=new BufferedReader(new InputStreamReader(fi));
		Vector<String> lineas=new Vector<String>();
		String linea=null;
		do {
			linea=br.readLine();
			if (linea!=null && linea.trim().length()>0)
				lineas.add(linea.trim());
		}
		while (linea!=null);
		fi.close();
		return lineas;
	}
	
	public static void save(String fileName, Vector seleccionados, boolean conSaltoDeLinea) throws IOException {
		FileOutputStream fos=new FileOutputStream(fileName);
		for (Object s : seleccionados) {
			fos.write(s.toString().getBytes());
			if (conSaltoDeLinea)
				fos.write("\n".getBytes());
		}
		fos.close();
	}

	public static FileOutputStream crearFichero(String fileName) throws FileNotFoundException {
		FileOutputStream fos=new FileOutputStream(fileName);
		return fos;
	}
}
