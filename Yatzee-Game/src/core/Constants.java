/*
 * Karin Whiting
 * COP 3330 Object Oriented Programming
 * University of Central Florida
 */

package core;

public class Constants 
{
    public final static int ZERO = 0;
    
    // constant for yahtzee
    public final static int MAX_YAHTZEE = 4;
    
    // constants for the dice and categories
    public final static int LOWER_CATERGORY = 7;
    public final static int MAX_DIE_VALUE = 6;    
    public final static int NUM_CATERGORY = 13;
    public final static int NUM_DICE = 5;

    public final static int ONES = 1;
    public final static int TWOS = 2;
    public final static int THREES = 3;
    public final static int FOURS = 4;
    public final static int FIVES = 5;
    public final static int SIXES = 6;
    public final static int THREE_KIND = 7;
    public final static int FOUR_KIND = 8;
    public final static int CHANCE = 9;
    
    public final static String ACE = "Aces                                     "
            + "Count and add only aces";
    public final static String TWO = "Twos                                     "
            + "Count and add only twos";
    public final static String THREE = "Threes                                 "
            + "Count and add only threes";
    public final static String FOUR = "Fours                                   "
            + "Count and add only fours";
    public final static String FIVE = "Fives                                   "
            + "Count and add only fives";
    public final static String SIX = "Sixes                                    "
            + "Count and add only sixes";
    public final static String BONUS = "BONUS                                  "
            + "If total score is 63 or over";
    public final static String TRIPLE = "3 of a kind                           "
            + "Add total of all dice";
    public final static String QUAD = "4 of a kind                             "
            + "Add total of all dice";
    public final static String FULL = "Full house                              "
            + "Score 25";
    public final static String SMALL = "Small straight                         "
            + "Score 30";
    public final static String LARGE = "Large straight                         "
            + "Score 40";
    public final static String YAHTZ = "YAHTZEE                                "
            + "Score 50";
    public final static String YAHTZ_BONUS = "YAHTZEE BONUS                    "
            + "Score 100";
    public final static String LASTCHANCE = "Chance                            "
            + "Score total of all 5 dice";

    // static scores
    public final static int FULL_HOUSE = 25;
    public final static int SM_STRAIGHT = 30;
    public final static int UPPER_BONUS = 35;
    public final static int LG_STRAIGHT = 40;
    public final static int YAHTZEE = 50;   
    public final static int YAHTZEE_BONUS = 100;
    public final static int IS_BONUS = 63;
}