/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
//import static constants.Constants.MAX_ROLLS;
//import static constants.Constants.NUM_DICE;
import java.util.ArrayList;
//import java.util.Scanner;
import javax.swing.JOptionPane;
import userInterface.YahtzeeUi;

/**
 *
 * @author Richard Noteboom
 */
public class Game {

    /**
     * @return the gameTurn
     */
    public int getGameTurn() {
        return gameTurn;
    }

    /**
     * @param gameTurn the gameTurn to set
     */
    public void setGameTurn(int gameTurn) {
        this.gameTurn = gameTurn;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * @return the dice
     */
    public Roll getDice() {
        return dice;
    }

    /**
     * @param dice the dice to set
     */
    public void setDice(Roll dice) {
        this.dice = dice;
    }
    private int gameTurn;
    private ArrayList<Player> players;
    private YahtzeeUi yahtzeeUi;
    private Roll dice;
    private Player currentPlayer;
    
    public Game(YahtzeeUi ui)
    {
        yahtzeeUi = ui;
        createPlayers();
        // initialize game turns to 0
        setGameTurn(Constants.ZERO);
        
        JOptionPane.showMessageDialog(null, "Let's play Yahtzee!");
    }
    
    private void createPlayers(){
        players = new ArrayList();
        
        for(int p = 0; p < Constants.TWOS; p++)
        {
            String name = JOptionPane.showInputDialog("Enter player name");
            HumanPlayer hp = new HumanPlayer();
            hp.setName(name);
            players.add(hp);
        }
        
//        Scanner input = new Scanner(System.in);
//        System.out.println("Player Name:"); 
//        String name = input.nextLine();
//        HumanPlayer player = new HumanPlayer();
//        player.setName(name);
        
//        AiPlayer ai = new AiPlayer();
//        ai.setName("Ai Dusty");
        
//        players.add(player);
//        players.add(ai);
    }
    
    private void switchPlayers()
    {
        currentPlayer.setFinished(false);
        currentPlayer.setCatSelected(false);
        currentPlayer.setRoll(0);
        yahtzeeUi.getRollUi().resetSelectedDice();
        
        if(currentPlayer == players.get(Constants.ZERO))
            currentPlayer = players.get(Constants.ONES);
        else if(currentPlayer == players.get(Constants.ONES))
            currentPlayer = players.get(Constants.ZERO);
    }
    
//    private void displayPlayers(){
//        System.out.println("*************************************");
//        System.out.println("Players for this game are:");
//        System.out.println("*************************************");
//        players.forEach((player) -> {
//            System.out.println(player.getName());
//        });
//    }
    public void playGame()
    {
        dice = new Roll();
        currentPlayer = players.get(Constants.ZERO);
        
        for(int turn = 0; turn < Constants.NUM_CATERGORY; turn++)
        {
            yahtzeeUi.getGameUi().setGameTurnValue(turn + 1);
        
            for(int p = 0; p < 2; p++)
            {
                currentPlayer.rollDice(dice);

                JOptionPane.showMessageDialog(yahtzeeUi.getRollUi(), currentPlayer.getName());
            
                while(!currentPlayer.isFinished())
                {
                    yahtzeeUi.getPlayerUi().setPlayerName(currentPlayer.getName());
                    yahtzeeUi.getScoreCardUi().setPlayer(currentPlayer);
                    yahtzeeUi.getRollUi().setPlayer(currentPlayer);
                }
            
                while(!currentPlayer.isCatSelected())
                {
                    //waiting....
                }
            
                switchPlayers();
            }
        }
        
//        for (Player player : players) 
//        {
//            Roll selected = new Roll();
//            selected.removeDice(selected);
//            
//            System.out.println("*************************************");
//            System.out.println("Player " + player.getName() + " was passed the dice");
//            System.out.println("Player " + player.getName() + " is rolling the dice");
//            System.out.println("*************************************");
//            while (selected.dice.size() < NUM_DICE && cur_roll < MAX_ROLLS){
//                player.rollDice(dice);
//                player.selectDice(dice, selected, cur_roll);
//                cur_roll++;
//            }
//            player.selectCategory(selected);
//        }
//        dice.displayDice();
    }
}
