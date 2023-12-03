package TheGameOfLife;

import java.util.ArrayList;
import java.util.List;

public class implementCircularQueue<T> implements CircularQueue<T>{
    private Node<T> rear;
    private int size;

    public implementCircularQueue(int size) {
        rear = null;
        this.size = size;
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            newNode.next = newNode; // Point to itself for the first node
        } else {
            newNode.next = rear.next; // New node points to the head
            rear.next = newNode; // Rear now points to the new node
        }
        rear = newNode; // The new node is now the rear
        size++;
    }

    public T dequeue() {
        /*if (!isEmpty()) {
            T data = rear.next.data; // Get the data of the head
            if (rear.next == rear) {
                rear = null; // If only one node, make the queue empty
            }else {
                rear.next = rear.next.next; // Skip the head in the circular linked list
            }
            size--;
            return data;
        }
        return null; */


        if (isEmpty()) {
            return null; // or throw an exception, depending on your design
        }

        T data = rear.next.data; // Get the data of the head

        if (rear.next == rear) {
            rear = null; // If only one node, make the queue empty
        } else {
            rear.next = rear.next.next; // Skip the head in the circular linked list
        }

        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue is empty";
        }

        StringBuilder result = new StringBuilder();
        Node<T> current = rear.next;
        do {
            result.append(current.data).append(" ");
            current = current.next;
        } while (current != rear.next);

        return result.toString().trim();
    }
}
