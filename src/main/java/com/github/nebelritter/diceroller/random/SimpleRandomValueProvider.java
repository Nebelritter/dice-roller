/**
 * 
 */
package com.github.nebelritter.diceroller.random;

import java.util.Random;

/**
 * @author Nebelritter
 *
 */
public class SimpleRandomValueProvider implements RandomValueProvider {

	
	private Random random;
	
	public SimpleRandomValueProvider() {
		super();
		random = new Random();
	}

	
	/* (non-Javadoc)
	 * @see com.github.nebelritter.diceroller.random.RandomValueProvider#nextInt(int)
	 */
	@Override
	public int nextInt(int maxValue) {		
		return random.nextInt(maxValue);
	}

	/* (non-Javadoc)
	 * @see com.github.nebelritter.diceroller.random.RandomValueProvider#nextBoolean()
	 */
	@Override
	public boolean nextBoolean() {
		return random.nextBoolean();
	}

}
