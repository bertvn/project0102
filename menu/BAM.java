import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BAM is one of the Obstacles in the Ontwijken minigame
 * extends Obstacles
 * 
 * @author  RU development 
 * @version 1.0
 */
public class BAM extends Obstacles{

    /**
     * constructor for the class BAM
     */
    public BAM(){
        setImage("ontwijken/BAM.png");
        //this class is used as hitindicator, not as obstacle
        setScoreIncrease(0);
    }
    
    /**
     * Act - do whatever the BAM wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        super.act();
        
    }    
}
