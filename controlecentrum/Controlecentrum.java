import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Controlecentrum extends World{
    private int totalStreetFloodings;
    private int[] streetFloodingSpots;
    private int[] usedSpots;
    
    private int currentNewSpot;
    private int newSpotX;
    private int newSpotY;
    
    private static int  xCoordCalamityTimer = 500;
    
    public Controlecentrum(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 640, 1);
        populate();
        
        // Set initial street floodings to 0, then fill array with possible positions.
        totalStreetFloodings = 0;
        streetFloodingSpots = new int[]{
            0, 184, 330, 1, 425, 390,
            2, 366, 165, 3, 40, 369,
            4, 59, 119, 5, 137, 51,
            6, 545, 162, 7, 457, 128
        };
        
        usedSpots = new int[]{
            0, 3, 6, 9, 12, 15, 18, 21
        };
    }
    
    public void populate(){
        setBackground("controlecentrum.jpg");
        
        // Headertext aanmaken voor kopje Calamiteiten
        addObject(new HeaderText("Calamiteiten"), 175, 476);
        
        // Headertext aanmaken voor kopje Hulpdiensten
        addObject(new HeaderText("Hulpdiensten"), 550, 476);      
        
        // Adding enforcements
        EnfFirefighter fireTruck = new EnfFirefighter();
        addObject(fireTruck, 375, 531);
        
        EnfPolice policeCar = new EnfPolice();
        addObject(policeCar, 475, 532);
        
        EnfAmbulance ambulanceCar = new EnfAmbulance();
        addObject(ambulanceCar, 575, 532);
    }
    
    public void act(){
        if(totalStreetFloodings == 0){
            while(totalStreetFloodings == 0){
                createNewFlood();
            }
            
            addObject(new CalStreetFlooding(currentNewSpot), newSpotX, newSpotY);
        }else{        
            if(createNewFlood()){
                // createNewFlood results true so we are going to create a new flood. Therfore we update
                addObject(new CalStreetFlooding(currentNewSpot), newSpotX, newSpotY);
            }
        }
    }
    
    public boolean createNewFlood(){
        if(totalStreetFloodings >= 8){
            // If we have 8, or somehow more, floodings we will not create a new one.
            return false;
        }else if((int) (Math.random() * 600) != 1){
            // If the number is nog 1 then we will not create one this time.
            return false;
        }else{
            // If we still have 'spots' left and the random number equals 1.
            int randomSpot;
            boolean foundSpot = false;
            do{
                // Finding a new spot in the array which is not taken yet.
                randomSpot = (int) (Math.random() * 8);
                if(usedSpots[randomSpot] != -1){
                    // We found a new spot and save our information for later.
                    currentNewSpot = randomSpot + 1;
                    newSpotX = streetFloodingSpots[usedSpots[randomSpot] + 1];
                    newSpotY = streetFloodingSpots[usedSpots[randomSpot] + 2];
                    
                    // Make this spot unavailable by setting it with -1.
                    usedSpots[randomSpot] = -1;
                    foundSpot = true;
                    
                    
                }
            }while(!foundSpot);
            totalStreetFloodings++;
            return true;
        }
    }
    
    public static int getXCoord(){
        return xCoordCalamityTimer;
    }
    
    public static void setXCoord(int value){
        xCoordCalamityTimer += value;
        if(xCoordCalamityTimer > 630){
            xCoordCalamityTimer = 500;
        }
    }
        
}
