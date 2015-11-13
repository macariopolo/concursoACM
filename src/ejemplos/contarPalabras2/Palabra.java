package ejemplos.contarPalabras2;

public class Palabra {
	String texto;
	int veces;
	
	@Override
	public String toString() {
		return texto + " " + veces + "\n";
	}
}
