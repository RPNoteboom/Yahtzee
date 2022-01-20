/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */
package userInterface;

import constants.Constants;
import core.Player;
import core.UpperSection;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class UpperSectionUi extends JPanel
{

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
    private JLabel total;
    private JLabel bonus;
    private JLabel totalScore;
    private JLabel totalScr;
    private JLabel bonusScr;
    private JLabel totalScoreScr;
    private SelectionListener selectionListener;
    private Player player;
    private static int CATS = 6;
    private static int ROWS = 9;
    private static int COLS = 2;
    private GridLayout gridLayout;
    private UpperSection upperSection;
    
    public UpperSectionUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        // layout manager
        gridLayout = new GridLayout(ROWS, COLS);
        
        // setting up JPanel
        this.setLayout(gridLayout);        
        this.setMinimumSize(new Dimension(500, 300));
        this.setPreferredSize(new Dimension(500, 300));
        this.setMaximumSize(new Dimension(500, 300));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList();
        scores = new ArrayList();
        
        selectionListener = new SelectionListener();
               
        for(int i = 0; i < CATS; i++)
        {
            JButton category = new JButton();
            category.setMinimumSize(new Dimension(300, 35));
            category.setPreferredSize(new Dimension(300, 35));
            category.setMaximumSize(new Dimension(300, 35));
            category.addActionListener(selectionListener);
            
            switch(i)
            {
                case 0:
                    category.setText("ACES");
                    category.putClientProperty("category", Constants.ONES);
                    break;
                case 1:
                    category.setText("TWOS");
                    category.putClientProperty("category", Constants.TWOS);
                    break;
                case 2:
                    category.setText("THREES");
                    category.putClientProperty("category", Constants.THREES);
                    break;
                case 3:
                    category.setText("FOURS");
                    category.putClientProperty("category", Constants.FOURS);
                    break;
                case 4:
                    category.setText("FIVES");
                    category.putClientProperty("category", Constants.FIVES);
                    break;
                case 5:
                    category.setText("SIXES");
                    category.putClientProperty("category", Constants.SIXES);
                    break;
                default:
                    break;
            }
            categories.add(category);

            JLabel score = new JLabel(String.valueOf(Constants.ZERO));
            score.setMinimumSize(new Dimension(50, 35));
            score.setMaximumSize(new Dimension(50, 35));
            score.setPreferredSize(new Dimension(50, 35));
            score.setVerticalTextPosition(JLabel.CENTER);
            score.setHorizontalTextPosition(JLabel.CENTER);

            scores.add(score);
        }
              
        totalScore = new JLabel("TOTAL SCORE");
        totalScore.setMinimumSize(new Dimension(300, 25));
        totalScore.setPreferredSize(new Dimension(300, 25));
        totalScore.setMaximumSize(new Dimension(300, 25));

        totalScoreScr = new JLabel("0");
        totalScoreScr.setMinimumSize(new Dimension(50, 25));
        totalScoreScr.setPreferredSize(new Dimension(50, 25));
        totalScoreScr.setMaximumSize(new Dimension(50, 25));

        bonus = new JLabel();
        bonus.setText("BONUS");
        bonus.setMinimumSize(new Dimension(300, 25));
        bonus.setPreferredSize(new Dimension(300, 25));
        bonus.setMaximumSize(new Dimension(300, 25));
        
        bonusScr = new JLabel();
        bonusScr.setText("0");
        bonusScr.setMinimumSize(new Dimension(50, 25));
        bonusScr.setPreferredSize(new Dimension(50, 25));
        bonusScr.setMaximumSize(new Dimension(50, 25));

        total = new JLabel("TOTAL of Upper Section");
        total.setMinimumSize(new Dimension(120, 25));
        total.setPreferredSize(new Dimension(120, 25));
        total.setMaximumSize(new Dimension(120, 25));

        totalScr = new JLabel("0");
        totalScr.setMinimumSize(new Dimension(50, 25));
        totalScr.setPreferredSize(new Dimension(50, 25));
        totalScr.setMaximumSize(new Dimension(50, 25));
        System.out.println(categories.size());
        // add the UI components
        for(int row = 0; row < categories.size(); row++)
        {
            this.add(categories.get(row));
            this.add(scores.get(row));
        }
        
        this.add(totalScore);
        this.add(totalScoreScr);
        this.add(bonus);
        this.add(bonusScr);
        this.add(total);
        this.add(totalScr);

    }
    
    public void updateUi()
    {
        int counter = 0;
        
        for(JLabel score : scores)
        {
            switch(counter)
            {
                case 0:
                    score.setText(String.valueOf(player.getScore().getUpper().getAces()));
                case 1:
                    score.setText(String.valueOf(player.getScore().getUpper().getTwos()));
                case 2:
                    score.setText(String.valueOf(player.getScore().getUpper().getThrees()));
                case 3:
                    score.setText(String.valueOf(player.getScore().getUpper().getFours()));
                case 4:
                    score.setText(String.valueOf(player.getScore().getUpper().getFives()));
                case 5:
                    score.setText(String.valueOf(player.getScore().getUpper().getSixes()));
                case 6:
                    score.setText(String.valueOf(player.getScore().getUpper().getTotalScore()));
            }
            counter++;
        }
    }

    /**
     * @return the upperSection
     */
    public UpperSection getUpperSection() {
        return upperSection;
    }

    /**
     * @param upperSection the upperSection to set
     */
    public void setUpperSection(UpperSection upperSection) {
        this.upperSection = upperSection;
    }
    
    private class SelectionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int category = 0;
            
            if(ae.getSource() instanceof JButton)
            {
                JButton button = (JButton)ae.getSource();
                category = (int)button.getClientProperty("category");
                //check the category and add the dice together
                upperSection.evaluateCategory(player.getRollDice(), category);
                
                player.setCatSelected(true);
                player.setFinished(true);
                
                updateUi();
            }
        }
        
    }
}
