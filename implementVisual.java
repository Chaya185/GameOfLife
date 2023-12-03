package TheGameOfLife;

public class implementVisual implements Visual{
    private int size;
    public implementVisual(int size){
        this.size = size;
    }
    @Override
    public void display(boolean[][] grid) {

    // Print the visual representation of the grid
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] ? "█" : " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
}
