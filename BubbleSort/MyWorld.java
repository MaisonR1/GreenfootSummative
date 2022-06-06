
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 Class for the bubble sorting system/visualization
 */
public class MyWorld extends World
{
    //Creates a new array for the values to be stored in
    int[] array = new int[8];
    //Creates an array for the background of the sorted numbers
    NumberBackground[] squares = new NumberBackground[8];
    //Initial X position for the numbers
    int spawnLocationX = 30;
    //Initial Y position for the numbers
    int spawnLocationY = 30;
    //Starts isRowDone as false
    boolean isRowDone = false;
    /**
     * Calls the bubbles sort to start after the array is initalized with values
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800/600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
     
        //Makes the array have random numbers (8 to be exact)
        for(int i=0;i<array.length;i++)
        {
            array[i] = GetRandomNumber(1,99);
        }
        //Calls the bubble sort to start
        BubbleSort();   
    }
    //Random Number generator
    public int GetRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    /**
     * This is where the numbers and number backgrounds are printed
     */
    void prettyPrint()
    {
        //Initalized the numberBackground
        NumberBackground numberBackground = new NumberBackground();
        //For statement to run while i is less than array.length
        for (int i = 0; i < array.length; i++)
        {
         //Sets each value in the squares array to the numberbackground object
         squares[i] = new NumberBackground();
         //Adds the numberbackground object to the world
         addObject(squares[i], spawnLocationX, spawnLocationY);
         //Prepares the next location for the next block
         spawnLocationX += 60;
         //Draws the value of the array onto the number background
         squares[i].getImage().drawString(""+array[i], 17, 30); 
         //Fixes an error where an extra block would add to the array
         if(i>=7)
         {
             isRowDone=true;
         }
        
         //Beings the next row below the first
         if(isRowDone == true)
         {
             
            spawnLocationY += 60; 
            spawnLocationX = 30;
            isRowDone = false;
            
         }
        }
    }
    /**
     * Sorts the numbers in the array from least to greatest
     */
    public void BubbleSort()
    {
        //Used to stop the code if done instead of printing 
        //up to the array length (both of them)
        boolean stopIfDone = false;
        boolean codeStop = false;
        //Each time this runs it sorts the numbers for 1 step and prints results
        for(int l = 0; l < array.length-1; l++)
        {
            //This sorts the numbers for 1 step
            for(int i = 0; i < array.length-1; i++)
            {
                //if one number is greater than the other but on the
                //wrong side they will switch
                if(array[i] > array[i+1])
                {
                    int x = array[i];
                    array[i] = array[i+1];
                    array[i+1] = x;
                  
                    stopIfDone = true;
                }  
                //If  stopIfDone was never called and i is more than 3 then
                //the code will stop printing
                if(!stopIfDone && i > 3)
                {
                    codeStop = true;
                }
            }
            //This prints the code unless the codeStop variable is true    
            if(!codeStop)
            {
                prettyPrint();
            }
            //Resets the stopping process until it stops
            stopIfDone = false;
            
            
        }
    }
}
