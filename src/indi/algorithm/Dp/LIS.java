package indi.algorithm.Dp;
import java.util.Arrays;


public class LIS {
	
	public static int searchPos(int[] matrix,int a) {
		int lenM=matrix.length;
		int l=0;
		int r=lenM-1;
		while(l<r){
			int mid=(l+r)/2;
			if(a>matrix[mid]){
				l=mid+1;
			}
			else{
				r=mid;
			}
		}
		if(a<matrix[l])
			return l;
		else
			return l+1;		
	}
	
	public static int LIS2(int[] L){
		int lenL=L.length;
		int[] matrix=new int[lenL];
		Arrays.fill(matrix, 9999999);
		int max=0;
		for (int i = 0; i < lenL; i++) {
			int pos=searchPos(matrix, L[i]);
			matrix[pos]=L[i];	
			if(max<pos)
				max=pos;
		}
		return max+1;		
	}
	
	public static int  LIS(int[] L) {
		int lenL=L.length;
		int[] matrix=new int[lenL];
		int max=1;
		Arrays.fill(matrix,1);
		for(int i=1;i<lenL;i++){
			for(int j=0;j<i;j++){
				if(L[i]>L[j] && matrix[j]+1>matrix[i]){
					matrix[i]=matrix[j]+1;
					if(max<matrix[i])
						max=matrix[i];
				}
				
			}
		}
		return max;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] t={0,56,1,5,3,5,6,6,60,45};
		System.out.println(LIS2(t));
	}

}
