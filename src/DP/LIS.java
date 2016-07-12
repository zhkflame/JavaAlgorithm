package DP;
import java.util.Arrays;

public class LIS {
	
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
		int[] t={0,56,1,5,3,5,60,45};
		System.out.println(LIS(t));
	}

}
