/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Random;

/**
 *
 * @author Natacha
 */
public class Die  
{
    private int faceValue;
    
    public void rollDie()
    {
        Random random = new Random();
        setFaceValue(random.nextInt(Constants.MAX_DIE_VALUE) + 1);
    }

    /**
     * @return the faceValue
     */
    public int getFaceValue() 
    {
        return faceValue;
    }

    /**
     * @param faceValue the faceValue to set
     */
    public void setFaceValue(int faceValue) 
    {
        this.faceValue = faceValue;
    }
    
    @Override
    public String toString()
    {
        return Integer.toString(getFaceValue());
    }
} 