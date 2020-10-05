package com.leetcode.problems;
import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] nums= {1,3,2};
		nextPermutation(nums);
		for (int i : nums) {
			System.out.println(i);
		}
		

	}
	
	public static  void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int len=nums.length;
        for(int i=len-2;i>=0;i--){
            int temp=-1;
            for(int j=i+1;j<len;j++){
                if(nums[i]<nums[j]){
                    if(temp<0 || nums[temp]>nums[j]){
                        temp=j;
                    }
                }
            }
            
            if(temp>=0){
                int swap=nums[temp];
                nums[temp]=nums[i];
                nums[i]=swap;
                Arrays.sort(nums,i+1,len-1);
                return;
            }
            
        }
        
        Arrays.sort(nums);
        return;
        
    }

}
