import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ObsCar is one of the Obstacles in the Ontwijken minigame
 * extends Obstacles
 * 
 * @author  RU development 
 * @version 1.0
 */
public class ObsCar extends Obstacles{
    
    /**
     * constructor for the class ObsCar
     */
    public ObsCar(){
        //chooses random number between 0 and 5
        int random = (int) Math.round(Math.random()*5);
        
        //chooses image depending on number
        setImage("ontwijken/obstacle" + random + ".png");
        
        //sets random rotation
        setRotation((int)(Math.random() * 360));
        
        //sets score increase for when car is evaded
        setScoreIncrease(10);
    }
    
    /**
     * Act - do whatever the ObsCar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        //calls the act of Obstacles
        super.act();
    }    
}
