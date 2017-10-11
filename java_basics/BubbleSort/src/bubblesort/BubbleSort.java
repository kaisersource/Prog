/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Arrays;

/**
 *
 * @author BACKSLASHZERO
 */
public class BubbleSort{
    
    public int[] metodo(int b[], int len){
        int temp;
    if(len==0) {
        return b;
    }
    else{
        for(int i=0;i<len-1;i++){
            if(b[i]>b[i+1]){
                temp=b[i];
                b[i]=b[i+1];
                b[i+1]=temp;
                
            }
        }  
      return metodo(b,len-1);
        }
    }  
   
    
    public static void main(String[] args) {
      int []a={5,6,7,8,67,5,3,24,5,4,3,5};
      BubbleSort b1=new BubbleSort();
          System.out.println (Arrays.toString(b1.metodo(a,a.length)));
      
      
    }
    
}
