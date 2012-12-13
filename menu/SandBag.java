import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SandBag extends Materials{
    public SandBag(){
        super.setDissolveRate(3);
        super.setSpeedReducement(3);
        super.setBaseHealth(20);
        super.setWeight(2);
        setImage("dijkdoorbraak/bigSandBag.png");
    }

    public void act(){
        
    } 
    
    public void select(){
        setImage("dijkdoorbraak/selectedbigSandBag.png");
    }
    
    public void deselect(){
        setImage("dijkdoorbraak/bigSandBag.png");
    }
}

