import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent of DoolhofIcon, ControlecentrumIcon, DijkdoorbraakIcon and OntwijkenIcon
 * Code can be added later
 * MAIN function is having the icons combined under 1 parent, for the MouseControl in Menu.class
 * It will interfer with the mouse 
 * 
 * @author  RU development
 * @version 1.0
 */
public abstract class Icons extends Actor{
  
    /**
     * method that is overriden by the child class
     */
    public abstract void setBackground();
    
}
