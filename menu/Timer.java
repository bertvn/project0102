import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

public class Timer extends Actor{
    private int currentValue = 0;
    private int targetValue = 0;
    
    private String prefix;
    private static String suffix = " second(s)";
    private int stringLength;
    
    
    // Constructor of the class Timer.
    public Timer(String prefix){
        // Set the prefix for later use.
        this.prefix = prefix;
        
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
    
    // This method will be called every act.
    public void act(){
        if(endGame()){ // Check if the timer has reached 0.
            createMessage(320, 320, "You won! Click to continue..");
            
            Score.addScore(Dijkdoorbraak.score);
            changeWorld();
        }else{
            currentValue--;
            updateImage();
        }
    }
    
    public boolean endGame(){
        if(currentValue <= targetValue){
            return true;
        }else{
            return false;
        }
    }
    
    // This method updates the timer to the 
    public void updateImage(){
        GreenfootImage timerImage = getImage();
        timerImage.clear();
        timerImage.drawString(this.prefix + (Math.round(currentValue/60)) + suffix, 1, 18);
    }
    
    public void setCurrentValue(int currentValue){
        if(currentValue < 0){
            System.out.println("currentValue must be equal or greater than 0");
        }else{
            // currentValue is in seconds, multiply with 60 because 60 acts is 1 second.
            this.currentValue = currentValue * 60;
            updateImage();
        }
    }
    
    // This method updates the timer to the 
    public int getCurrentValue(){
        return currentValue;
    }
    
    public int getTimeLeft(){
        return (int) currentValue/60;
    }
    
    public void changeWorld(){
        Greenfoot.setWorld(new Menu());
    }
    
     public void createMessage(int xCoord, int yCoord, String message){
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
