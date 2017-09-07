/**
 * 
 */
package com.github.nebelritter.diceroller;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.nebelritter.diceroller.DiceUtils;
import com.github.nebelritter.diceroller.entity.DiceRollResult;
import com.github.nebelritter.diceroller.entity.RolledDie;

/**
 * @author Alti
 *
 */
public class TestDiceUtils {

    @Test
    public void testAddUpRollResult() {
        DiceRollResult rollResult = new DiceRollResult();
        List<RolledDie> dieResults = new ArrayList<>();
        RolledDie six = new RolledDie();
        six.setNumberOfSides(6);
        six.setRollResult(6);
        dieResults.add(six);
        dieResults.add(six);
        rollResult.setDieResults(dieResults);
        int result = DiceUtils.addUpRollResult(rollResult);
        assertEquals(result, 12);
    }

    @Test
    public void testAddUpRollResultAdvanced() {
        DiceRollResult rollResult = new DiceRollResult();
        List<RolledDie> dieResults = new ArrayList<>();
        RolledDie six = new RolledDie();
        six.setNumberOfSides(6);
        six.setRollResult(6);
        dieResults.add(six);
        RolledDie five = new RolledDie();
        five.setNumberOfSides(6);
        five.setRollResult(5);
        dieResults.add(five);
        RolledDie four = new RolledDie();
        four.setNumberOfSides(6);
        four.setRollResult(4);
        dieResults.add(four);
        RolledDie three = new RolledDie();
        three.setNumberOfSides(6);
        three.setRollResult(3);
        dieResults.add(three);
        RolledDie two = new RolledDie();
        two.setNumberOfSides(6);
        two.setRollResult(2);
        dieResults.add(two);
        RolledDie one = new RolledDie();
        one.setNumberOfSides(6);
        one.setRollResult(1);
        dieResults.add(one);
        rollResult.setDieResults(dieResults);
        int result = DiceUtils.addUpRollResult(rollResult);
        assertEquals(result, 21);
    }

    @Test
    public void privateConstructorTest() throws Exception {
        final Constructor<?>[] constructors = DiceUtils.class.getDeclaredConstructors();
        // check that all constructors are 'private':
        for (final Constructor<?> constructor : constructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }
        // call the private constructor:
        constructors[0].setAccessible(true);
        constructors[0].newInstance((Object[]) null);
    }
}
