import java.util.ArrayList;
import java.util.List;

public class QueueADTImpl <T> implements QueueADT<T> {
    private int capacity;
    private List<T> items;

    public QueueADTImpl(int capacity) {
        if(capacity <= 0) {
            throw new RuntimeException("Có lỗi xảy ra! Sức chứa hàng đợi bé hơn hoặc bằng 0");
        }
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T t) {
        // Thêm vào cuối hàng đợi
        if(!isFull()) {
            items.add(t);
        } else {
            throw new RuntimeException("Hàng đợi đã đầy!");
        }
    }

    @Override
    public T dequeue() {
        if(!isEmpty()) {
            T t = items.get(0);
            items.remove(0);
            return t;
        } else {
            throw new RuntimeException("Hàng đợi rỗng!");
        }
    }

    @Override
    public T peek() {
        return items.get(0);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public boolean isFull() {
        return items.size() == capacity;
    }
}
