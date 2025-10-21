import java.util.*;

public class ReverseArray {
    // Q = You have been given an array of length n, reverse this

    public static void reverseArray(int arr[]){
        int start = 0, end = arr.length - 1;
        while(start<end){
            int startCopy = arr[start];
            arr[start] = arr[end];
            arr[end] = startCopy;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int [n];
        for(int i = 0; i<arr.length; i++){
            arr[i]=sc.nextInt();
        }
        reverseArray(arr); // calling our function (Without calling this, reverse won't work)
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
