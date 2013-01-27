import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is a child of DesignObjects, this will show the road
 * 
 * @author  RU development 
 * @version 1.0
 */
public class Road extends DesignObjects{
    
    private int speed;
    
    /**
     * constructor of the class Road
     */
    public Road(){
        // prepare the image
        img = new GreenfootImage("ontwijken/road.jpg");
        setImage(img); // set the image    
    }
    
    
    /**
     * Act - do whatever the Road wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        speed = Ontwijken.speed; // assign the global speed to var ww
        switch(speed) {
            case 1:                 
                img = new GreenfootImage("ontwijken/road.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 2:                
                img = new GreenfootImage("ontwijken/road.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 3:            
                img = new GreenfootImage("ontwijken/road02.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 4:             
                img = new GreenfootImage("ontwijken/road02.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 5: 
                img = new GreenfootImage("ontwijken/road02.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            case 6:
                img = new GreenfootImage("ontwijken/road03.jpg"); // prepare the image
                setImage(img); // set the image                
            break;
            default:
                img = new GreenfootImage("ontwijken/road03.jpg"); // prepare the image
                setImage(img); // set the image    
            break;
        }
    }    
}
