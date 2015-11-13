package comunes;

import java.util.Vector;

public class Primos {
	
	public static Vector<Integer> getDivisores(int n) {
		Vector<Integer> result=new Vector<>();
		for (int i=2; i<=n; i++) {
			if (n%i==0)
				result.add(i);
		}
		return result;
	}

	public static Vector<Integer> descomponerEnFactoresPrimos(int n) {
		Vector<Integer> result = new Vector<>();
		int num = 2;

		while (n != 1) {
			while (n % num == 0) {
				result.add(num);
				n /= num;
			}
			num++;
		}
		return result;
	}

	public static boolean esPrimo(int n) {
		if (n < 2)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

}
