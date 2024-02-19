import java.util.Iterator;

public interface DoublyLinkedList<T> extends Iterable {
    void clear();
    int size();
    boolean isEmpty();
    void add(T element);
    void addLast(T element);
    void addFirst(T element);
    T peekFirst();
    T peekLast();
    T removeLast();
    T removeFirst();
    T remove(Node<T> node);
    boolean remove(Object object);
    T removeAt(int index);
    int indexOf(Object object);
    boolean contains(Object object);
}
