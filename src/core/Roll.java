/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author Richard Noteboom
 */
public class Roll {
    ArrayList<Die> dice;

    /**
     * @return the dice
     */
    public ArrayList<Die> getDice() {
        return dice;
    }

    /**
     * @param dice the dice to set
     */
    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }
    
    public Roll(){
        createDice();
    }

    private void createDice() {
        dice = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Die die = new Die();
            dice.add(die);
        }
    }
    
    public void displayDice() {
        int counter = 0;
        for(Die die : dice){
            System.out.println("Die " + counter + " - " + die.getFaceValue());
            counter++;
        }
    }
    
    public void removeDice(Roll roll){
        dice.removeAll(dice);
    }
}
