
package byui.cit260.hobbit.view;

import byui.cit260.hobbit.control.GameControl;
import hobbit.Hobbit;



public class MainMenuView extends View {
   
    @Override
    public boolean doAction(Object obj){
        
        String value = (String) obj;
        
        value = value.toUpperCase();
        char choice = value.charAt(0);
        return true;
    }
    
    public MainMenuView() {
    /* private final String MENU = */ super("\n"
            + "\n-----------------------------------------------------"
            + "\n| Main Menu                                         |"
            + "\n-----------------------------------------------------"
            + "\nG - Start Game"
            + "\nN - New Game"
            + "\nS - Save game"
            + "\nH - Help"
            + "\nD - Dragon"
            + "\nO - Gold"
            + "\nB - Store"
            + "\nE - Exit"
            + "\n-----------------------------------------------------");
    }
    
    /* void displayMenu() {
        
        char selection = ' ';
        do {
            System.out.println(MENU); //DISPLAY the Main Menu
            
            String input = this.getInput(); //GET the user’s selection
            selection = input.charAt(0); //get first character of string
            
            this.doAction(selection); //Perform the action associated with selection
   
        } while (selection != 'E'); // a selection is not "Exit"
        
    } */

    /*private String getInput() {
        boolean valid = false;           
        String selection = null;
        Scanner keyboard = new Scanner(System.in);
        
        while(!valid) {
            //System.out.println("Enter the player's name below:");
            
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (!"G".equals(selection)
                    && !"H".equals(selection)
                    && !"B".equals(selection)
                    && !"S".equals(selection)
                    && !"D".equals(selection)
                    && !"O".equals(selection)
                    && !"E".equals(selection)
                    && !"N".equals(selection)){
                System.out.println("Invalid Selection - Try again.");
                continue;
            }
            break;
        }
        return selection;
    } */

    public void doAction(String value) {
        switch (value) {
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "G": // get and start and existing game
                this.startExistingGame();
                break;
            case "H": // display the help menu
                this.displayHelpMenu();
                break;
            case "S": // save the current game
                this.saveGame();
                break;
            case "B": // save the current game
                this.displayStore();
                break;
            case "D": // save the current game
                this.displayDragon();
                break;
            case "O": // save the current game
                this.displayGold();
                break;
            case "E": // Exit the game
                return;
            default: // create and start a new game'
                System.out.println("\n*** Invalid Selection - Try again");
                break;
        }
    }

    private void startNewGame() {
        GameControl.createNewGame(Hobbit.getPlayer());
        
        //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.displayMenu();
        
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }
   
    private void saveGame() {
        System.out.println("*** saveGame function called ***");    }

    private void displayStore() {
        SuppliesView suppliesStore = new SuppliesView();
        suppliesStore.display();
    }
    private void displaySkills(){
        SkillsView skillsView = new SkillsView();
        skillsView.display();
    }

    private void displayDragon() {
        DragonView dragonView = new DragonView();
        dragonView.display();
    }

    private void displayGold() {
        GoldView goldView = new GoldView();
        goldView.displayMenu();

    }
    
}
