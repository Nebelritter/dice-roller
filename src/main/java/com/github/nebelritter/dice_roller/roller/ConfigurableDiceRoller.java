/**
 * 
 */
package com.github.nebelritter.dice_roller.roller;

import java.util.ArrayList;
import java.util.List;

import com.github.nebelritter.dice_roller.DiceRoller;
import com.github.nebelritter.dice_roller.entity.DiceRollResult;
import com.github.nebelritter.dice_roller.entity.OneDie;

/**
 * @author Alti
 *
 */
public class ConfigurableDiceRoller implements DiceRoller {

    private List<DiceRollResult> configuredResults = new ArrayList<>();

    @Override
    public DiceRollResult rollDice(List<OneDie> dice2Roll) {
        if (configuredResults.size() < 1) {
            throw new IllegalStateException(
                    "Not enough configured results, need at least 1 but found " + configuredResults.size());
        }
        //take first and remove afterwards
        DiceRollResult result = configuredResults.get(0);
        //checks
        //check size
        int resultSize = result.getDieResults().size();
        int rollSize = dice2Roll.size();
        if(resultSize != rollSize){
        	throw new IllegalStateException("Number of dice configured("+resultSize+") does not equal number of dice to roll ("+rollSize+")");
        }
        //check sides
        if(result.getDieResults().size()>0){//can only check dice sides if any dice present
        	int resultSides = result.getDieResults().get(0).getNumberOfSides();        
            int rollSides = dice2Roll.get(0).getNumberOfSides();
            if(resultSides != rollSides){
            	throw new IllegalStateException("Number of sides of dice configured("+resultSides+") does not equal number of sides of dice to roll ("+rollSides+")");
            }
        }        
        configuredResults.remove(0);
        return result;
    }

    public void configureResults(List<? extends DiceRollResult> results) {
        configuredResults.clear();
        configuredResults.addAll(results);
    }

    public void clean() {
        configuredResults.clear();
    }
}
