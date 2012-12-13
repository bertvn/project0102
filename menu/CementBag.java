import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CementBag extends Materials{
    public CementBag(){
        super.setDissolveRate(1);
        super.setSpeedReducement(4);
        super.setBaseHealth(20);
        super.setWeight(3);
        setImage("dijkdoorbraak/bigCementBag.png");
    }

    public void act(){
        
    }
    
    public void select(){
        setImage("dijkdoorbraak/selectedbigCementBag.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/bigCementBag.png");
    }
}

