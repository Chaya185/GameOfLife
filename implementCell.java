package TheGameOfLife;

public class implementCell implements Cell {
    private boolean alive;
    static int row;
    private int col;

    public implementCell(int row, int col) {
        this.row = row;
        this.col = col;
        this.alive = false;
    }
    @Override
    public boolean isAlive(){
        return alive;
    }
    @Override
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    @Override
    public int getRow(){
        return row;
    }
    @Override
    public int getCol(){
        return col;
    }

    @Override
    public int countAliveNeighbors(Cell[][] grid){
        int aliveNeighbors = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Defines 8 relative coordinates of neighbors
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = (row + rowOffsets[i] + rows) % rows; // Wrap around vertically
            int newCol = (col + colOffsets[i] + cols) % cols; // Wrap around horizontally

            if (grid[newRow][newCol].isAlive()) {
                aliveNeighbors++;
            }
        }
        return aliveNeighbors;    }
}
