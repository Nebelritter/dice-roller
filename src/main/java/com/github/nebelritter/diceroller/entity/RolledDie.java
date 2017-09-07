/**
 * 
 */
package com.github.nebelritter.diceroller.entity;

/**
 * @author Alti
 *
 */
public class RolledDie extends OneDie {
    int rollResult;

    public int getRollResult() {
        return rollResult;
    }

    public void setRollResult(int rollResult) {
        this.rollResult = rollResult;
    }

    @Override
    public String toString() {
        return "[" + rollResult + "/" + numberOfSides + "]";
    }

}
