package com.leetcode.problems;

public class DivideTwoInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(divide(2147483647, 1));

	}
	
	public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        
        
        
        int a=Math.abs(dividend);
        int b=Math.abs(divisor);
       
        int rem=0;
        
        if(a==b){
            rem=1;
            return (dividend<0)==(divisor<0)?rem:-rem;
        }
        
        while(a-b>0){
            int x=0;
            while(a-(b<<1<<x)>0){
                x++;
            }
            
            if(x>0)
                rem+=1<<(x-1);
                a-=b<<(x-1);
                
        }
        
        
        
        
        return (dividend<0)==(divisor<0)?rem:-rem;
    }

}
