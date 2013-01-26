
/**
 * The full memory of the whole game
 * Saves the minigames placed, 
 * tracks progress of the user, 
 * tracks score of the user,
 * what day user currently is on 
 * removes game when game is finished
 * stores the current background
 * stores the current flooding of the map
 * 
 * @author  RU development: Patrick Aleman 
 * @version 1.1
 */
public class MiniGameMemory{
    public static int currentGameX; // holder for icon of current game running Xaxis
    public static int currentGameY; // holder for icon of current game running Yaxis

    public static int amountOfGames; // holder for amount of games in the day    
    public static int[] gameTypes; // holder for what game types where placed
    public static int[] gamesX; // holder for the Xaxis values of all games
    public static int[] gamesY; // holder for the Yaxis values of all games
    
    public static boolean readyNextDay = true; // check if day is complete
    public static String background = "overstroming00";
    public static int minigamesPlayed = 0;
    public static int flooded = 0; // how far the flood has come, according to the day
    
    /**
     * updates the currentGameX and currentGameY values 
     * 
     * @param valX  the X value of the currentGame
     * @param valY  the Y value of the currentGame
     */
    public static void setCurrentGame(int valX, int valY) {
        currentGameX = valX;
        currentGameY = valY;
    }
    
    /**
     * updates the background value
     * 
     * @param name  the name of the current background : String
     */
    public static void setBackground(String name) {
        background = name; // store background image name
    }
    
    /**
     * sets readyNextDay to false
     * Updates: amountOfGames
     *          gameTypes
     *          gamesX
     *          gamesY
     * 
     * @param amount    the amount of games on the current day
     * @param gameType  the type of game the current day is
     * @param placedX   the X value of the game that is placed
     * @param placedY   the Y value of the game that is placed
     */
    public static void setMiniGames(int amount, int[] gameType, int[] placedX, int[] placedY){
        readyNextDay = false;
        amountOfGames = amount;
        gameTypes = gameType;
        gamesX = placedX;
        gamesY = placedY;
    }
    
    /**
     * is invoked when is game is finished
     * 
     * removes the gamefinished from the menu and variables
     * substract 1 from amountOfGames
     * 
     * if ( amountOfGames equals 0 )
     *      readyNextDay is TRUE
     * else 
     *      readyNextDay is FALSE
     * end if
     * 
     * add 1 to miniGamesPlayed
     */
    public static void gameFinished() {
        int position = 99; // set position to a false state
        
        for(int i = 0; i < gamesX.length; i++) {
            
            if(gamesX[i] <= currentGameX+15 && gamesX[i] >= currentGameX-15) {
                position  = i; // get the index of the current game
            }
        }
        
        if(position < 99) { // if an index was found
            gameTypes[position] = 99; // set the index of the game to zero, removing the game
        }
        
        amountOfGames -= 1; // decrease amount of games

        if(amountOfGames == 0) {
            readyNextDay = true;
        } else {
            readyNextDay = false;
        }
        
        minigamesPlayed++; // add 1 to finished minigames
    }
}
