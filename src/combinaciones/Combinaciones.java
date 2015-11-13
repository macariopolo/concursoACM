package combinaciones;

import java.util.Vector;

public class Combinaciones {
	private Vector<Set> sets;
	private int[]divisors;
	
	public Combinaciones() {
		sets=new Vector<>();
	}
	
	public void add(Set set) {
		this.sets.add(set);
		this.divisors=new int[sets.size()];
		for (int i=0; i<sets.size(); i++) {
			int divisor=1;
			for (int j=i+1; j<sets.size(); j++) {
				Set s=sets.get(j);
				divisor=divisor*s.size();
			}
			divisors[i]=divisor;
		}
	}
	
	public int getMaxNumberOfCombinations() {
		int maxNumberOfCombinations=1;
		for (Set s : sets)
			maxNumberOfCombinations=maxNumberOfCombinations*s.size();
		return maxNumberOfCombinations;
	}
	
	public Vector<Combination> getCombinations() {
		int numberOfCombinations=this.getMaxNumberOfCombinations();
		Vector<Combination> result=new Vector<>();
		for (int i=0; i<numberOfCombinations; i++) {
			Combination combination=getCombination(i);
			result.add(combination);
		}
		return result;
	}

	public Combination getCombination(int position) {
		Combination result=new Combination();
		for (int i=0; i<result.size(); i++) {
			int divisor=this.divisors[i];
			Set set=this.sets.get(i);
			int elementPosition=(position/divisor)%set.size();
			result.setValuePosition(i, elementPosition);
			Object valor=set.get(elementPosition);
			result.setValue(i, valor);
		}
		return result;
	}
}
