package com.github.nebelritter.diceroller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.github.nebelritter.diceroller.random.ConfigurableRandomValueProviderTest;
import com.github.nebelritter.diceroller.random.SimpleRandomValueProviderTest;
import com.github.nebelritter.diceroller.roller.ConfigurableDiceRollerTest;
import com.github.nebelritter.diceroller.roller.SimpleModuloDiceRollerTest;
import com.github.nebelritter.diceroller.roller.SimpleRandomDiceRollerTest;

@RunWith(Suite.class)
@SuiteClasses({ ConfigurableDiceRollerTest.class, SimpleModuloDiceRollerTest.class, SimpleRandomDiceRollerTest.class,
		DiceUtilsTest.class, ConfigurableRandomValueProviderTest.class, SimpleRandomValueProviderTest.class })
public class AllTestsSuite {

}
