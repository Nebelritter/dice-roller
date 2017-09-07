/**
 * 
 */
package com.github.nebelritter.dice_roller.roller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.github.nebelritter.dice_roller.DiceUtils;
import com.github.nebelritter.dice_roller.entity.DiceRollResult;
import com.github.nebelritter.dice_roller.entity.OneDie;
import com.github.nebelritter.dice_roller.entity.RolledDie;

/**
 * @author alters
 *
 */
public class SimpleModuloDiceRollerTest {
	
	private SimpleModuloDiceRoller roller = new SimpleModuloDiceRoller();
	
	@Test
	public void testRollSomeDice(){
		List<OneDie> dice2Roll = DiceUtils.createDice(4, 6);		
		DiceRollResult rollResult = roller.rollDice(dice2Roll);
		assertEquals(4,rollResult.getDieResults().size());
		for (RolledDie die : rollResult.getDieResults()) {
			int result = die.getRollResult();
			assertTrue(0<result && result<=6);
		}
	}
	
	@Test
	public void testMillionTenSidedRollDice(){
		int numberOfDice = 1_000_000;
		int sideNumber = 10;
		List<OneDie> dice2Roll = DiceUtils.createDice(numberOfDice, sideNumber);		
		DiceRollResult rollResult = roller.rollDice(dice2Roll);
		assertEquals(numberOfDice,rollResult.getDieResults().size());
		List<RolledDie> dieResults = rollResult.getDieResults();
		for (RolledDie die : dieResults) {
			int result = die.getRollResult();
			assertTrue(0<result && result<=sideNumber);
		}
		Map<Object, Long> grouped = dieResults.stream().collect(Collectors.groupingBy(die -> die.getRollResult(),Collectors.counting()));		
		assertEquals(sideNumber,grouped.keySet().size());
		Collection<Long> values = grouped.values();
		Long diff=0L;
		Long prevValue = values.iterator().next();
		for (Long value : values) {
			diff += Math.abs(value-prevValue);
		}
		System.out.println("Difference: "+diff);
	}
}
