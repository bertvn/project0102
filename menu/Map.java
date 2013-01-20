import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Map extends World{

    private int flooded;
    private final int FLOODSTAGES;
    private GreenfootImage backGround;
    /*private String[] miniGames = {
            "Calamiteiten", "Dijkdoorbraak", "Ontwijken", "Doolhof"
        };*/
    private int amountOfGames;
    private int posX;
    private int posY;
    private int[] positionsX = 
            {40, 50, 120, 200, 250, 280}; 
    private int[] positionsY = 
            {220, 220, 280, 380, 480, 550};
    private int[] placedX = new int[3];
    private int[] placedY = new int[3];
    private int marge = 200;
    public static int DAY = 1;
    public static int minigamesPlayed = 0;
    private int amountPlaced;
    
    private boolean firstAct;
    
    public Map(){    
        // Create a new world with 640x640 cells with a cell size of 1x1 pixels;
        super(640, 640, 1);   
        
        amountPlaced = 0; // start with no icons placed
        flooded = 0; // start with no flood at all;
        FLOODSTAGES = 9; // amount of floods, starting with 0 (so there's 10);
        
        backGround = new GreenfootImage("overstromingen/overstroming00.jpg"); // prepare the background;
        setBackground(backGround); // set the background;  
        
        firstAct = true;
        
        selectMinigames(); // select amount of games
    }
    
    public void populate(){
        // add top panel on coordinates 320, 26
        addObject(new DisplayTopPanel(DAY), 320, 26);
        // add top panel on coordinates 507, 540
        addObject(new DisplayMenuPanel(), 507, 540);
        // add scoreText
        addObject(new DisplayScoreText(), 457, 475);
        // add doneText
        addObject(new DisplayDoneText(), 507, 540);
        // add scoreField
        addObject(new DisplayScoreField(), 515, 495);
        // add doneTextField
        addObject(new DisplayDoneField(minigamesPlayed), 515, 560);
        // add highscores button
        addObject(new HighscoresButton(), 520, 610);
    }
    
    public void act() {
        if(firstAct){
            populate();
            firstAct = false;
        }
        
        if(Greenfoot.mouseClicked(null)) { // when mouse button is pressed
            MouseInfo mouse = Greenfoot.getMouseInfo(); // get mouse info
            List<Icons> icon = getObjectsAt(mouse.getX(), mouse.getY(), Icons.class); // get the object that hits mouse
        
            if(icon != null) { // if there is an object (are objects)
                for(Icons test : icon) { // for every object

                    if(test.getClass().equals(DijkdoorbraakIcon.class)) { // retrieve class and chose proper map
                        Greenfoot.setWorld(new Dijkdoorbraak());
                        //System.out.println("Fapman plays dijkdoorbraak");
                    } else if (test.getClass().equals(ControlecentrumIcon.class)) {
                        //Greenfoot.setWorld(new Calamiteiten());
                        System.out.println("Fapman plays calamiteiten");
                    } else if (test.getClass().equals(DoolhofIcon.class)) {
                        //Greenfoot.setWorld(new Doolhof());
                        System.out.println("Fapman plays doolhof");
                    } else if (test.getClass().equals(OntwijkenIcon.class)) {
                        //Greenfoot.setWorld(new Ontwijken());
                        System.out.println("Fapman plays ontwijken");
                    }
                }
            }
        }
    }
    
    public void selectMinigames() {
        amountOfGames = (int) (Math.random() * 3) + 1; // pick random amount of games

        placeMinigames(); // place minigames
    }
    
    public void placeMinigames() {
        while(amountOfGames > 0) { // as long not all the games are placed, keep placing
            int gameNumber = (int) (Math.random() * 4); // retrieve a random game number
            
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
                    addObject(new DoolhofIcon(), posX, posY);
                break;
            }
            
            posX = 0; // position X op 0 zetten voor plaatsen volgende game
            posY = 0; // position Y op 0 zetten voor plaatsen volgende game
            
            amountPlaced++; // enlarge the amount of icons placed;
            amountOfGames--; // game geplaatst dus 1 afhalen van nog te plaatsen games
        }
    }
    
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
    
    public static void setDay(int val) {
        DAY = val; // set the day to given value
    }

    public void setMarge(int val) {
        marge = val;
    }
    
    public void nextImage() {
        if(flooded < FLOODSTAGES) {
            flooded++; // set flooded to next level (if its not the last);
        }
        changeImage(); 
    }
    
    public void prevImage() {
        if(flooded > 0) {
            flooded--; // set flooded to next level (if its not the first);
        }
        changeImage();
    }
    
    private void changeImage() {        
        backGround.clear(); // clear the current image to replace with the new

        backGround = new GreenfootImage("/overstromingen/overstroming0"+flooded+".jpg");
        setBackground(backGround);
    }
}
