package com.leetcode.problems;
import java.util.Arrays;

public class CoinSum {

	public static void main(String[] args) {
		
		
		int n=1000;
		int[] coin= {10,15,55};
		int[] table=new int[n+1];
		
		Arrays.fill(table, 0);
		table[0]=1;
		
		for(int i=0;i<coin.length;i++) {
			for(int j=coin[i];j<=n;j++) {
				table[j]+=table[j-coin[i]];
			}
		}
		
		for(int i=0;i<table.length;i++) {
			if(table[i]>0) {
				System.out.println(i+":"+table[i]);
			}
		}
	}


}
