package Codes;
import java.util.*;

public class ArraryInputOutput {

    public static void updateValues(int newarr[]){
        // Arguments passing - increasing each array element by 1
        for(int index = 0; index<newarr.length; index++){
            newarr[index]++; // *** this will update main function's original array's elements, because array follows - Pass by Value (changes original value)
            System.out.print(newarr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int newarr[] = new int[n];

        // basics
        newarr[0]=sc.nextInt();
        newarr[1]=sc.nextInt();
        newarr[2]=sc.nextInt();
        newarr[3]=sc.nextInt();
        newarr[4]=sc.nextInt();
        System.out.println(newarr[3]+7); // changed value of an elment
        System.out.println(newarr.length); // find length of my newarr array

        // Arguments passing - Pass by reference
        updateValues(newarr);
        
        System.out.println(newarr[0]); // this value changed through arguments passing
        sc.close();
    }
}
