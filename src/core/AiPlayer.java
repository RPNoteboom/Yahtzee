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
public class AiPlayer extends Player{
    @Override
    public void rollDice(Roll roll){
        for(Die die: roll.getDice()){
            die.rollDie();
        }
    }
    @Override
    public void selectCategory(Roll roll){
    }
    @Override
    public void selectDice(Roll original, Roll kept, int cur_roll){
    }
    @Override
    public void calculateScore(Roll kept, int cat){
    }
}
