/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.hobbit.view;

import byui.cit260.hobbit.control.GoldControl;
import byui.cit260.hobbit.control.MathControl;
import java.io.IOException;


public class GoldView extends View {
    
    GoldView() {
        super("\n"
            + "\n-----------------------------------------------------"
            + "\n| Gold Mines Menu                                   |"
            + "\n| Dig for gold by answering math problems.          |"
            + "\n-----------------------------------------------------"
            + "\nA - Addition is worth 1 piece of Gold"
            + "\nS - Subtraction is worth 2 pieces of Gold"
            + "\nM - Multiplication is worth 3 pieces of Gold"
            + "\nD - Division is worth 4 pieces of Gold"
            + "\nE - Exit"
            + "\n-----------------------------------------------------");
    }
    
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase();
        char choice = value.charAt(0);
        switch (choice) {
            case 'A': // create and start a new game
                this.doMath("+");
                break;
            case 'S': // get and start and existing game
                this.doMath("-");
                break;
            case 'M': // display the help menu
                this.doMath("*");
                break;
            case 'D': // save the current game
                this.doMath("/");
                break;
            case 'E': // Leave the Gold Mines
                break;
            default: // 
                this.console.println("\n*** Invalid Selection - Try again");
                break;
        }
        return true;
    }

    private void doMath(String operator) {

        int countCorrect = 0;
        int lastGoldEarned = 0;
        boolean userContinue = false;
        
        do {
            //Display Math
            MathControl math = new MathControl();
            this.console.println(math.makeMath(operator));

            //Get Input
            String userAnswer = null;
            try {
                userAnswer = this.getMathInput();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                                    "Error reading input: " + ex.getMessage());
            }

            //Do Action
            if (math.verifyMath(userAnswer)) {
                countCorrect++;
                lastGoldEarned = GoldControl.correctAnswer(countCorrect, lastGoldEarned);
            } else {
                ErrorView.display(this.getClass().getName(),"\nWrong Answer");
                countCorrect = 0;
                lastGoldEarned = 0;
            }

            try {
                //Does user want to continue?
                userContinue = this.getContinueInput();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),
                                    "Error reading input: " + ex.getMessage());
            }

        } while (userContinue);
    }
    
    private String getMathInput() throws IOException {
        boolean valid = false;
        String selection = null;
        
        while(!valid) {
            selection = this.keyboard.readLine();
            selection = selection.trim();
            
            break;
        }
        return selection;
    }

    private boolean getContinueInput() throws IOException {
        boolean valid = false;
        String selection = null;
        
        while(!valid) {
            this.console.println("Do you want to continue? (Y/N)");
            
            selection = this.keyboard.readLine();
            selection = selection.trim();
            selection = selection.toUpperCase();
            
            if ("Y".equals(selection) || "N".equals(selection)){
                break;
            } else {
                ErrorView.display(this.getClass().getName(),"\nInvalid Selection - Try again.");
            }
        }
        return "Y".equals(selection);
    }
       
}
