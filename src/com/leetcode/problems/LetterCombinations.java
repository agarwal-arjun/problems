package com.leetcode.problems;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * @author arjunagarwal
 *
 */
public class LetterCombinations {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("23"));
		
	}
	

	 public static List<String> letterCombinations(String digits) {
	        List<String> out=new ArrayList();
	        if(digits.length()==0){
	            return out;
	        }
	        
	        StringBuilder sb=new StringBuilder();
	        
	        
	        char[] chars=getChars(digits.charAt(0));
	        List<String> inner=letterCombinations(digits.substring(1));
	        for(int i=0;i<chars.length;i++){
	            if(inner.size()==0){
	                out.add(chars[i]+"");
	            }else{
	                for(int j=0;j<inner.size();j++){
	                    out.add(chars[i]+inner.get(j));
	                }
	            }
	            
	        }
	        
	        return out;
	        
	    }
	    
	    public static char[] getChars(char num){
	        if(num=='2'){
	            return new char[]{'a','b','c'};
	        }else if(num=='3'){
	            return new char[]{'d','e','f'};
	        }else if(num=='4'){
	            return new char[]{'g','h','i'};
	        }else if(num=='5'){
	            return new char[]{'j','k','l'};
	        }else if(num=='6'){
	            return new char[]{'m','n','o'};
	        }else if(num=='7'){
	            return new char[]{'p','q','r','s'};
	        }else if(num=='8'){
	            return new char[]{'t','u','v'};
	        }else if(num=='9'){
	            return new char[]{'w','x','y','z'};
	        }
			return null;
	    }

}
