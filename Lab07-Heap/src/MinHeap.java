public class MinHeap {

    int load = 0;                 // number of items in heap
    int[] hArray = new int[100];  // heap storage

    MinHeap() { }

    // Move a newly inserted value up the heap
    void reheapUp(int currentIndex) {
        if (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            // For MIN heap: child < parent
            if (hArray[currentIndex] < hArray[parentIndex]) {
                swap(hArray, currentIndex, parentIndex);
                reheapUp(parentIndex);
            }
        }
    }

    // Insert a new value into the min heap
    void insert(int data) {
        hArray[load] = data;
        load++;
        reheapUp(load - 1);
    }

    // Move a value down the heap to restore order
    void reheapDown(int currentIndex) {
        int lastIndex = load - 1;

        // Check if it has a left child
        if (2 * currentIndex + 1 <= lastIndex) {
            int smallIndex;
            int left = 2 * currentIndex + 1;
            int right = 2 * currentIndex + 2;

            // Pick the smaller child
            if (right > lastIndex) {
                smallIndex = left;
            } else if (hArray[right] < hArray[left]) {
                smallIndex = right;
            } else {
                smallIndex = left;
            }

            // For MIN heap: parent > smaller child
            if (hArray[currentIndex] > hArray[smallIndex]) {
                swap(hArray, currentIndex, smallIndex);
                reheapDown(smallIndex);
            }
        }
    }

    // Remove and return smallest element (root)
    int deleteRoot() {
        if (load == 0) {
            return -1;
        }

        int temp = hArray[0];
        hArray[0] = hArray[load - 1];
        hArray[load - 1] = 0;
        load--;

        reheapDown(0);

        return temp;
    }

    // Priority Queue: insert (enqueue)
    public void enqueue(int data) {
        insert(data);
    }

    // Priority Queue: remove smallest element (dequeue)
    public int dequeue() {
        return deleteRoot();
    }

    // Check if empty
    public boolean isEmpty() {
        return load == 0;
    }

    // Swap two values
    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Print heap content
    void printHeap() {
        for (int i = 0; i < load; i++)
            System.out.print(hArray[i] + " ");
        System.out.println();
    }
}
