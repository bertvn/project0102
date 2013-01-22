import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BurningCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BurningCar extends Actor
{
    /**
     * Act - do whatever the BurningCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public BurningCar(){
        setImage("ontwijken/burningCar.png");
    }
    
    public void act() 
    {
        // Add your action code here.
        if(getY() >= 320){
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
        Ontwijken.speed = 0;
        createMessage(320, 320, "You won! Click to continue..");
        Score.addScore(Ontwijken.score);
        MiniGameMemory.gameFinished();
        
        System.out.println("Ended");
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
