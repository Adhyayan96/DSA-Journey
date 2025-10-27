import java.util.*;
// Binary Search applies on Sorted Arrays
// Time complexity = O(log n)

public class BinarySearch {

    public static int binarySearch(int numbers[], int key){
        int start = 0, end = numbers.length -1;

        while(start<=end){ // this loop will go till we come to the last elemnt in the array (it doesn't mean the last (array.lenght -1) index element)
            // finding mid
            int mid = start+(end - start)/2;

            // Doing comparison
            if(numbers[mid]==key){
                return mid;
            }
            else if(numbers[mid]<key){ // right
                start = mid+1; // here we need to find in right side, so end remains same but our start becomes mid + 1
            }
            else{ // left
                end = mid-1; // here we need to find in left side, so start remains same but our end becomes mid - 1
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int numbers[] = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;
        System.out.println("Index for key is : " + binarySearch(numbers, key));
    }
}
