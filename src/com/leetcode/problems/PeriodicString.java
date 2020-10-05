package com.leetcode.problems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeriodicString {

	public static void main(String[] args) {
		System.out.println("Please provide input :"+"");
		Scanner sc=new Scanner(System.in);
		String input=sc.next();
		System.out.println(periodicString(input));

	}

	private static String periodicString(String input) {
		if(input.length()<2)
			return "non-periodic";
		
		char firstChar=input.charAt(0);
		char lastChar=input.charAt(input.length()-1);
		List<Integer> list=new ArrayList<>();
		
		for(int i=1;i<input.length();i++) {
			if(input.charAt(i-1)==lastChar && input.charAt(i)==firstChar) {
				list.add(i);
			}
		}
		
		int period=-1;
		for(Integer val : list) {
			boolean periodic=true;
			for(int i=2;i<=input.length()/val;i++) {
				if(!input.substring(val*i-2*val, val*i-val).equals(input.substring(val*i-val, val*i))) {
					periodic=false;
					break;
				}
			}
			
			if(periodic) {
				period=val;
				break;
			}
			
		}
		
		return period>0?input.substring(0,period):"non-periodic";
		
	}
	
	

}
