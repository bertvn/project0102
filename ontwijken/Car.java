import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Car() {       
        // prepare image
        GreenfootImage img = new GreenfootImage("car.png");
        setImage(img); // set image
        setRotation(0);
    }
    
    public void act() 
    {          
        hitDetection();
        
        if(Greenfoot.isKeyDown("left")) {
            move(0);
            setRotation(355);
        } else if(Greenfoot.isKeyDown("right")) {
            move(1);
            setRotation(5);
        } else{
            setRotation(0);
        }
        
        
    }    
    //moves firecar left or right if button pressed
    public void move(int direction) {
        
        switch(direction) {
            case 0 :
                if(getX() > 137){
                    setLocation(getX() - 2, getY());
                }
                break;
            case 1 :
                if(getX() < 503){
                    setLocation(getX() + 2, getY());
                }
                break;
                
        }
    }
    
    public void hitDetection(){
        List<ObsCar> oc = getObjectsInRange(55, ObsCar.class);
        if(!oc.isEmpty()){
            WorldWorker.speed = 1;
            
            for(ObsCar ocar : oc){
                getWorld().addObject(new BAM(),ocar.getX(),ocar.getY());
                getWorld().removeObject(ocar);
                if(WorldWorker.score > 50){
                    WorldWorker.score -= 50;
                }else{
                    WorldWorker.score = 0;
                }
            }
                
        }
        List<Cracks> ck = getObjectsInRange(57, Cracks.class);
        if(!ck.isEmpty()){
            WorldWorker.speed = 1;
            
            for(Cracks cr : ck){
                //getWorld().removeObject(cr);
                if(WorldWorker.score > 100){
                    WorldWorker.score -= 100;
                }else{
                    WorldWorker.score = 0;
                }
            }
                
        }
    }
    
    public void endGame(){
        Greenfoot.stop();
    }
}
