public interface QueueADT<T> {
    void enqueue(T t);
    T dequeue();
    T peek();
    int size();
    boolean isEmpty();
    boolean isFull();
}
