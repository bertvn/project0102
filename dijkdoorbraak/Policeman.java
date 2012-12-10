import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Policeman extends Helpers{
    private int speed;
    private int power;

    public Policeman(){
        speed = 3;
        power = 3;
    }
    
    public void act(){
        move();
    }    
}

