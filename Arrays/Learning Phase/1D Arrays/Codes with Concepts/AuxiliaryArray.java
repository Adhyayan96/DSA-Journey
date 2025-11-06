public class AuxiliaryArray{
    /*  Topic = Auxiliary array or Helper array (an array that helps to solve a problem) = like prefix sum array, below see : maxlefthight and maxrightheight arrays
     
        Problem = Trapping rain water (Leetcode : 42)
        Approach: Auxiliary Arrays (Prefix Max + Suffix Max)

        Many questions that are using same concept and approach are like = how much can a character jump, storing acid ....

        Disclaimer : if there are just <3 buildings, water can't be trapped because it will fall in all cases
                     & 2nd thing is water can't be trapped on 2nd and last 2nd building because that will definitely fall */

    public static int TrappedRainWater(int height[]){
        int width = 1; // give in the question, each building's width
        int totalTrappedWater = 0;

        // Step 1 : calculate left max boundaries for each building's height (each array's element), in a seperate array : Prefix max
        int maxLeftHeight[] = new int[height.length];
        // intialling 1st index as usual, because if not do this then the program will through error because for index 0 there is no i-1 = -1 index
        maxLeftHeight[0]=height[0];
        for(int i = 1; i<height.length; i++){ // like prefix sum ; here we are taking "prefix max value/height" at left side
        // Each index's value represents max height among left buildings for that index
            maxLeftHeight[i] = Math.max(height[i], maxLeftHeight[i-1]); // storing the maximum height 
        }

        // Step 2 : calculate right max boundaries for each building's height (each array's element), in a seperate array : Suffix max
        int maxRightHeight[] = new int[height.length];
        maxRightHeight[height.length-1]=height[height.length-1]; // starting from last indedx, because we need to compare right side max height
        for(int j = height.length-2; j>=0; j--){ // starting from 2nd last building, last one we calculated on upper line 
        // this array will take all max heights for each building, by comparing current height from right most one and then this way will come to fast index 0
            maxRightHeight[j] = Math.max(height[j], maxRightHeight[j+1]);  // storing the maximum height       
        }

        // Step 3 : Calculate total trapped water
        for(int in = 1; in<height.length-1; in++){ // started from 2nd building and goes till 2nd last building, because water can't be trapped over first and last building
            // waterlevel = min(leftmax height, rightmax height)*width of buildings
            int waterlevel = (Math.min(maxLeftHeight[in], maxRightHeight[in]))*width;
            // totaltrappedWater = (waterLevel - height[in])
            totalTrappedWater += (waterlevel-height[in]); // here height[in] = height of the building
        }
        return totalTrappedWater;
    }

    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        System.out.println(TrappedRainWater(height));
    }
}

// Output = 11 (total trapped rain water)