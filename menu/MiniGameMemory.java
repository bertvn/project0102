/**
 * Write a description of class MiniGameMemory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGameMemory  
{
    public static int currentGameX; // holder for icon of current game running Xaxis
    public static int currentGameY; // holder for icon of current game running Yaxis

    public static int amountOfGames; // holder for amount of games in the day    
    public static int[] gameTypes; // holder for what game types where placed
    public static int[] gamesX; // holder for the Xaxis values of all games
    public static int[] gamesY; // holder for the Yaxis values of all games
    
    public static boolean readyNextDay = true; // check if day is complete
    public static String background = "overstroming00";
    public static int minigamesPlayed = 0;

    public static void setCurrentGame(int valX, int valY) {
        currentGameX = valX;
        currentGameY = valY;
    }
    
    public static void setBackground(String name) {
        background = name; // store background image name
    }
    
    public static void setMiniGames(int amount, int[] gameType, int[] placedX, int[] placedY){
        readyNextDay = false;
        amountOfGames = amount;
        gameTypes = gameType;
        gamesX = placedX;
        gamesY = placedY;
    }
    
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
