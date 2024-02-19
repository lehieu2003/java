class OrderedArray {
    long[] arr;
    int nElems;

    public OrderedArray(int max) {
        arr = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (arr[i] > value) {
                break;
            }
        }
        for (int j = nElems; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void merge(long[] source1, long[] source2) {
        int i = 0, j = 0;
        while (i < source1.length && j < source2.length) {
            if (source1[i] < source2[j]) {
                insert(source1[i]);
                i++;
            } else {
                insert(source2[j]);
                j++;
            }
        }

        // Add any remaining elements from source1 (if any)
        while (i < source1.length) {
            insert(source1[i]);
            i++;
        }

        // Add any remaining elements from source2 (if any)
        while (j < source2.length) {
            insert(source2[j]);
            j++;
        }
    }
}


