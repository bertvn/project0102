import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cracks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cracks extends Obstacles
{
    
   
    private Boolean hitAlready = false;
    
   /**
    * constructor for the class Cracks
    */ 
    public Cracks(){
        //sets image
        setImage("ontwijken/cracks.png");
        //sets random rotation
        setRotation((int)(Math.random() * 360));
        
        //sets score increase for when crack is evaded
        setScoreIncrease(20);
    }
    
   /**
     * Act - do whatever the Cracks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */ 
   public void act() {
        //calls the act of Obstacles
        super.act();
   } 
   
   /**
    * checks if this crack has been hit before, so damage calculation only happens once
    */
   public Boolean isHitAlready(){
       return hitAlready;
    }
   
   /**
    * sets hitAlready to true
    */
   public void hitAlreadyIndeed(){
       //sets hitAlready to true
       hitAlready = true;
    }
}
