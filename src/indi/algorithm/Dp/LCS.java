package indi.algorithm.Dp;

public class LCS {
	
	public static int LCS(String str1,String str2) {
		int len1=str1.length();
		int len2=str2.length();
		int[][] matrix=new int[len1+1][len2+1];
		int[][] b_matrix=new int[len1+1][len2+1];
		for(int i=1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				if(str1.charAt(i-1)==str2.charAt(j-1))
					matrix[i][j]=matrix[i-1][j-1]+1;
				else {
					if (matrix[i-1][j]>=matrix[i][j-1]) 
						matrix[i][j]=matrix[i-1][j];
					else
						matrix[i][j]=matrix[i][j-1];
				}
			}
		}		
		return matrix[len1][len2];
	}
	
	public static int LCS2(String str1,String str2) {
		int len1=str1.length();
		int len2=str2.length();
		int[] matrix=new int[len2+1];
		int leftup=0;
		for(int i=1;i<=len1;i++){
			for(int j=0;j<=len2;j++){
				if(j==0){
					leftup=matrix[j];
					matrix[j]=0;
				}
				else {
					int temp=matrix[j];
					if(str1.charAt(i-1)==str2.charAt(j-1))
						matrix[j]=leftup+1;
					else {
						if (matrix[j]<matrix[j-1]) 
							matrix[j]=matrix[j-1];
					}
					leftup=temp;
				}
			}
		}		
		return matrix[len2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="aaaabccccdef";
		String str2="abbccefg";
		System.out.println(LCS2(str1,str2));
	}

}
