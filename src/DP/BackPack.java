package DP;

import java.util.Arrays;

public class BackPack {
	
	public static int BackPack(int[] heavy,int[] value,int maxHeavy) {
		int lenH=heavy.length;
		int lenV=value.length;
		if(lenH!=lenV)
			return -1;
		int[][] matrix=new int[lenH+1][maxHeavy+1];
		
		for(int i=1;i<=lenH;i++){
			for(int j=1;j<=maxHeavy;j++){
				if(j>=heavy[i-1])
					matrix[i][j]=Math.max(matrix[i-1][j], matrix[i-1][j-heavy[i-1]]+value[i-1]);
				else
					matrix[i][j]=matrix[i-1][j];
			}
		}
		return matrix[lenH][maxHeavy];
	}
	
	public static int BackPack2(int[] heavy,int[] value,int maxHeavy) {
		int lenH=heavy.length;
		int lenV=heavy.length;
		if(lenH!=lenV)
			return -1;
		int[] matrix=new int[maxHeavy+1];
		
		for(int i=1;i<=lenH;i++){
			for(int j=maxHeavy;j>=heavy[i-1];j--){
				matrix[j]=Math.max(matrix[j], matrix[j-heavy[i-1]]+value[i-1]);
			}
		}
		return matrix[maxHeavy];
		
	}
	
	
	//刚好等于maxHeavy的最大价值是多少
	public static int BackPack3(int[] heavy,int[] value,int maxHeavy) {
		int lenH=heavy.length;
		int lenV=heavy.length;
		if(lenH!=lenV)
			return -1;
		int[] matrix=new int[maxHeavy+1];
		Arrays.fill(matrix,-99999999);
		matrix[0]=0;
		for(int i=1;i<=lenH;i++){
			for(int j=maxHeavy;j>=heavy[i-1];j--){
				matrix[j]=Math.max(matrix[j], matrix[j-heavy[i-1]]+value[i-1]);
				//if(matrix[j]>0)
				//	System.out.println(heavy[i-1]+":"+matrix[j]);
			}
		}
		return matrix[maxHeavy];
	}
	
	//给出最大价值，求达到最大价值的最小重量
	public static int BackPack4(int[] heavy,int[] value,int maxValue) {
		int lenH=heavy.length;
		int lenV=heavy.length;
		if(lenH!=lenV)
			return -1;
		int[] matrix=new int[maxValue+1];
		Arrays.fill(matrix, 9999999);
		matrix[0]=0;
		for(int i=1;i<=lenV;i++){
			for(int j=maxValue;j>=value[i-1];j--){
				matrix[j]=Math.min(matrix[j], matrix[j-value[i-1]]+heavy[i-1]);
			}
		}
		return matrix[maxValue];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heavy={23,15,34,7,45,30,60,10};
		int[] value={100,75,110,26,180,80,170,31};
		int maxHeavy=90;
		int maxValue=180;
		System.out.println(BackPack3(heavy, value, maxHeavy));
		System.out.println(BackPack4(heavy, value, maxValue));
	}

}
