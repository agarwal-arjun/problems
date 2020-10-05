package com.leetcode.problems;

public class FindTarget {

	public static void main(String[] args) {
		int[] nums= {1,3};
		int target=1;
		System.out.println(search(nums,target));

	}
	
	
	public static int search(int[] nums, int target) {
        if(nums.length==0 ){
            return -1;
        }else if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }
            return -1;
        }
        
        int dip=findDip(nums, 0,nums.length-1);
        
       
        int first= find(nums,target,0,dip<0?nums.length-1:dip-1);
        if(first>0){
            return first;
        }
        
        return dip<0? -1:find(nums,target,dip,nums.length-1);
        
    }
    
    public static int find(int[] nums, int target, int l, int h){
        if(l==h){
            if(nums[l]==target){
                return l ;
            }
            return -1;
        }
        
        int mid=(l+h)/2;
        if(nums[mid]+1>target){
            return find(nums,target,l,mid);
        }else{
            return find(nums,target,mid+1,h);
        }
    }
    
    public static int findDip(int[] nums,int l,int h){
        if(l==h){
            if(l==0){
                return -1;
            }
            return l;
        }
        
        int mid=(l+h)/2;
        if(nums[mid]>nums[h]){
            return findDip(nums,mid+1,h);
        }else{
            return findDip(nums,l,mid);
        }  
    }

}
