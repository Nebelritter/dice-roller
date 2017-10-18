/**
 * 
 */
package com.github.nebelritter.diceroller.roller;

import java.util.List;

import com.github.nebelritter.diceroller.DiceRoller;
import com.github.nebelritter.diceroller.entity.DiceRollResult;
import com.github.nebelritter.diceroller.entity.OneDie;
import com.github.nebelritter.diceroller.entity.RolledDie;
import com.github.nebelritter.diceroller.random.RandomValueProvider;

/**
 * @author Alti
 *
 */
public class SimpleRandomDiceRoller implements DiceRoller {

	protected RandomValueProvider randomProvider;
	
    @Override
    public DiceRollResult rollDice(List<OneDie> dice2Roll) {
        DiceRollResult result = new DiceRollResult();
        List<RolledDie> dieResults = result.getDieResults();
        for (OneDie oneDie : dice2Roll) {
            int numberOfSides = oneDie.getNumberOfSides();
            RolledDie rolledDie = new RolledDie();
            rolledDie.setNumberOfSides(numberOfSides);
            rolledDie.setRollResult(rollDie(numberOfSides));            
            dieResults.add(rolledDie);            
        }
        result.setDieResults(dieResults);
        return result;
    }

    protected int rollDie(int numberOfSides) {        
        int value0Based = randomProvider.nextInt(numberOfSides);
        return (value0Based + 1);
    }

	public RandomValueProvider getRandomProvider() {
		return randomProvider;
	}

	public void setRandomProvider(RandomValueProvider randomProvider) {
		this.randomProvider = randomProvider;
	}
}
