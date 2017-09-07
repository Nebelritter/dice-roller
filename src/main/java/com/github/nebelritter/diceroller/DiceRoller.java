/**
 * 
 */
package com.github.nebelritter.diceroller;

import java.util.List;

import com.github.nebelritter.diceroller.entity.DiceRollResult;
import com.github.nebelritter.diceroller.entity.OneDie;

/**
 * @author Stefan Alter
 *
 */
public interface DiceRoller {

    public DiceRollResult rollDice(List<OneDie> dice2Roll);

}
