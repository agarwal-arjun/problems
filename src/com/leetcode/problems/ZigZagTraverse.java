package com.leetcode.problems;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverse {

	public static void main(String[] args) {
		TreeNode root=new TreeNode(3);
		TreeNode left=new TreeNode(9);
		TreeNode right=new TreeNode(20);
		
		root.left=left;
		root.right=right;
		
		right.left=new TreeNode(15);
		right.right=new TreeNode(7);
		
		
		System.out.println(zigzagLevelOrder(root));
				
				//[3,9,20,null,null,15,7]
		

	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList();
        if(root==null){
            return list;
        }
        
        ArrayDeque<TreeNode> queue=new ArrayDeque();
        queue.add(root);
        
        level(queue,list,true);
        
        return list;
    }
    
    public static void level(ArrayDeque<TreeNode> queue,List<List<Integer>> list,boolean right){
        if(queue.isEmpty()){
            return;
        }
        
        List<Integer> lev=new ArrayList();
        int size=queue.size();
        int count=0;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            lev.add(node.val);
            queue.add(node);
            count++;
        }
        
        count=0;
        while(!queue.isEmpty() && count<size){
            TreeNode node=queue.pollLast();
            if(right){
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
            }else{
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        
        list.add(lev);
        level(queue,list,!right);
        
        
    }
    
    
    public static class TreeNode {
    	      int val;
    	      TreeNode left;
    	     TreeNode right;
    	      TreeNode(int x) { val = x; }
    	  }

}
