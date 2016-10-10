/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import gui.GUIGrid.*;
/**
 *
 * @author Jacob, Alice, Shaon
 */
public class Board {
    Cell[][] cells;
    
    public Board(int c1, int c2){
         cells = new Cell[c1][c2];
         Cell.setNumberOfAliveCells(0);
         for (int i =0;i<cells.length;i++){
             for (int j=0;j<cells[i].length;j++){
                cells [i][j] = new Cell(false);
             }
         }
    }
    
    public int getNumberOfAliveCells(){
        return Cell.getNumberOfAliveCells();
    }
    
    public Cell[][] getCells(){
        return cells;
    }
    public Cell getCell(int x, int y){
        return cells[x][y];
    }
    
    
    public void generate(){
        reset();
        double rnd;

        for (Cell[] cell : cells) {
            for (int x = 0; x < cell.length; x++) {
                rnd = Math.random();
                if (rnd > 0.95) {
                    cell[x].setState(true);
                }
            }
        }
    }
    
    public void reset(){
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[0].length;j++){
                cells[i][j].setState(false);
            }
        }
        Cell.setNumberOfAliveCells(0);
    }
    
    @Deprecated
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
        /*TODO FIX INDEX OUT OF BOUNDS*/
        /*If i-1 < 0, i = cells.length*/
        /*if i+1 > cells.length, i+1 = 0*/
        /*or something like that*/
        int aliveNeighbour = 0;
        if (j > 0){
            if (cells[i+1][j-1].isAlive()){
                aliveNeighbour++;
            }
            if (j < cells.length-1){
                if(cells[i][j-1].isAlive()){
                aliveNeighbour++;
                }
            }
            if (i > 0){
                if (cells[i-1][j-1].isAlive()){
                    aliveNeighbour++;
                }
            }
        }
        if (j < cells[0].length-1){
            if (i < cells.length-1){
                if (cells[i+1][j+1].isAlive()){
                    aliveNeighbour++; 
                }
            }
            if (cells[i][j+1].isAlive()){
                aliveNeighbour++;
            }
            if (i > 0){
                if (cells[i-1][j+1].isAlive()){
                    aliveNeighbour++;
                }
            }
            
        }
        if (i < cells.length){
            if (cells[i+1][j].isAlive()){
                aliveNeighbour++;
            }
        }
        if (i > 0){
            if(cells[i-1][j].isAlive()){
                aliveNeighbour++;
            }
        }
        
        return aliveNeighbour;
    }
    
    
    }
