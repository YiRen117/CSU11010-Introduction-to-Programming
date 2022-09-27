/*SELF ASSESSMENT:
Connect4Grid2DArray class (25 marks):25
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment:My class implements the Connect4Grid interface.
*/
import java.util.Arrays;

public class Connect4Grid2DArray implements Connect4Grid{
    public String[][] grid;
    private int lastRow;
    private int lastCol;
    private String lastPlayer;

    public void emptyGrid(){
        grid = new String[Constants.TOTAL_ROW][Constants.TOTAL_COLUMN];
        for(String[] column : grid){
            Arrays.fill(column,"   ");
        }
    }

    public String toString(){
        String gridString = "";
        for (String[] strings : grid) {
            for (String string : strings) {
                gridString += "|" + string;
            }
            gridString += "|\n";
        }
        return gridString;
    }

    public boolean isValidColumn(int column){
        return (column >= 0 && column < 7);
    }

    public boolean isColumnFull(int column){
        return !grid[0][column].equals("   ");
    }

    public void dropPiece(ConnectPlayer player, int column){
        this.lastCol = column;
        this.lastPlayer = player.piece;
        boolean drop = false;
        for(int row = grid.length-1; row >= 0 && !drop; row--){
            if(grid[row][column].equals("   ")){
                drop = true;
                grid[row][column] = " " + lastPlayer + " ";
                this.lastRow = row;
            }
        }
    }

    public boolean didLastPieceConnect4(){
        int countRow = 0;
        for (String[] strings : grid) {
            countRow = (strings[lastCol].equals(" " + lastPlayer + " ")) ? (countRow + 1) : 0;
            if (countRow >= 4) {
                return true;
            }
        }
        int countCol = 0;
        for(int col = 0; col < grid[lastRow].length; col++){
            countCol = (grid[lastRow][col].equals(" " + lastPlayer + " ")) ? (countCol + 1) : 0;
            if(countCol >= 4){
                return true;
            }
        }
        for(int row = 0; row <= grid.length-4; row++){
            for(int col = 0; col <= grid[row].length-4; col++) {
                if (grid[row][col].equals(" " + lastPlayer + " ") && grid[row + 1][col + 1].equals(" " + lastPlayer + " ")
                        && grid[row + 2][col + 2].equals(" " + lastPlayer + " ") && grid[row + 3][col + 3].equals(" " + lastPlayer + " ")) {
                    return true;
                }
            }
            for(int col = grid[row].length-1; col >= 3; col--){
                if(grid[row][col].equals(" " + lastPlayer + " ") && grid[row+1][col-1].equals(" " + lastPlayer + " ")
                    && grid[row+2][col-2].equals(" " + lastPlayer + " ") && grid[row+3][col-3].equals(" " + lastPlayer + " ")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGridFull(){
        for(int column = 0; column < grid[0].length; column++){
            if(grid[0][column].equals("   ")){
                return false;
            }
        }
        return true;
    }


}
