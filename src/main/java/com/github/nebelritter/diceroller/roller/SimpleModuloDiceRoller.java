/**
 * 
 */
package com.github.nebelritter.diceroller.roller;

import java.util.List;

import com.github.nebelritter.diceroller.DiceRoller;
import com.github.nebelritter.diceroller.entity.DiceRollResult;
import com.github.nebelritter.diceroller.entity.OneDie;
import com.github.nebelritter.diceroller.entity.RolledDie;

/**
 * @author Alti
 *
 */
public class SimpleModuloDiceRoller implements DiceRoller {

    @Override
    public DiceRollResult rollDice(List<OneDie> dice2Roll) {
        DiceRollResult result = new DiceRollResult();
        List<RolledDie> dieResults = result.getDieResults();
        for (int index = 0; index < dice2Roll.size(); index++) {
            OneDie oneDie = dice2Roll.get(index);
            int numberOfSides = oneDie.getNumberOfSides();
            RolledDie rolledDie = new RolledDie();
            rolledDie.setNumberOfSides(numberOfSides);
            int rollResult = (index % numberOfSides) + 1;//predictable modulo result by index of die
            rolledDie.setRollResult(rollResult);                       
            dieResults.add(rolledDie);                        
        }
        result.setDieResults(dieResults);
        return result;
    }

}
