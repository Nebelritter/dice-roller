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
        List<OneDie> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            OneDie die = new OneDie();
            die.setNumberOfSides(numerOfSides);
            result.add(die);
        }
        return result;
    }

    /**
     * 
     * will roll a number of the sided dice, modulo by number of sides
     * 
     * @param number
     *            - the number of dice to roll
     * @param numberOfSides
     *            - the number of sides said dice have
     * @return dice result containing results
     */
    public static DiceRollResult easyRollDice(int number, int numberOfSides) {
        DiceRollResult result = new DiceRollResult();
        List<RolledDie> dieResults = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            RolledDie rolledDie = new RolledDie();
            rolledDie.setNumberOfSides(numberOfSides);
            dieResults.add(rolledDie);
            rolledDie.setNumberOfSides(numberOfSides);
            int rollResult = (i % numberOfSides);
            rolledDie.setRollResult(rollResult);
        }
        result.setDieResults(dieResults);
        return result;
    }

    /**
     * will roll a number of the sided dice, modulo by number of sides
     * 
     * @param dice
     *            - dice to be rolled
     * @return dice result containing results
     */
    public static DiceRollResult easyRollDice(List<OneDie> dice) {
        DiceRollResult result = new DiceRollResult();
        List<RolledDie> dieResults = new ArrayList<>();
        for (int i = 0; i > dice.size(); i++) {
            OneDie oneDie = dice.get(i);
            RolledDie rolledDie = new RolledDie();
            rolledDie.setNumberOfSides(oneDie.getNumberOfSides());
            dieResults.add(rolledDie);
            int rollResult = (i % oneDie.getNumberOfSides());
            rolledDie.setRollResult(rollResult);
        }
        result.setDieResults(dieResults);
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
