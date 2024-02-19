public class Main {
    public static void main(String[] args) {
        // Create two DynamicArray objects
        DynamicArray<Integer> arr1 = new DynamicArray<>(10);
        DynamicArray<Integer> arr2 = new DynamicArray<>(10);

        // Insert elements into the first array
        for (int i = 0; i < 5; i++) {
            arr1.insertLast((int) (Math.random() * 100));
        }

        // Insert elements into the second array
        for (int i = 0; i < 5; i++) {
            arr2.insertLast((int) (Math.random() * 100));
        }

        System.out.println("Array 1: " + arr1.display());
        System.out.println("Array 2: " + arr2.display());

        arr1.sort(arr1);
        arr2.sort(arr2);

        System.out.println("Array 1: " + arr1.display());
        System.out.println("Array 2: " + arr2.display());

        // Merge the two arrays into a new array
        DynamicArray<Integer> mergedArray = new DynamicArray<>(arr1.size() + arr2.size());
        mergedArray.mergeArray(arr1, arr2);

        System.out.println("Merged Array: " + mergedArray.display());
    }
}
