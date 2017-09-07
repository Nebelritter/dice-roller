/**
 * 
 */
package com.github.nebelritter.dice_roller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.nebelritter.dice_roller.entity.DiceRollResult;
import com.github.nebelritter.dice_roller.entity.OneDie;
import com.github.nebelritter.dice_roller.entity.RolledDie;

/**
 * @author Alti
 *
 */
public class DiceUtils {
	
    public static List<OneDie> createDice(int number, int numerOfSides) {
    	if(number <= 0){
    		return new ArrayList<>();
    	}
    	if(numerOfSides <=0){
    		throw new IllegalArgumentException("Number of sides must be positive, no die may have 0 sides");
    	}
        List<OneDie> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            OneDie die = new OneDie();
            die.setNumberOfSides(numerOfSides);
            result.add(die);
        }
        return result;
    }
   
    /**
     * to add up the dice given in the result
     * 
     * @param diceRollResult
     *            - result containing dice values to add up
     * @return number of added up values
     */
    public static int addUpRollResult(DiceRollResult diceRollResult) {
        int result = 0;
        Stream<RolledDie> rolledDiceStr = diceRollResult.getDieResults().stream();
        result = rolledDiceStr.collect(Collectors.summingInt(d -> d.getRollResult()));
        return result;
    }
}
