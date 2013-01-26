import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Menu is starts the menu it self, it places all the objects and invokes most of the calculation
 * Next to that, Menu controls all mouse input from the user, in the menu
 * 
 * @author  RU development: Patrick Aleman 
 * @version 1.1
 */
public class Menu extends World{

    /**
     * Constructor for variables of class Menu.
     * 
     */
    /* standard variables */
    private final int FLOODSTAGES; // amount of floodstages the game has
    
    private GreenfootImage backGround; // background of menu
    
    /* variables for processing the initiation of minigames */
    private int amountOfGames; // amount of games in the day
    private int amountPlaced; // amount of games placed on the map (ensurance that initialised games are placed)
    
    /* positioning and saving positions of games */
    private int posX;
    private int posY;
    private int[] positionsX = 
            {40, 50, 120, 200, 250, 280}; 
    private int[] positionsY = 
            {220, 220, 280, 380, 480, 550};
    private int[] placedX = new int[3];
    private int[] placedY = new int[3];
    private int marge = 200;
    private int[] gameMemory = new int[3];
    
    /* the current day and init amount of games played */
    public static int DAY = 0; 
    
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu(){    
        // Create a new world with 640x640 cells with a cell size of 1x1 pixels;
        super(640, 640, 1); 
        
        amountPlaced = 0; // start with no icons placed
        FLOODSTAGES = 9; // amount of floods, starting with 0 (so there's 10);
        
        populate();       
    }
    
    /**
     * Places all the objects on the world
     * en checks if game needs to go to next day
     * 
     * if MiniGameMemory.readyNextDay is true, 
     *      call goToNextDay()
     * else 
     *      placeGamesMemory()
     * endif
     */
    public void populate() {
        backGround = new GreenfootImage("overstromingen/"+MiniGameMemory.background+".jpg"); // prepare the background;
        setBackground(backGround); // set the background;  
        
        // add top panel on coordinates 320, 26
        displayTopPanel(320, 26);
        // add top panel on coordinates 507, 540
        displayMenuPanel(507, 540);
        // add scoreText
        displayScoreText(457, 475);
        // add doneText
        displayDoneText(507, 540);
        // add scoreField
        displayScoreField(515, 495);
        // add doneTextField
        displayDoneField(515, 560, MiniGameMemory.minigamesPlayed);
        // add highscores button
        addObject(new HighscoresButton(), 520, 610);
        // add instructions button
        addObject(new InstructionsButton(), 94, 610);
        
        
        if(MiniGameMemory.readyNextDay == true) { // if ready for the next day
            goToNextDay(); // go to the next day
        } else {
            placeGamesMemory(); // place the minigames
        }
    }
    
    /**
     * Act is run every act of greenfoot
     * Gets mouse info and preform checks
     * 
     * note: @objectList.isEmpty -> if false, means the mouse was pressed on the object
     * 
     * if !icon.isEmpty() 
     *      if iconItem.getClass.equals(DijkdoorbraakIcon.class 
     *          setWorld(Dijkdoorbraak) <<-- starts dijkdoobraak
     *      else if iconItem.getClass.equals(ControlecentrumIcon.class 
     *          setWorld(Controlecentrum) <<-- starts controlecentrum
     *      else if iconItem.getClass.equals(OntwijkenIcon.class 
     *          setWorld(ontwijken) <<-- starts ontwijken
     *      end if
     * end if
     * 
     * if !iconHigh.isEmpty 
     *      addObject(Highscore) <<-- opens highscore panel
     * end if
     * 
     * if !highscorePanel.isEmpty() 
     *      removeObject(highscorePanel) <<-- close the highscorePanel when clicked on with mouse
     * end if
     * 
     * if !iconsIns.isEmpty() 
     *      addObject(Instructions) <<-- opens instructions panel
     * end if
     * 
     * if !instructionsPanel.isEmpty() 
     *      removeObject(InstructionsPanel) <<-- closes instructions panel
     * end if
     * 
     */
    public void act() {
        if(Greenfoot.mouseClicked(null)) { // when mouse button is pressed
            MouseInfo mouse = Greenfoot.getMouseInfo(); // get mouse info
            int x = mouse.getX();
            int y = mouse.getY();
            List<Icons> icon = getObjectsAt(x, y, Icons.class); // get the object that hits mouse of icons
            List<HighscoresButton> iconHigh = getObjectsAt(x, y, HighscoresButton.class); // get the object that hits mouse of highscorebutton
            List<Highscore> highscorePanel = getObjectsAt(x, y, Highscore.class); // get the object that hits mouse of highscore (panel)
            List<InstructionsButton> iconIns = getObjectsAt(x, y, InstructionsButton.class); // get the object that hits mouse of highscorebutton
            List<Instructions> instructionsPanel = getObjectsAt(x, y, Instructions.class); // get the object that hits mouse of highscore (panel)
            
            if(!icon.isEmpty()) { // if there is an object (are objects)
                for(Icons iconItem : icon) { // for every object

                    if(iconItem.getClass().equals(DijkdoorbraakIcon.class)) { // retrieve class and chose proper map
                        Greenfoot.setWorld(new Dijkdoorbraak());
                    } else if (iconItem.getClass().equals(ControlecentrumIcon.class)) {
                        Greenfoot.setWorld(new Controlecentrum());
                    } else if (iconItem.getClass().equals(OntwijkenIcon.class)) {
                        Greenfoot.setWorld(new Ontwijken());
                    }
                    
                }
                
                MiniGameMemory.setCurrentGame(x,y);
            }
            
            if(!iconHigh.isEmpty()) { // if there is an object hit (if pressed on highscores button
                addObject(new Highscore(), 312, 246);
            }
            
            if(!highscorePanel.isEmpty()) { // if there is an object hit (if pressed on highscores panel
                removeObject(highscorePanel.get(0));
            }
            
            if(!iconIns.isEmpty()) { // if there is an object hit (if pressed on instructions button
                addObject(new Instructions(0), 312, 246);
            }
            
            if(!instructionsPanel.isEmpty()) { // if there is an object hit (if pressed on instructions panel
                removeObject(instructionsPanel.get(0));
            }
            
            List<TextDisplay> highScore = getObjectsAt(x, y, TextDisplay.class); // get the object that hits mouse
        }
    }
    
    /**
     * places the games that still need to be played before the day can end
     * Reads from static variables from MiniGameMemory
     * 
     * switch gameNumber
     *      1: Controlecentrum 
     *      2: Dijkdoorbraak
     *      3: ontwijken
     * end switch
     */
    public void placeGamesMemory() {
        for(int i = 0; i < MiniGameMemory.gameTypes.length; i++) {
            
            int gameNumber = MiniGameMemory.gameTypes[i]; // get the game type
            
            switch(gameNumber) { /* random geselecteerde game plaatsen 
                                  * op random positie op X en Y as 
                                  */
                    case 0: 
                        addObject(new ControlecentrumIcon(), MiniGameMemory.gamesX[i], MiniGameMemory.gamesY[i]); 
                    break;
                    case 1: 
                        addObject(new DijkdoorbraakIcon(), MiniGameMemory.gamesX[i], MiniGameMemory.gamesY[i]); 
                    break;
                    case 2: 
                        addObject(new OntwijkenIcon(), MiniGameMemory.gamesX[i], MiniGameMemory.gamesY[i]);
                    break;
            }
        }
    }
    
    /**
     * selects amount of minigames about to place
     * and invokes the placeMinigames method
     */
    public void selectMinigames() {
        /// Changed to 2 games per day as default;
        /// amountOfGames = (int) (Math.random() * 3) + 1; // pick random amount of games
        amountOfGames = 2;

        placeMinigames(); // place minigames
    }
    
    /**
     * places minigames 
     * 
     * while ( not all games are place )
     *      ** continue placing **
     *     
     *      select random game 
     *      get X and Y positions 
     *      
     *      switch gameNumber
     *         1: Controlecentrum 
     *         2: Dijkdoorbraak
     *         3: ontwijken
     *      end switch
     *      
     *      **reset variables**
     *      
     *      add game that is placed to MiniGameMemory variables for later use
     */
    public void placeMinigames() {
        placedX = new int[3];
        placedY = new int[3];
        
        while(amountOfGames > 0) { // as long not all the games are placed, keep placing
            int gameNumber = (int) (Math.random() * 3); // retrieve a random game number
            // int gameNumber = 1; //  specific assignment
            
            //while(posX == 0) { // get position X for the game.
                posX = randomX();
            //}
            //while(posY == 0) { // get position Y for the game.
                posY = randomY();
            //}
           
            switch(gameNumber) { /* random geselecteerde game plaatsen 
                                  * op random positie op X en Y as 
                                  */
                case 0: 
                    addObject(new ControlecentrumIcon(), posX, posY); 
                break;
                case 1: 
                    addObject(new DijkdoorbraakIcon(), posX, posY); 
                break;
                case 2: 
                    addObject(new OntwijkenIcon(), posX, posY);
                break;
                case 3: 
                    // game doesnt exist : addObject(new DoolhofIcon(), posX, posY);
                break;
            }
            
            posX = 0; // position X op 0 zetten voor plaatsen volgende game
            posY = 0; // position Y op 0 zetten voor plaatsen volgende game
            
            gameMemory[amountPlaced] = gameNumber; // send amount of games
            amountPlaced++; // enlarge the amount of icons placed;
            amountOfGames--; // game geplaatst dus 1 afhalen van nog te plaatsen games
        }
        
        MiniGameMemory.setMiniGames(amountPlaced, gameMemory, placedX, placedY);
    }
    
    /**
     * Gets a random X value for minigame to be placed
     * 
     * for every minigame X value
     *      if getPposX > compareX 
     *          add getPosX to placedX
     *      end if
     * end for
     */
    public int randomX() {
        // get random position on the X axis with a minimum of the set minimum on that day
        int getPosX = (int) (Math.random() * marge) + positionsX[DAY];
        
        for(int compareX : placedX) { /* if the number is bigger then all placed icons X value
                                       * and minimum 40 pixels bigger { 
                                       * } else return zero;
                                       */
            if(getPosX > compareX) {
               placedX[amountPlaced] = getPosX; /* when the position is good, at the position
                                                 * to the array holding the positions of the
                                                 * game icons X axis values;
                                                 */
               return getPosX; // return the X axis value;
            } 
        }
        return 0; // standard zero return, else greenfoot doesnt understand
    }
    
    /**
     * Gets a random Y value for minigame to be placed
     * 
     * for every minigame Y value
     *      if getPposY > compareY 
     *          add getPosY to placedY
     *      end if
     * end for
     */
    public int randomY() {
        // get random position on the Y axis with a minimum of the set minimum on that day
        int getPosY = (int) (Math.random() * marge) + positionsY[DAY];
        
        for(int compareY : placedY) { /* if the number is bigger then all placed icons Y value
                                       * and minimum 40 pixels bigger { 
                                       * } else return zero;
                                       */
            if(getPosY > compareY) {
               placedY[amountPlaced] = getPosY; /* when the position is good, at the position
                                                 * to the array holding the positions of the
                                                 * game icons Y axis values;
                                                 */               
               return getPosY; // return the X axis value;
            }
        }
        return 0; // standard zero return, else greenfoot doesnt understand
    }
    
    /**
     * setter for day value
     * @DAY = val
     */
    public static void setDay(int val) {
        DAY = val; // set the day to given value
    }
    
    /**
     * setter for marge value
     * @marge = val
     */
    public void setMarge(int val) {
        marge = val;
    }
    
    /**
     * set game to the next day 
     * 
     * if MiniGameMemory.flooded < FLOODSTAGES
     *      MiniGameMemory.flooded++;
     * end if
     * 
     * setDay( DAY + 1)
     * invoke displayTopPanel
     * changeImage()
     * 
     * selectMinigames
     */
    public void goToNextDay() {
        if(MiniGameMemory.flooded < FLOODSTAGES) {
            MiniGameMemory.flooded++; // set flooded to next level (if its not the last);
        }
        
        setDay(DAY+1); // add 1 day
        
        displayTopPanel(320, 26); // resetToppanel
        
        changeImage(); // go to next flooding
        
        selectMinigames(); // get new minigames
    }
    
    /**
     * Removes background and adds a new one
     * 
     * clear the background
     * 
     * invoke MiniGameMemory.setBackground() to save current background for later use
     * update backGround
     * invoke setBackgroud() <<-- sets the new image 
     */
    private void changeImage() {        
        backGround.clear(); // clear the current image to replace with the new
        
        MiniGameMemory.setBackground("overstroming0"+MiniGameMemory.flooded);
        backGround = new GreenfootImage("overstromingen/"+MiniGameMemory.background+".jpg");

        setBackground(backGround);
    }
    
    /**
     * Creates a new TextDisplay object
     * Calls the TextDisplay methods to set all the values
     * Places the object on the screen
     * 
     *   add top panel on coordinates 320, 26
     *   displayTopPanel(320, 26);
     *   
     *   add top panel on coordinates 507, 540
     *   displayMenuPanel(507, 540);
     *   
     *   add scoreText
     *   displayScoreText(457, 475);
     *   
     *   add doneText
     *   displayDoneText(507, 540);
     *   
     *   add scoreField
     *   displayScoreField(515, 495);
     *   
     *   add doneTextField
     *   displayDoneField(515, 560, MiniGameMemory.minigamesPlayed);
     */
    public void displayTopPanel(int xCoord, int yCoord){
        TextDisplay topPanel = new TextDisplay(); // create new text display
        topPanel.setTheGreenfootImage("opmaak/topPanel.png"); // init background
        topPanel.setFontColor(255, 255, 255, 0); // set font color
        topPanel.setDrawString(40, 28); // draw the text
        topPanel.setInput("Dag " + DAY); // place day as text
        
        topPanel.createTextBox();
        addObject(topPanel, xCoord, yCoord);
    }
    
    public void displayMenuPanel(int xCoord, int yCoord){
        TextDisplay menuPanel = new TextDisplay();
        menuPanel.setTheGreenfootImage("opmaak/menuPanel.png");
        
        menuPanel.createTextBox();
        addObject(menuPanel, xCoord, yCoord);
    }
    
    public void displayScoreText(int xCoord, int yCoord){
        TextDisplay scoreText = new TextDisplay();
        scoreText.setFontColor(255, 255, 255, 0);
        scoreText.setInput("Score:");
        
        scoreText.createTextBox();
        addObject(scoreText, xCoord, yCoord);
    }
    
    public void displayDoneText(int xCoord, int yCoord){
        TextDisplay doneText = new TextDisplay();
        doneText.setFontColor(255, 255, 255, 0);
        doneText.setInput("Voltooide calamiteiten:");
        doneText.setField(200, 30);
       
        doneText.createTextBox();
        addObject(doneText, xCoord, yCoord);
    }
    
    public void displayScoreField(int xCoord, int yCoord){
        TextDisplay scoreField = new TextDisplay();
        scoreField.setFontColor(0, 0, 0, 0);
        scoreField.setBackgroundColor(255, 255, 255, 255);
        scoreField.setBorderColor(176, 176, 176, 255);
        scoreField.setField(220, 30);
        scoreField.setBorder(2, 2);
        scoreField.setDrawString(6, 22);
        scoreField.setInput(String.valueOf(new Integer(Score.score)));
        scoreField.setHasBackground(true);
        
        scoreField.createTextBox();
        addObject(scoreField, xCoord, yCoord);
    }
    
    public void displayDoneField(int xCoord, int yCoord, int minigamesPlayed){
        TextDisplay doneField = new TextDisplay();
        doneField.setFontColor(0, 0, 0, 0);
        doneField.setBackgroundColor(255, 255, 255, 255);
        doneField.setBorderColor(176, 176, 176, 255);
        doneField.setField(220, 30);
        doneField.setBorder(2, 2);
        doneField.setDrawString(6, 22);
        doneField.setInput(String.valueOf(new Integer(minigamesPlayed)));
        doneField.setHasBackground(true);
        
        doneField.createTextBox();
        addObject(doneField, xCoord, yCoord);
    }
    
    public void displayHighscoresButton(int xCoord, int yCoord){
        TextDisplay highscoresButton = new TextDisplay();
        highscoresButton.setTheGreenfootImage("opmaak/highscoresButton.png");
        
        highscoresButton.createTextBox();
        addObject(highscoresButton, xCoord, yCoord);
    }
}