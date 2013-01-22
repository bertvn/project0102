import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cracks extends Obstacles
{
    /**
     * Act - do whatever the Cracks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    private Boolean hitAlready = false;
    
    public Cracks(){
        //sets image
        setImage("ontwijken/cracks.png");
        //sets random rotation
        setRotation((int)(Math.random() * 360));
        
        //sets score increase for when crack is evaded
        setScoreIncrease(20);
    }
    
   public void act() 
    {
        //calls the act of Obstacles
        super.act();
    } 
    
   public Boolean isHitAlready(){
       return hitAlready;
    }
       
   public void hitAlreadyIndeed(){
       //sets hitAlready to true
       hitAlready = true;
    }
}
