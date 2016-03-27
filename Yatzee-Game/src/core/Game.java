/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import userInterface.YahtzeeUi;

/**
 *
 * @author Natacha
 */ 
public class Game extends Player 
{
    private int gameTurn;
    private ArrayList<Player> players = new ArrayList<Player>();
    private YahtzeeUi yahtzeeUi;
    
    // no-arguement constructor 
    public Game(YahtzeeUi ui)
    {
        yahtzeeUi  = ui;

        // get number of players
        int numPlayers = Integer.parseInt(JOptionPane.showInputDialog("How many players for this game? "));
        // initialize game turns to 0
        setGameTurn(Constants.ZERO);
        // loop through number of players and create the objects
        for(int i = 0; i < numPlayers; i++)
        {
            // call method to create the new player
            newPlayer();
        }   
        JOptionPane.showMessageDialog(null, "Let's play Yahtzee!");
    }
    
    /**
     * @return the gameTurn
     */
    public int getGameTurn() 
    {
        return gameTurn;
    }

    /**
     * @param gameTurn the gameTurn to set
     */
    public void setGameTurn(int gameTurn) 
    {
        this.gameTurn = gameTurn;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) 
    {
        this.players = players;
    }
    
    private void newPlayer()
    {
        // prompt the user for the player name
        String data = JOptionPane.showInputDialog("Enter player's name: ");
        // create a new Player with data
        Player player = new Player();
        // set the name member variable to the data read in
        player.setName(data);
        // add the player to the container
        players.add(player);
    }

    public void displayPlayers()
    {
        System.out.println("Players for this game are: ");

        // loop through players and display information
        for(Player player : players)
        {
            System.out.println(player.getName());
        }
    }
    
    public void playGame()
    {
        for(int turn = 0; turn < Constants.NUM_CATERGORY; turn++)
        {
            yahtzeeUi.getGameUi().setGameTurnValue(turn + 1);
            
            for(Player player : players)
            {
                player.setFinished(false);
                JOptionPane.showMessageDialog(null, player.getName() + " please roll the dice");
                
                while(!player.isFinished())
                {
                    yahtzeeUi.getPlayerUi().setPlayerName(player.getName());
                    yahtzeeUi.getScoreCardUi().setPlayer(player);
                    yahtzeeUi.getRollUi().setPlayer(player);
                }
                // reset your player
                player.setFinished(false);
            }
        }
        
        
        JOptionPane.showMessageDialog(null, "Game over!");

        /* The following code is used to determine the winner of the game */
        String winner = "";

        for(int i = 0; i < players.size(); i++)
        {
            if(i < players.size() - 1)
            {
                if(players.get(i).getScore().getGrandTotal() < players.get(i+1).getScore().getGrandTotal())
                {
                    winner = players.get(i).getName();
                }
                else
                {
                    winner = players.get(i+1).getName();
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, winner + " is the winner!");

    }
}