package combinaciones;

import java.util.Vector;

public class Set {
	private Vector<Object> elements;
	
	public Set() {
		elements=new Vector<>();
	}
	
	public void add(Object element) {
		elements.add(element);
	}
	
	public int size() {
		return elements.size();
	}

	public Object get(int index) {
		return elements.get(index);
	}

}
