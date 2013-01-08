import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

public class BusyTimer extends Actor{
    private long currentValue;
    private long targetValue;
    
    private String prefix;
    private static String suffix = "s";
    private int stringLength;
    
    // Constructor of the class Timer.
    public BusyTimer(String prefix, long currentValue, long targetValue){
        // Set the prefix for later use.
        this.prefix = prefix;
        this.currentValue = currentValue;
        this.targetValue = targetValue;
        
        // Count the amount of characters in prefix + suffix and multiply by 10.
        stringLength = (this.prefix.length() + suffix.length() + 2) * 10;

        // Create an image and add a fontsize to it.
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage timerImage = getImage();
        Font timerFont = timerImage.getFont();
        timerImage.setFont(timerFont.deriveFont(16.0F));
        
        // Start updating the image.
        updateImage();
    }
    
    // This method will be called every act.
    public void act(){
        currentValue--;
        updateImage();
    }
    
    // This method updates the timer to the 
    public void updateImage(){
        GreenfootImage timerImage = getImage();
        timerImage.clear();
        timerImage.drawString(this.prefix + (Math.round(currentValue)) + suffix, 1, 18);
    }
    
    public void setCurrentValue(long currentValue){
        if(currentValue < 0){
            System.out.println("currentValue must be equal or greater than 0");
        }else{
            // currentValue is in seconds, multiply with 60 because 60 acts is 1 second.
            this.currentValue = currentValue;
            updateImage();
        }
    }
    
    // This method updates the timer to the 
    public long getCurrentValue(){
        return currentValue;
    }
    
    public long getTimeLeft(){
        return (long) currentValue/60;
    }
}
