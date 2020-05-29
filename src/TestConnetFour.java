import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * This is the Test class for connect 4
 * game which tests various test cases pertaining to
 * connect 4 game.
 *
 * @author  Chiddu bhat
 * @version 2.0
 * @since   May-18-2020
 */


public class TestConnetFour{

    /**
     * This Test is used to verify if the boundary conditions are
     * handled correctly, we try to insert more than 6 discs in a
     * particular column.
     */

    @org.junit.jupiter.api.Test
    public void outOfBoundaryVerify() {

        Game g = new Game();
        g.initializeBoard();
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        Assertions.assertEquals(true, g.makeAMove(1, "Y"));
        Assertions.assertEquals(false, g.makeAMove(1, "Y"));
        System.out.println("****************Score**********************");
        System.out.println("Out of boundary test case successfully passed");
        System.out.println("*******************************************");
    }

    /**
     * This Test is used to verify if the horizontal matching is
     * handled correctly, we try to insert 4 discs of same color in the
     * same row (bottom most row), we check before and after the last disc
     * is placed
     *
     *   |  1   | 2  |  3  |  4  |  5  |  6  |  7  |
     *   |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
     * ------------------------------------------------------------
     *   |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
     * ------------------------------------------------------------
     *   |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
     * ------------------------------------------------------------
     *   |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
     * ------------------------------------------------------------
     *   |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
     * ------------------------------------------------------------
     *   |  R  |  R  |  R  |  R  |  -  |  -  |  -  |
     *   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
     */

    @org.junit.jupiter.api.Test
    public void HorizontalMatchVerify() {

        Game g = new Game();
        g.initializeBoard();
        g.makeAMove(1, "Y");
        g.makeAMove(2, "Y");
        g.makeAMove(3, "Y");
        Assertions.assertEquals(false, g.checkForWinner());
        g.makeAMove(4, "Y");
        Assertions.assertEquals(true, g.checkForWinner());
        System.out.println("****************Score**********************");
        System.out.println("Horizontal matching test case successfully passed");
        System.out.println("*******************************************");

    }

    /**
     * This Test is used to verify if the Vertical matching is
     * handled correctly, we try to insert 4 discs of same color in the
     * same column (column 1), we check before and after the last disc
     * is placed.
     *          |  1   | 2  |  3  |  4  |  5  |  6  |  7  |
     *      *   |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  -  |  -  |  -  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  R  |  -  |  -  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  R  |  -  |  -  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  R  |  -  |  -  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  R  |  -  |  -  |  -  |  -  |  -  |  -  |
     *      *   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
     *
     *
     */

    @org.junit.jupiter.api.Test
    public void veritcalMatchVerify() {

        Game g = new Game();
        g.initializeBoard();
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        Assertions.assertEquals(false, g.checkForWinner());
        g.makeAMove(1, "Y");
        Assertions.assertEquals(true, g.checkForWinner());
        System.out.println("****************Score**********************");
        System.out.println("Vertical match  test case successfully passed");
        System.out.println("*******************************************");

    }

    /**
     * This Test is used to verify if the left to right diagonal conditions are
     * handled correctly, discs in the diagonal fashion and check before and after the
     * last disc is inserted.
     *
     *      *   |  1   | 2  |  3  |  4  |  5  |  6  |  7  |
     *      *   |  R  |  Y  |  R  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  Y  |  R  |  Y  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  R  |  Y  |  R  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  Y  |  R  |  Y  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  R  |  Y  |  R  |  -  |  -  |  -  |  -  |
     *      * ------------------------------------------------------------
     *      *   |  Y  |  R  |  Y  |  R  |  -  |  -  |  -  |
     *      *   |  1  |  2  |  3  |  4  |  5  |  6  |  7  |
     */

    @org.junit.jupiter.api.Test
    public void DiagonalLeftToRightMatchVerify() {

        Game g = new Game();
        g.initializeBoard();
        for(int i =0; i<3;i++){
            g.makeAMove(1, "Y");
            g.makeAMove(1, "R");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(2, "R");
            g.makeAMove(2, "Y");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(3, "Y");
            g.makeAMove(3, "R");
        }

        Assertions.assertEquals(false, g.checkForWinner());
            g.makeAMove(4, "R");
        Assertions.assertEquals(true, g.checkForWinner());
        System.out.println("****************Score**********************");
        System.out.println("Diagonal left to right test case successfully passed");
        System.out.println("*******************************************");

    }

    /**
     * This Test is used to verify if the left to right diagonal conditions are
     * handled correctly, discs in the diagonal fashion and check before and after the
     * last disc is inserted.
     |  1   | 2  |  3  |  4  |  5  |  6  |  7  |
     |  -  |  -  |  -  |  -  |  R  |  Y  |  R  |
     ------------------------------------------------------------
     |  -  |  -  |  -  |  -  |  Y  |  R  |  Y  |
     ------------------------------------------------------------
     |  -  |  -  |  -  |  -  |  R  |  Y  |  R  |
     ------------------------------------------------------------
     |  -  |  -  |  -  |  -  |  Y  |  R  |  Y  |
     ------------------------------------------------------------
     |  -  |  -  |  -  |  -  |  R  |  Y  |  R  |
     ------------------------------------------------------------
     |  -  |  -  |  -  |  R  |  Y  |  R  |  Y  |
     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |

     */

    @org.junit.jupiter.api.Test
    public void DiagonalRightToLeftMatchVerifys() {

        Game g = new Game();
        g.initializeBoard();
        for(int i =0; i<3;i++){
            g.makeAMove(6, "Y");
            g.makeAMove(6, "R");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(5, "R");
            g.makeAMove(5, "Y");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(4, "Y");
            g.makeAMove(4, "R");
        }

        Assertions.assertEquals(false, g.checkForWinner());
        g.makeAMove(3, "R");
        Assertions.assertEquals(true, g.checkForWinner());

        Assertions.assertEquals(true, g.checkForWinner());
        System.out.println("****************Score**********************");
        System.out.println("Diagonal right to left  test case successfully passed");
        System.out.println("*******************************************");
    }

    /**
     * This Test is used to verify if the left to right diagonal conditions are
     * handled correctly, discs in the diagonal fashion and check before and after the
     * last disc is inserted.
     |  1   | 2  |  3  |  4  |  5  |  6  |  7  |
     |  R  |  R  |  Y  |  R  |  R  |  Y  |  R  |
     ------------------------------------------------------------
     |  Y  |  Y  |  R  |  Y  |  Y  |  R  |  Y  |
     ------------------------------------------------------------
     |  R  |  R  |  Y  |  R  |  R  |  Y  |  R  |
     ------------------------------------------------------------
     |  Y  |  Y  |  R  |  Y  |  Y  |  R  |  Y  |
     ------------------------------------------------------------
     |  R  |  R  |  Y  |  R  |  R  |  Y  |  R  |
     ------------------------------------------------------------
     |  Y  |  Y  |  R  |  Y  |  Y  |  R  |  Y  |
     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |

     */

    @org.junit.jupiter.api.Test
    public void drawMatchVerify() {

        Game g = new Game();
        g.initializeBoard();
        for(int i =0; i<3;i++){
            g.makeAMove(6, "Y");
            g.makeAMove(6, "R");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(5, "R");
            g.makeAMove(5, "Y");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(4, "Y");
            g.makeAMove(4, "R");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(3, "Y");
            g.makeAMove(3, "R");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(2, "R");
            g.makeAMove(2, "Y");
        }

        for(int i =0; i<3;i++){
            g.makeAMove(1, "Y");
            g.makeAMove(1, "R");
        }
        for(int i =0; i<3;i++){
            g.makeAMove(0, "Y");
            g.makeAMove(0, "R");
        }


        Assertions.assertEquals(true, g.checkForDraw());
        System.out.println("****************Score**********************");
        System.out.println("Draw match test case successfully passed");
        System.out.println("*******************************************");
    }

    /**
     * This Test is used to verify if the user provides a wrong
     * column number we return false ,so that user is asked to
     * provide right column number.
     */

    @org.junit.jupiter.api.Test
    public void invalidColumnNumberVerify() {

        Game g = new Game();
        g.initializeBoard();
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        g.makeAMove(1, "Y");
        Assertions.assertEquals(true, g.makeAMove(1, "Y"));
        //positive out of bound
        Assertions.assertEquals(false, g.makeAMove(9, "Y"));
        //negative out of bound.
        Assertions.assertEquals(false, g.makeAMove(-1, "Y"));
        System.out.println("****************Score**********************");
        System.out.println("Invalid Column input test case successfully passed");
        System.out.println("*******************************************");
    }





}
