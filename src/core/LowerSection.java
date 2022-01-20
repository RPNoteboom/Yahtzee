/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Richard Noteboom
 */
public class LowerSection {
    private int threeKind;
    private int fourKind;
    private int fullHouse;
    private int smStraight;
    private int lgStraight;
    private int yahtzee;
    private int chance;
    private int yahtzeeBonus;
    private int totalScore;

    /**
     * @return the threeKind
     */
    public int getThreeKind() {
        return threeKind;
    }

    /**
     * @param threeKind the threeKind to set
     */
    public void setThreeKind(int threeKind) {
        this.threeKind += threeKind;
    }

    /**
     * @return the fourKind
     */
    public int getFourKind() {
        return fourKind;
    }

    /**
     * @param fourKind the fourKind to set
     */
    public void setFourKind(int fourKind) {
        this.fourKind += fourKind;
    }

    /**
     * @return the fullHouse
     */
    public int getFullHouse() {
        return fullHouse;
    }

    /**
     * @param fullHouse the fullHouse to set
     */
    public void setFullHouse(int fullHouse) {
        this.fullHouse = fullHouse;
    }

    /**
     * @return the smStraight
     */
    public int getSmStraight() {
        return smStraight;
    }

    /**
     * @param smStraight the smStraight to set
     */
    public void setSmStraight(int smStraight) {
        this.smStraight = smStraight;
    }

    /**
     * @return the lgStraight
     */
    public int getLgStraight() {
        return lgStraight;
    }

    /**
     * @param lgStraight the lgStraight to set
     */
    public void setLgStraight(int lgStraight) {
        this.lgStraight = lgStraight;
    }

    /**
     * @return the yahtzee
     */
    public int getYahtzee() {
        return yahtzee;
    }

    /**
     * @param yahtzee the yahtzee to set
     */
    public void setYahtzee(int yahtzee) {
        this.yahtzee = yahtzee;
    }

    /**
     * @return the chance
     */
    public int getChance() {
        return chance;
    }

    /**
     * @param chance the chance to set
     */
    public void setChance(int chance) {
        this.chance += chance;
    }

    /**
     * @return the yahtzeeBonus
     */
    public int getYahtzeeBonus() {
        return yahtzeeBonus;
    }

    /**
     * @param yahtzeeBonus the yahtzeeBonus to set
     */
    public void setYahtzeeBonus(int yahtzeeBonus) {
        this.yahtzeeBonus = yahtzeeBonus;
    }

    /**
     * @return the totalScore
     */
    public int getTotalScore() {
        return threeKind + fourKind + fullHouse + smStraight + lgStraight + yahtzee + chance + yahtzeeBonus;
    }

    /**
     * @param totalScore the totalScore to set
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    
    public void evaluateCategory(Roll roll, int category){
        sortDice(roll);
        switch (category){
            case Constants.THREE_KIND:
                int[] counterThree = new int[6];
                boolean threes = false;
                int points = 0;
                for (int i = 0; i < roll.dice.size(); i++)
                    //increase the relevant counter
                    counterThree[roll.getDice().get(i).getFaceValue()-1]++;
                //now check we've got a pair and three of a kind
                for (int i: counterThree) {
                    if (i == 3){
                        for(Die die : roll.getDice()){
                            points += die.getFaceValue();
                        }
                        setThreeKind(points);
                        threes = true;
                    }
                    else if (threes == false)
                        setThreeKind(Constants.ZERO);
                }
//                int points = 0;
//                int counter = 0;
//                for(Die die : roll.getDice()){
//                    if (die.getFaceValue() == Constants.THREE_KIND)
//                      counter++;
//                }
//                if (counter == 3){
//                    for(Die die : roll.getDice())
//                        points += die.getFaceValue();
//                    setThreeKind(points);
//                }
//                else 
//                    setThreeKind(Constants.ZERO);
                break;
            case Constants.FOUR_KIND:
                int[] counterFour = new int[6];
                boolean fours = false;
                points = 0;
                for (int i = 0; i < roll.dice.size(); i++)
                    //increase the relevant counter
                    counterFour[roll.getDice().get(i).getFaceValue()-1]++;
                //now check we've got a pair and three of a kind
                for (int i: counterFour) {
                    if (i == 4){
                        for(Die die : roll.getDice()){
                            points += die.getFaceValue();
                        }
                        setFourKind(points);
                        fours = true;
                    }
                    else if (fours == false)
                        setFourKind(Constants.ZERO);
                }
//                points = 0;
//                counter = 0;
//                for(Die die : roll.getDice()){
//                    if (die.getFaceValue() == Constants.FOUR_KIND)
//                      counter++;
//                }
//                if (counter == 4){
//                    for(Die die : roll.getDice())
//                        points += die.getFaceValue();
//                    setFourKind(points);
//                }
//                else 
//                    setFourKind(Constants.ZERO);
                break;
            case 9:
                int[] counterHouse = new int[6];
                for (int i = 0; i < roll.dice.size(); i++)
                    //increase the relevant counter
                    counterHouse[roll.getDice().get(i).getFaceValue()-1]++;
                //now check we've got a pair and three of a kind
                boolean pair = false;
                boolean three = false;
                for (int i: counterHouse) {
                    if (i == 2)
                        pair = true;//found 2 of some number
                    if (i == 3)
                        three = true; //found 3 of some number
                }
                if (pair == true && three == true)
                    setFullHouse(Constants.FULL_HOUSE);
                else 
                    setFullHouse(Constants.ZERO);

//                for (int outer = 0; outer < 4; outer++){
//                    for (int inner = outer + 1; inner < 5; inner++)
//                    {
//                        if (roll.getDice().get(outer).getFaceValue() == 
//                                roll.getDice().get(inner).getFaceValue())
//                        {
//                        counter++;
//                        }
//                    }
//                    if (counter == 3)
//                        three = true;
//                    else if (counter == 1)
//                        pair = true;
//                }
                break;
            case 10:
                int counter = 0;
                for (int i = 0; i < 4; i++){
                    for (int j = i + 1; j < 5; j++)
                    {
                        if (roll.getDice().get(i).getFaceValue() == 
                                roll.getDice().get(j).getFaceValue() + 1)
                        counter++;
                        else if (roll.getDice().get(i).getFaceValue() == 
                                roll.getDice().get(j).getFaceValue())
                            continue;
                    }
                    if (counter == 3){
                        setSmStraight(Constants.SM_STRAIGHT);
                        break;
                    }
                }        
                break;
            case 11:
                counter = 0;
                for (int i = 0; i < 4; i++){
                    for (int j = i + 1; j < 5; j++)
                    {
                        if (roll.getDice().get(i).getFaceValue() == 
                                roll.getDice().get(j).getFaceValue() + 1)
                        counter++;
                        else if (roll.getDice().get(i).getFaceValue() == 
                                roll.getDice().get(j).getFaceValue())
                            continue;
                    }
                    if (counter == 4){
                        setLgStraight(Constants.LG_STRAIGHT);   
                        break;
                    }
                }        
                break;
            case 12:
                int[] counterYahtzee = new int[6];
                boolean yahtzee = false;
                points = 0;
                for (int i = 0; i < roll.dice.size(); i++)
                    //increase the relevant counter
                    counterYahtzee[roll.getDice().get(i).getFaceValue()-1]++;
                //now check we've got a pair and three of a kind
                for (int i: counterYahtzee) {
                    if (i == 5){
                        for(Die die : roll.getDice()){
                            points += die.getFaceValue();
                        }
                        setFourKind(points);
                        fours = true;
                    }
                    else if (yahtzee == false)
                        setFourKind(Constants.ZERO);
                }
                break;
            case 13:
                points = 0;
                for(Die die : roll.getDice())
                        points += die.getFaceValue();
                    setFourKind(points);
                break;
            default:
                System.out.println("Error in LowerSection Category Evaluation");
                break;
        }
    }
    
    private ArrayList<Integer> sortDice(Roll roll){
        ArrayList<Integer> list = new ArrayList<>();
        
        roll.dice.forEach((die) -> {
            Integer facevalue = die.getFaceValue();
            list.add(facevalue);
        });
        Collections.sort(list);
        
        return list;
    }
}
