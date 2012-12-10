import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Paper extends Materials{
    private int dissolveRate;
    private int speedReducement;
    private int itemsLeft;
    
    public Paper(){
        dissolveRate = 16;
        speedReducement = 16;
        itemsLeft = 5;
    }

    public void act(){
        
    }
    
    public void setItemsLeft(int itemsLeft){
        this.itemsLeft = itemsLeft;
    }
}
