import java.util.*;

/*Inbuilt sorting technique : 
                            Arrays.sort(arr);
                            Time complexity = O(log n)
*/

public class ArraysSortingFunctions {
    public static void main(String[] args) {
        Integer arr[]= {5,4,1,3,2};
        
/* 1 :  1 : Arrays.sort(arr); // all array elements will be sorted in increasing order
        Output : 12345 -->> fully sorted

        2 : for sorting a specific part : Arrays.sort(arr, startingIndex, endingIndex);
        Arrays.sort(arr,0,4);
        Output : 13452 -->> here sorted is done till 3rd index not 4,because in this way end index is exclusive (not included)

        3 : Sorting in reverse order : Arrays.sort(arr,Collections.reverseOrder()); 
        & for specific part : Arrays.sort(arr, StIndex, EndInd, Collections.reverseOrder());
        Very imortant : for this we need to convert our arr datatype int to Integer : because here this function allow us to do sorting 
        of Objects but int is a primitive datatype, so we need to convert to Integer for making a object. So we are converting array datatype 
        int to Integer type -->> now it's a object type array.
        
        Case 1 -->> Arrays.sort(arr,Collections.reverseOrder());
                    Output : 54321

        Case 2 -->> Arrays.sort(arr,0,3, Collections.reverseOrder());
                    Output : 54132
*/

        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
