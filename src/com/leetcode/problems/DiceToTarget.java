package com.leetcode.problems;

public class DiceToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public int numRollsToTarget(int d, int f, int target) {
        int[][] t=new int[target+1][2];
        t[0][0]=1;
        
        //t[j-i][1]+1
        for(int i=1;i<=f;i++){
            for(int j=i;j<=target;j++){
                if(t[j-i][1]+1<=d){
                    t[j][0]+=t[j-i][0];
                    t[j][1]+=1;
                }
                
            }
        }
        int mod=(10^9+7);
        return t[target][0] % mod;
        
    }
}
