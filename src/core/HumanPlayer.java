/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import java.util.Scanner;

/**
 *
 * @author Richard Noteboom
 */
public class HumanPlayer extends Player{
    @Override
    public void rollDice(Roll roll){
        setRollDice(roll);
        {
            setRollDice(roll);
        
            for (Die die : roll.getDice())
            {
                die.rollDie();
            }
        }
        for(Die die: roll.getDice()){
            die.rollDie();
        }
    }
    @Override
    public void selectCategory(Roll dice){
        Scanner input = new Scanner(System.in);
        int category = 0;

        do {
            System.out.println("*************************************");
            System.out.println("Select the category for this roll by entering "
                    + "the index"); 
            dice.displayDice();
            System.out.println("*************************************");
            System.out.println(" UPPER SECTION");
            System.out.println("*************************************");
            System.out.println("1 - ONES");
            System.out.println("2 - TWOES");
            System.out.println("3 - THREES");
            System.out.println("4 - FOURS");
            System.out.println("5 - FIVES");
            System.out.println("6 - SIXES");
            System.out.println("*************************************");
            System.out.println(" LOWER SECTION");
            System.out.println("*************************************");
            System.out.println("7 - THREE OF A KIND");
            System.out.println("8 - FOUR OF A KIND");
            System.out.println("9 - FULL HOUSE");
            System.out.println("10 - SMALL STRAIGHT");
            System.out.println("11 - LARGE STRIAGHT");
            System.out.println("12 - YAHTZEE");
            System.out.println("13 - CHANCE");
            try {
                String s = input.nextLine();
                category = Integer.parseInt(s);
                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid option, try again");
            }
        }
        while (category < 1 || category > Constants.NUM_CATERGORY);
        
        calculateScore(dice, category);
    }
    @Override
    public void calculateScore(Roll selected, int category){
        if (category <= 6){
            getScore().getUpper().evaluateCategory(selected, category);
        }
        else if (category >=7){
            getScore().getLower().evaluateCategory(selected, category);
        }
        System.out.println("score calculated, score is " + getScore().getGrandTotal());
    }
    @Override
    public void selectDice(Roll roll, Roll selected, int cur_roll){
        boolean done = false;
        int selection = -1;
        Scanner input = new Scanner(System.in);

        
        do { 
            System.out.println("Enter the index of each die you would like to keep,"
                + " enter D for Done when finished");
            roll.displayDice();
        
            String s = input.next();
            if ("D".equalsIgnoreCase(s)){
                if (cur_roll == 2 && selected.getDice().size() < 5){
                    for(Die die : roll.dice){
                        selected.dice.add(die);
                    }
                    roll.dice.removeAll(roll.dice);
                }
                
                done = true;
                break;
            }
            else{
                try {
                    Die temp;
                    selection = Integer.parseInt(s);
                    temp = roll.dice.get(selection);
                    selected.dice.add(temp);
                    roll.getDice().remove(selection);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid option, try again");
                }
                selected.displayDice();
                if (selected.dice.size() == 5)
                    break;
            }
        }
        while (done == false && (selection >= 0 && selection < 7));
    } // end of selectDice
    
    ScoreCard sc;
    public HumanPlayer(){
        setScore(new ScoreCard());
    }
}
