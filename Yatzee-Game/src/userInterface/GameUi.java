/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Constants;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Natacha
 */
public class GameUi extends JPanel
{
    private BoxLayout boxLayout;
    private ImageIcon logoImage;
    private JLabel maxTurn;
    private JLabel gameTurn;
    private JLabel logo;
    
    public GameUi()
    {
        initComponents();
    }
    
    private void initComponents()
    {
        boxLayout = new BoxLayout(this, BoxLayout.X_AXIS);
        
        this.setLayout(boxLayout);
        this.setMinimumSize(new Dimension(300, 100));
        this.setPreferredSize(new Dimension(300, 100));
        this.setMaximumSize(new Dimension(300, 100));
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        
        logo = new JLabel();
        logo.setMinimumSize(new Dimension(150, 200));
        logo.setPreferredSize(new Dimension(150, 200));
        logo.setMaximumSize(new Dimension(150, 200));
        logoImage = new ImageIcon( getClass().getResource("../images/yahtzee.jpg"));
        logoImage = imageResize(logoImage);
        logo.setIcon(logoImage);

        gameTurn = new JLabel();
        gameTurn.setMinimumSize(new Dimension(30, 15));
        gameTurn.setPreferredSize(new Dimension(30, 15));
        gameTurn.setMaximumSize(new Dimension(30, 15));
        gameTurn.setFont(new Font("Serif", Font.BOLD, 16));
        
        maxTurn = new JLabel();
        maxTurn.setMinimumSize(new Dimension(30, 15));
        maxTurn.setPreferredSize(new Dimension(30, 15));
        maxTurn.setMaximumSize(new Dimension(30, 15));
        maxTurn.setText(" / " + String.valueOf(Constants.NUM_CATERGORY));
        maxTurn.setFont(new Font("Serif", Font.BOLD, 16));

        this.add(logo);
        this.add(gameTurn); 
        this.add(maxTurn);
    }
   
    public void setGameTurnValue(int value)
    {
        gameTurn.setText(String.valueOf(value));
    }
    
        // method to resize the image to fit on the jbutton
    private ImageIcon imageResize(ImageIcon icon)
    {
        Image image = icon.getImage();
        Image newImage = 
               image.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }

}