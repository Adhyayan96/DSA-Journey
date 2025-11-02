import java.util.*;
public class CountingSort {

    /* 
        Where to use Count Sort :   Works best when array length can be any size but values are small. 
                                    Because if the range of values is huge, the count array will be very large → wasteful in space.
    */

    /*  Counting Sort :
                        S1 : Find largest value.

                        S2 : Count frequency of all main array's elements, through an additional
                             count array (length = largest value+1)

                        S3 : Sort them in Asending/Descending order
    */

    /*
        Time and Space Complexity Notes:

        - Find max → O(n)

        - Build count array → O(n)

        - Optional: accumulate counts → O(k) where k = max/largest value in main array

        - Build sorted array → O(n)
        
        Final Time Complexity: O(n + k), not O(n²)
        - n = number of elements in input array
        - k = range of values (maximum element in array)

        Space Complexity: O(k) for the count array, not O(1)
        - Extra memory proportional to the maximum/largest value in main array
    */

    
    public static void countingSort(int arr[]){
        int largest = Integer.MIN_VALUE;

        // S1 : find largest value
        for(int i = 0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }


        // S2 : count each element in count array
        int count[] = new int[largest+1];
        /* "+1" : because ideally we start an array from 0th index.
            So the array will start from 0th index go upto the largest index. 
            So the array's length = largest value+1.
        */
        for(int i = 0; i<arr.length; i++){ // Iterate on original array
            count[arr[i]]++;
        }
            /*
                Concept :   
                            count[i] stores how many times value 'i' appears in arr[]
                            
                            Example (same array):
                               arr = {1,4,1,3,2,4,3,7}
                            
                            After this loop, count[] becomes:
                               Index →  0 1 2 3 4 5 6 7
                               Value →  0 2 1 2 2 0 0 1
                            
                            Meaning:
                               count[1] = 2 → number 1 appears twice
                               count[2] = 1 → number 2 appears once
                               count[3] = 2 → number 3 appears twice
                               count[4] = 2 → number 4 appears twice
                               count[7] = 1 → number 7 appears once
                            
                            Memory Trick:
                               index = number
                               value = how many times it appears (frequency)
                            
            */


        // S3 : sorting part -->> Buid the sorted array using the frequency stored in the count array
        int j = 0; // for sorting main array's indexs
        for(int i = 0; i<count.length; i++){ // Iterate on count array
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
            /*
                STEP 3: Build the sorted array using the count[] frequency table

                Concept:
                ➤ We loop through count[] from index 0 to last index.
                ➤ Each index (i) represents a number.
                ➤ count[i] tells how many times number i appears in the original array.
                ➤ If count[i] > 0, we insert number i into the result array exactly count[i] times.

                Example:
                Original Array  = {4, 1, 3, 4, 1, 2, 3, 7}
                After counting, we get count[] = {0,2,1,2,2,0,0,1}

                Meaning of count[]:
                    count[2] = 1 → number 2 appears once
                    count[1] = 2 → number 1 appears twice
                    count[3] = 2 → number 3 appears twice
                    count[4] = 2 → number 4 appears twice
                    count[7] = 1 → number 7 appears once

                Dry Run of building sorted array:

                i = 0 → count[0] = 0 → skip (0 appears 0 times)
                i = 1 → count[1] = 2 → insert 1 twice → arr = {1, 1}
                i = 2 → count[2] = 1 → insert 2 once → arr = {1, 1, 2}
                i = 3 → count[3] = 2 → insert 3 twice → arr = {1, 1, 2, 3, 3}
                i = 4 → count[4] = 2 → insert 4 twice → arr = {1, 1, 2, 3, 3, 4, 4}
                i = 5 → count[5] = 0 → skip
                i = 6 → count[6] = 0 → skip
                i = 7 → count[7] = 1 → insert 7 once → arr = {1, 1, 2, 3, 3, 4, 4, 7}
            */


        // Print sorted array
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
    
    public static void main(String[] args) {
        int arr[]= {1,4,1,3,2,4,3,7};
        countingSort(arr);
    }
}

// Output : 11233447