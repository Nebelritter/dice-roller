/**
 * 
 */
package com.github.nebelritter.diceroller.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alti
 *
 */
public class DiceRollResult implements Serializable{
    /**	 */
	private static final long serialVersionUID = 1L;
	
	private List<RolledDie> dieResults = new ArrayList<>();

    public List<RolledDie> getDieResults() {
        return new ArrayList<>(dieResults);
    }

    public void setDieResults(List<RolledDie> dieResults) {
        this.dieResults = dieResults;
    }

}
