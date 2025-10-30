public class KadaneAlgo {
    // Kadane's Algorithm
    // Q = Maximum Subarray Sum = optimized approach : TC = O(n)

    public static void subArraysum(int numbers[]){
        int currentSum = 0; 
        int max = Integer.MIN_VALUE; // Intializing from the minimum value = -infinity

        for(int i = 0; i<numbers.length; i++){
            currentSum += numbers[i]; // Step 1 : adding each array element with current sum
            max = Math.max(max, currentSum); // Step 2 : finding maximum value
            if(currentSum<0){ // Step 3 : most important step of kadane's algorithm = re-initializing current sum to 0, if ...
                currentSum = 0;
            }

            /*
            Concepts :  Q. If all array values are negative then the max value will come in negative, so how this Kadane's algo manaage that ? 
                            = In this case we do these upper 3 steps : at first we are taking the current sum as in main array and
                            then finding maximum value between the max(-infinity) value and curent sum value -> here already we are storing
                            that max negative value in max value, then we resetting the current value to 0 if current sum <0. 
                            So this upper 3 steps together works for every single scenarios, including even all negative elments of an array.

                        Q.  Why we reset current sum to 0 ?
                            = Because if a sum we got negative (after doing sum of current sum with next element of the array) then for 
                            the next element, its total sum well be less (if we don't reset current sum = 0) - so this sum will not be 
                            what is needed.
            */   
        }

        System.out.println("Maximum Subarray sum : "+max);
    }

    public static void main(String[] args){
        int numbers[] = {-1,-2,-3,-4};
        subArraysum(numbers);
    }
}

// Output is : Maximum Subarray sum is : -1 // for this all negative array elements

/*
    Kadane's Algo :
                    +ve value + +ve value = +value
                    +ve value + -ve value (smaller than +ve value) = +ve value // like = 2-1 = 1
                    +ve value + -ve value (bigger than +ve value) = -ve value // like = 1-2 = -1

                    Here Kaden says, if sum is -ve, then return sum = 0 instead the -ve number 

                    it's TC is = O(n) // see KadaneAlgo code in Learning Phase  

    Explanatiion :  let's take an example array = {-2,-3,4,-1,-2,1,5,-3}
                    Now if you carefully see the maximum subarray sum comes from index 2 to 6 = so 4 + (-1) + (-2) + 1 + 5 = 7
                    In subarray sum, we are storing each element's sum to current value and then finding MAX_VALUE 
                    (see KadaneAlgo code in Learning Phase)

                    And doing sum between every array's element with previous currentsum / previous sum.
*/