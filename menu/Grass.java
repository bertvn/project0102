import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Grass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grass extends DesignObjects
{
    /**
     * Act - do whatever the Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    
    public Grass() {
        // prepare the image
        img = new GreenfootImage("ontwijken/grass01.jpg");
        setImage(img); // set the image
        
    }
    
    public void act() 
    {
        speed = Ontwijken.speed; // assign the global speed to var ww
        switch(speed) {
            case 1:                 
                img = new GreenfootImage("ontwijken/grass01.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 2:                
                img = new GreenfootImage("ontwijken/grass02.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 3:            
                img = new GreenfootImage("ontwijken/grass02.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 4:             
                img = new GreenfootImage("ontwijken/grass03.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 5: 
                img = new GreenfootImage("ontwijken/grass03.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 6:
                img = new GreenfootImage("ontwijken/grass04.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            default:
                img = new GreenfootImage("ontwijken/grass04.jpg"); // prepare the image
                setImage(img); // set the image    
            break;
        }
    }    
}