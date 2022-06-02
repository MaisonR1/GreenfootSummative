
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int[] array = new int[8];
    int[] squareArray = new int[8];
    int spawnLocationX = 30;
    int spawnLocationY = 30;
    boolean isRowDone = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
     
       
        int x = 8;
        for(int i=0;i<x;i++)
        {
            array[i] = GetRandomNumber(1,99);
        }
        prettyPrint();
        BubbleSort();
    }
    public int GetRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    public void MyWorld()
    {
        array = new int[0];
    }
    void prettyPrint()
    {
        NumberBackground numberBackground = new NumberBackground();
        for (int i = 0; i < array.length; i++)
        {
         
         addObject(numberBackground, spawnLocationX, spawnLocationY);
         spawnLocationX += 60;
         
         numberBackground.getImage().drawString(""+array[i], 17, 30); 
         if(isRowDone == true)
         {
            spawnLocationY += 60; 
            spawnLocationX = 30;
            isRowDone = false;
         }
        }
    }
    public void BubbleSort()
    {
        for(int l = 0; l < array.length; l++)
        {
            for(int i = 0; i < array.length-1; i++)
            {
                if(array[i] > array[i+1])
                {
                    int x = array[i];
                    array[i] = array[i+1];
                    array[i+1] = x;
                }
            }
            prettyPrint();
            isRowDone = true;
            
        }
    }
}
