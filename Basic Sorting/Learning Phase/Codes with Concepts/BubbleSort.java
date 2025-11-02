public class BubbleSort {

    // Bubble sort for arrenging an increasing or decreasing array
    public static void bubbleSort(int arr[]){
        for(int turn = 0; turn<arr.length-1; turn++){ // here we are going till 2nd last element of the array

            for(int j = 0; j<arr.length-1-turn; j++){ 

                // Swap : now will compare each element to the next element, to get which is smaller and will place them at first
                if(arr[j]>arr[j+1]){
                    int temp = arr[j]; // storing intial arr[j]'s value for swaping
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

        // Print the sorted array
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[]= {5,4,1,3,2};
        bubbleSort(arr);
    }
}

// Output : 1 2 3 4 5

/* 
Concept:
Each pass (or "turn") in Bubble Sort compares adjacent(next to each other or side by side) elements 
and moves the largest element of that pass to the end of the array.

We reduce the range of comparison by one after every pass because:
- In the first pass, we compare till the 2nd last element (since the last element has no next one to compare with).
- After the first pass, the largest element is placed at the last index.
- So, in the 2nd pass, we compare till the 3rd last element (the last one is already sorted).
- Each turn places the next-largest element in its correct position at the end.

In short:
Each pass places the largest element to the end, 
and the comparison range decreases from the end by one every time.
*/