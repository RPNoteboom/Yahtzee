/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;

/**
 *
 * @author Richard Noteboom
 */
public class UpperSection {

    /**
     * @return the aces
     */
    public int getAces() {
        return aces;
    }

    /**
     * @param aces the aces to set
     */
    public void setAces(int aces) {
        this.aces += aces;
    }

    /**
     * @return the twos
     */
    public int getTwos() {
        return twos;
    }

    /**
     * @param twos the twos to set
     */
    public void setTwos(int twos) {
        this.twos += twos;
    }

    /**
     * @return the threes
     */
    public int getThrees() {
        return threes;
    }

    /**
     * @param threes the threes to set
     */
    public void setThrees(int threes) {
        this.threes += threes;
    }

    /**
     * @return the fours
     */
    public int getFours() {
        return fours;
    }

    /**
     * @param fours the fours to set
     */
    public void setFours(int fours) {
        this.fours += fours;
    }

    /**
     * @return the fives
     */
    public int getFives() {
        return fives;
    }

    /**
     * @param fives the fives to set
     */
    public void setFives(int fives) {
        this.fives += fives;
    }

    /**
     * @return the sixes
     */
    public int getSixes() {
        return sixes;
    }

    /**
     * @param sixes the sixes to set
     */
    public void setSixes(int sixes) {
        this.sixes += sixes;
    }

    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        totalScore = aces + twos + threes + fours + fives + sixes;
//        System.out.println("upper total score " + totalScore);        
        
        if(totalScore >= 63)
            setBonus(35);
        
        return totalScore;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return (getTotalScore() + getBonus());
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    private int aces;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int totalScore;
    private int bonus;
    private int total;
    
    public void evaluateCategory(Roll roll, int category){

        switch (category){ 
            
           
            
            case 1:
                for(Die die : roll.getDice()){
                    if (die.getFaceValue() == Constants.ONES)
                        setAces(Constants.ONES);
                }
                break;
            case 2:
                for(Die die : roll.getDice()){
                    if (die.getFaceValue() == Constants.TWOS)
                        setTwos(Constants.TWOS);
                }
                break;
            case 3:
                for(Die die : roll.getDice()){
                    if (die.getFaceValue() == Constants.THREES)
                        setThrees(Constants.THREES);
                }
                break;
            case 4:
                for(Die die : roll.getDice()){
                    if (die.getFaceValue() == Constants.FOURS)
                        setFours(Constants.FOURS);
                }
                break;
            case 5:
                for(Die die : roll.getDice()){
                    if (die.getFaceValue() == Constants.FIVES)
                        setFives(Constants.FIVES);
                }
                break;
            case 6:
                for(Die die : roll.getDice()){
                    if (die.getFaceValue() == Constants.SIXES)
                        setSixes(Constants.SIXES);
                }
                break;
            default:
                break;
            
        }
                
    }
}
