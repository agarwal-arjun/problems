package com.leetcode.problems;
import java.util.Scanner;

public class LargestPalindrom {

	public static void main(String[] args) {
		System.out.println("input:");
		Scanner sc=new Scanner(System.in);
		String input=sc.next();

		System.out.println(longestPalindrome(input));
	}
	
	public static String longestPalindrome(String s) {
		StringBuilder sb=new StringBuilder();
        String r=sb.append(s).reverse().toString();
        int[][] L=new int[s.length()+1][s.length()+1];
        
        int max=0;
        int row=0;
        int col=0;
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<s.length()+1;j++){
                if(i==0||j==0){
                    L[i][j]=0;
                }else if(s.charAt(i-1)==r.charAt(j-1)){
                    L[i][j]=L[i-1][j-1]+1;
                    if(max<L[i][j] && i==s.length()-j+L[i][j]){
                        max=L[i][j];
                        row=i;
                        col=j;
                    }
                }else{
                    L[i][j]=0;
                }
            }
        }
        
       sb.setLength(0);
        while(max>0){
           sb.append(s.charAt(row-max));
            max--;
        }
        return sb.toString();
    }
	
	

}
