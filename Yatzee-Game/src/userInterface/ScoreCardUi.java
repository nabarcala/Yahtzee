/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Player;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Natacha
 */
public class ScoreCardUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel grandTotal;    
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
        this.setMinimumSize(new Dimension(600, 500));
        this.setPreferredSize(new Dimension(600, 500));
        this.setMaximumSize(new Dimension(800, 500));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        upperUi = new UpperSectionUi();
        lowerUi = new LowerSectionUi();

        grandTotal = new JLabel("GRAND TOTAL                                        0");
        grandTotal.setMinimumSize(new Dimension(300, 40));
        grandTotal.setPreferredSize(new Dimension(300, 50));
        grandTotal.setMaximumSize(new Dimension(300, 60));
       
        this.add(upperUi);
        this.add(lowerUi);
        this.add(grandTotal);
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
        lowerUi.setPlayer(player);
        upperUi.setPlayer(player);
        updateUi();
    }
    
    public void updateUi()
    {
        lowerUi.updateUi();
        upperUi.updateUi();
    }
} 