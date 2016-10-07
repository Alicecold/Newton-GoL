/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Jacob
 */
public class Board {
    Cell[][] cells;
    
    public Board(int c1, int c2){
         cells = new Cell[c1][c2];
         
         for (int i =0;i<cells.length;i++){
             for (int j=0;j<cells[i].length;j++){
                cells [i][j] = new Cell(true);
             }
         }
             
    }
    public void update(){
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                int aliveNeighbour = surroundingNeighbours(i,j);
                
                if(cells[i][j].isAlive() && aliveNeighbour < 2){
                    cells[i][j].die();
                }else if(cells[i][j].isAlive() && aliveNeighbour > 3){
                    cells[i][j].die();
                }
                
                if(!cells[i][j].isAlive() && aliveNeighbour == 3){
                    cells[i][j].born();
                }
            }
        }
    }
    
    private int surroundingNeighbours(int i, int j){
        int aliveNeighbour = 0;
                if (cells[i-1][j-1].isAlive()){
                    aliveNeighbour++;
                }
                if (cells[i+1][j+1].isAlive()){
                   aliveNeighbour++; 
                }
                if (cells[i-1][j+1].isAlive()){
                    aliveNeighbour++;
                }
                if (cells[i+1][i-j].isAlive()){
                    aliveNeighbour++;
                }
                if (cells[i][j+1].isAlive()){
                    aliveNeighbour++;
                }
                if (cells[i+1][j].isAlive()){
                    aliveNeighbour++;
                }
                
                if(cells[i][j-1].isAlive()){
                    aliveNeighbour++;
                }
                
                if(cells[i-1][j].isAlive()){
                    aliveNeighbour++;
                }
        return aliveNeighbour;
    }
    
    
    }
