import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Controlecentrum extends World{
    
    // temporary int
    private int totalStreetFloodings;
    private int[] streetFloodingSpots;
    
    public Controlecentrum(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
        populate();

        totalStreetFloodings = 0;
        streetFloodingSpots = new int[]{
            0, 184, 330, 1, 425, 390,
            2, 366, 165, 3, 40, 369,
            4, 59, 119, 5, 137, 51,
            6, 545, 162, 7, 457, 128
        };
    }
    
    public void populate(){
        setBackground("controlecentrum.jpg");
        
        // Headertext aanmaken voor kopje Calamiteiten
        addObject(new HeaderText("Calamiteiten"), 175, 476);
        
        // Headertext aanmaken voor kopje Hulpdiensten
        addObject(new HeaderText("Hulpdiensten"), 550, 476);       
    }
    
    public void act(){
        if(totalStreetFloodings == 0 || totalStreetFloodings < 8 && createNewFlood()){

            // totalStreetFloodings == imageNumber so with that we searhc the array
            // for the xCoordinate which is after the imageNumber, y on the 2nd position
            // after the imageNumber.
            int xCoordinate = streetFloodingSpots[totalStreetFloodings * 3 + 1];
            int yCoordinate = streetFloodingSpots[totalStreetFloodings * 3 + 2];

            totalStreetFloodings++;
            addObject(new CalStreetFlooding(totalStreetFloodings), xCoordinate, yCoordinate);
        }
    }
    
    public boolean createNewFlood(){
        if((int) (Math.random() * 600) == 1){
            return true;
        }else{
            return false;
        }
    }
    
    
}
