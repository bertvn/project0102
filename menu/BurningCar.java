import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BurningCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BurningCar extends Actor{

    private boolean done = false;
    private TextDisplay theMessage;
    
    /**
     * constructor of the class BurningCar
     */
    public BurningCar(){
        setImage("ontwijken/burningCar.png");
    }
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        // Add your action code here.
        if(getY() >= 320 && !done){
            Ontwijken.music.stop();
            endGame();
        } else{
            move();
        }
    }
    
    /**
     * moves the car Ontwijken.speed pixels 
     */
    public void move(){
        setLocation(getX(),getY()+ Ontwijken.speed);
    }
    
    /**
     * stops the game
     */
    public void endGame(){
        Ontwijken.go = false;
        done = true;
        createMessage(320, 320, "You won! Click to continue..");
        Ontwijken.score += ((TimerDisplay.currentValue/60) * 39.1);
        Score.addScore(Ontwijken.score);
        MiniGameMemory.gameFinished();
        
    }
    
    /**
     * creates message image
     * @param xCoord The x coord of where the image will spawn
     * @param yCoord The y coord of where the image will spawn
     * @param message The message that will be shown
     */
    public void createMessage(int xCoord, int yCoord, String message){
        theMessage = new TextDisplay();
        theMessage.setBackgroundColor(255, 255, 255, 160);
        theMessage.setBorderColor(0, 0, 0, 160);
        theMessage.setField(480, 150);
        theMessage.setFontSize(30.0f);
        theMessage.setBorder(5, 5);
        theMessage.setDrawString(50, 90);
        theMessage.setInput(message);
        theMessage.setHasBackground(true);
        
        theMessage.createTextBox();
        getWorld().addObject(theMessage, xCoord, yCoord);
    }
}
