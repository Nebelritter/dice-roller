/**
 * 
 */
package com.github.nebelritter.dice_roller.roller;

import java.util.ArrayList;
import java.util.List;

import com.github.nebelritter.dice_roller.DiceRoller;
import com.github.nebelritter.dice_roller.entity.DiceRollResult;
import com.github.nebelritter.dice_roller.entity.OneDie;
import com.github.nebelritter.dice_roller.entity.RolledDie;

/**
 * @author Alti
 *
 */
public class SimpleModuloDiceRoller implements DiceRoller {

    @Override
    public DiceRollResult rollDice(List<OneDie> dice2Roll) {
        DiceRollResult result = new DiceRollResult();
        for (int index = 0; index < dice2Roll.size(); index++) {
            OneDie oneDie = dice2Roll.get(index);
            int numberOfSides = oneDie.getNumberOfSides();
            RolledDie rolledDie = new RolledDie();
            rolledDie.setNumberOfSides(numberOfSides);
            int rollResult = (index % numberOfSides) + 1;//predictable modulo result by index of die
            rolledDie.setRollResult(rollResult);
            List<RolledDie> dieResults = result.getDieResults();
            if (dieResults == null) {
                dieResults = new ArrayList<>();
                dieResults.add(rolledDie);
            } else {
                dieResults.add(rolledDie);
            }
            result.setDieResults(dieResults);
        }
        return result;
    }

}
