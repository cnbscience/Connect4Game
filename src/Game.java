import java.util.Scanner;

/**
 * This is the Game class (Game engine) for connect 4
 * game which provides attributes and methods pertaining
 * to connect 4 game. Driver class accesses attributes
 * and methods from this class.
 *
 * Design constraints: This class is designed to support 7*6
 * connect 4 game, currently it only supports 2 players.
 * Both players need to provide their name and color of choice
 * to start the game.
 *
 * @author  Chiddu bhat
 * @version 2.0
 * @since   May-18-2020
 */


public class Game {

    private Player p1;
    private Player p2;

    private static String[][] board;
    private int MAX_ROW = 6;
    private int MAX_COLUMN = 7;
    private int MAX_DISC = 42;
    private int totalDiscInserted =0;


    public Player getFirstPlayer() {
        return p1;
    }

    /**
     * This method shows all the options available to players
     * for playing connect4.
     * @param
     * @return None.
     * @exception
     * @see
     */

    void showGameOptions() {
        System.out.println();
        System.out.println(" press 1 to start a game");
        System.out.println(" press 2 to play the game");
        System.out.println(" press 3 to check scores");
        System.out.println(" press 4 to get help");
        System.out.println(" press 5 to stop the game");
        System.out.print("Choose an option: ");
    }


    /**
     * This method Initializes the board to all "-"
     * this is done when the player requests a new game
     * for playing connect4.
     * @param
     * @return None.
     * @exception
     * @see
     */

    void initializeBoard(){
        board = new String[MAX_ROW][MAX_COLUMN];
        for(int row =0; row< MAX_ROW; row++){
            for(int column =0; column< MAX_COLUMN; column++){
                board[row][column]="-";
            }
        }
    }

    /**
     * This method is used to change turns of players
     * while playing connect4. This is called from the driver class
     * @param player
     * @return player
     * @exception
     * @see
     */

    public Player changePlayer(Player player){
        if(player.getName()==p1.getName()){
            return p2;
        }else{
            return p1;
        }
    }

    /**
     * This method is used to get current state of the board.
     * @param
     * @return board
     * @exception
     * @see
     */

    public String[][] getBoard() {
        return board;
    }

    /**
     * This method is used to place the  disc into the
     * board as per the color specified. It places the disk
     * at specified column,to do that it searches from bottom the
     * bottom row.
     * If there are no slots available in column it returns false.
     * @param column, color
     * @return true/false
     * @exception
     * @see
     */

    public boolean makeAMove(int column, String color){
        //check boundaries of column before entering
        if(column >= MAX_COLUMN || column < 0) {
            System.out.println("Please enter valid column number");
            return false;
        }

    // Column already filled ??
        if (!board[0][column].equals("-")){
            System.out.println("This column is full, choose another column");
            return false;
        }
    // Find empty slot from bottom up
        for (int row = board.length-1; row >= 0; row--) {
            if (board[row][column].equals("-")) {
                board[row][column] = color;
                totalDiscInserted += 1;
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to print the scores of both players.
     * It shows the cumulative score of each players , since the game is
     * designed to allow players to play multiple matches.
     * If there are no slots available in column it returns false.
     * @param
     * @return
     * @exception
     * @see
     */

    //get the latest score.
    public void checkScore(){
        System.out.println("****************Score**********************");
        System.out.println("Player : " +  p2.getName()+" Score : "+p2.getTotalScore());
        System.out.println("Player : " +  p1.getName()+" Score : "+p1.getTotalScore());
        System.out.println("*******************************************");
    }

    /**
     * This method is used display game rules and regulations.
     * This is called from the driver class.
     * @param
     * @return
     * @exception
     * @see
     */

    void displayGameInstruction() {
        System.out.println();
        System.out.println("Connect 4 game instructions needs to filled here.");

    }

    /**
     * This method is used the current state of the board
     * This is called from the driver class.
     * @param
     * @return
     * @exception
     * @see
     */

    public  void printLatestBoard() {
        System.out.println("  |  1   | 2  |  3  |  4  |  5  |  6  |  7  |");
        for(int row = 0; row < board.length; row++) {
            for(int column = 0; column < board[row].length; column++) {
                System.out.print("  |  " + board[row][column]);
            }
            System.out.println("  |");
            if(row < board.length - 1)
                System.out.println("------------------------------------------------------------");
            else
                System.out.println("  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |");
        }
    }

    public  boolean checkForDraw() {
        if (totalDiscInserted == MAX_DISC) {
            System.out.println("******************************************");
            System.out.println("*****************GAME DRAWN***************");
            System.out.println("*******************************************");
            return true;
        }
        return false;
    }
    /**
     * This method is used to check if a player has won the game
     * after placing a disc, this method checks 4 possible directions
     * after every move by either players.
     *  1) Horizontal verification (check all the rows)
     *  2) Vertical verifaction (check all the columns)
     *  3)Left diagonal
     *  4)Right diagonal.
     * @param
     * @return true/false
     * @exception
     * @see
     */

    public  boolean checkForWinner(){
        //check all the rows
        for (int row = 0; row < board.length; row++){
            for (int column = 0; column < board[row].length - 3; column++){
                if (!board[row][column].equals("-") && board[row][column] == board[row][column+1] &&
                        board[row][column] == board[row][column+2] && board[row][column] == board[row][column
                        +3]){
                    return true;
                }
            }
        }
        // check all the columns
        for (int row = 0; row < board.length - 3; row++){
            for (int column = 0; column < board[0].length; column++){
                if (!board[row][column].equals("-") && board[row][column] == board[row+1][column] &&
                        board[row][column] == board[row+2][column] && board[row][column] == board[row+3][column]){
                    return true;
                }
            }
        }

        //Check left diagonal
        for (int row = 0; row < board.length - 3; row++){
            for (int column = 0; column < board[row].length - 3; column++){
                if (!board[row][column].equals("-") && board[row][column] == board[row+1][column
                        +1] && board[row][column] == board[row+2][column+2] && board[row][column] ==
                        board[row+3][column+3]){
                    return true;
                }
            }
        }
        //check right diagonal
        for (int row = 0; row < board.length - 3; row++){
            for (int column = 3; column < board[row].length; column++){
                if (!board[row][column].equals("-") && board[row][column] == board[row+1]
                        [column-1] && board[row][column] == board[row+2][column-2] && board[row]
                        [column] == board[row+3][column-3]){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * This method is used to start a new game,
     * asks players names and their color of choice
     * for the connect 4 game.
     * This also initializes the board to all "-".
     *
     * Constraint: The players name and color cannot be
     * changed after the game is complete, they have to use the
     * same name and color for the next match, else restart to
     * change name and color.
     * @param
     * @return true/false
     * @exception
     * @see
     */

    void startNewGame() {
        String p1Name;
        String p2Name;
      while(true) {
          Scanner sc = new Scanner(System.in);
          System.out.print("Please enter player one name: ");
          p1Name = sc.nextLine();
          p1 = new Player(p1Name);
          System.out.print("Please select color(RED/YELLOW) by typing R/Y ");
          p1.setColor(sc.nextLine());
          if(!p1.getColor().equals("R") || p1.getColor().equals("Y")){
              System.out.print("Please enter valid color :( ");
              continue;
          }
          System.out.print("Please enter player two name: ");
          p2Name = sc.nextLine();
          p2 = new Player(p2Name);
          if (p1.getColor().equals("R"))
              p2.setColor("Y");
          else
              p2.setColor("R");

          //Initialize the board;
          initializeBoard();
          break;
      }

    }
}
