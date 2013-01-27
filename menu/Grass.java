import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Child of DesignObject, this will show the grass next to the road
 * 
 * @author  RU development
 * @version 1.0
 */
public class Grass extends DesignObjects{

    private int speed;
    
    /**
     * constructor of the class Grass
     */
    public Grass(){
        // prepare the image
        img = new GreenfootImage("ontwijken/grass01.jpg");
        setImage(img); // set the image
        
    }
    
    /**
     * Act - do whatever the Grass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
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
