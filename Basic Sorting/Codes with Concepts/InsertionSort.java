public class InsertionSort {
    /* Insertion sort : Build sorted array from left side by inserting element into correct position by "shifting" ("swapping" happens in - selection and bubble sort)
    
                        Insert current value into already sorted part
                        Moves (shifts) left side until correct spot

    Remember :  Selection Sort = FIND in right side → SWAP
                Insertion Sort = look in left side & SHIFT → INSERT

                The key difference:

                                    Selection Sort swaps only once per outer loop iteration.

                                    Insertion Sort may shift multiple elements to insert the current element.
    */
   public static void insertionSort(int arr[]){
        for(int i = 1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1; // storing just index

            // finding out the correct position to insert
            while(prev >=0 && arr[prev]>curr){
                arr[prev+1] = arr[prev]; // storing previous value to next index
                prev--;
            }
            // insertion of i's value
            arr[prev+1] = curr; // while prev's value becomes -1 or doesn't satisfy while loop's conditions, arr[prev+1] stores left i's value
        }

        // Print the sorted array
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int arr[]= {5,4,1,3,2};
        insertionSort(arr);
    }
}

// Output : 1 2 3 4 5 

/*  
    Insertion Sort Concept:

    Insertion sort builds a sorted portion of the array on the LEFT.

    For each index i (from 1 to end):
    - Take the element arr[i].
    - Compare with the left side (i-1 down to 0).
    - Shift bigger elements to the right.
    - Insert current element into its correct position.
*/

/* 
-------------------------------------
    DRY RUN (INPUT: 5,4,1,3,2)
-------------------------------------

Initial Array:
[5, 4, 1, 3, 2]

i = 1
curr = 4, prev = 0

[5, 4, 1, 3, 2]
5 > 4 → shift 5
[5, 5, 1, 3, 2]
prev becomes -1 → insert 4 at index 0
[4, 5, 1, 3, 2]


i = 2
curr = 1, prev = 1

[4, 5, 1, 3, 2]
5 > 1 → shift 5
[4, 5, 5, 3, 2]

prev = 0
4 > 1 → shift 4
[4, 4, 5, 3, 2]

prev becomes -1 → insert 1 at index 0
[1, 4, 5, 3, 2]


i = 3
curr = 3, prev = 2

[1, 4, 5, 3, 2]
5 > 3 → shift 5
[1, 4, 5, 5, 2]

prev = 1
4 > 3 → shift 4
[1, 4, 4, 5, 2]

prev = 0
1 <= 3 → stop → insert 3 at index 1
[1, 3, 4, 5, 2]


i = 4
curr = 2, prev = 3

[1, 3, 4, 5, 2]
5 > 2 → shift 5
[1, 3, 4, 5, 5]

prev = 2
4 > 2 → shift 4
[1, 3, 4, 4, 5]

prev = 1
3 > 2 → shift 3
[1, 3, 3, 4, 5]

prev = 0
1 <= 2 → stop → insert 2 at index 1
[1, 2, 3, 4, 5]


FINAL SORTED ARRAY:
[1, 2, 3, 4, 5]
-------------------------------------
*/
