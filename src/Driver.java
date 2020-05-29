import java.util.Scanner;


/**
 * This is the Driver class  for connect 4
 * game which is the starting point of the game. It makes
 * various calls to the game class (Game engine).
 *
 * @author  Chiddu bhat
 * @version 2.0
 * @since   May-18-2020
 */


public class Driver {
    public static void main(String[]args){
        System.out.println("Welcome to the game of Connect 4");

        Game game = new Game();

        game.startNewGame();
        Player p = game.getFirstPlayer();

        while (true){
// Show the state of the board
            game.printLatestBoard();
// Ask player for move
            System.out.println("Player " + p.getName() + ", Enter column number between 1 - 7 : ");
            Scanner input = new Scanner(System.in);
            int col = input.nextInt();
            if (game.makeAMove(col-1, p.getColor())){// Try move

                if(game.checkForWinner()){ // Check for winner
                    System.out.println("Player " + p.getName() + " Wins this game!");
                    p.setTotalScore(100);
                    game.printLatestBoard();
                    //print the results
                    game.checkScore();
                    while(true) {
                        System.out.println("Do you want to continue playing the game? ");
                        System.out.println("Press 7 to restart 9 to exit");
                        Scanner input1 = new Scanner(System.in);
                        if (input1.nextInt() == 7) {
                            game.initializeBoard();
                            p = game.getFirstPlayer();
                            break;
                        } else if (input1.nextInt() == 9) {
                            return; // End game
                        }else{
                            System.out.println("Wrong input try again :(");
                        }
                    }
                }else if(game.checkForDraw()){
                    while(true) {
                        game.printLatestBoard();
                        //print the results
                        game.checkScore();
                        System.out.println("Do you want to continue playing the game? ");
                        System.out.println("Press 7 to restart 9 to exit");
                        Scanner input1 = new Scanner(System.in);
                        if (input1.nextInt() == 7) {
                            game.initializeBoard();
                            p = game.getFirstPlayer();
                            break;
                        } else if (input1.nextInt() == 9) {
                            return; // End game
                        }else{
                            System.out.println("Wrong input try again :(");
                        }
                    }
                }
                p = game.changePlayer(p);
            }
        }
    }

}
