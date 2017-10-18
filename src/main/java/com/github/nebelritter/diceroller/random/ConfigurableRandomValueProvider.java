/**
 * 
 */
package com.github.nebelritter.diceroller.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nebelritter
 *
 */
public class ConfigurableRandomValueProvider implements RandomValueProvider {
	
	private List<Integer> ints = new ArrayList<>();
	private List<Boolean> bools = new ArrayList<>();
	
	/* (non-Javadoc)
	 * @see com.github.nebelritter.diceroller.random.RandomValueProvider#nextInt(int)
	 */
	@Override
	public int nextInt(int maxValue) {
		if(ints.isEmpty()){
			throw new IllegalStateException("configured no values");			
		}
		Integer firstValue = ints.get(0);
		if(firstValue > maxValue){
			throw new IllegalStateException("configured value ("+firstValue+") is bigger than max value ("+maxValue+")");			
		}
		ints.remove(0);
		return firstValue;
	}

	/* (non-Javadoc)
	 * @see com.github.nebelritter.diceroller.random.RandomValueProvider#nextBoolean()
	 */
	@Override
	public boolean nextBoolean() {
		if(bools.isEmpty()){
			throw new IllegalStateException("configured no values");			
		}
		Boolean firstValue = bools.get(0);		
		bools.remove(0);
		return firstValue;
	}

	public List<Integer> getInts() {
		return ints;
	}

	public void setInts(List<Integer> ints) {
		this.ints = ints;
	}

	public List<Boolean> getBools() {
		return bools;
	}

	public void setBools(List<Boolean> bools) {
		this.bools = bools;
	}

}
