package indi.algorithm.simple;

public class heapSort {	
	public static void adjustToHeap(int[] L,int start,int end) {
		if (start>=end)
			return;
		int i=start;
		int max=i;
		while(i<=end){  //当前顶点循环不断下沉
			if(2*i+1<=end){//判断孩子是否越界
	            if(2*i+2<=end && L[2*i+2]>L[2*i+1])//判断两个孩子谁大谁小
	                max=2*i+2;
	            else
	                max=2*i+1;
	            if(L[max]>L[i]){  //判断父节点与较大孩子的大小
	            	int temp=L[max];
	                L[max]=L[i];
	                L[i]=temp;
	                i=max;
	            }
	            else
	            	return;
			}
	        else
	        	return;
		}
	}
	
	public static int[] heapSort(int[] L,int len){
		for(int i=(len-2)/2;i>=0;i--)
		    adjustToHeap(L,i,len-1);
		for(int i=len-1;i>0;i--){
			int temp=L[i];
		    L[i]=L[0];
		    L[0]=temp;
		    adjustToHeap(L,0,i-1);
		}
		return  L;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] temp={3,67,123,71,0,72,1101,2,4,45,21,1,34,7,28,121,1000};
		 heapSort(temp,temp.length);
		 for(int i=0;i<temp.length;i++)
			 System.out.println(temp[i]);
	}
}
