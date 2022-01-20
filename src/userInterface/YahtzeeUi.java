/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import constants.Constants;
import core.Game;
import core.Player;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class YahtzeeUi
{
    private GameUi gameUi;
    private PlayerUi playerUi;
    private RollUi rollUi;
    private ScoreCardUi scoreCardUi;
    private Game theGame;
    
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu game;
    private JMenuItem exit;
    private JMenuItem newGame;
    private JPanel rightPanel;
    private MenuListener menuListener;
    
    public YahtzeeUi()
    {
        initComponents();
        
        theGame = new Game(this);
        startGame();
    }
    
    private void initComponents()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Yahtzee!");
        frame.setMinimumSize(new Dimension(700, 900));
        frame.setPreferredSize(new Dimension(700, 900));
        frame.setMaximumSize(new Dimension(700, 900));
        
        // Initialize the JMenuBar and add to the JFrame
        createMenu();
        
        // Add everything to the JFrame
        frame.setJMenuBar(menuBar);
        
        // setting up the game
        gameUi = new GameUi();
        playerUi = new PlayerUi();      
        rollUi = new RollUi();
        
        rightPanel = new JPanel();
        rightPanel.setMinimumSize(new Dimension(300, 300));
        rightPanel.setPreferredSize(new Dimension(300, 300));
        rightPanel.setMaximumSize(new Dimension(300, 300));
        rightPanel.add(gameUi);
        rightPanel.add(playerUi);
        rightPanel.add(rollUi);
        
        scoreCardUi = new ScoreCardUi();
        
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(scoreCardUi, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    private void createMenu()
    {
        menuListener = new MenuListener();
        
        menuBar = new JMenuBar();
        game = new JMenu("Yahtzee");
        game.setMnemonic('Y');
        
        newGame = new JMenuItem("New Game");
        newGame.setMnemonic('N');
        newGame.addActionListener(menuListener);
        
        exit = new JMenuItem("Exit");
        exit.setMnemonic('E');
        exit.addActionListener(menuListener);

        game.add(newGame);    
        game.add(exit);    
        
        menuBar.add(game);
    }
    
    private void resetUi()
    {
        for(Player player : theGame.getPlayers())
        {
            player.getScore().getUpper().setAces(Constants.ZERO);
            player.getScore().getUpper().setTwos(Constants.ZERO);
            player.getScore().getUpper().setThrees(Constants.ZERO);
            player.getScore().getUpper().setFours(Constants.ZERO);
            player.getScore().getUpper().setFives(Constants.ZERO);
            player.getScore().getUpper().setSixes(Constants.ZERO);
            player.getScore().getLower().setChance(Constants.ZERO);
            player.getScore().getLower().setFourKind(Constants.ZERO);
            player.getScore().getLower().setFullHouse(Constants.ZERO);
            player.getScore().getLower().setLgStraight(Constants.ZERO);
            player.getScore().getLower().setSmStraight(Constants.ZERO);
            player.getScore().getLower().setThreeKind(Constants.ZERO);
            player.getScore().getLower().setTotalScore(Constants.ZERO);
            player.getScore().getLower().setYahtzee(Constants.ZERO);
            player.getScore().getLower().setYahtzeeBonus(Constants.ZERO);
        }
    }

    public GameUi getGameUi() {
        return gameUi;
    }

    public void setGameUi(GameUi gameUi) {
        this.gameUi = gameUi;
    }

    public PlayerUi getPlayerUi() {
        return playerUi;
    }

    public void setPlayerUi(PlayerUi playerUi) {
        this.playerUi = playerUi;
    }

    public RollUi getRollUi() {
        return rollUi;
    }

    public void setRollUi(RollUi rollUi) {
        this.rollUi = rollUi;
    }

    public ScoreCardUi getScoreCardUi() {
        return scoreCardUi;
    }

    public void setScoreCardUi(ScoreCardUi scoreCardUi) {
        this.scoreCardUi = scoreCardUi;
    }
    
    private void startGame()
    {
        theGame.playGame();
    }
    private class MenuListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            int result = 0;
        
            if(ae.getSource() instanceof JMenuItem)
            {
                if(ae.getActionCommand().equals("Exit"))
                    System.exit(0);
                else if(ae.getActionCommand().equals("New Game"))
                {
                    result = JOptionPane.showConfirmDialog(null, "Are you you want to start a new game?");
                
                    if(result == JOptionPane.YES_OPTION)
                    {
                        // reset all JLabels
                        resetUi();
                        // start new game
                        startGame();
                    }
                }
            }
        }
    }
}

