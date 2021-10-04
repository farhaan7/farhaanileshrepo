package interview_Normal;

import java.util.Arrays;

public class ArraySize4 
{
  public static void main(String[] args)
	{
	  
	//Arrays.ToString(a) and Arrays.deepToString(array) used to print Array data
	  
	  int[][] array = {{1, 2}, {3, 4}, {5, 6, 7}};
      System.out.println(Arrays.deepToString(array));
	  //Arrays.deepToString()prints the multi-direction arrays
	  
	  int[] a=new int[4];
	  int b[]= {1,2,3,4};
	  //System.out.println(b[1]);
	  a[0]=5;
	  a[1]=10;
	  a[2]=15;
	  a[3]=20;
	//System.out.println(Arrays.toString(a)); or use looping
	  
	  for(int i=0;i<a.length;i++)
	  {
		  System.out.println("Element in array at location: "+i +" is: "+a[i]);
	  }
     
	 //for-each loop 
	  for(int i:a)
	  {
		  System.out.println("Another way: "+i);
	  }
	  
	  int max=a[0];
	  for(int i=0;i<4;i++)
	  {
		  if(max>a[i])
		  {
			  max=a[i];
		  }
	  }
	  
	  System.out.println("maxium number is :"+max);
	  
	  
	}
}
