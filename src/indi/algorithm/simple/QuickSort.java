package indi.algorithm.simple;

public class QuickSort {

	public static void quickSort(int[] L,int start,int end) {
		if (start>=end){
			return;
		}
		int l=start;int r=end;
		int temp=L[l];
		while(l<r){
			while(l<r && temp<L[r])
				r--;
			L[l]=L[r];
			while(l<r && temp>=L[l])
				l++;
			L[r]=L[l];
		}
		L[l]=temp;
		quickSort(L, start, l-1);
		quickSort(L, l+1, end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] temp={3,67,123,71,72,1101,2,4,45,21,1,34,7,28,121};
		 quickSort(temp,0,temp.length-1);
		 for(int i=0;i<temp.length;i++)
			 System.out.println(temp[i]);

	}

}
