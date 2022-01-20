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
public abstract class Player implements IPlayer{
    private String name;
    private ScoreCard score;
    private boolean finished = false;
    private int roll;
    private Roll rollDice;
    private boolean catSelected = false;
    
    public void incrementRoll()
    {
        if(getRoll() < 4)
        {
            setFinished(false);
            setRoll(getRoll() + 1);
        }
        else
            setFinished(true);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public ScoreCard getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(ScoreCard score) {
        this.score = score;
    }
    
    abstract void selectDice(Roll roll, Roll selected, int cur_roll);
    abstract void calculateScore(Roll selected, int cat);

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    /**
     * @return the roll
     */
    public int getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(int roll) {
        this.roll = roll;
    }

    /**
     * @return the rollDice
     */
    public Roll getRollDice() {
        return rollDice;
    }

    /**
     * @param rollDice the rollDice to set
     */
    public void setRollDice(Roll rollDice) {
        this.rollDice = rollDice;
    }

    /**
     * @return the catSelected
     */
    public boolean isCatSelected() {
        return catSelected;
    }

    /**
     * @param catSelected the catSelected to set
     */
    public void setCatSelected(boolean catSelected) {
        this.catSelected = catSelected;
    }
    
}
