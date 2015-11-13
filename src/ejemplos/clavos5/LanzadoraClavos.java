package ejemplos.clavos5;

import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import comunes.Ficheros;

public class LanzadoraClavos {

	public static void main(String[] args) throws IOException {
		Vector<Clavo> clavos=new Vector<Clavo>();
		Vector<String> lineas=Ficheros.readLines(args[0]);
		int i=0;
		for (i=0; i<lineas.size(); i++) {
			String linea=lineas.get(i);
			String[] coordenadas=linea.split(",");
			int x=Integer.parseInt(coordenadas[0]);
			int y=Integer.parseInt(coordenadas[1]);
			Clavo clavo=new Clavo(x, y);
			clavos.add(clavo);
		}
		
		Vector<Clavo> seleccionados=new Vector<Clavo>();
		Vector<String> cadenasSeleccionadas = new Vector<>();
		for (i=0; i<clavos.size(); i++) {
			Clavo clavo=clavos.get(i);
			if (!estaRodeado(clavo, clavos, i)){
				seleccionados.add(clavo);
				cadenasSeleccionadas.add(clavo.toString());
			}
		}
		Collections.sort(clavos, new ComparadorClavos());
		System.out.println(seleccionados.toString());
		Ficheros.save("clavos.txt", cadenasSeleccionadas, false);
	}

	private static boolean estaRodeado(Clavo clavo, Vector<Clavo> clavos, int index) {
		for (int i=0; i<clavos.size(); i++) {
			Clavo c1=algunoALaIzquierdaArriba(clavo, clavos, index);
			Clavo c2=algunoALaIzquierdaAbajo(clavo, clavos, index);
			Clavo c3=algunoALaDerechaArriba(clavo, clavos, index);
			Clavo c4=algunoALaDerechaAbajo(clavo, clavos, index);
			boolean respuesta=c1!=null && c2!=null && c3!=null && c4!=null;
			if (respuesta)
				return true;
		}
		return false;
	}

	private static Clavo algunoALaIzquierdaArriba(Clavo clavo, Vector<Clavo> clavos, int index) {
		for (int i=0; i<clavos.size(); i++)
			if (i!=index)
				if (clavos.get(i).getX()<=clavo.getX() && clavos.get(i).getY()>=clavo.getY())
					return clavos.get(i);
		return null;
	}

	private static Clavo algunoALaIzquierdaAbajo(Clavo clavo, Vector<Clavo> clavos, int index) {
		for (int i=0; i<clavos.size(); i++)
			if (i!=index)
				if (clavos.get(i).getX()<=clavo.getX() && clavos.get(i).getY()<=clavo.getY())
					return clavos.get(i);
		return null;
	}
	
	private static Clavo algunoALaDerechaArriba(Clavo clavo, Vector<Clavo> clavos, int index) {
		for (int i=0; i<clavos.size(); i++)
			if (i!=index)
				if (clavos.get(i).getX()>=clavo.getX() && clavos.get(i).getY()>=clavo.getY())
					return clavos.get(i);
		return null;
	}
	
	private static Clavo algunoALaDerechaAbajo(Clavo clavo, Vector<Clavo> clavos, int index) {
		for (int i=0; i<clavos.size(); i++)
			if (i!=index)
				if (clavos.get(i).getX()>=clavo.getX() && clavos.get(i).getY()<=clavo.getY())
					return clavos.get(i);
		return null;
	}
}
