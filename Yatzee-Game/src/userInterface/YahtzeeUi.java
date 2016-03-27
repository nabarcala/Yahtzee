/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Natacha
 */
public class YahtzeeUi extends JFrame
{
    private GameUi gameUi;
    private PlayerUi playerUi;
    private RollUi rollUi;
    private ScoreCardUi scoreCardUi;
    private Game theGame;
    
//    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu game;
    private JMenuItem exit;
    private JMenuItem newGame;
    private JPanel rightPanel;
    private MenuListener menuListener;
    
    public YahtzeeUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Yahtzee!");
        this.setMinimumSize(new Dimension(840, 740));
        this.setPreferredSize(new Dimension(840, 740));
        this.setMaximumSize(new Dimension(840, 760));
        // Initialize the JMenuBar and add to the JFrame
        createMenu();
        
        // Add everything to the JFrame
        this.setJMenuBar(menuBar);
        
        // setting up the game
        setGameUi(new GameUi());
        setPlayerUi(new PlayerUi());      
        setRollUi(new RollUi());
        
        rightPanel = new JPanel();
        rightPanel.setMinimumSize(new Dimension(300, 700));
        rightPanel.setPreferredSize(new Dimension(300, 700));
        rightPanel.setMaximumSize(new Dimension(300, 700));
        rightPanel.add(getGameUi());
        rightPanel.add(getPlayerUi());
        rightPanel.add(getRollUi());
        
        setScoreCardUi(new ScoreCardUi());
        
        theGame = new Game(this);

        this.add(rightPanel, BorderLayout.EAST);
        this.add(getScoreCardUi(), BorderLayout.CENTER);
        this.setVisible(true);
        
        startGame();
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
        
    }
    
    private void startGame()
    {
        theGame.playGame();
    }

    /**
     * @return the gameUi
     */
    public GameUi getGameUi() {
        return gameUi;
    }

    /**
     * @param gameUi the gameUi to set
     */
    public void setGameUi(GameUi gameUi) {
        this.gameUi = gameUi;
    }

    /**
     * @return the playerUi
     */
    public PlayerUi getPlayerUi() {
        return playerUi;
    }

    /**
     * @param playerUi the playerUi to set
     */
    public void setPlayerUi(PlayerUi playerUi) {
        this.playerUi = playerUi;
    }

    /**
     * @return the rollUi
     */
    public RollUi getRollUi() {
        return rollUi;
    }

    /**
     * @param rollUi the rollUi to set
     */
    public void setRollUi(RollUi rollUi) {
        this.rollUi = rollUi;
    }

    /**
     * @return the scoreCardUi
     */
    public ScoreCardUi getScoreCardUi() {
        return scoreCardUi;
    }

    /**
     * @param scoreCardUi the scoreCardUi to set
     */
    public void setScoreCardUi(ScoreCardUi scoreCardUi) {
        this.scoreCardUi = scoreCardUi;
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
                {
                    System.exit(0); 
                }
                else if(ae.getActionCommand().equals("New Game"))
                {
                    result = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?");
                    
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