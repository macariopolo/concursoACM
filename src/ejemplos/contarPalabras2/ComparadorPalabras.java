package ejemplos.contarPalabras2;

import java.util.Comparator;

public class ComparadorPalabras implements Comparator<Palabra> {

	@Override
	public int compare(Palabra a, Palabra b) {
		if (a.veces>b.veces)
			return -1;
		if (a.veces==b.veces)
			return a.texto.compareTo(b.texto);
		return 1;
	}

}
