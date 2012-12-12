import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GravelBag extends Materials{  
    public GravelBag(){
        super.setDissolveRate(2);
        super.setSpeedReducement(2);
        super.setItemsLeft(5);
        super.setBaseHealth(20);
        super.setWeight(2);
        setImage("dijkdoorbraak/bigGravelBag.png");
    }

    public void act(){
        
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedbigGravelBag.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/bigGravelBag.png");
    }
}