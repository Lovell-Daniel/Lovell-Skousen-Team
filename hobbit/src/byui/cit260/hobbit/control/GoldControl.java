/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hobbit.control;

import byui.cit260.hobbit.model.GoldPouch;
import hobbit.Hobbit;

/**
 *
 * @author daniel
 */
public class GoldControl {
    
    public static int correctAnswer(int countCorrect, int lastGoldEarned) {
        GoldPouch goldPouch = Hobbit.getGoldPouch();
        int newGold = 0;
        int newGoldEarned = 0;
        //Add Calculated Gold to GoldPouch
        newGoldEarned = calculateEarnedGold(lastGoldEarned, countCorrect);
        newGold = goldPouch.getAmount() + newGoldEarned;
        goldPouch.setAmount(newGold);
        return newGoldEarned;
    }
    
    public static int calculateEarnedGold(int lastGoldEarned, int countCorrect) {
        
        if (lastGoldEarned < 0) {
            return -1;
        }
        
        if (countCorrect < 1) {
            return -1;
        }

        int earnedGold = 0;

        if (countCorrect > 1) {
            earnedGold = (lastGoldEarned + 1) * 2;
        } else {
            earnedGold = lastGoldEarned + 1;
        }
        return earnedGold;
    }

    public static boolean pouchFull(GoldPouch goldPouch) {
        
        return goldPouch.getAmount() / goldPouch.getMaxAmount() >= 1;
    }
   
}
