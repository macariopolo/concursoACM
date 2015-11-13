package combinaciones;

import java.util.Vector;

public class Combination {
	private Vector<Integer> positions;
	private Vector<Object> values;
	
	public Combination() {
		positions=new Vector<>();
		values=new Vector<>();
	}

	public int size() {
		return values.size();
	}

	public void setValuePosition(int index, int elementPosition) {
		this.positions.set(index, elementPosition);
	}

	public void setValue(int index, Object element) {
		this.values.set(index, element);
	}
}
