package Codes;
import java.util.*;
// time complexity = O(n)

public class LinearSearch {

    public static int linearSearch(int numbers[], int key){
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Linear Search = searching an element in a linear array
        int numbers[] = {13, 34, 10, 1};
        int key = 10;
        int ans = linearSearch(numbers, key); // stored our return value
        if(ans==-1){
            System.out.println("Not found");
        }
        else{
            System.out.println("Here is the index : " + ans);
        }
    }
}
