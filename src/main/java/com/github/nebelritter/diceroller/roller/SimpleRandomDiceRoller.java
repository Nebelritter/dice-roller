/**
 * 
 */
package com.github.nebelritter.diceroller.roller;

import java.util.List;
import java.util.Random;

import com.github.nebelritter.diceroller.DiceRoller;
import com.github.nebelritter.diceroller.entity.DiceRollResult;
import com.github.nebelritter.diceroller.entity.OneDie;
import com.github.nebelritter.diceroller.entity.RolledDie;

/**
 * @author Alti
 *
 */
public class SimpleRandomDiceRoller implements DiceRoller {

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
        Random rnd = new Random();
        int value0Based = rnd.nextInt(numberOfSides);
        return (value0Based + 1);
    }
}
