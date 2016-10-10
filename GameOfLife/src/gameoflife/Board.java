/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.lang.reflect.Array;

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
                if (rnd > 0.82) {
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
    
    public void update(){
        Cell[][] write = new Cell[cells.length][cells[0].length];
        copy(cells, write);
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                int aliveNeighbour = surroundingNeighbours(i,j);
                
                if(cells[i][j].isAlive() && aliveNeighbour < 2){
                    write[i][j].setState(false);
                }else if(cells[i][j].isAlive() && aliveNeighbour > 3){
                    write[i][j].setState(false);
                }
                if(!cells[i][j].isAlive() && aliveNeighbour == 3){
                    write[i][j].setState(true);
                }
                
            }
        }
        copy(write, cells);
    }
    
    private void copy(Object source, Object dest) {
        if(source.getClass().isArray() && dest.getClass().isArray()) {
            for(int i=0;i<Array.getLength(source); i++) {
                if(Array.get(source, i) != null && Array.get(source, i).getClass().isArray()) {
                    copy(Array.get(source, i), Array.get(dest, i));
                } else {
                    Array.set(dest, i, Array.get(source, i));
                }
            }
        }
    }
private int surroundingNeighbours(int i, int j){
        int aliveNeighbour = 0;
        
        int jminus = j-1, jplus= j+1, iminus=i-1, iplus = i+1;
        if (jminus < 0){jminus = cells[i].length-1;}
        if (jplus > cells[i].length-1){ jplus = 0;}
        if (iminus < 0){iminus = cells.length-1;}
        if (iplus > cells.length-1){ iplus = 0;}
        
        if (cells[iplus][jminus].isAlive()){
            aliveNeighbour++;
        }
        if(cells[i][jminus].isAlive()){
            aliveNeighbour++;
        }
        if (cells[iminus][jminus].isAlive()){
            aliveNeighbour++;
        }
        if (cells[iplus][jplus].isAlive()){
            aliveNeighbour++; 
        }
        if (cells[i][jplus].isAlive()){
            aliveNeighbour++;
        }
        if (cells[iminus][jplus].isAlive()){
            aliveNeighbour++;
        }
        if (cells[iplus][j].isAlive()){
            aliveNeighbour++;
        }
        if(cells[iminus][j].isAlive()){
            aliveNeighbour++;
        }
        return aliveNeighbour;
    }
}
