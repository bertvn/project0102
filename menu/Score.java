
/**
 * Score keeps track of score and adds score when method is invoked
 * 
 * @author  RU development: Patrick Aleman 
 * @version 1.0
 */
public class Score{

    public static int score;

    /**
     * Constructor for objects of class Score
     */
    public Score(){
        score = 0;
    }
    
    /**
     * @score adds value of score recieved with last game
     * 
     * @param val   the score achieved in the last game played
     */
    public static void addScore(int val){
        score += val;
    }
}
