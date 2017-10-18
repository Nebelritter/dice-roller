/**
 * 
 */
package com.github.nebelritter.diceroller.random;

/**
 * @author Nebelritter
 *
 */
public interface RandomValueProvider {
	/**
	 * provides random number from 0-maxValue(exclusive)
	 * @param maxValue
	 * @return
	 */
	int nextInt(int maxValue);
	
	/**
	 * provides random boolean value
	 * @return
	 */
	boolean nextBoolean();
}
