/**
 * 
 */
package com.github.nebelritter.diceroller.entity;

/**
 * @author Alti
 *
 */
public class OneDie {
    int numberOfSides;

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "[" + numberOfSides + "]";
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

}
