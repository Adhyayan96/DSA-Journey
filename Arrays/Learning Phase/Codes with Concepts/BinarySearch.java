import java.util.*;
// Binary Search applies on Sorted Arrays
// Time complexity = O(log n)

public class BinarySearch {

    public static int binarySearch(int numbers[], int key){
        int start = 0, end = numbers.length -1;

        while(start<=end){ // this loop will go till we come to the last elemnt in the array (it doesn't mean the last (array.lenght -1) index element)
        // Note : If the given array sorted in descending order, condition changes (> instead of <)
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

/*
    Binary Search Concept :
                            TC = O(log n)
                            Def = It applies on sorted arrays (like increasing or decreasing elements). 
                            
                            In BInary Search, we don’t need to do linear search to find some key element in the array. 
                            Rather we find the array where it will be in the array and then check only that area, not whole array elements.

                            # Solving way (Pseudocode) : 

                            start = 0
                            end = length - 1

                            while start <= end:
                            mid = start + (end - start) / 2
                            if arr[mid] == key: return mid
                            else if arr[mid] < key: search right (start = mid + 1)
                            else search left (end = mid - 1)

                            return -1

    In short : 
                Binary Search = Pick middle → compare with key → if equal: found → if smaller: go right → 
                if larger: go left → repeat until found or array ends                     
*/