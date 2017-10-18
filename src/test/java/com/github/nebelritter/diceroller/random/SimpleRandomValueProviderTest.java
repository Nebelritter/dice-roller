/**
 * 
 */
package com.github.nebelritter.diceroller.random;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author Nebelritter
 *
 */
public class SimpleRandomValueProviderTest {

	private SimpleRandomValueProvider provider = new SimpleRandomValueProvider();
	
	@Test
	public void testNextBoolean(){
		boolean result = provider.nextBoolean();
		assertNotNull(result);
	}
	@Test
	public void testNextInt(){
		int result = provider.nextInt(3);
		assertNotNull(result);
	}
}
