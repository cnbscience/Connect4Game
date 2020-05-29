import java.util.Scanner;

/**
 * This is the player class  for connect 4
 * game which is used to represent various
 * attributes of a player like name, color score.
 *
 * @author  Chiddu bhat
 * @version 2.0
 * @since   May-18-2020
 */


public class Player {

    private final String name;


    private String color;
    private int totalScore;

    Player(String name){
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    String getName(){
        return name;
    }

    int getTotalScore(){
        return totalScore;
    }

    void setTotalScore(int score){
        totalScore += score;
    }

}
