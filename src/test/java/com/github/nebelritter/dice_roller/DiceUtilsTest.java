/**
 * 
 */
package com.github.nebelritter.dice_roller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.nebelritter.dice_roller.DiceUtils;
import com.github.nebelritter.dice_roller.entity.DiceRollResult;
import com.github.nebelritter.dice_roller.entity.OneDie;
import com.github.nebelritter.dice_roller.entity.RolledDie;

/**
 * @author Alti
 *
 */
public class DiceUtilsTest {

    @Test
    public void test_AddUpRollResult() {
        DiceRollResult rollResult = new DiceRollResult();
        List<RolledDie> dieResults = new ArrayList<>();
        RolledDie six = new RolledDie();
        six.setNumberOfSides(6);
        six.setRollResult(6);
        String stringRep = six.toString();
        assertEquals("[6/6]",stringRep);
        dieResults.add(six);
        dieResults.add(six);
        rollResult.setDieResults(dieResults);
        int result = DiceUtils.addUpRollResult(rollResult);
        assertEquals(result, 12);
        
    }

    @Test
    public void test_AddUpRollResultAdvanced() {
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
    public void test_createDice(){
    	List<OneDie> dice = DiceUtils.createDice(4, 6);
    	assertEquals(4, dice.size());
    	assertEquals(6, dice.get(0).getNumberOfSides());
    	String stringRep = dice.get(0).toString();
    	assertEquals("[6]", stringRep);
    }
    
    @Test
    public void test_createDice_0Number(){
    	List<OneDie> dice = DiceUtils.createDice(0, 6);
    	assertEquals(0, dice.size());    	
    }
    
    @Test
    public void test_createDice_NegativeNumber(){
    	List<OneDie> dice = DiceUtils.createDice(-4, 6);
    	assertEquals(0, dice.size());    	
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void test_createDice_NoSides(){
    	DiceUtils.createDice(4, 0);    	
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void test_createDice_NegativeSides(){
    	DiceUtils.createDice(4, -6);    	
    }
    
    @Test
    public void test_Create(){
    	new DiceUtils();    	
    }
}
