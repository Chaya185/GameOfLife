package TheGameOfLife;

public class implementGrid implements Grid{
    boolean[][] board;
    private Cell[][] grid;
    private int rows;
    private int cols;
    private CircularQueue<Cell> updateQueue;

    public implementGrid(int size){
        this.board = new boolean[size][size];
        updateQueue = new implementCircularQueue<>(size);
        rows = size;
        cols = size;
    }

    @Override
    public void initialize(){
        this.grid = new Cell[rows][cols];

        // Initialize each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.grid[i][j] = new implementCell(i, j);
            }
        }

        // Enqueue cells based on initial configuration
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j]) {
                    updateQueue.enqueue(grid[i][j]);
                }
            }
        }
    }

    @Override
    public void update() {
        Cell[][] newGrid = new Cell[rows][cols];

        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = grid[i][j].countAliveNeighbors(grid);

                // Apply Game of Life rules
                if (grid[i][j].isAlive()) {
                    // Underpopulation or Overpopulation: Cell dies
                    if (aliveNeighbors < 2 || aliveNeighbors > 3) {
                        board[i][j] = false;
                    } else {
                        // Survival: Cell survives
                        board[i][j] = true;
                    }
                } else {
                    // Reproduction: Dead cell becomes alive
                    if (aliveNeighbors == 3) {
                        board[i][j] = true;
                        //enqueue here
                        updateQueue.enqueue(grid[i][j]);
                    } else {
                        // Cell remains dead
                        //newGrid[i][j] = grid[i][j];
                        newGrid[i][j] = new implementCell(i, j);
                    }
                }
            }
        }

        // Update the grid with the new state
        grid = newGrid;
        updateDequeue();

    }

    @Override
    public void updateDequeue() {
        //boolean[][] currentState = new boolean[rows][cols];

        //dequeue all and flip state
        for (int i = 0; i < updateQueue.getSize(); i++) {
            Cell obj = updateQueue.dequeue();
            if (obj.isAlive()) {
                obj.setAlive(false);
            } else {
                obj.setAlive(true);
            }
        }
    }

    @Override
    public boolean[][] getBoard(){
        return board;
    }



}
