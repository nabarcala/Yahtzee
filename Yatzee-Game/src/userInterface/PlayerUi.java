/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import core.Player;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Natacha
 */
public class PlayerUi extends JPanel
{
    private BoxLayout boxLayout;
    private JLabel playerName;
    private JLabel playerScore;
    
    public PlayerUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(200, 60));
        this.setPreferredSize(new Dimension(200, 60));
        this.setMaximumSize(new Dimension(200, 60));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        
        playerName = new JLabel();
        playerName.setText("Name");
        playerName.setMinimumSize(new Dimension(100, 60));
        playerName.setPreferredSize(new Dimension(100, 60));
        playerName.setMaximumSize(new Dimension(100, 60));
        
        playerScore = new JLabel();
        playerScore.setText(String.valueOf(Constants.ZERO));
        playerScore.setMinimumSize(new Dimension(100, 60)); 
        playerScore.setPreferredSize(new Dimension(100, 60));
        playerScore.setMaximumSize(new Dimension(100, 60));
        
        this.add(playerName);
        this.add(playerScore);
    }
    
    public void setPlayerName(String name)
    {
        playerName.setText(name);
    }
}