package com.leetcode.problems;

public class WaterInContainer {

	public static void main(String[] args) {
		int[] height= {1,3,2,5,25,24,5};
		
		System.out.println(maxArea(height));

	}
	
	public static int maxArea(int[] height) {
        int[] hight=height;
        if(hight.length<=1){
            return 0;
        }
        
        int[] max=nextMax(hight);
         int[] min=preMin(hight);
        
        int i=0;
        int j=hight.length-1;
        int maxar=0;
        while(i<j){
            int area=Math.min(hight[i],hight[j])*(j-i);
            if(maxar<area){
                maxar=area;
            }
            
            if(hight[i]<=hight[j] && max[i]>0){
                i=max[i];
            }else if(hight[i]>hight[j] && min[j]>0){
                j=min[j];
            }else{
                break;
            }
            
        }
        
        return maxar;
    }
    
public static int [] nextMax(int[] hight){
        
        int[] max=new int[hight.length];
        for(int i=hight.length-1;i>=0;i--){
            if(i==hight.length-1){
                max[i]=-1;
            }else{
                if(max[i+1]<0 || hight[i]<hight[i+1]){
                    if(hight[i]<hight[i+1]){
                        max[i]=i+1;
                    }else{
                        max[i]=-1;
                    }
                    
                }else{
                    int j=i+1;
                    while(true){
                        int temp=(max[j]==-1?j:max[j]);
                            
                        if(hight[i]<=hight[temp]){
                            max[i]=temp;
                            break;
                        }else if(max[j]==-1){
                            max[i]=-1;
                            break;
                        }
                        j++;
                    }
                }
            }
        }
        
        return max;
    }
    
    public static int [] preMin(int[] hight){
        
        int[] min=new int[hight.length];
        for(int i=0;i<hight.length;i++){
            if(i==0){
                min[i]=-1;
            }else{
                if(min[i-1]<0 || hight[i]<hight[i-1]){
                    if(hight[i]<hight[i-1]){
                        min[i]=i-1;
                    }else{
                       min[i]=-1;  
                    }
                   
                }else{
                    int j=i-1;
                    while(true){
                        int temp=(min[j]==-1?j:min[j]);
                        if(hight[i]<hight[temp]){
                            min[i]=temp;
                            break;
                        }else if(min[j]==-1){
                            min[i]=-1;
                            break;
                        }
                        j--;
                    }
                    
                }
            }
        }
        
        return min;
    }

}
