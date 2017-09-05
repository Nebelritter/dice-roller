/**
 * 
 */
package com.github.nebelritter.dice_roller;

import java.util.List;

import com.github.nebelritter.dice_roller.entity.DiceRollResult;
import com.github.nebelritter.dice_roller.entity.OneDie;

/**
 * @author Stefan Alter
 *
 */
public interface DiceRoller {

    public DiceRollResult rollDice(List<OneDie> dice2Roll);

}
