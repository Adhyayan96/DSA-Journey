import java.util.*;

public class LargestNumber {
    // Q = find the largest number in the given array of length 5

    public static int largestNumber(int arr[], int largest){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int largest = Integer.MIN_VALUE;
        int arr[] = new int [5];
        for(int i = 0; i<arr.length; i++){
            arr[i]=sc.nextInt();
        }
        int ans = largestNumber(arr, largest);
        System.out.println(ans);
        sc.close();
    }
}
