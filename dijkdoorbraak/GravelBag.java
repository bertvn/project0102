import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GravelBag extends Materials{
    private int dissolveRate;
    private int speedReducement;
    private int itemsLeft;
        
    public GravelBag(){
        dissolveRate = 1;
        speedReducement = 1;
        itemsLeft = 5;
    }

    public void act(){
        
    }
    
    public void setItemsLeft(int itemsLeft){
        this.itemsLeft = itemsLeft;
    }
}