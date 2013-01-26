import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

public class Timer extends Actor{

    private int currentValue = 0;
    private int targetValue = 0;
    
    public static boolean done;
    
    private String prefix;
    private static String suffix = " second(s)";
    private int stringLength;
    
    /**
     * Constructor of the class Timer, uses the prefix as prefix for the image text
     * @param prefix this is used as prefix for the image text
     */
    public Timer(String prefix){
        // Set the prefix for later use.
        this.prefix = prefix;
        
        //sets that the game is not done yet
        done = false;
        
        // Count the amount of characters in prefix + suffix and multiply by 10.
        stringLength = (this.prefix.length() + suffix.length() + 2) * 10;

        // Create an image and add a fontsize to it.
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage timerImage = getImage();
        Font timerFont = timerImage.getFont();
        timerImage.setFont(timerFont.deriveFont(20.0F));
        
        // Start updating the image.
        updateImage();
    }
    
    /**
     * method that is run every act, this is contains everything that makes the class do what it does
     */
    public void act(){
        if(!done){ 
            if(endGame()){// Check if the timer has reached 0.
                createMessage(320, 320, "You won! Click to continue..");
                MiniGameMemory.gameFinished();
                Score.addScore(Dijkdoorbraak.score);
                done = true;
            }else{
                currentValue--;
                updateImage();
            }
        }
    }
    
    /**
     * returns if game has ended, game ends if the time limit has past
     * @return boolean true if game has ended
     */
    private boolean endGame(){
        if(currentValue <= targetValue){
            return true;
        }else{
            return false;
        }
    }
     
    /**
     * updates the image with the new time left
     */
    private void updateImage(){
        GreenfootImage timerImage = getImage();
        timerImage.clear();
        timerImage.drawString(this.prefix + (Math.round(currentValue/60)) + suffix, 1, 18);
    }
    
    /**
     * sets currentValue
     * @param currentValue this will be used as value of currentValue and needs to be higher than zero
     */
    public void setCurrentValue(int currentValue){
        if(currentValue < 0){
            System.out.println("currentValue must be equal or greater than 0");
        }else{
            // currentValue is in seconds, multiply with 60 because 60 acts is 1 second.
            this.currentValue = currentValue * 60;
            updateImage();
        }
    }
    
    /**
     * returns the currentValue
     * @return int containing the currentValue
     */
    public int getCurrentValue(){
        return currentValue;
    }
    
    /**
     * returns currentValue in seconds
     * @return int containing amount of seconds left
     */
    public int getTimeLeft(){
        return (int) currentValue/60;
    }
    
    /**
     * game goes back to menu
     */
    public void changeWorld(){
        Greenfoot.setWorld(new Menu());
    }
    
    /**
     * creates message image
     * @param xCoord The x coord of where the image will spawn
     * @param yCoord The y coord of where the image will spawn
     * @param message The message that will be shown
     */
     private void createMessage(int xCoord, int yCoord, String message){
        TextDisplay theMessage = new TextDisplay();
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
