public class PrefixSum {
    /*
        Q = Find Maximum Subarray Sum : Prefix Sum approach = O(n²)
        Better than brute-force O(n³) subarray sum approach
    */

    public static void prefixSum(int numbers[]){
        int currSum = 0; // current sum
        int maxSum = Integer.MIN_VALUE; // initially : -infinity

        /*
            Prefix array stores sum of elements from index 0 to i
            Note: We could update the original array to save space,
            but keeping it unchanged is safer for reuse elsewhere.
        */
        int prefix[] = new int[numbers.length]; 
        prefix[0] = numbers[0]; // first index’s sum is same as original

        for(int i = 1; i < prefix.length; i++){
            prefix[i] = prefix[i-1] + numbers[i]; 
            // prefix[i] = sum from index 0 to i
        }

        for(int i = 0; i < numbers.length; i++){ // start index
            for(int k = i; k < numbers.length; k++){ // end index
                /*
                    Concept: Subarray sum from i to k
                    - If i == 0: sum = prefix[k]
                    - Else: sum = prefix[k] - prefix[i-1]

                    Explanation:
                    - prefix[k] = sum from index 0 to k
                    - prefix[i-1] = sum from index 0 to i-1
                    - Difference = sum from i to k
                    - Avoids extra inner loop (O(n³) → O(n²))
                    - Space complexity = O(n) for prefix array
                    - Kadane's algorithm can achieve O(n) if needed
                */
                currSum = i == 0 ? prefix[k] : prefix[k] - prefix[i-1]; 
                maxSum = Math.max(maxSum, currSum); // store maximum sum
            }
        }
        System.out.println("Maximum sum is : " + maxSum);
    }

    public static void main(String[] args){
        int numbers[] = {1, -1, 6, -1, 3};
        prefixSum(numbers);
    }
}

/*
    PREFIX SUM NOTES (Full Concept - Easy to Recall):

    1. Definition:
       Prefix sum at index i = sum of all elements from 0 to i

    2. When to use:
       Frequently calculating subarray sums or range queries

    3. How to calculate:
       - prefix[0] = arr[0]
       - prefix[i] = prefix[i-1] + arr[i]  (for i >= 1)

    4. Subarray sum formula:
       - sum(i to j) = prefix[j] - prefix[i-1]  (if i > 0)
       - sum(0 to j) = prefix[j]  (if i == 0)

    5. Benefits:
       - Reduces O(n³) brute-force → O(n²)
       - Original array stays unchanged
       - Avoids recalculating sums multiple times

    6. Dry Run Example:
       Array = {1, -1, 6, -1, 3}
       Prefix = {1, 0, 6, 5, 8}
       Maximum Subarray Sum = 8 (subarray {1, -1, 6, -1, 3})

    7. Extra Notes:
       - This approach is intermediate optimization
       - Kadane's algorithm is O(n) and better for max subarray sum
*/


/*
----------------------------------------------
🔹 DRY RUN OF PREFIX SUM METHOD
----------------------------------------------

Array: numbers = {1, -1, 6, -1, 3}

Step 1️⃣: Build prefix array
----------------------------------------------
prefix[0] = numbers[0] = 1 (subarray sum of 0th index)
prefix[1] = prefix[0] + numbers[1] = 1 + (-1) = 0 (subarray sum of 0th index to 1st index)
prefix[2] = prefix[1] + numbers[2] = 0 + 6 = 6 (subarray sum of 0th index to 2nd index)
prefix[3] = prefix[2] + numbers[3] = 6 + (-1) = 5 (subarray sum of 0th index to 3rd index)
prefix[4] = prefix[3] + numbers[4] = 5 + 3 = 8 (subarray sum of 0th index to 4th index)

So, prefix = {1, 0, 6, 5, 8}

----------------------------------------------
Step 2️⃣: Find maximum subarray sum
----------------------------------------------
Loop through all subarrays (i...k):

i=0, k=0 → currSum = prefix[0] = 1            → maxSum = 1
i=0, k=1 → currSum = prefix[0] = 1            → maxSum = 1
i=0, k=2 → currSum = prefix[0] = 1            → maxSum = 1
i=0, k=3 → currSum = prefix[0] = 1            → maxSum = 1
i=0, k=4 → currSum = prefix[0] = 1            → maxSum = 1

i=1, k=1 → currSum = prefix[1]-prefix[0] = 0-1 = -1     → maxSum = 1
i=1, k=2 → currSum = prefix[2]-prefix[0] = 6-1 = 5      → maxSum = 5
i=1, k=3 → currSum = prefix[3]-prefix[0] = 5-1 = 4      → maxSum = 4
i=1, k=4 → currSum = prefix[4]-prefix[0] = 8-1 = 7      → maxSum = 7

i=2, k=2 → currSum = prefix[2]-prefix[1] = 6-0 = 6      → maxSum = 7
i=2, k=3 → currSum = prefix[3]-prefix[1] = 5-0 = 5      → maxSum = 7
i=2, k=4 → currSum = prefix[4]-prefix[1] = 8-0 = 8      → maxSum = 8

i=3, k=3 → currSum = prefix[3]-prefix[2] = 5-6 = -1     → maxSum = 8
i=3, k=4 → currSum = prefix[4]-prefix[2] = 8-6 = 2      → maxSum = 8

i=4, k=4 → currSum = prefix[4]-prefix[3] = 8-5 = 3      → maxSum = 8

----------------------------------------------
✅ FINAL RESULT:
Maximum Subarray Sum = 8

(The subarray with max sum is {1, -1, 6, -1, 3})
----------------------------------------------
*/
