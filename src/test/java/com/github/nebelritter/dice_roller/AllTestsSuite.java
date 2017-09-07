package com.github.nebelritter.dice_roller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.github.nebelritter.dice_roller.roller.ConfigurableDiceRollerTest;
import com.github.nebelritter.dice_roller.roller.SimpleModuloDiceRollerTest;
import com.github.nebelritter.dice_roller.roller.SimpleRandomDiceRollerTest;

@RunWith(Suite.class)
@SuiteClasses({ ConfigurableDiceRollerTest.class, SimpleModuloDiceRollerTest.class, SimpleRandomDiceRollerTest.class,DiceUtilsTest.class })
public class AllTestsSuite {

}
