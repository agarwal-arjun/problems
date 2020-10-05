package com.leetcode.problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("input:");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		int[] input=new int[size];
		
		for(int i=0;i<size;i++) {
			input[i]=sc.nextInt();
		}

		System.out.println(threeSum(input));
		
	}

	
	public static List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> ret=new ArrayList();
        if(nums.length<3){
            return ret;
        }
        
        if(!Arrays.stream(nums).anyMatch(k->{return k!=0;})) {
        	List<Integer> inner=new ArrayList<>();
            inner.add(0);
            inner.add(0);
            inner.add(0);
            ret.add(inner);
        	return ret;
        }
        
       
        
        Map<Integer,Integer> map=new HashMap();
        
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
               map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        
        Set<String> unique=new HashSet();
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j){
                    continue;
                }else{
                    int neg=(-nums[i]-nums[j]);
                    
                    if(map.containsKey(neg)){
                    	if(nums[i]==0 && nums[j]==0) {
                    		if(map.get(neg)<3) {
                        		continue;
                        	}
                    	}else if(neg==nums[i]||neg==nums[j]) {
                        	if(map.get(neg)<2) {
                        		continue;
                        	}
                        }
                       
                        List<Integer> inner=new ArrayList<>();
                        inner.add(nums[i]);
                        inner.add(nums[j]);
                        inner.add(neg);
                        Collections.sort(inner);
                        
                        sb.append(inner.get(0));
                        sb.append(inner.get(1));
                        sb.append(inner.get(2));
                        if(!unique.contains(sb.toString())) {
                        	 ret.add(inner);
                        	 unique.add(sb.toString());
                        }
                        sb.setLength(0);
                       
                    }
                }
                
            }
        }
        
        return ret;
    }


}
	
