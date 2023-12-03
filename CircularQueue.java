package TheGameOfLife;

public interface CircularQueue<T> {
    void enqueue(T item);
    T dequeue();
    int getSize();
    boolean isEmpty();
}
