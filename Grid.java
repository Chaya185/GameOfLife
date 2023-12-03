package TheGameOfLife;

public interface Grid {
    void initialize();
    void update();
    void updateDequeue();
    boolean[][] getBoard();
}
