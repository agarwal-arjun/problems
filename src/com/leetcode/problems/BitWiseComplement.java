package com.leetcode.problems;


/**
 * Every non-negative integer N has a binary representation.  For example, 5 can be represented as "101" in binary, 11 as "1011" in binary, and so on.  Note that except for N = 0, there are no leading zeroes in any binary representation.
 * The complement of a binary representation is the number in binary you get when changing every 1 to a 0 and 0 to a 1.  For example, the complement of "101" in binary is "010" in binary.
 * For a given number N in base-10, return the complement of it's binary representation as a base-10 integer.
 * 
 * 
 * @author arjunagarwal
 *
 */
public class BitWiseComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bitwiseComplement(5));
		String str="adfdf";
		char elem[] = new char[] {'a'};
		
	}
	
	public static int bitwiseComplement(int N) {
        int [] bits=new int[32];
        int num=N;
        int pos=0;
        while(num>0){
            bits[pos]=num%2;
            num=num/2;
            pos++;
        }
        
        int out=0;
        for(int i=0;i<pos;i++){
            out=out*2+(bits[i]==0?1:0);
        }
        return out;
        
    }

}

