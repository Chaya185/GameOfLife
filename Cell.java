package TheGameOfLife;

public interface Cell {
    boolean isAlive();
    void setAlive(boolean alive);
    int getRow();
    int getCol();
    int countAliveNeighbors(Cell[][] grid);
}
