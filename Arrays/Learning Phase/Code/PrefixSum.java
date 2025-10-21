public class PrefixSum {
    // Q = Find Maximum Subarray sum (O(n²))

    public static void prefixSum(int numbers[]){
        int currSum = 0; // current sum
        int maxSum = Integer.MIN_VALUE; // initially : -infinity

        // Prefix array making & all elements calculation - Prefix sum
        int prefix[] = new int[numbers.length]; // making an array to store prefix sum elements
        // Though we don't need to make another array for storing prefix sum values becuase space complexity will increase. So if we just change main arrays values and call from main function it works
        prefix[0]=numbers[0]; // first index's value will be same

        for(int i = 1; i<prefix.length; i++){
            prefix[i]=prefix[i-1]+numbers[i]; // prefix[i] = previous index's element of prefix array or previous sum + current index's element of numbers' array
        } // here i'm already storing all subarray sums of index 0

        for(int i = 0; i<numbers.length; i++){ // i = Start index of subarray
            for(int k=i; k<numbers.length; k++){ // j = End index of subarray
                // See the dry run below
                currSum = i==0? prefix[i]: prefix[k]-prefix[i-1]; // if starting index is zero, then we will get "negative value" & will got an error during running the code
                // prefix[end] - prefix[start-1]
                // Instead of doing sum through another nested loop, this is a shortest way (but there is kadane's algorithm, the shortest way possible) - just we need to do prefix sum, then we get same sum of all pairs and this prefix sum way reduces time complexity : O(n^3) to O(n^2)
                maxSum = Math.max(maxSum, currSum); // maximum value will be stored in maxSum
            }
        }
        System.out.println("maximum sum is : " + maxSum);
    }

    public static void main(String[] args){
        int numbers[] = {1,-1,6,-1,3};
        prefixSum(numbers);
    }
}

/*
----------------------------------------------
🔹PREFIX SUM METHOD SHORT CONCEPT NOTE
----------------------------------------------

Outer loop (i) fixes starting index of subarray
Inner loop (k) moves end index from i → end of array
=> Together, they generate ALL possible subarrays.

Instead of summing manually inside another loop, we use prefix sum to quickly calculate subarray sums:

prefix[k] = sum of elements from 0 to k
prefix[i-1] = sum of elements from 0 to (i-1)
So, sum of subarray (i to k) = prefix[k] - prefix[i-1]

Explanation = ex array : {1,-2,6,-1,3} = if we wanna get this subarray's sum {-2,6,-1} = if we make a loop that goes start index(1) to end index(3) to get the sum of the subarray
then = (-2+6+(-1)) = 3. But if we do "prefix[end] - prefix[start-1]" then in our prefix array {1,-1,5,4,7} = if we take as usual this part ({-2,6,-1}) start from index 1 and 
goes till index 3, so through prefix array we will get this value by prefix[end] - prefix[start-1] = 
prefix [end value = 4] - prefix[start value = 1 and then minus 1 : so 1-1 = 0th index] = 3.

If i == 0, then we directly take prefix[k]


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
