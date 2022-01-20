/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Richard Noteboom
 */
public class ScoreCard {

    /**
     * @return the upper
     */
    public UpperSection getUpper() {
        return upper;
    }

    /**
     * @param upper the upper to set
     */
    public void setUpper(UpperSection upper) {
        this.upper = upper;
    }

    /**
     * @return the lower
     */
    public LowerSection getLower() {
        return lower;
    }

    /**
     * @param lower the lower to set
     */
    public void setLower(LowerSection lower) {
        this.lower = lower;
    }

    /**
     * @return the grandTotal
     */
    public int getGrandTotal() {
        this.grandTotal = upper.getTotal() + lower.getTotalScore();

        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(int grandTotal) {
        this.grandTotal = grandTotal;
    }
    private UpperSection upper;
    private LowerSection lower;
    private int grandTotal;
    
    public ScoreCard(){
        upper = new UpperSection();
        lower = new LowerSection();
    }
}
