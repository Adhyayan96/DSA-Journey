package Easy;
import java.util.*;

public class HWofLinearSearch {
    // Q = make an array food (String data type) & then take input through elements. Now find where is mango, if there is not then return -1.
    // Space complexity = O(n)
    // Time complexity = O(n)
    
    public static int HW(String food[], String key){
        for(int index = 0; index<food.length; index++){
            if(food[index].equals(key)){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ElementsArray = sc.nextInt();
        sc.nextLine(); // after taking integer input the scanner gets stuck after that and takes the line after the integer input and gets an empty line, so This dummy nextLine() reads and throws away that leftover empty line after the number.
        String food[] = new String[ElementsArray];
        for(int i = 0; i<ElementsArray; i++){
            food[i]=sc.nextLine();
        }
        String key = sc.nextLine();
        int ans = HW(food, key);
        System.out.println(ans);
        sc.close();
    }
}
