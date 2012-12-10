import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cardboard extends Materials{
    private int dissolveRate;
    private int speedReducement;
    private int itemsLeft;
    
    public Cardboard(){
        dissolveRate = 8;
        speedReducement = 8;
        itemsLeft = 5;
    }

    public void act(){
        
    }
    
    public void setItemsLeft(int itemsLeft){
        this.itemsLeft = itemsLeft;
    }
}