package exercise;

import java.util.ArrayList;

public class Exercise23 {

	public static void main(String[] args) {
		int flag=1;
		ArrayList<Integer> ls=new ArrayList<Integer>();
		for(int i=1;i<100;i++) {
			ls.add(i);
		}
		
		int n=(int)(Math.random()*9+1);
		System.out.println(n);
		
		String s = "The";
		String j="";
		for(int i=0;i<=s.length()-1;i++)
		{
		j += s.substring(i,i+1) + s.substring(i,i+1);
		}
		System.out.println(j);
		
		String input="abc def qwerty";
			   
	        char[] inputArray = input.toCharArray();  
	        char[] result = new char[inputArray.length];  
	   
	        for (int i = 0; i < inputArray.length; i++) {  
	            if (inputArray[i] == ' ') {  
	                result[i] = '-';  
	            }  
	        }
	        
	        for(int i = 0; i < result.length; i++) {
	        	System.out.print(result[i]);
	        }

	}

}
