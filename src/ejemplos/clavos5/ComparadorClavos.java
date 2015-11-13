package ejemplos.clavos5;

import java.util.Comparator;

public class ComparadorClavos implements Comparator<Clavo> {

	@Override
	public int compare(Clavo a, Clavo b) {
		if (a.getX()<b.getY())
			return -1;
		if (a.getX()==b.getY())
			if (a.getY()==b.getY())
				return -1;
			else
				return 1;
		return 1;
	}

}
