import java.util.Arrays;
public class Merge2Arrays {


    public static void main(String[] args) {

        int arr1[] = {1, 2, 3};
        int arr2[] = {4, 5, 6};


        /* ------------------------------------------------------------
           ✅ METHOD 1: MERGE USING LOOPS (INTERVIEW FRIENDLY)
          
           Concept:
           → Create a new array (size = arr1.length + arr2.length)
           → Copy arr1 values first, then arr2 values
         ------------------------------------------------------------
        */

        int merged1[] = new int[arr1.length + arr2.length];
        int index = 0; // pointer to merged array -->> Starting index

        // Copy arr1 into merged1
        for (int i = 0; i < arr1.length; i++) {
            merged1[index++] = arr1[i];  // insert first, then increase index
        }

        // Copy arr2 into merged1
        for (int j = 0; j < arr2.length; j++) {
            merged1[index++] = arr2[j];  // insert first, then increase index
        }

        System.out.println("Merged (Using Loop)          : " + Arrays.toString(merged1));



        /* ------------------------------------------------------------
           ✅ METHOD 2: USING System.arraycopy() (FASTER / EFFICIENT)
          
            Format:
            System.arraycopy(sourceArray, sourceStartIndex, destinationArray, destinationStartIndex, numberOfValuesToCopy);
        
            Step:
            → Copy arr1 to merged2 starting from index 0
            → Copy arr2 to merged2 starting from arr1.length
         ------------------------------------------------------------
         */

        int merged2[] = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, merged2, 0, arr1.length);
        System.arraycopy(arr2, 0, merged2, arr1.length, arr2.length);

        System.out.println("Merged (Using arraycopy)     : " + Arrays.toString(merged2));
    }
}


/*
======================
✅ OUTPUT
======================

Merged (Using Loop)          : [1, 2, 3, 4, 5, 6]
Merged (Using arraycopy)     : [1, 2, 3, 4, 5, 6]

*/

