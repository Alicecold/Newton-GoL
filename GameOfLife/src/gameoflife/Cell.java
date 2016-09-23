/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author alicecold
 */
public class Cell {
    
    private boolean isAlive;
    private static int numberOfAlive = 0;
    
    
    Cell(boolean isAlive){
        if(isAlive){
            this.isAlive = true;
            numberOfAlive++;
        }else{
            this.isAlive = false;
        }
    }
    
    public void born(){
        numberOfAlive++;
        isAlive = true;
    }
    
    public void die(){
        numberOfAlive--;
        isAlive = false;
    }
    
    public boolean isAlive(){
        return isAlive;
    }
    
    public static int getNumberOfAliveCells(){
        return numberOfAlive;
    }
    
}
