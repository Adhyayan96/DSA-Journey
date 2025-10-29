public class SelectionSort {
    /*
    Selection Sort :    Select best (smallest/largest) and swap
                        Searches right side for min/max

    Remember :  Selection Sort = FIND in right side → SWAP
                Insertion Sort = look in left side & SHIFT → INSERT

                The key difference:

                                    Selection Sort swaps only once per outer loop iteration.

                                    Insertion Sort may shift multiple elements to insert the current element.
    */

    public static void selectionSort(int arr[]){
        for(int i = 0; i<arr.length-1; i++){ 
        int smallIn = i; // Index of the smallest element in the array: here initially we are assuming
            for(int j = i+1; j<arr.length; j++){ // each time we are comparing each element (i) with next all element through the inner loop
                if(arr[j]<arr[smallIn]){ // if we give ">" in between, then it will look for biggest value's index
                    smallIn = j; // storing smallest value's index
                }
            }

            // swap
            int temp = arr[smallIn]; // storing j's index's value
            arr[smallIn] = arr[i]; // changing j index's value to i's value
            arr[i] = temp; // changing i's value to j's value
        }

        // Print all array elements
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[]= {5,4,1,3,2};
        selectionSort(arr);
    }
}

// Output : 1 2 3 4 5

/* 
Selection Sort Concept:

For each index i (from 0 to n-2):
    1. Assume arr[i] is the smallest element.
    2. Scan the rest of the array (i+1 to n-1) to find the actual smallest element.
    3. Swap that smallest element with arr[i].

Result: After each outer loop iteration, the correct element is placed at position i.

Short Note : Selection sort = Find best element (smallest/largest) + Swap → repeat
*/
