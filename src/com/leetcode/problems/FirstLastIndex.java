package com.leetcode.problems;
import java.util.ArrayList;
import java.util.List;

public class FirstLastIndex {

	public static void main(String[] args) {
		int[] nums= {5,7,7,8,8,10};
		int target=8;
		int[] out=searchRange(nums,target);
		System.out.println(out[0]+" "+out[1]);
		
	}
	
	
	public static int[] searchRange(int[] nums, int target) {
        int[] ret=new int[2];
        
        int start=search(nums,target,0,nums.length-1,true);
        int end=search(nums,target,0,nums.length-1,false);
        ret[0]=start;
        ret[1]=end;
        return ret;
            
    }
    
    public static int search(int[] nums, int target,int l,int h, boolean left){
        if(l==h){
            if(nums[l]!=target){
                return -1;
            }
            return l;
        }
        
        int mid=(l+h)/2;
        
        if(left){
             if(nums[mid]>=target){
               return  search(nums,target,l,mid,left);
            }else{
                return search(nums,target,mid+1,h,left);
            }
        }else{
            if(nums[mid+1]<=target){
               return  search(nums,target,mid+1,h,left);
            }else{
                return search(nums,target,l,mid,left);
            }
        }
       
        
        
    }

}
