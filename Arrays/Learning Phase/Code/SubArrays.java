package Codes;
import java.util.*;
// Subarrays = a continuous part of an array
// Q = Print all sub arrays of an array, count how many sub arrays are there, find sum of every single subarrays & the find max and minimum values of these sums of subarrays

public class SubArrays {

    public static void subArrays(int numbers[]){
        for(int i = 0; i<numbers.length; i++){
            int totalSubarrays = 0; // for calculating total number of sub arrays of an element
            int max = 0;
            int min = 1;
            for(int k =i; k<numbers.length; k++){
                int sumOfSubarrays = 0; // for calculating sum of each subarrays
                for(int j = i; j<=k; j++){
                System.out.print(numbers[j] + " ");
                sumOfSubarrays +=numbers[j];
            }
            totalSubarrays++;
            max = Math.max(max, sumOfSubarrays);
            min = Math.min(min, sumOfSubarrays);
            System.out.println("   - Sum of all this sub array's elements is : "+sumOfSubarrays);           
            System.out.println();
            }
            System.out.println("Maximum value of all subarray's sum of '"+i+"' is : "+max);
            System.out.println("Minimum value of all subarray's sum of '"+i+"' is : "+min);
            System.out.println("Total sub arrays for element " + i + " is : "+totalSubarrays);
            System.out.println();
        }
    }

    public static void main(String[] args){
        int numbers[] = {2, 4, 6, 8, 10, 12, 14};
        subArrays(numbers);
    }
}

/*
Output =

2    - Sum of all this sub array's elements is : 2

2 4    - Sum of all this sub array's elements is : 6

2 4 6    - Sum of all this sub array's elements is : 12

2 4 6 8    - Sum of all this sub array's elements is : 20

2 4 6 8 10    - Sum of all this sub array's elements is : 30

2 4 6 8 10 12    - Sum of all this sub array's elements is : 42

2 4 6 8 10 12 14    - Sum of all this sub array's elements is : 56

Maximum value of all subarray's sum of '0' is : 56
Minimum value of all subarray's sum of '0' is : 1
Total sub arrays for element 0 is : 7

4    - Sum of all this sub array's elements is : 4

4 6    - Sum of all this sub array's elements is : 10

4 6 8    - Sum of all this sub array's elements is : 18

4 6 8 10    - Sum of all this sub array's elements is : 28

4 6 8 10 12    - Sum of all this sub array's elements is : 40

4 6 8 10 12 14    - Sum of all this sub array's elements is : 54

Maximum value of all subarray's sum of '1' is : 54
Minimum value of all subarray's sum of '1' is : 1
Total sub arrays for element 1 is : 6

6    - Sum of all this sub array's elements is : 6

6 8    - Sum of all this sub array's elements is : 14

6 8 10    - Sum of all this sub array's elements is : 24

6 8 10 12    - Sum of all this sub array's elements is : 36

6 8 10 12 14    - Sum of all this sub array's elements is : 50

Maximum value of all subarray's sum of '2' is : 50
Minimum value of all subarray's sum of '2' is : 1
Total sub arrays for element 2 is : 5

8    - Sum of all this sub array's elements is : 8

8 10    - Sum of all this sub array's elements is : 18

8 10 12    - Sum of all this sub array's elements is : 30

8 10 12 14    - Sum of all this sub array's elements is : 44

Maximum value of all subarray's sum of '3' is : 44
Minimum value of all subarray's sum of '3' is : 1
Total sub arrays for element 3 is : 4

10    - Sum of all this sub array's elements is : 10

10 12    - Sum of all this sub array's elements is : 22

10 12 14    - Sum of all this sub array's elements is : 36

Maximum value of all subarray's sum of '4' is : 36
Minimum value of all subarray's sum of '4' is : 1
Total sub arrays for element 4 is : 3

12    - Sum of all this sub array's elements is : 12

12 14    - Sum of all this sub array's elements is : 26

Maximum value of all subarray's sum of '5' is : 26
Minimum value of all subarray's sum of '5' is : 1
Total sub arrays for element 5 is : 2

14    - Sum of all this sub array's elements is : 14

Maximum value of all subarray's sum of '6' is : 14
Minimum value of all subarray's sum of '6' is : 1
Total sub arrays for element 6 is : 1

*/