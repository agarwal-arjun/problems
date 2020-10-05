package com.leetcode.problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShortestPAltPath {

	public static void main(String[] args) {
		int[][] red={{3,1},{2,3},{7,6},{5,1},{1,3},{8,1},{5,4},{8,4},{6,3},{4,7},{0,1},{7,8},{3,8}};
		int[][] blue={{4,1},{5,8},{3,7},{7,1},{1,8},{8,7},{5,4}};
		
				
		int[] ret=shortestAlternatingPaths(9,red,blue);
		for(int i=0;i<ret.length;i++) {
			System.out.println(ret[i]);
		}
		

	}

	
	  public static int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
	        Map<Integer,List<Integer>> redM=new HashMap();
	        
	        for(int i=0;i<red_edges.length;i++){
	            if(redM.containsKey(red_edges[i][0])){
	                redM.get(red_edges[i][0]).add(red_edges[i][1]);
	            }else{
	                List<Integer> list=new ArrayList();
	                list.add(red_edges[i][1]);
	                redM.put(red_edges[i][0],list);
	            }
	        }
	        
	        Map<Integer,List<Integer>> blueM=new HashMap();
	        
	        for(int i=0;i<blue_edges.length;i++){
	            if(blueM.containsKey(blue_edges[i][0])){
	                blueM.get(blue_edges[i][0]).add(blue_edges[i][1]);
	            }else{
	                List<Integer> list=new ArrayList();
	                list.add(blue_edges[i][1]);
	                blueM.put(blue_edges[i][0],list);
	            }
	        }
	        
	        int[] ret=new int[n];
	        Arrays.fill(ret,Integer.MAX_VALUE);
	        shortest(redM,blueM,ret);
	        shortest(blueM,redM,ret);
	        
	        for(int i=0;i<ret.length;i++){
	            if(ret[i]==Integer.MAX_VALUE){
	                ret[i]=-1;
	            }
	        }
	        return ret;
	        
	    }
	    
	    public static void shortest(Map<Integer,List<Integer>> first,Map<Integer,List<Integer>> sec, int[] ret){
	        Set<String> visited=new HashSet();
	        LinkedList<Integer> queue=new LinkedList();
	        queue.add(0);
	        ret[0]=0;
	        queue.add(-1);
	        int count=1;
	        boolean flip=true;
	        while(queue.size()>1){
	            int v=queue.poll();
	            if(v<0){
	                flip=!flip;
	                queue.add(-1);
	                count++;
	                continue;
	            }else if(visited.contains(v+""+flip)){
	                continue;
	            }else{
	                visited.add(v+""+flip);
	            }
	            List<Integer> eList=flip?first.get(v):sec.get(v);
	            if(eList!=null){
	                for(Integer k : eList){
	                    queue.add(k);
	                    if(ret[k]>count){
	                        ret[k]=count;
	                    }
	                }
	            }
	            
	            
	        }
	    }
}
