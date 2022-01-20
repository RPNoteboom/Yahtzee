/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package userInterface;

import constants.Constants;
import core.Die;
import core.LowerSection;
import core.Player;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.*;
        
public class LowerSectionUi extends JPanel
{

    /**
     * @return the lowerSection
     */
    public LowerSection getLowerSection() {
        return lowerSection;
    }

    /**
     * @param lowerSection the lowerSection to set
     */
    public void setLowerSection(LowerSection lowerSection) {
        this.lowerSection = lowerSection;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
    private ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private GridLayout gridLayout;
    private JLabel totalLower;
    private JLabel totalUpper;
    private JLabel totalLowerScore;
    private JLabel totalUpperScore;
    private LowerSection lowerSection;
    private SelectionListener selectionListener;
    private Player player;
    private static int CATS = 7;
    private static int ROWS = 10;
    private static int COLS = 2;

    public LowerSectionUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        // layout manager
        gridLayout = new GridLayout(ROWS, COLS);
        
        // setting up JPanel
        this.setLayout(gridLayout);        
        this.setMinimumSize(new Dimension(500, 500));
        this.setPreferredSize(new Dimension(500, 500));
        this.setMaximumSize(new Dimension(500, 500));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList<>();
        scores = new ArrayList<>();
        
        selectionListener = new SelectionListener();
        
        for(int i = 0; i < CATS; i++)
        {
            // JButton for the category
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(300, 35));
            category.setPreferredSize(new Dimension(300, 35));
            category.setMaximumSize(new Dimension(300, 35));
            category.addActionListener(selectionListener);  
            
            switch(i)
            {
                case 0:
                    category.setText("THREE OF A KIND");
                    category.putClientProperty("category", Constants.THREE_KIND);
                    break;
                case 1:
                    category.setText("FOUR OF A KIND");
                    category.putClientProperty("category", Constants.FOUR_KIND);
                    break;
                case 2:
                    category.setText("FULL HOUSE");
                    category.putClientProperty("category", Constants.FULL_HOUSE);
                    break;
                case 3:
                    category.setText("SMALL STRAIGHT");
                    category.putClientProperty("category", Constants.SM_STRAIGHT);
                    break;
                case 4:
                    category.setText("LARGE STRAIGHT");
                    category.putClientProperty("category", Constants.LG_STRAIGHT);
                    break;
                case 5:
                    category.setText("YAHTZEE");
                    category.putClientProperty("category", Constants.YAHTZEE);
                    break;
                case 6:
                    category.setText("CHANCE");
                    category.putClientProperty("category", Constants.CHANCE);
                    break;
                case 7:
                    category.setText("YAHTZEE BONUS");
                    category.putClientProperty("category", Constants.YAHTZEE_BONUS);
                    break;
                default:
                    category.setText("No valid value");
                    break;
            }
            categories.add(category);
            
            JLabel score = new JLabel(String.valueOf(Constants.ZERO));
            score.setMinimumSize(new Dimension(50, 35));
            score.setMaximumSize(new Dimension(50, 35));
            score.setPreferredSize(new Dimension(50, 35));
            score.setHorizontalTextPosition(JLabel.CENTER);
            scores.add(score);
        }
              
        totalLower = new JLabel("TOTAL of Lower Section0");
        totalLower.setMinimumSize(new Dimension(500, 35));
        totalLower.setPreferredSize(new Dimension(500, 35));
        totalLower.setMaximumSize(new Dimension(500, 35));

        totalLowerScore = new JLabel("0");
        totalLowerScore.setMinimumSize(new Dimension(50, 25));
        totalLowerScore.setPreferredSize(new Dimension(50, 25));
        totalLowerScore.setMaximumSize(new Dimension(50, 25));

        totalUpper = new JLabel("TOTAL of Upper Section");
        totalUpper.setMinimumSize(new Dimension(500, 35));
        totalUpper.setPreferredSize(new Dimension(500, 35));
        totalUpper.setMaximumSize(new Dimension(500, 35));

        totalUpperScore = new JLabel("0");
        totalUpperScore.setMinimumSize(new Dimension(50, 25));
        totalUpperScore.setPreferredSize(new Dimension(50, 25));
        totalUpperScore.setMaximumSize(new Dimension(50, 25));

        for(int row = 0; row < categories.size(); row++)
        {
            this.add(categories.get(row));
            this.add(scores.get(row));
        }
        
        this.add(totalLower);
        this.add(totalLowerScore);
        this.add(totalUpper);
        this.add(totalUpperScore);

    }
    
    public void updateUi()
    {
        int counter = 0;
        for(JLabel score : scores)
        {
            switch(counter)
            {
                case 0:
                    score.setText(String.valueOf(player.getScore().getLower().getThreeKind()));
                case 1:
                    score.setText(String.valueOf(player.getScore().getLower().getFourKind()));
                case 2:
                    score.setText(String.valueOf(player.getScore().getLower().getFullHouse()));
                case 3:
                    score.setText(String.valueOf(player.getScore().getLower().getSmStraight()));
                case 4:
                    score.setText(String.valueOf(player.getScore().getLower().getLgStraight()));
                case 5:
                    score.setText(String.valueOf(player.getScore().getLower().getYahtzee()));
                case 6:
                    score.setText(String.valueOf(player.getScore().getLower().getYahtzeeBonus()));
            }
            counter++;
        }
        totalLower.setText(String.valueOf(player.getScore().getLower().getTotalScore()));
        totalUpper.setText(String.valueOf(player.getScore().getUpper().getTotal()));
    }
    
    private class SelectionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            int category = 0;
            
            if(ae.getSource() instanceof JButton)
            {
                JButton button = (JButton)ae.getSource();
                
                category = (int)button.getClientProperty("category");
                
                player.setCatSelected(true);
                player.setFinished(true);
                
                //check category and add the dice together
                lowerSection.evaluateCategory(player.getRollDice(), category);
                
                updateUi();
            }
        }
        
    }
}
