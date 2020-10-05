package com.leetcode.problems;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		int[] test={1,0};
		test[0]++;
		PriorityQueue<int[]> pq= new PriorityQueue<int[]>(test.length,(a,b) -> {
			return a[0]-b[0];
					}) ;
		
		System.out.println(new int[]{1,2});
		
		List<int[]> list=new ArrayList<>();
		
//		int i=3;
//		int k=i;
//		i++;
//		System.out.println(i+" "+k);
		
		String[] str = "2019-01-01".split("-");
		System.out.println(str.length);
		
	}
	
	public static void some(int i) {
		i++;
	}
	

}
