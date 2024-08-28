public class implementation {
    class MinHeap {
        int[] harr;
        int capacity;
        int heap_size;
        MinHeap(int cap) {
            heap_size = 0;
            capacity = cap;
            harr = new int[cap];
        }
        int parent(int i) { return (i - 1) / 2; }
        int left(int i) { return (2 * i + 1); }
        int right(int i) { return (2 * i + 2); }

        //Function to extract minimum value in heap and then to store
        //next minimum value at first index.
        int extractMin() {
            if (heap_size == 0)
                return -1; // or throw an exception
            if (heap_size == 1) {
                heap_size--;
                return harr[0];
            }

            int root = harr[0];
            harr[0] = harr[heap_size - 1];
            heap_size--;
            MinHeapify(0);
            return root;
        }


        //Function to insert a value in Heap.
        void insertKey(int k) {
            if (heap_size == capacity)
                return; // or throw an exception
            heap_size++;
            int i = heap_size - 1;
            harr[i] = k;
            while (i != 0 && harr[parent(i)] > harr[i]) {
                int temp = harr[i];
                harr[i] = harr[parent(i)];
                harr[parent(i)] = temp;
                i = parent(i);
            }
        }


        void deleteKey(int i) {
            if (i < 0 || i >= heap_size)
                return; // or throw an exception
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }


        //Function to change value at ith index and store that value at first index.
        void decreaseKey(int i, int new_val)
        {
            harr[i] = new_val;
            while (i != 0 && harr[parent(i)] > harr[i]) {
                int temp = harr[i];
                harr[i] = harr[parent(i)];
                harr[parent(i)] = temp;
                i = parent(i);
            }
        }

        /* You may call below MinHeapify function in
          above codes. Please do not delete this code
          if you are not writing your own MinHeapify */
        void MinHeapify(int i) {
            int l = left(i);
            int r = right(i);
            int smallest = i;
            if (l < heap_size && harr[l] < harr[i]) smallest = l;
            if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
            if (smallest != i) {
                int temp = harr[i];
                harr[i] = harr[smallest];
                harr[smallest] = temp;
                MinHeapify(smallest);
            }
        }
        void MaxHeapify(int arr[], int n, int i) {

            int largest = i;
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if (l < n && arr[l] > arr[largest])
                largest = l;
            if (r < n && arr[r] > arr[largest])
                largest = r;
            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                MaxHeapify(arr, n, largest);
            }
        }
    }
}
