/* Name:- Sarvesh Kulkarni
   Roll.no:- 84
*/
import java.util.Scanner;

public class HeapSort {

    public void buildMaxHeap(int arr[]) {
        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyMax(arr, n, i);
        }
    }

    void heapifyMax(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyMax(arr, n, largest);
        }
    }

    public void buildMinHeap(int arr[]) {
        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyMin(arr, n, i);
        }
    }

    void heapifyMin(int arr[], int n, int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] < arr[smallest]) {
            smallest = l;
        }
        if (r < n && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapifyMin(arr, n, smallest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the number of elements: ");
            int n = s.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = s.nextInt();
            }

            System.out.println("Choose heap type:");
            System.out.println("1. Max Heap");
            System.out.println("2. Min Heap");
            int choice = s.nextInt();

            HeapSort ob = new HeapSort();

            switch (choice) {
                case 1:
                    ob.buildMaxHeap(arr);
                    System.out.println("The array in Max Heap format is:");
                    printArray(arr);
                    break;
                case 2:
                    ob.buildMinHeap(arr);
                    System.out.println("The array in Min Heap format is:");
                    printArray(arr);
                    break;
                default:
                    System.out.println("Invalid choice! Please choose 1 for Max Heap or 2 for Min Heap.");
                    break;
            }

            System.out.print("Do you want to continue? (for yes(1)/for no(2)): ");
            int x = s.nextInt();
            if (x != 1) {
                break;
            }
        }
    }
}