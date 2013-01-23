import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BurningCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BurningCar extends Actor
{
    private boolean done = false;
    private TextDisplay theMessage;
    
    public BurningCar(){
        setImage("ontwijken/burningCar.png");
    }
    
    public void act() 
    {
        // Add your action code here.
        if(getY() >= 320 && !done){
            Ontwijken.music.stop();
            endGame();
        } else{
            move();
        }
    }
    
    public void move(){
        setLocation(getX(),getY()+ Ontwijken.speed);
    }
    
    public void endGame(){
        Ontwijken.go = false;
        done = true;
        createMessage(320, 320, "You won! Click to continue..");
        Ontwijken.score += ((TimerDisplay.currentValue/60) * 39.1);
        Score.addScore(Ontwijken.score);
        MiniGameMemory.gameFinished();
        
    }
    
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
