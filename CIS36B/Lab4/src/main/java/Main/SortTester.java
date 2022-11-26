package Main;

import de.vandermeer.asciitable.AsciiTable;

public class SortTester {
    public static void main(String[] args) {
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Array Size", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort");
        at.addRule();

        testAllSorts(50_000, at);
        testAllSorts(100_000, at);
        testAllSorts(200_000, at);
        testAllSorts(250_000, at);
        testAllSorts(300_000, at);

        System.out.println(at.render());
    }

    public static void testAllSorts(int size, AsciiTable at) {
        int[] arr = createRandomArr(size);
        long selectionSortTime = selectionSort(arr.clone());
        long insertionSortTime = insertionSort(arr.clone());
        long mergeSortTime = mergeSort(arr.clone(), 0, arr.length - 1);
        long quickSortTime = quickSort(arr.clone(), 0, arr.length - 1);

        at.addRow(size, selectionSortTime + "ms", insertionSortTime + "ms", mergeSortTime + "ms", quickSortTime + "ms");
        at.addRule();
    }

    public static int[] createRandomArr(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }

        return arr;
    }


    public static long selectionSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.currentTimeMillis();

        return (endTime - startTime);
    }

    public static long insertionSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while ((j > -1) && (arr[j] > key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        long endTime = System.currentTimeMillis();

        return (endTime - startTime);
    }

    public static long mergeSort(int[] arr, int l, int r) {
        long startTime = System.currentTimeMillis();
        if (l < r) {
            int m = l + (r - l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
        long endTime = System.currentTimeMillis();

        return (endTime - startTime);
    }

    public static void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;


        int[] L = new int[n1];
        int[] R = new int[n2];


        System.arraycopy(arr, l, L, 0, n1);

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }


        int i = 0, j = 0;


        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static int partition(int[] array, int low, int high) {

        int pivot = array[high];

        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {


                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return (i + 1);
    }

    public static long quickSort(int[] array, int low, int high) {
        long startTime = System.currentTimeMillis();
        if (low < high) {

            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
        long endTime = System.currentTimeMillis();

        return (endTime - startTime);
    }

}