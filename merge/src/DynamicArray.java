import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private T[] arr;
    private int capacity;
    private int size = 0;

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return arr[index];
    }

    public void set(int index, T value){
        if (index < 0) throw new IndexOutOfBoundsException("Index out of bound");
        arr[index] = value;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public void insertLast(T element) {
        if (size >= capacity - 1) {
            if (capacity == 0) capacity = 1;
            else {
                capacity *= 2;
            }

            T[] newArray = (T[]) new Object[capacity];
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        arr[size++] = element;
    }
    public void sort(DynamicArray<T> arr){
        for (int i = 1; i < arr.size; i++){
            T key = arr.get(i);
            int j = i -1;
            while ( j >= 0 && ((Comparable<T>) arr.get(j)).compareTo(key) > 0) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }

    public void mergeArray(DynamicArray<T> arr1, DynamicArray<T> arr2) {
        int i = 0, j = 0;

        while (i < arr1.size() && j < arr2.size()) {
            T element1 = arr1.get(i);
            T element2 = arr2.get(j);

            if (((Comparable<T>) element1).compareTo(element2) < 0) {
                insertLast(element1);
                i++;
            } else {
                insertLast(element2);
                j++;
            }
        }

        while (i < arr1.size()) {
            insertLast(arr1.get(i));
            i++;
        }

        while (j < arr2.size()) {
            insertLast(arr2.get(j));
            j++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    public String display() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(arr[i]);
                if (i != size - 1) sb.append(",");
            }
            sb.append(arr[size - 1]).append("]");
            return sb.toString();
        }
    }
}

