package Easy;
import java.util.*;;

// Q = Print all possiblie pairs of all elements of an array
// Sample input = 5 (n) & then for array = 2,3,4,5,6
// Time complexity = O(n)

public class PairsinArray {

    public static void Pairs(int arr[]){
        for(int i = 0; i<arr.length; i++){
            int totalPairs = 0;
            for(int in = i+1; in<arr.length; in++){
                System.out.print("("+arr[i]+","+arr[in]+") " );
                totalPairs++;
            }
            System.out.print(" - total possiblie pairs are = " + totalPairs);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int in = 0; in<n; in++){
            arr[in]=sc.nextInt();
        }
        Pairs(arr);
        sc.close();
    }
}

/* Output =
(2,3) (2,4) (2,5) (2,6)  - total possiblie pairs are = 4
(3,4) (3,5) (3,6)  - total possiblie pairs are = 3
(4,5) (4,6)  - total possiblie pairs are = 2
(5,6)  - total possiblie pairs are = 1
 - total possiblie pairs are = 0
*/
