import java.util.* ;
import java.io.*; 

public class Deque {
    int front, rear, size;
    int[] arr;

    public Deque(int n) {
        size = n;
        arr = new int[size];
        front = rear = -1;
    }

    public boolean pushFront(int x) {
        if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
            return false;
        }

        if (front == -1) {
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }

        arr[front] = x;
        return true;
    }

    public boolean pushRear(int x) {
        if ((front == 0 && rear == size - 1) || (front == rear + 1)) {
            return false;
        }

        if (front == -1) {
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }

        arr[rear] = x;
        return true;
    }

    public int popFront() {
        if (front == -1) {
            return -1;
        }

        int val = arr[front];
        arr[front] = -1;

        if (front == rear) {
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }

        return val;
    }

    public int popRear() {
        if (front == -1) {
            return -1;
        }

        int val = arr[rear];
        arr[rear] = -1;

        if (front == rear) {
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }

        return val;
    }

    public int getFront() {
        if (front == -1) {
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (front == -1) {
            return -1;
        }
        return arr[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }
}
