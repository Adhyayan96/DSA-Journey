import java.util.*;

public class TrappingRainWater {
    /* 
    Problem = Trapping rain water (Leetcode : 42)
    Approach: Auxiliary Arrays (Prefix Max + Suffix Max)
    Time Complexity = O(n)
    Space Complexity = O(n) 
    */

    public static int TrappedRainWater(int height[]){
        int width = 1;
        int totalTrappedWater = 0;
        
        // Step 1 : Calculate left max height for each bar
        int maxLeftHeight[] = new int[height.length];
        maxLeftHeight[0]=height[0];
        for(int i = 1; i<height.length; i++){ 
            maxLeftHeight[i] = Math.max(height[i], maxLeftHeight[i-1]);
        }

        // Step 2 : Calculate right max height for each bar
        int maxRightHeight[] = new int[height.length];
        maxRightHeight[height.length-1]=height[height.length-1];
        for(int j = height.length-2; j>=0; j--){ 
            maxRightHeight[j] = Math.max(height[j], maxRightHeight[j+1]); 
        }

        // Step 3 : Calculate total trapped water
        for(int in = 1; in<height.length-1; in++){ 
            int waterlevel = (Math.min(maxLeftHeight[in], maxRightHeight[in]))*width;
            totalTrappedWater += (waterlevel-height[in]); 
        }
        return totalTrappedWater;
    }

    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(TrappedRainWater(height));
    }
}
