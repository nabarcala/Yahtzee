/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import core.Die;
import core.LowerSection;
import core.Player;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Natacha
 */
public class LowerSectionUi extends JPanel
{
    public ArrayList<JButton> categories;
    private ArrayList<JLabel> scores;
    private GridBagLayout gridBagLayout;
    private GridBagConstraints constraints;
    private JLabel totalLower;
    private JLabel totalUpper;
    private LowerSection lowerSection;
    private SelectionListener selectionListener;
    private Player player;

    public LowerSectionUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        // layout manager
        gridBagLayout = new GridBagLayout();
        constraints = new GridBagConstraints();
        
        // setting up JPanel
        this.setLayout(gridBagLayout);        
        this.setMinimumSize(new Dimension(500,335));
        this.setPreferredSize(new Dimension(500, 335));
        this.setMaximumSize(new Dimension(500, 340));
        this.setBorder(BorderFactory.createRaisedBevelBorder());

        categories = new ArrayList<JButton>();
        scores = new ArrayList<JLabel>();
        
        selectionListener = new SelectionListener();

        for(int i = 0; i <= Constants.LOWER_CATERGORY; i++)
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
                    category.setText(Constants.TRIPLE);
                    category.putClientProperty("category", Constants.THREE_KIND);
                    break;
                case 1:
                    category.setText(Constants.QUAD);
                    category.putClientProperty("category", Constants.FOUR_KIND);
                    break;
                case 2:
                    category.setText(Constants.FULL);
                    category.putClientProperty("category", Constants.FULL_HOUSE);
                    break;
                case 3:
                    category.setText(Constants.SMALL);
                    category.putClientProperty("category", Constants.SM_STRAIGHT);
                    break;
                case 4:
                    category.setText(Constants.LARGE);
                    category.putClientProperty("category", Constants.LG_STRAIGHT);
                    break;
                case 5:
                    category.setText(Constants.YAHTZ);
                    category.putClientProperty("category", Constants.YAHTZEE);
                    break;
                case 6:
                    category.setText(Constants.LASTCHANCE);
                    category.putClientProperty("category", Constants.CHANCE);
                    break;
                case 7:
                    category.setText(Constants.YAHTZ_BONUS);
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
              
        totalLower = new JLabel("TOTAL of Lower Section                              0");
        totalLower.setMinimumSize(new Dimension(500, 25));
        totalLower.setPreferredSize(new Dimension(500, 25));
        totalLower.setMaximumSize(new Dimension(500, 25));

        totalUpper = new JLabel("TOTAL of Upper Section                              0");
        totalUpper.setMinimumSize(new Dimension(500, 35));
        totalUpper.setPreferredSize(new Dimension(500, 35));
        totalUpper.setMaximumSize(new Dimension(500, 35));

        // add the UI components
        // X is the column
        // Y is the row
        // W is the width in cells
        // H is the height in cells
        // aContainer is the container the component is added to
        // aComponent is the component being added to the container
        int row = 0;
        for(JButton category : categories)
        {
            addComponent(0, row, 1, 1, this, category);
            row++; 
        }
        row = 0;
        for(JLabel score : scores) 
        {
            addComponent(1, row, 1, 1, this, score);
            row++;
        }
        
        addComponent(1, row++, 1, 1, this, totalUpper);
        addComponent(1, row++, 1, 1, this, totalLower);
        
    }

    // X is the column
    // Y is the row 
    // W is the width in cells
    // H is the height in cells
    // aContainer is the container the component is added to
    // aComponent is the component being added to the container
    private void addComponent( int x, int y, int w, int h, 
                               Container aContainer, Component aComponent )  
    {  
        constraints.gridx = x;  
        constraints.gridy = y;  
        constraints.gridwidth = w;  
        constraints.gridheight = h;
    
        gridBagLayout.setConstraints( aComponent, constraints );  
        
        aContainer.add( aComponent );  
    } 

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
    public void setPlayer(Player player) 
    {
        this.player = player;
    }
    
    public void updateUi()
    {
        int counter = 0;
        for(JLabel category : scores)
        {
            switch(counter)
            {
                case 0:
                    category.setText(String.valueOf(player.getScore().getLower().getThreeKind()));
                    break;
                case 1:
                    category.setText(String.valueOf(player.getScore().getLower().getFourKind()));
                    break;
                case 2:
                    category.setText(String.valueOf(player.getScore().getLower().getFullHouse()));
                    break;
                case 3:
                    category.setText(String.valueOf(player.getScore().getLower().getSmallStraight()));
                    break;
                case 4:
                    category.setText(String.valueOf(player.getScore().getLower().getLargeStraight()));
                    break;
                case 5:
                    category.setText(String.valueOf(player.getScore().getLower().getYahtzee()));
                    break;
                case 6: 
                     category.setText(String.valueOf(player.getScore().getLower().getChance()));
                    break;
                case 7:
                    category.setText(String.valueOf(player.getScore().getLower().getYahtzeeBonus()));
                    break;
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
//                String data = button.getActionCommand();
//                String dataToo = button.getText();
                category = (int)button.getClientProperty("category");                                

                // get the player's dice
                ArrayList<Die> dice = player.getRoll().getDice();
                
                // check the category and add the dice together
                int score = 0;
                        
                switch(category)
                {
                    case Constants.THREE_KIND:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                            score += dice.get(i).getFaceValue();
                        }
                        
                        player.getScore().getLower().setThreeKind(score);
                        categories.get(0).setEnabled(false);
                        scores.get(0).setText(String.valueOf(player.getScore().getLower().getThreeKind()));
                        break;
                        
                        ///FOUR OF A KIND
                        case Constants.FOUR_KIND:                        
                        // add together the dice that have the same face value
                        // loop through dice and find duplicates
                        // count how many
                        for(int i = 0; i < dice.size(); i++)
                        {
                            score += dice.get(i).getFaceValue();
                            //totalScore = score;
                        }
                        
                        player.getScore().getLower().setFourKind(score);
                        categories.get(1).setEnabled(false);
                        scores.get(1).setText(String.valueOf(player.getScore().getLower().getFourKind()));
                        break;
                        
                    case Constants.FULL_HOUSE:

                        score = Constants.FULL_HOUSE;
                        
                        player.getScore().getLower().setFullHouse(score);
                        categories.get(2).setEnabled(false);
                        scores.get(2).setText(String.valueOf(player.getScore().getLower().getFullHouse()));
                        break;
                        
                    case Constants.SM_STRAIGHT:

                        score = Constants.SM_STRAIGHT;
                        
                        player.getScore().getLower().setSmallStraight(score);
                        categories.get(3).setEnabled(false);
                        scores.get(3).setText(String.valueOf(player.getScore().getLower().getSmallStraight()));
                        break; 
                        
                    
                        
                    case Constants.LG_STRAIGHT:         
                        
                        score = Constants.LG_STRAIGHT;
                        
                       
                        player.getScore().getLower().setLargeStraight(Constants.LG_STRAIGHT);
                        scores.get(4).setEnabled(false);
                        scores.get(4).setText(String.valueOf(player.getScore().getLower().getLargeStraight()));
                        break;
                        
                        
                        
                  case Constants.YAHTZEE:

                        score = Constants.YAHTZEE;
                        
                        player.getScore().getLower().setYahtzee(score);
                        categories.get(5).setEnabled(false);
                        scores.get(5).setText(String.valueOf(player.getScore().getLower().getYahtzee()));
                        break; 
                        
                        
                        
                        
                        
                  case Constants.CHANCE:

                      for (int i = 0; i < dice.size(); i++)
                      {
                        score += dice.get(i).getFaceValue();
                      } 
                        player.getScore().getLower().setChance(score);
                        categories.get(6).setEnabled(false);
                        scores.get(6).setText(String.valueOf(player.getScore().getLower().getChance()));
                        break;       
                        
                        
                 case Constants.YAHTZEE_BONUS:

                        score = Constants.YAHTZEE_BONUS;
                        
                        player.getScore().getLower().setYahtzeeBonus(score);
                        categories.get(7).setEnabled(false);
                        scores.get(7).setText(String.valueOf(player.getScore().getLower().getYahtzeeBonus()));
                        break; 
                        
                }     
                totalLower.setText(String.valueOf(player.getScore().getLower().getTotalScore()));
            }
        }
    }
}