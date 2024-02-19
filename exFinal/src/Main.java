public class Main {
    public static void main(String[] args) {
        int maxSize = 10;
        OrderedArray arr1 = new OrderedArray(maxSize);
        OrderedArray arr2 = new OrderedArray(maxSize);

        // Insert random elements into the source arrays
        for (int i = 0; i < maxSize; i++) {
            arr1.insert((long) (Math.random() * 100));
            arr2.insert((long) (Math.random() * 100));
        }

        System.out.print("Array 1: ");
        arr1.display();
        System.out.print("Array 2: ");
        arr2.display();

        OrderedArray mergedArray = new OrderedArray(arr1.nElems + arr2.nElems);
        mergedArray.merge(arr1.arr, arr2.arr);

        System.out.print("Merged Array: ");
        mergedArray.display();
    }
}