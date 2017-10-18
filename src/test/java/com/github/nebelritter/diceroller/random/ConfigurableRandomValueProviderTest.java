/**
 * 
 */
package com.github.nebelritter.diceroller.random;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author Nebelritter
 *
 */
public class ConfigurableRandomValueProviderTest {

	private ConfigurableRandomValueProvider provider = new ConfigurableRandomValueProvider();
	
	@Test
	public void testNextBoolean(){
		List<Boolean> testBools = new ArrayList<>();
		testBools.add(true);
		testBools.add(false);
		testBools.add(true);
		provider.setBools(testBools );
		List<Boolean> bools = provider.getBools();
		assertEquals(testBools, bools);
		boolean result = provider.nextBoolean();
		assertTrue(result);
		result = provider.nextBoolean();
		assertFalse(result);
		result = provider.nextBoolean();
		assertTrue(result);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testNextBoolean_NoResults(){			
		provider.nextBoolean();		
	}
	
	@Test
	public void testNextInt(){
		List<Integer> testInts = new ArrayList<>();
		testInts.add(3);
		testInts.add(1);
		testInts.add(2);
		provider.setInts(testInts);
		List<Integer> ints = provider.getInts();
		assertEquals(testInts, ints);
		int result = provider.nextInt(3);
		assertEquals(3, result);
		result = provider.nextInt(3);
		assertEquals(1, result);
		result = provider.nextInt(3);
		assertEquals(2, result);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testNextInt_NoResults(){
		provider.nextInt(3);		
	}

	@Test(expected=IllegalStateException.class)
	public void testNextInt_BiggerThanMax(){
		List<Integer> testInts = new ArrayList<>();
		testInts.add(5);		
		provider.setInts(testInts);
		List<Integer> ints = provider.getInts();
		assertEquals(testInts, ints);
		provider.nextInt(3);		
	}
}
