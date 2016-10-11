/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;


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
                cells[i][j] = new Cell(false);
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
    
    public void update(){
        Cell[][] write = new Cell[cells.length][cells[0].length];
        copy(cells, write);
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                int aliveNeighbour = surroundingNeighbours(i,j);
                //System.out.print(aliveNeighbour);
                if(cells[i][j].isAlive() && (aliveNeighbour < 2 || aliveNeighbour > 3)){
                    write[i][j].setState(false);
                }else if(cells[i][j].isDead() && aliveNeighbour == 3){
                    write[i][j].setState(true);
                }
                
            }
            //System.out.print("\n");
        }
        //System.out.println();
        copy(write, cells);
    }
    
    private void copy(Cell[][] src, Cell[][] dest) {
        for (int i = 0; i < src.length; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, src[0].length);
        }
    }
    
    
private int surroundingNeighbours(int i, int j){
        int aliveNeighbour = 0;    
        
        int jminus = j-1, jplus = j+1, iminus = i-1, iplus = i+1;
        
        if (jminus < 0){
            jminus = cells[i].length;
        }else if (jplus > cells[i].length){
            jplus = 0;
        }
        
        if (iminus < 0){
            iminus = cells.length;
        }else if (iplus > cells.length){
            iplus = 0;
        }
        
        //first row
        if (cells[iminus][jminus].isAlive()){
            aliveNeighbour++;
        }
                
        if(cells[iminus][j].isAlive()){
            aliveNeighbour++;
        }
        if (cells[iminus][jplus].isAlive()){
            aliveNeighbour++;
        }
        
        //second row
        if(cells[i][jminus].isAlive()){
            aliveNeighbour++;
        }
//        if(cells[i][j].isAlive()){
//            //DO NAHING
//        }
        if (cells[i][jplus].isAlive()){
            aliveNeighbour++;
        }
       
        //thrid row
        
        if (cells[iplus][jminus].isAlive()){
            aliveNeighbour++;
        }
        
        if (cells[iplus][j].isAlive()){
            aliveNeighbour++;
        }
        
        if (cells[iplus][jplus].isAlive()){
            aliveNeighbour++; 
        }
        
        

        return aliveNeighbour;
    }
}
