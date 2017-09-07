/**
 * 
 */
package com.github.nebelritter.diceroller.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alti
 *
 */
public class DiceRollResult {
    private List<RolledDie> dieResults = new ArrayList<>();

    public List<RolledDie> getDieResults() {
        return new ArrayList<>(dieResults);
    }

    public void setDieResults(List<RolledDie> dieResults) {
        this.dieResults = dieResults;
    }

}
