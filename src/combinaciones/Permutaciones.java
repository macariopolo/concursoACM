package combinaciones;

import java.util.Vector;

public class Permutaciones {
    public static void intercambiar(StringBuilder input, int i, int j) {
        String temp;
        temp = input.substring(i, i + 1);
        input.replace(i, i + 1, input.substring(j, j + 1));
        input.replace(j, j + 1, temp);
    }
 
    public static void getPermutacionesDeCadenas(Vector<Object> result, StringBuilder input, int i, int length) {
        if (i == length - 1) {
            result.add(input.toString());
        } else {
            for (int j = i; j < length; ++j) {
                intercambiar(input, i, j);
                getPermutacionesDeCadenas(result, input, i + 1, length);
                intercambiar(input, i, j);
            }
        }
    }
    
    public static void intercambiar(Vector objetos, int i, int j) {
        Object temp=objetos.get(i);
        objetos.set(i, objetos.get(j));
        objetos.set(j, temp);
    }

    public static void getPermutacionesDeObjetos(Vector<Object> result, Vector objetos, int i, int length) {
        if (i == length - 1) {
        	Vector nuevo=new Vector<>();
        	for (int k=0; k<objetos.size(); k++) nuevo.add(objetos.get(k));
            result.add(nuevo);
        } else {
            for (int j = i; j < length; ++j) {
                intercambiar(objetos, i, j);
                getPermutacionesDeObjetos(result, objetos, i + 1, length);
                intercambiar(objetos, i, j);
            }
        }
    }
}
