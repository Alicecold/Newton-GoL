package gameoflife;
/**
 *
 * @author Jacob, Alice, Shaon, Viktor
 */
public class Board {
    Cell[][] cells;
    
    public Board(int c1, int c2){
         cells = new Cell[c1][c2];
         Cell.setNumberOfAliveCells(0);
        for (Cell[] cell : cells) {
            for (int j = 0; j < cell.length; j++) {
                cell[j] = new Cell(false);
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
    
    //Generates random cells on the grid
    public void generate(){
        reset();
        double rnd, value;
        if (cells.length == 25){
            value = 0.80;
        }
        else if (cells.length == 50){
            value = 0.85;
        }
        else {
            value = 0.95;
        }
        for (Cell[] cell : cells) {
            for (int x = 0; x < cell.length; x++) {
                rnd = Math.random();
                cell[x].setState(rnd > value);
            }
        }
    }
    
    //Resets the grid
    public void reset(){
        for (Cell[] cell : cells) {
            for (int j = 0; j < cells[0].length; j++) {
                cell[j].setState(false);
            }
        }
        Cell.setNumberOfAliveCells(0);
    }
    
    //Determine if the cell shall live or die
    public void update(){
        Cell[][] write;
        write = copyCellArray(cells);
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                int aliveNeighbour = surroundingNeighbours(i,j);
                //If the cell is alive and the neighbours are not equal 3 or 2, it dies.
                if(cells[i][j].isAlive() && aliveNeighbour != 3 && aliveNeighbour != 2){
                    write[i][j].setState(false);
                }
                //If the cell is dead, but has 3 neighbours, it lives.
                if(cells[i][j].isDead() && aliveNeighbour == 3){
                    write[i][j].setState(true);
                }
            }
        }
        cells = copyCellArray(write);
    }
    
    //Copy array
    private Cell[][] copyCellArray(Cell[][] src) {
        if (src == null) {
            return null;
        }
        final Cell[][] result = new Cell[src.length][src[0].length];
        for (int i = 0; i < src.length; i++) {
            for(int j = 0; j < src[i].length; j++){
                result[i][j] = new Cell(src[i][j].isAlive());
            }
        }
        return result;
}

    //Checking surrounding neighbours for each cell
    private int surroundingNeighbours(int i, int j){
        int aliveNeighbour = 0;    
        
        int jminus = j-1, jplus = j+1, iminus = i-1, iplus = i+1;
        
        if (jminus < 0){
            jminus = cells[i].length-1;
        }else if (jplus > cells[i].length-1){
            jplus = 0;
        }

        if (iminus < 0){
            iminus = cells.length-1;
        }else if (iplus > cells.length-1){
            iplus = 0;
        }
        
        //First row
        if (cells[iminus][jminus].isAlive()){
            aliveNeighbour++;
        }
                
        if(cells[iminus][j].isAlive()){
            aliveNeighbour++;
        }
        if (cells[iminus][jplus].isAlive()){
            aliveNeighbour++;
        }
        
        //Second row
        if(cells[i][jminus].isAlive()){
            aliveNeighbour++;
        }
        if (cells[i][jplus].isAlive()){
            aliveNeighbour++;
        }
       
        //Third row
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
