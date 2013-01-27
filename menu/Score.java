
/**
 * Score keeps track of score and adds score when method is invoked
 * 
 * @author  RU development 
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
     * adds val to score
     * @param val   the score achieved in the last game played
     */
    public static void addScore(int val){
        score += val;
    }
}
