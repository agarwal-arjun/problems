package com.leetcode.problems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EquiDistPermutation {

	public static void main(String[] args) {
		System.out.println("input:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		List<List<Integer>> retList=new ArrayList();
		List<Integer> input=new ArrayList<>();
		for(int i=0;i<n*2;i++) {
			input.add(0);
		}
		
		 dfs(retList,input,n);
		 retList.forEach(k->{
			 k.forEach(e->{
				 System.out.print(e+" ");
			 });
			 System.out.println();
		 });

	}

	private static void dfs(List<List<Integer>> retList, List<Integer> input, int n) {
		Set<Integer> set=new HashSet();
		for(int i=0;i<n*2;i++) {
			if(input.get(i)==0)
				continue;
			set.add(input.get(i));
		}
		
		if(set.size()==n) {
			retList.add(new ArrayList(input));
			return;
		}
		
		for(int i=1;i<n+1;i++){
			if(set.contains(i)) {
				continue;
			}
			for(int j=0;j<input.size()-i-1;j++) {
				if(input.get(j)==0 && input.get(j+i+1)==0) {
					input.set(j, i);
					input.set(j+i+1, i);
					dfs(retList,input,n);
					input.set(j, 0);
					input.set(j+i+1, 0);
				}
			}
			
		}	
	}

}
