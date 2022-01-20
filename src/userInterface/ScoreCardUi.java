/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package userInterface;

import core.Player;
import java.awt.Dimension;

import javax.swing.*;

public class ScoreCardUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel grandTotal;
    private JLabel grandTotalScr;
    private LowerSectionUi lowerUi;
    private UpperSectionUi upperUi;
    private Player player;
    
    public ScoreCardUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(300, 500));
        this.setPreferredSize(new Dimension(300, 500));
        this.setMaximumSize(new Dimension(300, 500));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        upperUi = new UpperSectionUi();
        lowerUi = new LowerSectionUi();

        grandTotal = new JLabel("GRAND TOTAL");
        grandTotal.setMinimumSize(new Dimension(300, 25));
        grandTotal.setPreferredSize(new Dimension(300, 25));
        grandTotal.setMaximumSize(new Dimension(300, 25));
        
        grandTotalScr = new JLabel("0");
        grandTotalScr.setMinimumSize(new Dimension(300, 25));
        grandTotalScr.setPreferredSize(new Dimension(300, 25));
        grandTotalScr.setMaximumSize(new Dimension(300, 25));
        
        this.add(getUpperUi());
        this.add(getLowerUi());
        this.add(grandTotal);
        this.add(grandTotalScr);
    }

    /**
     * @return the lowerUi
     */
    public LowerSectionUi getLowerUi() {
        return lowerUi;
    }

    /**
     * @return the upperUi
     */
    public UpperSectionUi getUpperUi() {
        return upperUi;
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
    public void setPlayer(Player player)
    {
        this.player = player;
        
        lowerUi.setPlayer(this.player);
        lowerUi.setLowerSection(this.player.getScore().getLower());
        
        upperUi.setPlayer(this.player);
        upperUi.setUpperSection(this.player.getScore().getUpper());
        
        updateUi();
    }
    
    public void updateUi()
    {
        lowerUi.updateUi();
        upperUi.updateUi();
    }
}
