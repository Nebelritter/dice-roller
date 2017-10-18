/**
 * 
 */
package com.github.nebelritter.diceroller.entity;

import java.io.Serializable;

/**
 * @author Alti
 *
 */
public class OneDie implements Serializable{
    /** */	
	private static final long serialVersionUID = 1L;
	
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
