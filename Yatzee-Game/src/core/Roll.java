/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import userInterface.RollUi;

/**
 *
 * @author Natacha
 */
public class Roll 
{
    // container for the five dice
    private ArrayList<Die> dice = new ArrayList<Die>();
    private RollUi rollUi;
    
    // no-argument constructor
    public Roll()
    {
        // initialize the dice for the roll
        initializeDice();
    }
    
    // creates the five dice and adds them to the ArrayList 
    private void initializeDice()
    {
        // creates five Die objects and adds them to the ArrayList container
        for(int i = 0; i < Constants.NUM_DICE; i++)
        {
            Die die = new Die();
            dice.add(die);
        }
    }
    
    public void rollDice()
    {
        // loop through the dice and roll each one
        for(Die die : dice)
        {
            die.rollDie();
        }
    }

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
}