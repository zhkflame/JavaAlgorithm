package indi.algorithm.simple;

public class MergeSort {
	
	public static void mergeAdjust(int[] L,int[] L_m,int start,int mid,int end) {
		int i=start;int j=mid+1;int k=start;
		while(i<=mid && j<=end){
			if(L[i]<=L[j])
				L_m[k++]=L[i++];
			else 
				L_m[k++]=L[j++];
		}
		while(i<=mid)
			L_m[k++]=L[i++];
		while(j<=end)
			L_m[k++]=L[j++];
		for(int t=0;t<=end;t++)
			L[t]=L_m[t];
	}
	
	public static void mergeSort(int[] L,int[] L_m,int start,int end) {
		if(start<end){
			int mid=(start+end)/2;
			mergeSort(L, L_m, start, mid);
			mergeSort(L, L_m, mid+1, end);
			mergeAdjust(L, L_m, start, mid, end);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] L={3,67,123,71,72,1101,2,4,45,21,1,34,7,28,121};
		 int[] L_m=L.clone();
		 mergeSort(L,L_m,0,L.length-1);
		 for(int i=0;i<L.length;i++){
			 System.out.println(L[i]);
		 }
	}

}
