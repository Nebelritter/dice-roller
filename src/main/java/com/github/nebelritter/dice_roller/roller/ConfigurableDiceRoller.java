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
