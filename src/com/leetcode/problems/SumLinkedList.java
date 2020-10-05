package com.leetcode.problems;
import java.util.LinkedList;
import java.util.Scanner;

public class SumLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc=new Scanner(System.in);
		//int n=sc.nextInt();
		LinkedList<Integer> first=new LinkedList<>();
		int[] input= {1,2,3,4,5};
		for(int i=0;i<input.length;i++) {
			first.add(input[i]);
		}
		
		//int m=sc.nextInt();
		int[] sInput= {1,2,3,4,5};
		LinkedList<Integer> sec=new LinkedList<>();
		for(int i=0;i<sInput.length;i++) {
			sec.add(sInput[i]);
		}
		
		LinkedList<Integer> ret=new LinkedList<>();
		
		int rem=sum(first,sec,ret);
		if(rem>0) {
			ret.addFirst(rem);
		}
		
		System.out.println(ret);
		
	}
	
	public static int sum(LinkedList<Integer> first,LinkedList<Integer> sec, LinkedList<Integer> ret) {
		if(first.size()==0 && sec.size()==0) {
			return 0;
		}
		
			
		Integer firstPoll=first.size()>=sec.size()?first.poll():null;
		Integer secPoll=sec.size()>=first.size()?sec.poll():null;
		Integer rem=0;
		if(first.size()>0 || sec.size()>0) {
			rem=sum(first,sec,ret);
		}
		
		int sum=(firstPoll==null?0:firstPoll)+(secPoll==null?0:secPoll)+rem;
		
		ret.addFirst(sum%10);
		
		return sum/10;
		
	}
	


}
