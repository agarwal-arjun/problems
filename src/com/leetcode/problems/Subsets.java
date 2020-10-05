package com.leetcode.problems;
import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subsets(new int[] {1,2,3}));

	}
	
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret=new ArrayList();
        if(nums.length==0){
            return ret;
        }
        ArrayList<Integer> list=new ArrayList();
        set(nums,ret,list,0);
        return ret;
    }
    
    public static void set(int[] nums,List<List<Integer>> ret, ArrayList<Integer> list, int pos){
        if(nums.length==pos){
            ret.add((List<Integer>)list.clone());
            return;
        }
        
        list.add(nums[pos]);
        set(nums,ret,list,pos+1);
        list.remove(list.size()-1);

        set(nums,ret,list,pos+1);
    }
}
