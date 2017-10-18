/**
 * 
 */
package com.github.nebelritter.diceroller.roller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.nebelritter.diceroller.DiceUtils;
import com.github.nebelritter.diceroller.entity.DiceRollResult;
import com.github.nebelritter.diceroller.entity.OneDie;
import com.github.nebelritter.diceroller.entity.RolledDie;
import com.github.nebelritter.diceroller.roller.ConfigurableDiceRoller;

/**
 * @author Nebelritter
 *
 */
public class ConfigurableDiceRollerTest {
    private static ConfigurableDiceRoller roller = new ConfigurableDiceRoller();

    @BeforeClass
    public static void before() {
        roller.clean();
    }

    @Test
    public void testRollSomeDice_NoDice() {
        List<OneDie> dice2Roll = DiceUtils.createDice(0, 6);
        List<DiceRollResult> configuredResults = new ArrayList<>();
        DiceRollResult configuredResult = new DiceRollResult();
        configuredResult.setDieResults(new ArrayList<>());
        configuredResults.add(configuredResult);
        roller.configureResults(configuredResults);
        roller.rollDice(dice2Roll);//exception should roll 6 sided dice but 10-sides are configured
    }

    @Test
    public void testRollSomeDice_Once() {
        int numberOfSides = 6;

        List<OneDie> dice2Roll = DiceUtils.createDice(4, numberOfSides);
        List<DiceRollResult> configuredResults = new ArrayList<>();
        DiceRollResult configuredResult = configureDiceRollResult(numberOfSides, 1, 2, 3, 4);
        configuredResults.add(configuredResult);
        roller.configureResults(configuredResults);
        configuredResults.add(configuredResult);
        roller.configureResults(configuredResults);
        DiceRollResult rollResult = roller.rollDice(dice2Roll);
        List<RolledDie> dieResults = rollResult.getDieResults();
        assertEquals(4, dieResults.size());
        assertEquals(1, dieResults.get(0).getRollResult());
        assertEquals(2, dieResults.get(1).getRollResult());
        assertEquals(3, dieResults.get(2).getRollResult());
        assertEquals(4, dieResults.get(3).getRollResult());
    }

    @Test(expected = IllegalStateException.class)
    public void testRollSomeDice_Once_WrongNumberOfDice() {
        int numberOfSides = 6;

        List<OneDie> dice2Roll = DiceUtils.createDice(4, numberOfSides);
        List<DiceRollResult> configuredResults = new ArrayList<>();
        DiceRollResult configuredResult = configureDiceRollResult(numberOfSides, 1, 2, 3);
        configuredResults.add(configuredResult);
        roller.configureResults(configuredResults);
        configuredResults.add(configuredResult);
        roller.configureResults(configuredResults);
        roller.rollDice(dice2Roll); //exception 4 dice configured, but should only roll 3

    }

    @Test(expected = IllegalStateException.class)
    public void testRollSomeDice_Once_WrongNumberOfSides() {
        int numberOfSides = 10;

        List<OneDie> dice2Roll = DiceUtils.createDice(3, 6);
        List<DiceRollResult> configuredResults = new ArrayList<>();
        DiceRollResult configuredResult = configureDiceRollResult(numberOfSides, 1, 2, 3);
        configuredResults.add(configuredResult);
        roller.configureResults(configuredResults);
        configuredResults.add(configuredResult);
        roller.configureResults(configuredResults);
        roller.rollDice(dice2Roll);//exception should roll 6 sided dice but 10-sides are configured
    }

    @Test
    public void testRollSomeDice_ThreeTimes() {
        int numberOfSides = 6;

        List<OneDie> dice2Roll = DiceUtils.createDice(4, numberOfSides);
        List<DiceRollResult> configuredResults = new ArrayList<>();

        DiceRollResult configuredResult = configureDiceRollResult(numberOfSides, 1, 2, 3, 4);
        configuredResults.add(configuredResult);

        configuredResult = configureDiceRollResult(numberOfSides, 4, 1, 3, 6, 2, 5);
        configuredResults.add(configuredResult);

        configuredResult = configureDiceRollResult(numberOfSides, 6, 5);
        configuredResults.add(configuredResult);

        roller.configureResults(configuredResults);
        DiceRollResult rollResult = roller.rollDice(dice2Roll);
        List<RolledDie> dieResults = rollResult.getDieResults();
        assertEquals(4, dieResults.size());
        assertEquals(1, dieResults.get(0).getRollResult());
        assertEquals(2, dieResults.get(1).getRollResult());
        assertEquals(3, dieResults.get(2).getRollResult());
        assertEquals(4, dieResults.get(3).getRollResult());

        dice2Roll = DiceUtils.createDice(6, numberOfSides);
        rollResult = roller.rollDice(dice2Roll);
        dieResults = rollResult.getDieResults();
        assertEquals(6, dieResults.size());
        assertEquals(4, dieResults.get(0).getRollResult());
        assertEquals(1, dieResults.get(1).getRollResult());
        assertEquals(3, dieResults.get(2).getRollResult());
        assertEquals(6, dieResults.get(3).getRollResult());
        assertEquals(2, dieResults.get(4).getRollResult());
        assertEquals(5, dieResults.get(5).getRollResult());

        dice2Roll = DiceUtils.createDice(2, numberOfSides);
        rollResult = roller.rollDice(dice2Roll);
        dieResults = rollResult.getDieResults();
        assertEquals(2, dieResults.size());
        assertEquals(6, dieResults.get(0).getRollResult());
        assertEquals(5, dieResults.get(1).getRollResult());
    }

    @Test(expected = IllegalStateException.class)
    public void testRollSomeDice_ThreeTimes_ResultMissing() {
        int numberOfSides = 6;

        List<OneDie> dice2Roll = DiceUtils.createDice(4, numberOfSides);
        List<DiceRollResult> configuredResults = new ArrayList<>();

        DiceRollResult configuredResult = configureDiceRollResult(numberOfSides, 1, 2, 3, 4);
        configuredResults.add(configuredResult);

        configuredResult = configureDiceRollResult(numberOfSides, 4, 1, 3, 6, 2, 5);
        configuredResults.add(configuredResult);

        configuredResult = configureDiceRollResult(numberOfSides, 6, 5);
        configuredResults.add(configuredResult);

        roller.configureResults(configuredResults);
        DiceRollResult rollResult = roller.rollDice(dice2Roll);
        List<RolledDie> dieResults = rollResult.getDieResults();
        assertEquals(4, dieResults.size());
        assertEquals(1, dieResults.get(0).getRollResult());
        assertEquals(2, dieResults.get(1).getRollResult());
        assertEquals(3, dieResults.get(2).getRollResult());
        assertEquals(4, dieResults.get(3).getRollResult());

        dice2Roll = DiceUtils.createDice(6, numberOfSides);
        rollResult = roller.rollDice(dice2Roll);
        dieResults = rollResult.getDieResults();
        assertEquals(6, dieResults.size());
        assertEquals(4, dieResults.get(0).getRollResult());
        assertEquals(1, dieResults.get(1).getRollResult());
        assertEquals(3, dieResults.get(2).getRollResult());
        assertEquals(6, dieResults.get(3).getRollResult());
        assertEquals(2, dieResults.get(4).getRollResult());
        assertEquals(5, dieResults.get(5).getRollResult());

        roller.clean();

        dice2Roll = DiceUtils.createDice(2, numberOfSides);
        rollResult = roller.rollDice(dice2Roll); //exception result is deleted		
    }

    public static DiceRollResult configureDiceRollResult(int numberOfSides, int... rolls) {
        DiceRollResult rollResult = new DiceRollResult();
        List<RolledDie> rolledDice = new ArrayList<>();
        for (int i = 0; i < rolls.length; i++) {
            RolledDie die = new RolledDie();
            die.setNumberOfSides(numberOfSides);
            die.setRollResult(rolls[i]);
            rolledDice.add(die);
        }
        rollResult.setDieResults(rolledDice);
        return rollResult;
    }
}
